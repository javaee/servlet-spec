/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2009 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package javax.servlet.descriptor;

/**
 * This interface provides access to the
 * <code>&lt;jsp-property-group&gt;</code>
 * related configuration of a web application.
 *
 * <p>The configuration is aggregated from the <code>web.xml</code> and
 * <code>web-fragment.xml</code> descriptor files of the web application.
 *
 * @since Servlet 3.0
 */
public interface JspPropertyGroupDescriptor {
    
    /**
     * Gets the URL patterns of the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     *
     * @return Iterable over the URL patterns of the JSP property group
     * represented by this JspPropertyGroupDescriptor
     */
    public Iterable<String> getUrlPatterns();

    /**
     * Checks whether Expression Language (EL) evaluation is enabled for any
     * JSP pages mapped to the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     *
     * @return true if Expression Language (EL) evaluation is enabled for any
     * JSP pages mapped to the JSP property group represented by this
     * JspPropertyGroupDescriptor, false otherwise
     */
    public boolean isElIgnored();

    /**
     * Gets the default page encoding for any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor.
     *
     * @return the default page encoding for any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor,
     * or null if unspecified
     */
    public String getPageEncoding();

    /**
     * Checks whether scripting is enabled for any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor.
     *
     * @return true if scripting is enabled for any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor,
     * false otherwise
     */
    public boolean isScriptingInvalid();

    /**
     * Checks whether any JSP pages mapped to the JSP property group
     * represented by this JspPropertyGroupDescriptor should be treated
     * as JSP documents (XML syntax).
     *
     * @return true if any JSP pages mapped to the JSP property group
     * represented by this JspPropertyGroupDescriptor should be treated
     * as JSP documents (XML syntax), false otherwise
     */
    public boolean isXml();

    /**
     * Gets an Iterable over the <code>&lt;include-prelude&gt;</code>
     * elements of the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     * 
     * @return Iterable over the <code>&lt;include-prelude&gt;</code>
     * elements of the JSP property group represented by this
     * JspPropertyGroupDescriptor
     */
    public Iterable<String> getIncludePreludes();

    /**
     * Gets an Iterable over the <code>&lt;include-coda&gt;</code>
     * elements of the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     * 
     * @return Iterable over the <code>&lt;include-coda&gt;</code>
     * elements of the JSP property group represented by this
     * JspPropertyGroupDescriptor
     */
    public Iterable<String> getIncludeCodas();

    /**
     * Checks whether the character sequence <code>&quot;#{&quot;</code>,
     * which is normally reserved for Expression Language (EL) expressions,
     * would cause a translation error if it appeared as a String literal
     * in any JSP pages mapped to the JSP property group represented by
     * this JspPropertyGroupDescriptor.
     *
     * @return true if the character sequence <code>&quot;#{&quot;</code>,
     * which is normally reserved for Expression Language (EL) expressions,
     * would cause a translation error if it appeared as a String literal in
     * any JSP pages mapped to the JSP property group represented by this
     * JspPropertyGroupDescriptor, false otherwise
     */
    public boolean isDeferredSyntaxAllowedAsLiteral();

    /**
     * Checks whether template text containing only whitespaces
     * must be removed from the response output of any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor.
     *
     * @return true if template text containing only whitespaces
     * must be removed from the response output of any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor,
     * false otherwise
     */
    public boolean isTrimDirectiveWhitespaces();

    /**
     * Gets the default response content type for any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor.
     *
     * @return the default response content type for any JSP pages mapped
     * to the JSP property group represented by this
     * JspPropertyGroupDescriptor, or null if unspecified
     */
    public String getDefaultContentType();

    /**
     * Gets the default size of the response buffer for any JSP pages mapped
     * to the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     *
     * @return the default size of the response buffer for any JSP pages
     * mapped to the JSP property group represented by this
     * JspPropertyGroupDescriptor, or null if unspecified
     */
    public String getBuffer();

    /**
     * Checks whether an error will be raised at translation time if tag
     * with an undeclared namespace is used in any JSP pages mapped
     * to the JSP property group represented by this
     * JspPropertyGroupDescriptor.
     *
     * @return true if an error will be raised at translation time if a tag
     * with an undeclared namespace is used in any JSP pages mapped to the
     * JSP property group represented by this JspPropertyGroupDescriptor,
     * false otherwise
     */
    public boolean isErrorOnUndeclaredNamespace();
}
