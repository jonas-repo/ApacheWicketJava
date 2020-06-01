package com.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import com.wicket.models.UserModel;

public class SpringIntegration extends WebPage{


	private static final long serialVersionUID = 1L;

	/**
	 * Enable this part if you want to use the spring bean
	 */
	//@SpringBean(name="userModel") //this bean is defined in the applicationContext file webapp>applicationcontext
	//private UserModel userModel;
	
	public SpringIntegration() {
		
		//add(new Label("nameLabel" , new PropertyModel<String>(userModel.getName(),"name")));
		//add(new Label("genderLabel" , new PropertyModel<String>(userModel.getGender(),"gender")));
		
		add(new Label("nameLabel" , new Model<String>(UserSession.getInstance().getUserModel().getName())));
		add(new Label("genderLabel" , new Model<String>(UserSession.getInstance().getUserModel().getGender())));
		
		add(new Link<String>("signOut") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				UserSession.getInstance().invalidate();
				setResponsePage(LoginPage.class);
			}
			
		});
			
		
	
	}

}
