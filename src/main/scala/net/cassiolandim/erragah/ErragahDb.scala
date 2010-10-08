package net.cassiolandim.erragah

import org.squeryl.PrimitiveTypeMode._
import java.sql.SQLException
import java.sql.Timestamp
import org.squeryl._
import adapters.H2Adapter
import dsl.ast.BinaryOperatorNodeLogicalBoolean
import dsl.{EnumExpression, StringExpression, Measures, GroupWithMeasures}
import java.util.{Date, Calendar}
import org.squeryl.adapters.PostgreSqlAdapter

class ErragahDbObject extends KeyedEntity[Long] {
  val id: Long = 0
  //var timeOfLastUpdate = new Timestamp(System.currentTimeMillis)
}

case class Company(var nome : String, var cnpj: String) extends ErragahDbObject{
  def this() = this("", "")
}

object ErragahDb extends Schema {
	val companies = table[Company]
	
	override def drop = super.drop
}

class ErragahDbConn {
	SessionFactory.concreteFactory = Some(()=>createPostgreSqlTestConnection)
	
	def createPostgreSqlTestConnection = {
		Class.forName("org.postgresql.Driver");
		val c = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/squeryl", "squeryl", "squeryl")
		c.setAutoCommit(false)
		Session.create(c, new PostgreSqlAdapter)
	}
}

class CompanyService {
	def insertCompany() {
		inTransaction{
			ErragahDb.companies.insert(new Company("AAA", "111"))
		}
	}
	def select() : Option[Company] = {
		inTransaction {
			ErragahDb.companies.lookup(1L)
		}
	}
}