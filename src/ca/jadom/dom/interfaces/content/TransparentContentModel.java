package ca.jadom.dom.interfaces.content;

/**
 * Some elements are described as transparent; they have "transparent" in 
 * the description of their content model. The content model of a transparent element 
 * is derived from the content model of its parent element: the elements required in
 *  the part of the content model that is "transparent" are the same elements as required 
 *  in the part of the content model of the parent of the transparent element in which 
 *  the transparent element finds itself.
 *  @see <a href='https://html.spec.whatwg.org/multipage/dom.html#transparent'>
 *  https://html.spec.whatwg.org/multipage/dom.html#transparent</a>
 * @author Aaron Ali
 *
 */
public interface TransparentContentModel {

}
