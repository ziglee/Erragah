package net.cassiolandim.erragah.web.page

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.link.Link
import net.cassiolandim.erragah.web.page.company.GeneralPage

class TemplatePage extends WebPage {
	add(new Label("user", "Cassio"));
	add(new Link[GeneralPage]("generalLink"){
		def onClick(){
			setResponsePage(classOf[GeneralPage])
		}
	});
}