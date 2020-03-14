package store;
import java.sql.*;
import java.io.*;
import java.util.StringTokenizer;
import java.util.Properties;
import java.util.Random;

/**
 * Class DBWrapper contains wrapper routines for using JDBC
 * to access the database.
 */
public class DBWrapper {
	
    private static int CONNECTION_RETRIES = 10;
    private static int QUERY_RETRIES = 10;
    private static int DEF_ISOLATION = Connection.TRANSACTION_READ_COMMITTED;
    
    private String dbUrl;
    private String password;
    private String username;
    private String jdbcClassName;
    private Connection dbCon;	

    private boolean hasError = false;
    private String errorString = null;
    private static DBWrapper myInstance = null;
    
    /**
     * DBWrapper constructor
     */
    private DBWrapper() 
    		throws Exception {
    	
    	connectAsDefaultLibrary();
    }

    /**
     * DBWrapper conscrutor
     */
    private DBWrapper(String inUrl, String inJdbcClassName, String inUserName, String inPassWord) 
    		throws Exception {
    	
		dbUrl = inUrl;
		jdbcClassName = inJdbcClassName;
		username = inUserName;
		password = inPassWord;
		closeConnections();
		connect();
    }
    
    /**
     * connectAsDefaultLibrary()
     * Create a connection to the library using default connection parameters.
     */
    public void connectAsDefaultLibrary()
    		throws Exception {
    	
        dbUrl = "jdbc:mysql://localhost:3306/myhome";
    	
        jdbcClassName = "com.mysql.jdbc.Driver";
        username = "root"; 
        password = "4869";
		closeConnections();
		connect();
    }

    /**
     * boolean connect()
     * Connect to a database using the parameters supplied in the constructor.
     */
    private void connect() 
    		throws Exception {
	
		// Set the JDBC class name.
                Class.forName(jdbcClassName);
		
		dbCon = DriverManager.getConnection(dbUrl, username, password);
    }

    
    /**
     * closeConnections closes any currently open connections
     */
    private void closeConnections() 
    		throws Exception {
		
    	if (dbCon!=null) {
		    dbCon.close();
		}
    }

    /**
     * DBWrapper Instance()
     * Get a singleton instance of the DBWrapper object.
     */
    public static DBWrapper Instance() 
    		throws Exception {
    	
		if (myInstance == null) {
			myInstance = new DBWrapper();
		    myInstance.connectAsDefaultLibrary();
		}
		
		return myInstance;
    }

    /**
     * Statement getStmt()
     * Sets up auto/manual commit & isolation level
     */
    private Statement getStmt(boolean isAutoCommit, int isolationLevel)
    		throws SQLException {
    	
		// Begin a transaction at given isolation level
		dbCon.setAutoCommit(isAutoCommit);
		dbCon.setTransactionIsolation(isolationLevel);
		
		return dbCon.createStatement();
    }

    /**
     * ResultSet runQuery()
     * Executes a query and returns a resultset.  
     */
    public ResultSet runQuery(String sqlQuery) 
    		throws Exception {
    	
		Statement dbStatement = this.getStmt(true, DEF_ISOLATION);
		
		return dbStatement.executeQuery(sqlQuery);
		// Note: We cannot close dbStatement since caller needs resultset!
    }
    
    /**
     * int runUpdate()
     * Executes an update and returns true of successfully executed.  
     */    
    public int runUpdate(String sqlQuery) 
    		throws Exception {
	
        Statement dbStatement = getStmt(true, DEF_ISOLATION);
		int rowCount = dbStatement.executeUpdate(sqlQuery);
		dbStatement.close();
		
		return rowCount;
    }
    
    /**
     * ResultSet runChainedQuery()
     * Executes a chained mode transaction query.  
     */  
    public ResultSet runChainedQuery(String sqlQuery, int isolationLevel) 
    		throws Exception {
	
        int retry = 0;
        boolean txnSuccess = false;
        Statement dbStatement = null;
        ResultSet resultSet = null;

		// Connect to the database.
		// Retry the query until complete or timeout.
        while (!txnSuccess && retry++ < QUERY_RETRIES) {
		    try { 
				dbStatement = getStmt(false, isolationLevel);
				// Execute the query.
				resultSet = dbStatement.executeQuery( sqlQuery );
				// Commit the transaction.
				dbCon.commit();
				txnSuccess = true;
		    } catch (SQLException se) {
				dbCon.rollback();
				dbStatement.close();
				// If deadlocked, try again after 10 msec
				if (se.getSQLState().equals("40P01")) {
				    Thread.sleep(10);
				} else {
				    dbCon.setTransactionIsolation(DEF_ISOLATION);
				    throw se;
				}
		    } catch (Exception e) {
				dbCon.rollback();
				dbStatement.close();
				dbCon.setTransactionIsolation(DEF_ISOLATION);
				throw e;
		    }
        }
        
        return resultSet;
    }
    
    /**
     * boolean runChainedUpdate()
     * Executes a chained mode update transaction.  
     */  
    public boolean runChainedUpdate(String [] sqlQuery, int isolationLevel) 
    		throws Exception {
		
    	int retry = 0;
		boolean txnSuccess = false;
        Statement dbStatement = null;
	
        while (!txnSuccess && retry++ < QUERY_RETRIES) {
		    // Begin a new transaction.
		    try	{
					dbStatement = getStmt(false, isolationLevel);
					
					// For each sql statement, perform the update.
					for(int i = 0; i < sqlQuery.length; i++) {
						dbStatement.executeUpdate(sqlQuery[i]);
					}
					
					// Commit the transaction and close.
					dbCon.commit();
					dbStatement.close();
					txnSuccess = true;
		    } catch (SQLException se) {
				dbCon.rollback();
				dbStatement.close();
				
				// If deadlocked, try again after 10 msec
				if (se.getSQLState().equals("40P01")) {
				    Thread.sleep(10);
				} else {
				    dbCon.setTransactionIsolation(DEF_ISOLATION);
				    throw se;
				}
		    } catch (Exception e) {
				dbCon.rollback();
				dbStatement.close();
				dbCon.setTransactionIsolation(DEF_ISOLATION);
				throw e;
		    }
        }
        
        return txnSuccess;
    }
}
