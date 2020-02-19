package ca.jadom.dom.element;

import java.util.HashMap;
import java.util.Map;

/**HTML DOM Element Attributes
 * @see <a href='https://html.spec.whatwg.org/multipage/dom.html#global-attributes'>
 * https://html.spec.whatwg.org/multipage/dom.html#global-attributes</a>
 * @author Aaron Ali
 *
 */
public class Attributes {

	Map<String,String> attributes = new HashMap<String,String>();
	private void initMap() {
		attributes.put("accesskey",null);
		attributes.put("autocapitalize",null);
		attributes.put("autofocus",null);
		attributes.put("contenteditable",null);
		attributes.put("class",null);
		attributes.put("contenteditable",null);
		attributes.put("dir",null);
		attributes.put("draggable",null);
		attributes.put("enterkeyhint",null);
		attributes.put("hidden",null);
		attributes.put("inputmode",null);
		attributes.put("itemid",null);
		attributes.put("itemprop",null);
		attributes.put("itemref",null);
		attributes.put("itemscope",null);
		attributes.put("itemref",null);
		attributes.put("itemscope",null);
		attributes.put("itemtype",null);
		attributes.put("lang",null);
		attributes.put("nonce",null);
		attributes.put("slot",null);
		attributes.put("spellcheck",null);
		attributes.put("tabindex",null);
		attributes.put("title",null);
		attributes.put("translate",null);  
 } 
	public Attributes() { 
	initMap(); 
	}
	
	public boolean put(String name, String value) {
		if(attributes.containsKey(name)) {
			attributes.put(name, value);
			return true;
		}
		return false;
	}
	

	public String get(String name) {
		if(attributes.containsKey(name)) {
			attributes.get(name);
		}
		return null;
	}

	public boolean append(String name, String value) {
		if(attributes.containsKey(name)) {
			attributes.put(name, attributes.get(name).concat(value));
			return true;
		}
		return false;
	}

	/**
	 * <b>Warning</b> : Forces a new attribute or overrides a current attribute
	 * without prejiduce
	 * @param name
	 * @param name
	 */
	public void newAttribute(String name, String value) {
		attributes.put(name, value);
		
	}
	
	final public Map<String,String> getAll(){
		return   attributes ;
	}
}
