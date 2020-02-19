package ca.jadom.dom;

import ca.jadom.dom.element.Element;

public class html extends Element {

	public html() {
		super(); 
		this.id="0";
		this.allowedContents.add(body.class); 
		this.allowedContents.add(head.class);  
		this.add(new head());
		this.add(new body());
		
	}
	
	public html(String title) {
		this();
		this.head().add(new title(title));
	}
	public body body() {
		return (ca.jadom.dom.body) this.childNodes().get(1);
	}
	 
	public ca.jadom.dom.head head() {
		return (ca.jadom.dom.head) this.childNodes().get(0);
	}
	

}
