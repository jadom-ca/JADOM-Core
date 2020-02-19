package ca.jadom.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.jadom.core.Core;
import ca.jadom.core.Node;
import ca.jadom.dom.Document;
import ca.jadom.dom.head;
import ca.jadom.dom.html;
import ca.jadom.dom.title;
import ca.jadom.dom.element.EventHandlerAttributes;
import ca.jadom.exceptions.JaDomElementNotAllowedException;

class TestNode {


	 
	@Test
	void testDocument1() {
	 head head = new head();
	 head.add(new title("title"));
	}

	 
	@Test
	void testDocument() {
		Core.getInstance();
		EventHandlerAttributes handler = new EventHandlerAttributes();
		Document d = new Document("doc title");
		System.out.println(d);
		System.out.println(d.toStringPrettify());
		assertTrue(d.toString().startsWith("<!DOCTYPE html>")); 
		Core core = Core.getInstance();
		assertTrue(core.compliant());
		assertTrue(Core.Compliant());
	    html html = new html();
		try{
			html.add(new html());
		}catch(Exception e) {
			assertTrue(e.getClass().getCanonicalName().contentEquals(
					JaDomElementNotAllowedException.class.getCanonicalName()));
		} 
	}

}
