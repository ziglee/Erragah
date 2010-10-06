package net.cassiolandim.erragah

import org.squeryl.Session
import org.junit.Test
import junit.framework.Assert._
import org.squeryl.adapters._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.SessionFactory

class TestErragahDb {
	
	@Test
	def tesaa(){
		conectar()
	}
	
	def conectar(){
		SessionFactory.concreteFactory = Some(()=>createPostgreSqlTestConnection)
	  
		inTransaction{
			ErragahDb.drop
			ErragahDb.create
			var companyTeste = ErragahDb.companies.insert(new Company("Teste", "837273.234234.234"))
			assertEquals("Nome da compania errado!", "Teste", companyTeste.nome)
		}
	}
	

	def createPostgreSqlTestConnection = {
		Class.forName("org.postgresql.Driver");
		val c = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/squeryl", "squeryl", "squeryl")
		c.setAutoCommit(false)
		Session.create(c, new PostgreSqlAdapter)
	}
}
