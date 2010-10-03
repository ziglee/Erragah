package net.cassiolandim.erragah.web.page

import org.apache.wicket.PageParameters
import org.apache.wicket.markup.html.basic.Label

class HomePage extends TemplatePage {
	add(new Label("message", "If you see this message wicket is properly configured and running"));
}