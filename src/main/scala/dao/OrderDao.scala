
package com.programmera.simpleorder.dao

// This singleton handles all database accesss for Order object
object OrderDao {
  import java.sql.{Connection, Statement, ResultSet, SQLException}
  import com.programmera.simpleorder.domain.Order

  val allOrdersSql= "SELECT customer, product, quantity FROM product_order"

  def getAllOrders(dbc: DbConnection) = {
    val orders = collection.mutable.ListBuffer[Order]()
    val connection = DaoUtil.getConnection(dbc)
    try {
      val stmt: Statement = connection.createStatement
      try {
        val rs: ResultSet  = stmt.executeQuery(allOrdersSql)
        try {
          while (rs.next()) {
            val order = Order(rs.getString(1), rs.getString(2), 
               rs.getInt(3))
            orders += order
          }
        } finally {  
          rs.close()
        }
      } finally { 
        stmt.close()
      }
    } finally { 
      connection.close()
    }
    orders
  }
}


