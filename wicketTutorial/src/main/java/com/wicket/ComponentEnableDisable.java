package com.wicket;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;

public class ComponentEnableDisable extends Panel{
	
	
	/**
	 * This component displays a component that allows to hide or show a textfield
	 */

	//objects
	

	
	public ComponentEnableDisable(String id) {
		super(id); //assign an id to super class
		
		//objects to use
		Form<?> form2 = new Form("form2");
		final TextField<String> textField = new TextField<String>("textField", new Model<String>());
		textField.setOutputMarkupId(true); //for changes without reload the page
		textField.setOutputMarkupPlaceholderTag(true);
	
		AjaxButton ajaxButton = new AjaxButton("submit") {
			
			/**
			 * assign an ID to this button
			 */
			private static final long serialVersionUID = 1L;

			@Override
			protected void onSubmit(AjaxRequestTarget target) {
				super.onSubmit(target);
				
				if(textField.isVisible()) {
					textField.setVisible(false);
				}
				else
				{
					textField.setVisible(true);
				}
				target.add(textField);
			}		
		};
		add(form2);
		form2.add(textField);
		form2.add(ajaxButton);
	}

}
