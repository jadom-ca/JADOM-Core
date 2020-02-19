package ca.jadom.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ca.jadom.dom.head;
import ca.jadom.dom.html;

class HTML {

	@Test
	void test() {
	html html = new html();
	System.out.println(html);
	head head = new head();
	System.out.println(head);
	
	}

}
