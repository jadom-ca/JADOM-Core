package ca.jadom.exceptions;

import ca.jadom.core.Core;

public class JadomPropertyNotFoundException extends Exception { 
	private static final long serialVersionUID = -8968848752458165667L;

	public JadomPropertyNotFoundException() {
		super(Core.Strings( JadomPropertyNotFoundException.class.getSimpleName()));
	}

	public JadomPropertyNotFoundException(String propertyName) {
		super(Core.Strings( JadomPropertyNotFoundException.class.getSimpleName()).concat(" : ").concat(propertyName));
		 
	}

}
