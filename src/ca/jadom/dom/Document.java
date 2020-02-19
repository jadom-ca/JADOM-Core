package ca.jadom.dom;

import java.util.ArrayList;
import java.util.Collection;

import ca.jadom.core.DOMElement;
import ca.jadom.core.Node;
import ca.jadom.dom.element.Element; 

/**
 * Every XML and HTML document in an HTML UA is represented by a Document object. [DOM]
 * @see <a href='https://www.w3.org/TR/html52/dom.html#the-document-object'>
 * https://www.w3.org/TR/html52/dom.html#the-document-object</a>
 * @author Aaron Ali
 *
 */
public class Document extends Element{
	public enum  DocumentReadyState { loading, interactive, complete };
	 
	 // resource metadata management
	  private Location location;
	  protected String domain;
	  private   String referrer;
	  protected String cookie;
	  private    String lastModified;
	  private   DocumentReadyState readyState=DocumentReadyState.loading;
	
	  
	  
	  // DOM tree accessors
/*	  getter object (DOMString name);  */
	  private String title;
	  private String dir;
	  private DOMElement  body;
	  private DOMElement head;
	  private  Collection<?> images;
	  private  Collection<?> embeds;
	  private Collection<?> plugins;
	  private Collection<?> links;
	  private Collection<?> forms;
	  private  Collection<?> scripts;
	  Collection<DOMElement> getElementsByName( String elementName) {
		 return null;
	  }
	// private  HTMLOrSVGScriptElement  currentScript; // classic scripts in a document tree only
	  
	
	  
	  public Document() {
		  super();
		  this.setAllowedContent();
		  this.id="0";
		  this.add(new html());
		  this.childNodes().get(0).setDocument(this);
	  }	  
	  public Document(String title) {
		  this(); 
		  this.add(new html(title)); 
	  }
	  
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public String getCookie() {
		return cookie;
	}
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public DocumentReadyState getReadyState() {
		return readyState;
	}
	public void setReadyState(DocumentReadyState readyState) {
		this.readyState = readyState;
	} 
	 
	public void setAllowedContent() {
		ArrayList<Class<?>> c = new ArrayList<Class<?>>();
		c.add(html.class); 
		super.setAllowedContent(c) ;  
	}
	  
	  
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<!DOCTYPE html>").append(System.lineSeparator());
		for(Node n : this.childNodes()) {
			sb.append(n.toString());
		}
		return sb.toString();
	}
	 

}
