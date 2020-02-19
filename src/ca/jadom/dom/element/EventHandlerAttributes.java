package ca.jadom.dom.element;

import java.util.HashMap; 
import java.util.Map; 

/**
 * @see <a href='https://html.spec.whatwg.org/multipage/dom.html#global-events'>
 *      https://html.spec.whatwg.org/multipage/dom.html#global-events</a>
 * @author Aaron Ali
 *
 */
public class EventHandlerAttributes {

	Map<String, String> events = new HashMap<String, String>();

	private void initMap() {  
		events.put("onmouseenter",null);
		events.put("onmouseleave",null);
		events.put("onmousemove",null);
		events.put("onmouseout",null); 
		events.put("onmouseover",null); 
		events.put("onpaste",null); 
		events.put("onpause",null);
		events.put("onplay",null);
		events.put("onplaying",null);
		events.put("onprogress",null);
		events.put("onratechange",null);
		events.put("onreset",null);
		events.put("onresize",null);
		events.put("onscroll",null);
		events.put("onsecuritypolicyviolation",null);
		events.put("onseeked",null);
		events.put("onseeking",null);
		events.put("onselect",null);
		events.put("onslotchange",null);
		events.put("onmouseup",null);
		events.put("onstalled",null);
		events.put("onsuspend",null);
		events.put("ontoggle",null);
		events.put("ontimeupdate",null);
		events.put("onvolumechange",null);
		events.put("onwaiting",null);
		events.put("onwheel",null); 
		events.put("onmousedown",null); 
		events.put("onloadstart",null); 
		events.put("onloadedmetadata",null); 
		events.put("onloadeddata",null);
		events.put("onkeyup",null);
		events.put("onkeypress",null);
		events.put("onkeydown",null);
		events.put("onloadeddata",null);
		events.put("oninvalid",null);
		events.put("onload",null);
		events.put("ondrop",null);
		events.put("ondurationchange",null);
		events.put("onemptied",null);
		events.put("onended",null);
		events.put("onerror",null);
		events.put("onfocus",null);
		events.put("onformdata",null);
		events.put("oninput",null);
		events.put("ondragstart",null);
		events.put("ondragover",null);
		events.put("ondragleave",null);
		events.put("ondragexit",null);
		events.put("ondragenter",null);
		events.put("ondragend",null);
		events.put("ondrag",null);
		events.put("ondblclick",null);
		events.put("oncut",null);
		events.put("oncuechange",null);
		events.put("oncopy",null);
		events.put("oncontextmenu",null);
		events.put("onclose",null);
		events.put("onclick",null);
		events.put("onchange",null);
		events.put("oncanplaythrough",null);
		events.put("oncanplay",null);
		events.put("oncancel",null);
		events.put("onblur",null);
		events.put("onauxclick",null);
		events.put("onabort",null);   
	}

	public EventHandlerAttributes() {
		initMap();
	}
	

	public boolean put(String name, String value) {
		if(events.containsKey(name)) {
			events.put(name, value);
			return true;
		}
		return false;
	}
	

	public String get(String name) {
		if(events.containsKey(name)) {
			events.get(name);
		}
		return null;
	}

	public boolean append(String name, String value) {
		if(events.containsKey(name)) {
			events.put(name, events.get(name).concat(value));
			return true;
		}
		return false;
	} 

}
