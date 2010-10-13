package net.cassiolandim.erragah.web.page.company

import net.cassiolandim.erragah.web.page.TemplatePage
import org.apache.wicket.Page
import org.apache.wicket.markup.html.form.Form
import net.cassiolandim.erragah.WicketApplication
import net.cassiolandim.erragah.Company
import net.cassiolandim.erragah.web.model.EntityLoadableDetachableModel
import org.apache.wicket.markup.html.form.Button
import org.apache.wicket.markup.html.form.TextField
import org.apache.wicket.model.PropertyModel
import org.apache.wicket.validation.validator.StringValidator
import org.apache.wicket.markup.html.panel.FeedbackPanel

class GeneralPage(val company : Company) extends TemplatePage {

	def this() = this(new Company())
	
	val feedbackPanel : FeedbackPanel = new FeedbackPanel("feedback")
	val model : EntityLoadableDetachableModel[Company] = new EntityLoadableDetachableModel[Company](company, getApplication.asInstanceOf[WicketApplication].companyService);
	val form : Form[Company] = new Form[Company]("form", model)
	
	add(feedbackPanel)
	add(form)
	
	val nome : TextField[String] = new TextField[String]("nome", new PropertyModel[String](company, "nome"))
	nome.setRequired(true)
	nome.add(StringValidator.maximumLength(50))
	form.add(nome)
	
	val salvar : Button = new Button("salvar"){
		override def onSubmit() {
			getApplication.asInstanceOf[WicketApplication].companyService.updateCompany(company);
			model.id = company.id;
			info("Sucesso: " + company.nome);
		}
	}
	form.add(salvar)

}