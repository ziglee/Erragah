package net.cassiolandim.erragah.service

import net.cassiolandim.erragah.ErragahDbObject

trait PersistableService[T <: ErragahDbObject] {
	def find(id : Long) : Option[T]
}