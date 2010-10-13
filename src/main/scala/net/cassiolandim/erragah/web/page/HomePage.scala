package net.cassiolandim.erragah.web.page

import org.apache.wicket.PageParameters
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import net.cassiolandim.erragah._
import org.apache.wicket.spring.injection.annot.SpringBean
import scala.reflect.BeanProperty

class HomePage extends TemplatePage {

	add(new Label("message", getCompany.get.nome))
	add(new Link("insert") {
		def onClick(){
			getApplication.asInstanceOf[WicketApplication].companyService.insertCompany(Company("BBB","222"))
		}
	})
	
	def getCompany = {
		getApplication.asInstanceOf[WicketApplication].companyService.find(1L)
	}
}