package com.programmera.simpleorder.dao

// Holder of database connection info
case class DbConnection(server: String, name: String, pw: String){
  require(server != null, "DB Server parameter is null")
  require(name != null, "DB (user) name parameter is null")
  require(pw != null, "DB pw parameter is null")

  def getConnectionString = 
    "jdbc:mysql://%s:3306/simpleorder?user=%s&password=%s".
      format(server, name, pw)
}



