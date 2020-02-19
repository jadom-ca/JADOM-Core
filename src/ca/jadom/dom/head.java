package ca.jadom.dom;
 
import ca.jadom.dom.element.Element;
import ca.jadom.dom.interfaces.content.MetadataContent;

public class head extends Element {
	
	
	public head() { 
		super();
		this.id="0";
		this.allowedContents.add(MetadataContent.class);
	}
	public head(String title) {
		this();  
		this.add(new title(title));
	
	}
	 
}
