package ca.jadom.dom;
 
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import ca.jadom.dom.element.Element;
import ca.jadom.dom.interfaces.content.MetadataContent;

public class title extends Element implements MetadataContent{
	
	public title() {
		this.id="0";
	}
	
	public title(String title) {
		this.text=title;
		this.id="0";
	}
 
}
