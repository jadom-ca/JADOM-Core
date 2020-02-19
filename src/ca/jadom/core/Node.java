package ca.jadom.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

import ca.jadom.dom.Document;
import ca.jadom.dom.element.Attributes;
import ca.jadom.exceptions.JaDomElementNotAllowedException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;
 

public class Node { 
	protected String id;
	protected String nodeName;
	protected String text="";
	protected Attributes attributes;
	protected Collection<Class<?>> allowedContents ;
	public Node  nextNode = null;
	public Node  parentNode = null;
	public  Node previousNode = null;
	
	
	public Node() {
		id=Core.Id();
		allowedContents = new ArrayList<Class<?>>();
		attributes= new Attributes();  
		this.nodeName=this.getClass().getSimpleName(); 
	}
	
	public Node( String text, Attributes attributes)  {
		id=Core.Id();
		this.nodeName=this.getClass().getSimpleName(); 
		this.text=text; 
		this.attributes= attributes;
		if(attributes==null) {
			this.attributes=new Attributes();
		}
	}
	
	
	private List<Node> nodes=new ArrayList<>(); 
	private Document document = null;
	
	public boolean add(Node node) {
		 if(Core.Compliant()) {   
			 Collection<Class<?>> nodeClasses= new ArrayList<Class<?>>();
			 nodeClasses.add(node.getClass());
			 for(Class<?> cls : node.getClass().getInterfaces()) {
				 nodeClasses.add(cls); 
			 } 
             boolean nodeAdded = false;	 			  
			 for(Class<?> cont : this.allowedContents){
				if(nodeClasses.contains(cont)) { 
					 if(nodes.size()>0) { 
						 node.previousNode=nodes.get(nodes.size()-1);
						 node.parentNode=this;
					 } 
					 nodeAdded=true;
					 break;
				} 
			 } 
			 if(Core.UseParent()==9 || nodeAdded &&( (Core.UseParent()==2 ||   Core.UseParent()==0)   ||
					 (Core.UseParent()==1 && node.document==this.document    ) )) { 
				 if(  Core.UseParent()==0) {
					 node.document=this.document;
				 }
				 if(  Core.UseParent()==9) {
					 if(this.document==null) {
						 Class<?> x = this.getClass();
						 Class<?> x1 = this.getClass();
						 int i=0;
							while (x!=null   && !x.getClass().equals( Document.class)) {
								System.out.print(x.getCanonicalName()); 
								x = x.getClass().getDeclaringClass();
								i++;
								
							}
							if(x!=null  ) {

								System.out.print(x ); 
							}
					 }
				 }
				 nodes.add(node);
			 }else { 
				  throw new JaDomElementNotAllowedException();
			}
				 
			 
		 }else {
			 nodes.add(node);
		 }
		 
		 return node.childNodes().contains(node);
	}
	
	/**
	 * Insert n1 after n2
	 * @param n1
	 * @param n2
	 * @return 
	 */
	public boolean  addAfter(Node n1 , Node n2) {
		n1.parentNode=this;
		int n  = nodes.size();
		for( int i = 0 ; i < nodes.size();i++) {
			if(nodes.get(i).id==n2.id) { 
					 n1.previousNode=nodes.get(i); 
					 nodes.get(i).nextNode=n1;
				 
				 if(i<nodes.size()) { 
					 n1.nextNode=nodes.get(i+1);
					 nodes.get(i+1).previousNode=n1;
				 }
				nodes.add(i, n1);
				break;
			}
		}
		return n == nodes.size()-1;
		}
	
	/**
	 * Remove node after n1
	 * @param n1
	 * @param n2
	 * @return 
	 */
	public boolean  removeAfter(Node n1) {
		int n  = nodes.size();
		for( int i = 0 ; i < nodes.size();i++) {
			if(nodes.get(i).id==n1.id) {
				if((i+1)<nodes.size()) {
					nodes.remove(i+1);
					break;
				}
			}
		}
		return n == nodes.size()+1;
		}
	
	
	public boolean remove(Node node) {
		int n = nodes.size();
		for( int i = 0 ; i < nodes.size();i++) {
			if(nodes.get(i).id==node.id) {
				if(i<0) {
					nodes.get(i-1).nextNode=nodes.get(i+1);
				}
				if(i<nodes.size()) {
					nodes.get(i+1).previousNode=nodes.get(i-1);
				}
				nodes.remove(i);
				break;
			}
		}
		return n == nodes.size()+1;
	}
	
	public List<Node> childNodes() {
		return nodes;
	}
	
	public Attributes attributes() {
		return this.attributes;
	}
	
	/**
	 * Returns true if the given interface is allowed to be added as a node
	 * @param contentInterface
	 * @return
	 */
	protected boolean isAllowedContents(Class<?> contentInterface) {
		if(allowedContents.contains(contentInterface)) {
			return true;
		}else {return false;}
		
	}
	
	/**
	 * Return html string for the node
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();
		if(id!="0") {
		s.append("<").append(nodeName.toLowerCase()).append(" id='").append(id).append("'");
		}else {
			s.append("<").append(nodeName.toLowerCase())	;	
		}
		
		String tag="";
		for(String att :attributes.getAll().keySet()) {
			if(attributes.get(att)!=null && attributes.get(att).trim().length()>0) {
			tag=tag.concat(" "+att+"=\""+attributes.get(att)+"\"");
			}
		}
		tag = tag.concat(">");
		s.append(tag);
		s.append(text); 
		for(Node n : nodes) {
			s.append(System.lineSeparator()); 
			s.append(n.toString());
			if(n.nextNode!=null)
				s.append(System.lineSeparator());
		} 
		if(nodes.size()!=0) { 
			s.append(System.lineSeparator());
		}
		return s.toString().concat("</").concat(nodeName.toLowerCase()).concat(">");
	}
	/**
	 * Return html string for the node
	 */
	protected String toString(int tabIndex) {
		String tab="";
		for(int d =0;d<tabIndex;d++) {
			tab+=" ";
		}
		StringBuilder s = new StringBuilder();
		if(id!="0") {
		s.append(tab).append("<").append(nodeName.toLowerCase()).append(" id='").append(id).append("'");
		}else {
			s.append(tab).append("<").append(nodeName.toLowerCase())	;	
		}
		
		String tag="";
		for(String att :attributes.getAll().keySet()) {
			if(attributes.get(att)!=null && attributes.get(att).trim().length()>0) {
			tag=tag.concat(" "+att+"=\""+attributes.get(att)+"\"");
			}
		}
		tag = tag.concat(">");
		s.append(tag);
		s.append(text); 
		for(Node n : nodes) {
			s.append(System.lineSeparator()); 
			s.append(n.toString(tabIndex+5));
			if(n.nextNode!=null)
				s.append(System.lineSeparator());
		} 
		if(nodes.size()!=0) { 
			s.append(System.lineSeparator().concat(tab));
		}
		return s.toString().concat("</").concat(nodeName.toLowerCase()).concat(">").replace(System.lineSeparator(), tab.concat(System.lineSeparator()));
	//	s.replace(System.lineSeparator(), n.concat(System.lineSeparator());
	}
	
	public String  toStringPrettify(){
		return this.toString(0);
	}
	 
	public Node parentNode() {

		throw new NotImplementedException();
	}
 
	public Node firstChild() {

		throw new NotImplementedException();
	}
 
	public Node lastChild() {

		throw new NotImplementedException();
	}
 
	public Node previousSibling() {

		throw new NotImplementedException();
	}
 
	public Node nextSibling() {

		throw new NotImplementedException();
	}
 
	public Node insertBeforeNode(Node newChild, Node refChild) throws DOMException {

		throw new NotImplementedException();
	}
 
	public Node replaceChildNode(Node newChild, Node oldChild) throws DOMException {

		throw new NotImplementedException();
	}
 
	public Node removeChildNode(Node oldChild) throws DOMException {

		throw new NotImplementedException();
	}
 
	public Node appendChildNode(Node newChild) throws DOMException {

		throw new NotImplementedException();
	}
  
	public Node clone(boolean deep) {

		throw new NotImplementedException();
	}
 
	public short compareDocumentNodePosition(Node other) throws DOMException {

		throw new NotImplementedException();
	}
 
	public boolean isSame(Node other) {

		throw new NotImplementedException();
	}
 
	public boolean isEqual(Node arg) {

		throw new NotImplementedException();
	}
	 
	public String getId() {
		return id; 
	}
 
	public void setId(String id) {
		this.id=id;
		Core.AddId(id);
	}
 
	public String getTitle() {
	 
		return null;
	}
 
	public void setTitle(String title) {

		throw new NotImplementedException();
	}
 
	public String getLang() {

		throw new NotImplementedException();
	}
 
	public void setLang(String lang) {

		throw new NotImplementedException();
	}
 
	public String getDir() {

		throw new NotImplementedException();
	}
 
	public void setDir(String dir) {

		throw new NotImplementedException();
	}
 
	public String getClassName() {

		throw new NotImplementedException();
	}
 
	public void setClassName(String className) {

		throw new NotImplementedException();
	}
 
	public String getTagName() {
		throw new NotImplementedException();
	}
 
	public String getAttribute(String name) {

		throw new NotImplementedException();
	}
 
	public void setAttribute(String name, String value) throws DOMException {

		throw new NotImplementedException();
	} 
	public void removeAttribute(String name) throws DOMException {

		throw new NotImplementedException();
		
	}
 
	public Attr getAttributeNode(String name) {

		throw new NotImplementedException();
	}
 
	public Attr setAttributeNode(Attr newAttr) throws DOMException {

		throw new NotImplementedException();
	}
 
	public Attr removeAttributeNode(Attr oldAttr) throws DOMException {

		throw new NotImplementedException();
	}
 
	public  NodeList getElementsByTagName(String name) {

		throw new NotImplementedException();
	}

 
	public String getAttributeNS(String namespaceURI, String localName) throws DOMException {

		throw new NotImplementedException();
	}
 
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {

		throw new NotImplementedException();
	}
 
	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {

		throw new NotImplementedException();
		
	}

	
	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {

		throw new NotImplementedException();
	}

	
	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {

		throw new NotImplementedException();
	}

	
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {

		throw new NotImplementedException();
	}

	
	public boolean hasAttribute(String name) {
		return attributes.get(name)!=null;
	}

	
	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {

		throw new NotImplementedException();
	}

	
	public TypeInfo getSchemaTypeInfo() {

		throw new NotImplementedException();
	}

	
	public void setIdAttribute(String name, boolean isId) throws DOMException {

		throw new NotImplementedException();
		
	}

	
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {

		throw new NotImplementedException();
	}

	
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {

		throw new NotImplementedException();
		
	}

	
	public String getNodeName() {
return this.getClass().getSimpleName();
	}

	
	public String getNodeValue() throws DOMException {

		throw new NotImplementedException();
	}

	
	public void setNodeValue(String nodeValue) throws DOMException {

		throw new NotImplementedException();
		
	}

	
	public short getNodeType() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node getParentNode() {

		throw new NotImplementedException();
	}

	
	public NodeList getChildNodes() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node getFirstChild() { 
		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node getLastChild() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node getPreviousSibling() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node getNextSibling() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.NamedNodeMap getAttributes() {

		throw new NotImplementedException();
	}
 
	public org.w3c.dom.Document getOwnerDocument() {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node insertBefore(org.w3c.dom.Node newChild, org.w3c.dom.Node refChild) throws DOMException {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node replaceChild(org.w3c.dom.Node newChild, org.w3c.dom.Node oldChild) throws DOMException {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node removeChild(org.w3c.dom.Node oldChild) throws DOMException {

		throw new NotImplementedException();
	}

	
	public org.w3c.dom.Node appendChild(org.w3c.dom.Node newChild) throws DOMException {

		throw new NotImplementedException();
	}

	
	public boolean hasChildNodes() {
		return nodes.size()>0;
	}

	
	public org.w3c.dom.Node cloneNode(boolean deep) {
		throw new NotImplementedException();
	}

	
	public void normalize() {
		throw new NotImplementedException();
	}

	
	public boolean isSupported(String feature, String version) {
		throw new NotImplementedException();
	}

	
	public String getNamespaceURI() {
		throw new NotImplementedException();
	}

	
	public String getPrefix() {
		throw new NotImplementedException();
	}

	
	public void setPrefix(String prefix) throws DOMException {
		throw new NotImplementedException();
		
	}

	
	public String getLocalName() { 
		throw new NotImplementedException();
	}

		public boolean hasAttributes() { 
		return attributes.getAll().size()>0;
	}

	
	public String getBaseURI() { 
		throw new NotImplementedException();
	}

	
	public short compareDocumentPosition(org.w3c.dom.Node other) throws DOMException {

		throw new NotImplementedException();
	}

	
	public String getTextContent() throws DOMException {
		return text;
	}

	
	public void setTextContent(String textContent) throws DOMException {
		text = textContent;
	}

	
	public boolean isSameNode(org.w3c.dom.Node other) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public String lookupPrefix(String namespaceURI) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public boolean isDefaultNamespace(String namespaceURI) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public String lookupNamespaceURI(String prefix) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public boolean isEqualNode(org.w3c.dom.Node arg) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public Object getFeature(String feature, String version) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	
	public Object getUserData(String key) {
		// TODO Auto-generated method stub
		throw new NotImplementedException();
	}

	public void setDocument(Document document ) {
		this.document=document;
	}
}
