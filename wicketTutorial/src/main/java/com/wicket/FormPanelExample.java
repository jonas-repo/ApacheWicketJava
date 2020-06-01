package com.wicket;

import java.util.ArrayList;
import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import com.wicket.models.UserModel;

public class FormPanelExample extends Panel{
		
	/**
	 *  This panel is to create an entire component of a web page to 
	 * 	maintain the order of all the components in our web page
	 *  
	 */
	

	private List<String> genderChoices = new ArrayList<String>();
	
	
	public FormPanelExample(String id) {
		super(id);//assign an id to super class
		//The choices of gender we want to fill dropdown
				genderChoices.add("Male");
				genderChoices.add("Female");
				genderChoices.add("No specified");
				UserModel userModel = new UserModel();
				
				PropertyModel<String> propertyModel = new PropertyModel<String>(userModel, "name");//we only need the name model in this property
				PropertyModel<String> propertyModelGender = new PropertyModel<String>(userModel, "gender");
				
				
				Form<?> wicketFormulary = new Form("form"); //id form
				
				final TextField<String> text = new TextField<String>("text", propertyModel); //id and the model that have to be filled
				text.setOutputMarkupId(true);
				
				
				final DropDownChoice<String> gender = new DropDownChoice<String>("gender", propertyModelGender,genderChoices);//id,model,list of choice
				gender.setOutputMarkupId(true);
//				Button button = new Button("submit"){
//					@Override
//					public void onSubmit() {
//						super.onSubmit();
//						System.out.println(userModel.getName());
//						System.out.println(userModel.getGender());
//					}
//				};
				
				AjaxButton ajaxButton = new AjaxButton("submit") {
					
					@Override
					protected void onSubmit(AjaxRequestTarget target) {
						super.onSubmit(target);
						
						text.setEnabled(false);
						text.setEnabled(false);
						
						target.add(text);
						target.add(gender);
					}		
				};
				
				
				//maintain the hierarchy
				add(wicketFormulary); // add form and their components in order
				wicketFormulary.add(text);
				wicketFormulary.add(gender);
				wicketFormulary.add(ajaxButton);
	}
}
