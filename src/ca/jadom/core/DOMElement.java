package ca.jadom.core;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.html.HTMLElement;

public interface DOMElement extends HTMLElement{

	 
	public String getId(); 
	public void setId(String id); 
	public String getTitle() ; 
	public void setTitle(String title); 
	public String getLang(); 
	public void setLang(String lang) ;  
	public String getDir(); 
	public void setDir(String dir) ; 
	public String getClassName();
 
	public void setClassName(String className); 
	public String getTagName() ;
 
	public String getAttribute(String name); 
	
	public void setAttribute(String name, String value) throws DOMException;

	
	public void removeAttribute(String name) throws DOMException;

	
	public Attr getAttributeNode(String name);
	
	public Attr setAttributeNode(Attr newAttr) throws DOMException ;
 
	public Attr removeAttributeNode(Attr oldAttr) throws DOMException ;
	
	public NodeList getElementsByTagName(String name) ;
	
	public String getAttributeNS(String namespaceURI, String localName) throws DOMException;
	
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException;

	
	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException;
	 

	
	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException;

	
	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException;

	
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException;
	
	public boolean hasAttribute(String name);

	
	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException;

	
	public TypeInfo getSchemaTypeInfo();
	
	public void setIdAttribute(String name, boolean isId) throws DOMException;

	
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException;
	
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException;

	
	public String getNodeName();
	
	public String getNodeValue() throws DOMException;

	
	public void setNodeValue(String nodeValue) throws DOMException;

	
	public short getNodeType() ;
 
	 
	
	public NodeList getChildNodes();

 

	
	public NamedNodeMap getAttributes();
	
	public Document getOwnerDocument() ;

  
 
	
	public boolean hasChildNodes() ;

	 
	
	public void normalize() ;
	
	public boolean isSupported(String feature, String version);

	
	public String getNamespaceURI() ;
	
	public String getPrefix();
	
	public void setPrefix(String prefix) throws DOMException;
	
	public String getLocalName();
	
	public boolean hasAttributes() ;
	
	public String getBaseURI();
	 
	public String getTextContent() throws DOMException;
	
	public void setTextContent(String textContent) throws DOMException;
	 
	public String lookupPrefix(String namespaceURI) ;
	
	public boolean isDefaultNamespace(String namespaceURI);
	
	public String lookupNamespaceURI(String prefix) ;
	 
	public Object getFeature(String feature, String version);

	
	public Object setUserData(String key, Object data, UserDataHandler handler);

	
	public Object getUserData(String key);
}
