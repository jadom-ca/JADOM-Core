package ca.jadom.dom.interfaces.content;

/**
 * As a general rule, elements whose content model allows any flow content
 *  or phrasing content should have at least one node in its contents that is palpable 
 *  content and that does not have the hidden attribute specified. Palpable content makes
 *   an element non-empty by providing either some descendant non-empty text, or else
 *    something users can hear (audio elements) or view (video or img or canvas elements) 
 *    or otherwise interact with (for example, interactive form controls).
 *    @see <a href='https://html.spec.whatwg.org/multipage/dom.html#palpable-content-2'>
 *    https://html.spec.whatwg.org/multipage/dom.html#palpable-content-2</a>
 * @author AARONAli
 *
 */
public interface PalpableContent extends ContentInterface {

}
