package ca.jadom.dom.element;
  
import java.util.Collection;
 
import ca.jadom.core.DOMElement;
import ca.jadom.core.Node;
import ca.jadom.dom.Document; 

public   class Element extends Node implements DOMElement{

	protected Document document = null;
	 
	public Element() {
		super();
		 
	}
	
	public Element(String name, String text, Attributes attributes){
		super(text, attributes);
	}
	
	/**
	 * Sets which interaces are allowed to be added as nodes
	 */
	public void setAllowedContent(Collection<Class<?>> contentsCollection) {
		this.allowedContents=  contentsCollection;
	} 
	 
}
