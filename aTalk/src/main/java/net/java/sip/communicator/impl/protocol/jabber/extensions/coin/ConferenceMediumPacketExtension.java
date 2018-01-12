/*
 * Jitsi, the OpenSource Java VoIP and Instant Messaging client.
 * 
 * Distributable under LGPL license. See terms of license at gnu.org.
 */
package net.java.sip.communicator.impl.protocol.jabber.extensions.coin;

import java.util.Map;

import net.java.sip.communicator.impl.protocol.jabber.extensions.AbstractPacketExtension;

import org.jivesoftware.smack.packet.ExtensionElement;
import org.jivesoftware.smack.util.XmlStringBuilder;

/**
 * Conference medium packet extension.
 *
 * @author Sebastien Vincent
 * @author Eng Chong Meng
 */
public class ConferenceMediumPacketExtension extends AbstractPacketExtension
{
	/**
	 * The name of the element that contains the conference medium.
	 */
	public static final String ELEMENT_NAME = "medium";

	/**
	 * The namespace that conference medium belongs to. cmeng NAMESPACE cannot be empty
	 */
	public static final String NAMESPACE = "medium";
	/**
	 * Display text element name.
	 */
	public static final String ELEMENT_DISPLAY_TEXT = "display-text";

	/**
	 * Type element name.
	 */
	public static final String ELEMENT_TYPE = "type";

	/**
	 * Status element name.
	 */
	public static final String ELEMENT_STATUS = "status";

	/**
	 * Label attribute name.
	 */
	public static final String LABEL_ATTR_NAME = "label";

	/**
	 * Type.
	 */
	private String type = null;

	/**
	 * Display text.
	 */
	private String displayText = null;

	/**
	 * Media status.
	 */
	private String status = null;

	/**
	 * Constructor.
	 *
	 * @param elementName
	 *        element name
	 * @param label
	 *        label
	 */
	public ConferenceMediumPacketExtension(String elementName, String label)
	{
		super(elementName, NAMESPACE);
		setAttribute(LABEL_ATTR_NAME, label);
	}

	/**
	 * Set status.
	 *
	 * @param status
	 *        status.
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}

	/**
	 * Set type.
	 *
	 * @param type
	 *        type
	 */
	public void setType(String type)
	{
		this.type = type;
	}

	/**
	 * Set display text.
	 * 
	 * @param displayText
	 *        display text
	 */
	public void setDisplayText(String displayText)
	{
		this.displayText = displayText;
	}

	/**
	 * Get display text.
	 *
	 * @return display text
	 */
	public String getDisplayText()
	{
		return displayText;
	}

	/**
	 * Get type.
	 *
	 * @return type
	 */
	public String getType()
	{
		return type;
	}

	/**
	 * Get status.
	 *
	 * @return status.
	 */
	public String getStatus()
	{
		return status;
	}

	/**
	 * Get an XML string representation.
	 *
	 * @return XML string representation
	 */
	@Override
	// public String toXML()
	public XmlStringBuilder toXML()
	{
		XmlStringBuilder xml = new XmlStringBuilder();
		xml.prelude(getElementName(), getNamespace());

		// add the rest of the attributes if any
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			xml.optAttribute(entry.getKey(), entry.getValue().toString());
		}
		xml.append(">");

		xml.optElement(ELEMENT_DISPLAY_TEXT, displayText);
		xml.optElement(ELEMENT_TYPE, type);
		xml.optElement(ELEMENT_STATUS, status);

		for (ExtensionElement ext : getChildExtensions()) {
			xml.append(ext.toXML());
		}

		xml.closeElement(getElementName());
		return xml;
	}
}