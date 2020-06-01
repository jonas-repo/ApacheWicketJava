package com.wicket;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow.PageCreator;
import org.apache.wicket.markup.html.panel.Panel;

public class ModalComponent extends Panel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ModalComponent(String id) {
		super(id);
		
		ModalWindow modalWindow = new ModalWindow("ModalWindow");
		
		modalWindow.setPageCreator(new PageCreator() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public Page createPage() {
				
				return new WelcomePage();
			}
			
		});
			
		
		
		modalWindow.setTitle("Modal window Example");
		
		add(new AjaxLink<String>("Modal") {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void onClick(AjaxRequestTarget target) {
				modalWindow.show(target);
				
			}
			
			
		});
		
		add(modalWindow);
	}

}
