package net.cassiolandim.erragah.entity

class Company(override val id : Long) extends BaseEntity[Company] {

	def compareTo(other : Company) : Int = {
		1
	}
}