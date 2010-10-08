package net.cassiolandim.erragah.web.page

import org.apache.wicket.PageParameters
import org.apache.wicket.markup.html.basic.Label
import net.cassiolandim.erragah._
import org.apache.wicket.spring.injection.annot.SpringBean
import scala.reflect.BeanProperty

class HomePage extends TemplatePage {

	add(new Label("message", getCompany.get.nome ))
	
	def getCompany = {
		getApplication.asInstanceOf[WicketApplication].companyService.select()
	}
}