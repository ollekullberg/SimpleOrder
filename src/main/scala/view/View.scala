
package com.programmera.simpleorder.view

// Responsible for generating the HTML view
object View {
  import com.programmera.simpleorder.domain.Order

  val htmlTop = 
  <HEAD> 
    <TITLE>Simple Order Application </TITLE>
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
  </HEAD>

  // Generate HTML from the orders
  def ordersToHtml(orders: Seq[Order]) = 
<HTML lang="sv-SE" > { htmlTop }
  <BODY>
    <H1>Simple Order Application</H1>
    All orders:
    <HR/>
    <TABLE>
      <TR><TH>Customer</TH><TH>Product</TH><TH>Quantity</TH></TR>
      {
        for( o <- orders) yield 
          <TR><TD>{ o.customer }</TD><TD>{ o.product }</TD><TD>{ o.quantity 
          }</TD></TR>
      }
    </TABLE>
    <HR/>
  </BODY>
</HTML>.toString

  // Generate error HTML
  def errorToHtml(err: String) = 
<HTML lang="sv-SE" > { htmlTop }
  <BODY>
    <H1>Simple Order Application</H1>
    Server error:
    <HR/>
    Message: { err }
    <HR/>
  </BODY>
</HTML>.toString

}
  
 


