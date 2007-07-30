/* *************************************************************************
 
 IT Mill Toolkit 

 Development of Browser User Interfaces Made Easy

 Copyright (C) 2000-2006 IT Mill Ltd
 
 *************************************************************************

 This product is distributed under commercial license that can be found
 from the product package on license.pdf. Use of this product might 
 require purchasing a commercial license from IT Mill Ltd. For guidelines 
 on usage, see licensing-guidelines.html

 *************************************************************************
 
 For more information, contact:
 
 IT Mill Ltd                           phone: +358 2 4802 7180
 Ruukinkatu 2-4                        fax:   +358 2 4802 7181
 20540, Turku                          email:  info@itmill.com
 Finland                               company www: www.itmill.com
 
 Primary source for information and releases: www.itmill.com

 ********************************************************************** */

package com.itmill.toolkit.terminal;

/**
 * This interface defines the methods for painting XML to the UIDL stream.
 * 
 * @author IT Mill Ltd.
 * @version
 * @VERSION@
 * @since 3.0
 */
public interface PaintTarget {

	/**
	 * Prints single XMLsection.
	 * 
	 * Prints full XML section. The section data is escaped from XML tags and
	 * surrounded by XML start and end-tags.
	 * 
	 * @param sectionTagName
	 *            the name of the tag.
	 * @param sectionData
	 *            the scetion data.
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addSection(String sectionTagName, String sectionData)
			throws PaintException;

	/**
	 * Prints element start tag of a paintable section. Starts a paintable
	 * section using the given tag. The PaintTarget may implement a caching
	 * scheme, that checks the paintable has actually changed or can a cached
	 * version be used instead. This method should call the startTag method.
	 * <p>
	 * If the Paintable is found in cache and this function returns true it may
	 * omit the content and close the tag, in which case cached content should
	 * be used.
	 * </p>
	 * 
	 * @param paintable
	 *            the paintable to start.
	 * @param tag
	 *            the name of the start tag.
	 * @return <code>true</code> if paintable found in cache,
	 *         <code>false</code> otherwise.
	 * @throws PaintException
	 *             if the paint operation failed.
	 * @see #startTag(String)
	 * @since 3.1
	 */
	public boolean startTag(Paintable paintable, String tag)
			throws PaintException;

	/**
	 * Prints element start tag.
	 * 
	 * <pre>
	 * Todo:
	 * Checking of input values
	 * </pre>
	 * 
	 * @param tagName
	 *            the name of the start tag.
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void startTag(String tagName) throws PaintException;

	/**
	 * Prints element end tag.
	 * 
	 * If the parent tag is closed before every child tag is closed an
	 * PaintException is raised.
	 * 
	 * @param tagName
	 *            the name of the end tag.
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void endTag(String tagName) throws PaintException;

	/**
	 * Adds a boolean attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Attribute name.
	 * @param value
	 *            the Attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, boolean value) throws PaintException;

	/**
	 * Adds a integer attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Attribute name.
	 * @param value
	 *            the Attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, int value) throws PaintException;

	/**
	 * Adds a resource attribute to component. Atributes must be added before
	 * any content is written.
	 * 
	 * @param name
	 *            the Attribute name
	 * @param value
	 *            the Attribute value
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, Resource value) throws PaintException;

	/**
	 * Adds a long attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Attribute name.
	 * @param value
	 *            the Attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, long value) throws PaintException;
	
	/**
	 * Adds a float attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Attribute name.
	 * @param value
	 *            the Attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, float value) throws PaintException;
	
	/**
	 * Adds a double attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Attribute name.
	 * @param value
	 *            the Attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, double value) throws PaintException;

	/**
	 * Adds a string attribute to component. Atributes must be added before any
	 * content is written.
	 * 
	 * @param name
	 *            the Boolean attribute name.
	 * @param value
	 *            the Boolean attribute value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addAttribute(String name, String value) throws PaintException;

	/**
	 * Adds a string type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, String value)
			throws PaintException;

	/**
	 * Adds a int type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, int value)
			throws PaintException;
	
	/**
	 * Adds a long type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, long value)
			throws PaintException;
	
	/**
	 * Adds a float type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, float value)
			throws PaintException;
	
	/**
	 * Adds a double type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, double value)
			throws PaintException;

	/**
	 * Adds a boolean type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, boolean value)
			throws PaintException;

	/**
	 * Adds a string array type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * @param value
	 *            the Variable initial value.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addVariable(VariableOwner owner, String name, String[] value)
			throws PaintException;

	/**
	 * Adds a upload stream type variable.
	 * 
	 * @param owner
	 *            the Listener for variable changes.
	 * @param name
	 *            the Variable name.
	 * 
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addUploadStreamVariable(VariableOwner owner, String name)
			throws PaintException;

	/**
	 * Prints single XML section.
	 * <p>
	 * Prints full XML section. The section data must be XML and it is
	 * surrounded by XML start and end-tags.
	 * </p>
	 * 
	 * @param sectionTagName
	 *            the tag name.
	 * @param sectionData
	 *            the section data to be printed.
	 * @param namespace
	 *            the namespace.
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addXMLSection(String sectionTagName, String sectionData,
			String namespace) throws PaintException;

	/**
	 * Adds UIDL directly. The UIDL must be valid in accordance with the
	 * UIDL.dtd
	 * 
	 * @param uidl
	 *            the UIDL to be added.
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	public void addUIDL(java.lang.String uidl) throws PaintException;

	/**
	 * Adds text node. All the contents of the text are XML-escaped.
	 * 
	 * @param text
	 *            the Text to add
	 * @throws PaintException
	 *             if the paint operation failed.
	 */
	void addText(String text) throws PaintException;

	/**
	 * Adds CDATA node to target UIDL-tree.
	 * 
	 * @param text
	 *            the Character data to add
	 * @throws PaintException
	 *             if the paint operation failed.
	 * @since 3.1
	 */
	void addCharacterData(String text) throws PaintException;

	public void addAttribute(String string, Object[] keys);
}
