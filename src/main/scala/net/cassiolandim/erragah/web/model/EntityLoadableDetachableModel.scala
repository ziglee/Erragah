package net.cassiolandim.erragah.web.model

import org.apache.wicket.model.LoadableDetachableModel
import net.cassiolandim.erragah.ErragahDbObject
import net.cassiolandim.erragah.service.PersistableService

class EntityLoadableDetachableModel[T <: ErragahDbObject](
		entity : T,
		@transient val service : PersistableService[T]) extends LoadableDetachableModel[T](entity){

	var id : Long = entity.id 
	override def load() : T = {
		println("********************* " + id + " *********************")
		service.find(id).get
	}
}