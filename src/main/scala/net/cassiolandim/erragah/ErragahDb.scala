package net.cassiolandim.erragah

import org.squeryl.PrimitiveTypeMode._
import java.sql.SQLException
import java.sql.Timestamp
import org.squeryl._
import adapters.H2Adapter
import dsl.ast.BinaryOperatorNodeLogicalBoolean
import dsl.{EnumExpression, StringExpression, Measures, GroupWithMeasures}
import java.util.{Date, Calendar}

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