package net.cassiolandim.erragah

import org.squeryl._
import org.squeryl.adapters.PostgreSqlAdapter

class ErragahSessionFactory(
    val driverClassName : String,
    val url : String,
    val username : String,
    val password : String
  ) {
	
  SessionFactory.concreteFactory = Some(() => createPostgreSqlConnection)

  def createPostgreSqlConnection = {
    Class.forName(driverClassName);
    val c = java.sql.DriverManager.getConnection(url, username, password)
    c.setAutoCommit(false)
    Session.create(c, new PostgreSqlAdapter)
  }
}