package net.cassiolandim.erragah

import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.context.ApplicationContext;
import net.cassiolandim.erragah.web.page.HomePage
import net.cassiolandim.erragah.service._
import scala.reflect.BeanProperty

class WicketApplication extends WebApplication {
	
	@BeanProperty
	var companyService : CompanyService = null
	
	def getHomePage = classOf[HomePage]
	
	override def init(){
		super.init();
		
		addComponentInstantiationListener(new SpringComponentInjector(this))
	}

}