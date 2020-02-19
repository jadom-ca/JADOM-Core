package ca.jadom.core;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import ca.jadom.exceptions.JaDomCoreNotInitializedException;
import ca.jadom.exceptions.JaDomDuplicateIdException;
import ca.jadom.exceptions.JadomPropertyNotFoundException;

public class Core {

	protected static Map<String,String> Strings = new HashMap<String,String>() ;
	String propFileName = "jadom.properties";
	private static long id = 1000000;
	private  Properties properties;
	private static List<String> ids; 
	private Core() {};
	/**
	 * Get the next unique id
	 * @return
	 */
	public static String Id() {
		if(core==null) 
			core = getInstance();
		id=id+1;
		return String.valueOf(id);
	}
	
	public static String Strings(String string) {
		if(core==null)
			core = Core.getInstance();
		return Strings.get(string);
	}
	/**
	 * 
	 * @param id
	 */
	public void addId(String id) {
		if(core==null) 
			core = getInstance();
		if(ids.contains(id)) {
			throw new JaDomDuplicateIdException();
		}else {
			ids.add(id);
		}
	}
	/**
	 * 
	 * @param id
	 */
	public static void AddId(String id) {
		if(core==null) 
			core = getInstance();
		if(ids.contains(id)) {
			throw new JaDomDuplicateIdException();
		}else {
			ids.add(id);
		}
	}
	
	/**
	 * Returns true if the id has been used
	 * @param id
	 * @return
	 */
	public boolean getId(String id) {
		if(core==null) 
			core = getInstance();
		if(ids.contains(id)) {
			return true;
		}
		return false;
	}
	
	public static short UseParent() {
		return  core.useParent;
	}

	public static short useParent() {
		return     core.useParent; 
	}

	
	protected short useParent;
	private void loadConfig() {
		if(core==null) 
			core = getInstance();
		InputStream inputStream = null;
		try {
			properties = new Properties(); 
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				properties.load(inputStream);
			} else {
				 
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
				 
			} 
  			System.out.println(properties);
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			if(inputStream!=null) 
				try {
				inputStream.close(); 
				}catch(Exception e) {
					throw new RuntimeException("Error initilizing Core");
				}
		} 
 	}
	
	private static Core core =null;
	public static Core getInstance() {
		if(core !=null) {
			return core;
		} 
		Core.Strings =new HashMap<String,String>();

		Strings.put(JadomPropertyNotFoundException.class.getSimpleName(), "Property not found");
		
		
		
		core  = new Core();
		core.loadConfig();
		ids= new ArrayList<>();
			try {
		if(core.properties.get("input.parentDocument")!=null) {
				String s =  core.properties.getProperty("input.parentDocument") ;
				if("0129".contains(s.trim() )) {
				core.useParent=Short.valueOf(  core.properties.getProperty("input.parentDocument").trim());
				}else throw new JadomPropertyNotFoundException("input.parentDocument") ;
			
		}else throw new JadomPropertyNotFoundException("input.parentDocument") ;
		}catch(Exception e) {
			e.printStackTrace();
				System.out.println(e);
				core.useParent=9;
			} 
		 ;

		return core;
	}
	
	public String getProperty(String name) { 
		return properties.getProperty(name);
	}
	
	public static boolean Compliant() {
		if(core==null)
			core = getInstance();
		return core.compliant();
	}
	final String FORCECOMPLIANCE = "force.compliance";
	public boolean compliant() { 
		if(properties==null) {
			throw new JaDomCoreNotInitializedException();
		}
		return Boolean.valueOf(properties.getProperty(FORCECOMPLIANCE).toLowerCase().trim());
	}
	
	 
}
