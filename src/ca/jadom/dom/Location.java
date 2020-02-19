package ca.jadom.dom;

import ca.jadom.dom.element.Element;
import sun.reflect.generics.reflectiveObjects.NotImplementedException; 
/**
 * Each Window object is associated with a unique instance of a Location object,
 * allocated when the Window object is created.
 * @see <a href='https://html.spec.whatwg.org/multipage/history.html#location'>
 * https://html.spec.whatwg.org/multipage/history.html#location</a>
 * @author Aaron Ali
 *
 */
public class Location extends Element{
	  protected StringBuilder href;
	  private String origin;
	  protected String protocol;
	  protected String host;
	  protected String hostname;
	  protected String port;
	  protected String pathname;
	  protected String search;
	  protected String hash;
	  private String[] ancestorOrigins;
	  
	  public Location() {}

	  public Location(StringBuilder href, String origin, String protocol, String host, String hostname, String port,
			String pathname, String search, String hash, String[] ancestorOrigins) {
		super();
		this.href = href;
		this.origin = origin;
		this.protocol = protocol;
		this.host = host;
		this.hostname = hostname;
		this.port = port;
		this.pathname = pathname;
		this.search = search;
		this.hash = hash;
		this.ancestorOrigins = ancestorOrigins;
	}
	public void assign(String url) {
		  throw new NotImplementedException();
	  }
	  void replace(String url) {
		  throw new NotImplementedException();
	  }
	  void reload() {
		  throw new NotImplementedException();
	  }

	public StringBuilder getHref() {
		return href;
	}

	public void setHref(StringBuilder href) {
		this.href = href;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getPathname() {
		return pathname;
	}

	public void setPathname(String pathname) {
		this.pathname = pathname;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getOrigin() {
		return origin;
	}

	public String[] getAncestorOrigins() {
		return ancestorOrigins;
	}
	  
	  

}
