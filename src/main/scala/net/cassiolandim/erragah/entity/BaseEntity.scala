package net.cassiolandim.erragah.entity

import java.io.Serializable
import java.lang.Comparable

abstract class BaseEntity[T] extends HasId with Serializable with Comparable[T]{
	
	override def hashCode = {
		val prime : Int = 31
		val result : Int = 1
		(prime * result + id.hashCode)
	}
	
	override def equals(obj : Any) = obj match {
		case that : BaseEntity[T] => id == that.id
		case _ => false
	}
}