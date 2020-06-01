package com.wicket;


import org.apache.wicket.markup.html.WebPage;


public class WelcomePage extends WebPage {
	
	
	
	private static final long serialVersionUID = 1L;
	
	


	/**
	 *  displays the objects that are connected with wicket in our web page
	 * 
	 *  
	 */
	public WelcomePage() {
		
		add(new FormPanelExample("panel")); //ADD to our web page an entire panel of formPanelExample
		add(new ComponentEnableDisable("panelShow"));
		add(new ModalComponent("modalComponent"));
	}

}
