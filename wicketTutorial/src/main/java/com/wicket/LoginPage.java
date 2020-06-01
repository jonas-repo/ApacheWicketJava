package com.wicket;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

import com.wicket.models.UserModel;

public class LoginPage extends WebPage{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public LoginPage() {
		final UserModel userModel = new UserModel();
		Form<Object> form = new Form<Object>("form"); 
		
		form.add(new TextField<String>("userName", new PropertyModel<String>(userModel,"name")));
		form.add(new PasswordTextField("password", new PropertyModel<String>(userModel, "password")));
		
		form.add(new Button("submit"){
			private static final long serialVersionUID = 1L;
			
			@Override
			public void onSubmit() {
				super.onSubmit();
				
				if(userModel.getName().equals("admin") && userModel.getPassword().equals("admin")) {
					userModel.setGender("undefined");
					UserSession.getInstance().setUserModel(userModel);
					setResponsePage(SpringIntegration.class);
				}
				else
				{
					System.out.println("Invalid user name or password");
				}
			}
		});
		
		add(form);
	}
}
