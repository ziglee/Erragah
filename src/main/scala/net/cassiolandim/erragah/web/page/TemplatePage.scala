package net.cassiolandim.erragah.web.page

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import net.cassiolandim.erragah.web.page.company.GeneralPage
import net.cassiolandim.erragah.Company
import net.cassiolandim.erragah.WicketApplication

class TemplatePage extends WebPage {
	add(new Label("user", "Cassio"));
	add(new Link[GeneralPage]("generalLink"){
		def onClick(){
			//setResponsePage(classOf[GeneralPage])
			setResponsePage(new GeneralPage(getApplication.asInstanceOf[WicketApplication].companyService.find(1L).get))
		}
	});
}