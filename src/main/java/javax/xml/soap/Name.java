/*
 * $Id: Name.java,v 1.5 2006/03/30 00:59:39 ofung Exp $
 * $Revision: 1.5 $
 * $Date: 2006/03/30 00:59:39 $
 */

/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License).  You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at
 * https://glassfish.dev.java.net/public/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at https://glassfish.dev.java.net/public/CDDLv1.0.html.
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Copyright 2006 Sun Microsystems Inc. All Rights Reserved
 */
package javax.xml.soap;

/**
 * A representation of an XML name.  This interface provides methods for
 * getting the local and namespace-qualified names and also for getting the
 * prefix associated with the namespace for the name. It is also possible 
 * to get the URI of the namespace.
 * <P>
 * The following is an example of a namespace declaration in an element.
 * <PRE>
 *   &lt;wombat:GetLastTradePrice xmlns:wombat="http://www.wombat.org/trader"&gt;
 * </PRE>
 * ("xmlns" stands for "XML namespace".)
 * The following 
 * shows what the methods in the <code>Name</code> interface will return.
 * <UL>
 *  <LI><code>getQualifiedName</code> will return "prefix:LocalName" =
 *      "WOMBAT:GetLastTradePrice"
 *  <LI><code>getURI</code> will return "http://www.wombat.org/trader"
 *  <LI><code>getLocalName</code> will return "GetLastTracePrice"
 *  <LI><code>getPrefix</code> will return "WOMBAT"
 * </UL>
 * <P>
 * XML namespaces are used to disambiguate SOAP identifiers from
 * application-specific identifiers.
 * <P>
 * <code>Name</code> objects are created using the method
 * <code>SOAPEnvelope.createName</code>, which has two versions.
 * One method creates <code>Name</code> objects with
 * a local name, a namespace prefix, and a namespace URI. 
 *  and the second creates <code>Name</code> objects with just a local name.  
 * The following line of
 * code, in which <i>se</i> is a <code>SOAPEnvelope</code> object, creates a new
 * <code>Name</code> object with all three.
 * <PRE>
 *     Name name = se.createName("GetLastTradePrice", "WOMBAT",
 *                                "http://www.wombat.org/trader");
 * </PRE>
 * The following line of code gives an example of how a <code>Name</code> object
 * can be used. The variable <i>element</i> is a <code>SOAPElement</code> object.
 * This code creates a new <code>SOAPElement</code> object with the given name and
 * adds it to <i>element</i>.
 * <PRE>
 *     element.addChildElement(name);
 * </PRE>
 * <P>
 * The <code>Name</code> interface may be deprecated in a future release of SAAJ
 * in favor of <code>javax.xml.namespace.QName<code>
 * @see SOAPEnvelope#createName(String, String, String) SOAPEnvelope.createName
 * @see SOAPFactory#createName(String, String, String) SOAPFactory.createName
 */
public interface Name {
    /**
     * Gets the local name part of the XML name that this <code>Name</code>
     * object represents. 
     *
     * @return a string giving the local name
     */
    String getLocalName();

    /**
     * Gets the namespace-qualified name of the XML name that this 
     * <code>Name</code> object represents. 
     *
     * @return the namespace-qualified name as a string
     */
    String getQualifiedName();

    /**
     * Returns the prefix that was specified when this <code>Name</code> object
     * was initialized. This prefix is associated with the namespace for the XML
     * name that this <code>Name</code> object represents. 
     *
     * @return the prefix as a string
     */
    String getPrefix();

    /**
     * Returns the URI of the namespace for the XML
     * name that this <code>Name</code> object represents. 
     *
     * @return the URI as a string
     */
    String getURI();
}
