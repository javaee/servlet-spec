/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2015 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
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
 *
 */

package javax.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 *
 * <p class="changed_added_4_0">Defines a generic, protocol-independent
 * filter. To write an HTTP filter for use on the
 * Web, extend {@link javax.servlet.http.HttpFilter} instead.</p>
 *
 * <div class="changed_added_4_0">
 * 
 * <p><code>GenericFilter</code> implements the <code>Filter</code>
 * and <code>FilterConfig</code> interfaces. <code>GenericFilter</code>
 * may be directly extended by a filter, although it's more common to extend
 * a protocol-specific subclass such as <code>HttpFilter</code>.
 *
 * <p><code>GenericFilter</code> makes writing filters
 * easier. It provides simple versions of the lifecycle methods 
 * <code>init</code> and <code>destroy</code> and of the methods 
 * in the <code>FilterConfig</code> interface.
 *
 * <p>To write a generic filter, you need only
 * override the abstract <code>doFilter</code> method. 
 *
 * </div>
 * 
 * @author 	Various
 * 
 * @since 4.0
 */

 
public abstract class GenericFilter 
    implements Filter, FilterConfig, java.io.Serializable
{
    private static final String LSTRING_FILE = "javax.servlet.LocalStrings";
    private static final ResourceBundle lStrings =
        ResourceBundle.getBundle(LSTRING_FILE);

    private transient FilterConfig config;
    

    /**
     *
     * <p class="changed_added_4_0">Does nothing. All of the filter initialization
     * is done by one of the <code>init</code> methods.</p>
     *
     * @since 4.0
     */
    public GenericFilter() { }
    
    
    /**
     * <p class="changed_added_4_0">Called by the servlet container to indicate to a filter that the
     * filter is being taken out of service.  See {@link Filter#destroy}.</p>
     *
     *
     * @since 4.0
     * 
     */
    @Override
    public void destroy() {
    }
    
    
    /**
     * <p class="changed_added_4_0">Returns a <code>String</code> containing the value of the named
     * initialization parameter, or <code>null</code> if the parameter does
     * not exist.  See {@link FilterConfig#getInitParameter}.</p>
     *
     * <p>This method is supplied for convenience. It gets the 
     * value of the named parameter from the servlet's 
     * <code>ServletConfig</code> object.
     *
     * @param name 		a <code>String</code> specifying the name 
     *				of the initialization parameter
     *
     * @return String 		a <code>String</code> containing the value
     *				of the initialization parameter
     *
     * @since 4.0
     *
     */ 
    @Override
    public String getInitParameter(String name) {
        FilterConfig fc = getFilterConfig();
        if (fc == null) {
            throw new IllegalStateException(
                lStrings.getString("err.filter_config_not_initialized"));
        }

        return fc.getInitParameter(name);
    }
    
    
   /**
    * <p class="changed_added_4_0">Returns the names of the filter's initialization parameters 
    * as an <code>Enumeration</code> of <code>String</code> objects,
    * or an empty <code>Enumeration</code> if the filter has no
    * initialization parameters.  See {@link
    * FilterConfig#getInitParameterNames}.</p>
    *
    * <div class="changed_added_4_0">
    * 
    * <p>This method is supplied for convenience. It gets the 
    * parameter names from the filter's <code>FilterConfig</code> object. 
    *
    * </div>
    * 
    * @return Enumeration 	an enumeration of <code>String</code>
    *				objects containing the names of 
    *				the filter's initialization parameters
    *
    * @since 4.0
    */
    @Override
    public Enumeration<String> getInitParameterNames() {
        FilterConfig fc = getFilterConfig();
        if (fc == null) {
            throw new IllegalStateException(
                lStrings.getString("err.filter_config_not_initialized"));
        }

        return fc.getInitParameterNames();
    }   
     

    /**
     * <p class="changed_added_4_0">Returns this servlet's {@link ServletConfig} object.</p>
     *
     * @return FilterConfig 	the <code>FilterConfig</code> object
     *				that initialized this filter
     *
     * @since 4.0
     */    
    public FilterConfig getFilterConfig() {
	return config;
    }
 
    
    /**
     * <p class="changed_added_4_0">Returns a reference to the {@link ServletContext} in which this filter
     * is running.  See {@link FilterConfig#getServletContext}.</p>
     *
     * <div class="changed_added_4_0">
     * 
     * <p>This method is supplied for convenience. It gets the 
     * context from the filter's <code>FilterConfig</code> object.
     *
     * </div>
     * 
     * @return ServletContext 	the <code>ServletContext</code> object
     *				passed to this filter by the <code>init</code>
     *				method
     *
     * @since 4.0
     */
    @Override
    public ServletContext getServletContext() {
        FilterConfig sc = getFilterConfig();
        if (sc == null) {
            throw new IllegalStateException(
                lStrings.getString("err.filter_config_not_initialized"));
        }

        return sc.getServletContext();
    }


    /**
     * <p class="changed_added_4_0">Called by the servlet container to indicate to a filter that
     * it is being placed into service.  See {@link Filter#init}.</p>
     * 
     * <div class="changed_added_4_0">
     *
     * <p>This implementation stores the {@link FilterConfig}
     * object it receives from the servlet container for later use.
     * When overriding this form of the method, call 
     * <code>super.init(config)</code>.
     * 
     * </div>
     *
     * @param config 			the <code>FilterConfig</code> object
     *					that contains configuration
     *					information for this filter
     *
     * @exception ServletException 	if an exception occurs that
     *					interrupts the servlet's normal
     *					operation
     * 
     * @see 				UnavailableException
     *
     * @since 4.0
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
	this.config = config;
	this.init();
    }

    /**
     * <p class="changed_added_4_0">A convenience method which can be overridden so that there's no need
     * to call <code>super.init(config)</code>.</p>
     *
     * <div class="changed_added_4_0">
     * 
     * <p>Instead of overriding {@link #init(FilterConfig)}, simply override
     * this method and it will be called by
     * <code>GenericFilter.init(FilterConfig config)</code>.
     * The <code>FilterConfig</code> object can still be retrieved via {@link
     * #getFilterConfig}. 
     * 
     * </div>
     *
     * @exception ServletException 	if an exception occurs that
     *					interrupts the servlet's
     *					normal operation
     *
     * @since 4.0
     */
    public void init() throws ServletException {

    }
    
    /**
     * Called by the servlet container to allow the filter to respond to
     * a request.  See {@link Filter#doFilter}.
     * 
     * <p>This method is declared abstract so subclasses, such as 
     * <code>HttpFilter</code>, must override it.
     *
     * @param req 	the <code>ServletRequest</code> object
     *			that contains the client's request
     *
     * @param res 	the <code>ServletResponse</code> object
     *			that will contain the servlet's response
     * 
     * @param chain     the <code>FilterChain</code> for invoking the next filter or the resource
     *
     * @exception ServletException 	if an exception occurs that
     *					interferes with the servlet's
     *					normal operation occurred
     *
     * @exception IOException 		if an input or output
     *					exception occurs
     *
     * @since 4.0
     */
    @Override
    public abstract void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException;
    
    

    

    /**
     * <p class="changed_added_4_0">Returns the name of this filter instance.
     * See {@link FilterConfig#getFilterName}.</p>
     *
     * @return          the name of this filter instance
     *
     * @since 4.0
     */
    @Override
    public String getFilterName() {
        FilterConfig sc = getFilterConfig();
        if (sc == null) {
            throw new IllegalStateException(
                lStrings.getString("err.servlet_config_not_initialized"));
        }

        return sc.getFilterName();
    }
}
