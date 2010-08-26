
package com.programmera.simpleorder.http 

import javax.servlet.http.{HttpServlet, HttpServletRequest, 
  HttpServletResponse}

import com.programmera.simpleorder.domain.Order
import com.programmera.simpleorder.dao.{OrderDao,DbConnection}
import com.programmera.simpleorder.view.View


// Main Servlet of the application
class FrontController extends HttpServlet {

  // General entry method for the servlet (Post and Get)
  override def service(req : HttpServletRequest, 
      resp : HttpServletResponse) ={
    try{
      // Do the work
      val html = processRequest(req)
      // Send response
      resp.getWriter().print(html)
    }catch{
      case e: Exception => {
        val html = View.errorToHtml(e.getMessage())
        resp.getWriter().print(html)
      }
    }
  }
 
  // Processes the request, might throw exception
  def processRequest(req : HttpServletRequest): String = {
    // Get the init parameters
    val config= getServletConfig()
    val dbc= DbConnection( 
      config.getInitParameter("db-server"),
      config.getInitParameter("db-username"),
      config.getInitParameter("db-password")
    )

    // Get the orders
    val orders: Seq[Order] = OrderDao.getAllOrders(dbc)
  
    // Generate the HTML
    View.ordersToHtml(orders)
  }
}
 
 


