package com.programmera.simpleorder.dao

// Util Class
object DaoUtil {
  import java.sql.{DriverManager, Connection}

  private var driverLoaded = false

  private def loadDriver()  {
    try{
      Class.forName("com.mysql.jdbc.Driver").newInstance
      driverLoaded = true
    }catch{
      case e: Exception  => { 
        println("ERROR: Driver not available: " + e.getMessage)
        throw e
      }
    }
  }
  
  def getConnection(dbc: DbConnection): Connection =  {
    // Only load driver first time
    this.synchronized {
      if(! driverLoaded) loadDriver()
    }

    // Get the connection
    try{
      DriverManager.getConnection(dbc.getConnectionString)
    }catch{
      case e: Exception  => {
        println("ERROR: No connection: " + e.getMessage)
        throw e
      }
    }
  }
}


