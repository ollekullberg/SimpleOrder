import sbt._

class SimpleOrderProject(info: ProjectInfo) extends DefaultWebProject(info) 
{ 
  // Declare Servlet Dependency
  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"

  // Declare MySQL connector Dependency
  val mysql = "mysql" % "mysql-connector-java" % "5.1.12" 
}
