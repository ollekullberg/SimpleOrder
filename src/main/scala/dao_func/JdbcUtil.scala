
package com.programmera.simpleorder.dao_func

object JdbcUtil {
  import java.sql.{Connection, Statement, ResultSet}

  // Runs the SQL query and call the function f with the 
  // resulting ResultSet as a parameter.
  def executeSelectQuery(connection: Connection, selectQuery: String)
      (f: ResultSet => Unit) {
    try {
      val stmt: Statement = connection.createStatement
      try {
        val rs: ResultSet  = stmt.executeQuery(selectQuery)
        try {
          f(rs)
        } finally {
          rs.close()
        }
      } finally { 
        stmt.close()
      }
    } finally { 
      connection.close()
    }
  }
}

