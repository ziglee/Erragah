package net.cassiolandim.erragah

import java.sql.SQLException
import java.sql.Timestamp
import org.squeryl._
import adapters.H2Adapter
import dsl.ast.BinaryOperatorNodeLogicalBoolean
import dsl.{EnumExpression, StringExpression, Measures, GroupWithMeasures}
import java.util.{Date, Calendar}

class ErragahDbObject extends KeyedEntity[Int] {
  val id: Int = 0
  var timeOfLastUpdate = new Timestamp(System.currentTimeMillis)
}

class Company(var nome : String, var cnpj: String) extends ErragahDbObject{
  def this() = this("", "")
}