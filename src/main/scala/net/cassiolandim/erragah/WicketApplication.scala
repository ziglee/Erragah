package net.cassiolandim.erragah

import org.apache.wicket.protocol.http.WebApplication
import net.cassiolandim.erragah.web.page.HomePage

class WicketApplication extends WebApplication {
	def getHomePage = classOf[HomePage]
}