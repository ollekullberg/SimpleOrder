
package com.programmera.simpleorder.dao_generic

object JdbcUtil {
  import java.sql.{Connection, Statement, ResultSet}

  // Runs the SQL query and call the function f with the 
  // resulting ResultSet as a parameter.
  def executeSelectQuery[A](connection: Connection, selectQuery: String)
      (f: ResultSet => A): A = 
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

