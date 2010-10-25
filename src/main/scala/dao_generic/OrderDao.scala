
package com.programmera.simpleorder.dao_generic

object OrderDao {
  import java.sql.{Connection, Statement, ResultSet, SQLException}
  import com.programmera.simpleorder.dao.{DaoUtil, DbConnection}
  import com.programmera.simpleorder.domain.Order

  val allOrdersSql= "SELECT customer, product, quantity FROM product_order"

  def getAllOrders(dbc: DbConnection): Seq[Order] = {
    val connection = DaoUtil.getConnection(dbc)
    JdbcUtil.executeSelectQuery(connection, allOrdersSql) { 
        rs: ResultSet => extractResults(rs)
    }
  }

  private def extractResults(rs: ResultSet): List[Order] =
    if (rs.next()) {
      val order = Order(rs.getString(1), rs.getString(2), rs.getInt(3))
      order :: extractResults(rs)
    } else {
      Nil
    }
      
}


