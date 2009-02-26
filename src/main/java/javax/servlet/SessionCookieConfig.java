/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
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
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 *
 */

package javax.servlet;

/**
 * Session tracking cookie configuration class.
 *
 * @since 3.0
 */
public class SessionCookieConfig {

    private String domain;
    private String path;
    private String comment;
    private boolean isHttpOnly;
    private boolean isSecure;
    private String name;

    /**
     * Constructor.
     * 
     * <p>If <tt>isHttpOnly</tt> is <tt>true</tt>, any session
     * tracking cookies configured by this <tt>SessionCookieConfig</tt>
     * will be marked as <i>HttpOnly</i>, by adding the <tt>HttpOnly</tt>
     * attribute to them. <i>HttpOnly</i> cookies are not supposed to be
     * exposed to client-side scripting code, and may therefore help
     * mitigate certain kinds of cross-site scripting attacks.
     *
     * <p>If <tt>isSecure</tt> is <tt>true</tt>, any session
     * tracking cookie configured by this <tt>SessionCookieConfig</tt>
     * will be marked as <i>secure</i>, even if the request that initiated
     * the corresponding session is using plain HTTP instead of a secure
     * protocol such as HTTPS.
     * If <tt>isSecure</tt> is <tt>false</tt>, any session tracking
     * cookie configured by this <tt>SessionCookieConfig</tt> will be marked
     * as <i>secure</i> only if the request that initiated the corresponding
     * session is also secure.
     *
     * <p>One use case for marking a session tracking cookie as secure, even
     * though the request that initiated the session came over HTTP, is to
     * support a topology where the web container is front-ended
     * by an SSL offloading load balancer. In this case, the traffic between
     * the client and the load balancer will be over HTTPS, whereas the
     * traffic between the load balancer and the web container will be over
     * HTTP.  
     * 
     * @param domain The domain name that will be assigned to any session
     * tracking cookies configured by this <tt>SessionCookieConfig</tt>
     * @param path The path that will be assigned to any session tracking
     * cookies configured by this <tt>SessionCookieConfig</tt>, or
     * <tt>null</tt> if the context path of the <tt>ServletContext</tt>
     * whose session tracking cookies this <tt>SessionCookieConfig</tt>
     * is going to configure is to be used
     * @param comment The comment that will be assigned to any session
     * tracking cookies configured by this <tt>SessionCookieConfig</tt>
     * @param isHttpOnly true if any session tracking cookies configured
     * by this <tt>SessionCookieConfig</tt> will be marked as <i>HttpOnly</i>,
     * false otherwise
     * @param isSecure true if any session tracking ccokies configured by
     * this <tt>SessionCookieConfig</tt> will be marked as <i>secure</i>
     * even if the request that initiated the corresponding session is
     * using plain HTTP instead of HTTPS, and false if any session tracking
     * cookie configured by this <tt>SessionCookieConfig</tt> will be marked
     * as <i>secure</i> only if the request that initiated the corresponding
     * session is also secure
     * @param name The name that will be assigned to any session tracking
     * cookies configured by this <tt>SessionCookieConfig</tt>, or
     * <tt>null</tt> if the default <tt>JSESSIONID</tt> should be used
     *
     * @see javax.servlet.http.Cookie#setDomain(String)
     * @see javax.servlet.http.Cookie#setPath(String)
     * @see javax.servlet.http.Cookie#setComment(String)
     * @see javax.servlet.http.Cookie#setHttpOnly(boolean)
     * @see javax.servlet.http.Cookie#setSecure(boolean)
     * @see ServletContext#setSessionCookieConfig
     */
    public SessionCookieConfig(String domain, String path, String comment,
                               boolean isHttpOnly, boolean isSecure,
                               String name) {
        this.domain = domain;
        this.path = path;
        this.comment = comment;
        this.isHttpOnly = isHttpOnly;
        this.isSecure = isSecure;
        this.name = name;
    }

    /**
     * Gets the domain name that will be assigned to any session tracking
     * cookies configured by this <tt>SessionCookieConfig</tt>.
     *
     * @return the cookie domain
     *
     * @see javax.servlet.http.Cookie#getDomain()
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Gets the path that will be assigned to any session tracking cookies
     * configured by this <tt>SessionCookieConfig</tt>.
     *
     * @return the cookie path, or <tt>null</tt> if the context path
     * of the <tt>ServletContext</tt> whose session tracking cookies
     * this <tt>SessionCookieConfig</tt> is going to configure is to
     * be used
     *
     * @see javax.servlet.http.Cookie#getPath()
     */
    public String getPath() {
        return path;
    }

    /**
     * Gets the comment that will be assigned to any session tracking
     * cookies configured by this <tt>SessionCookieConfig</tt>.
     *
     * @return the cookie comment
     *
     * @see javax.servlet.http.Cookie#getComment()
     */
    public String getComment() {
        return comment;
    }

    /**
     * Checks if any session tracking cookies configured by this
     * <tt>SessionCookieConfig</tt> will be marked as <i>HttpOnly</i>.
     *
     * @return true if any session tracking cookies configured by this
     * <tt>SessionCookieConfig</tt> will be marked as <i>HttpOnly</i>,
     * false otherwise
     *
     * @see javax.servlet.http.Cookie#isHttpOnly()
     */
    public boolean isHttpOnly() {
        return isHttpOnly;
    }

    /**
     * Checks if any session tracking cookie configured by this
     * <tt>SessionCookieConfig</tt> will be marked as <i>secure</i> even
     * if the request that initiated the corresponding session is using
     * plain HTTP instead of HTTPS.
     *
     * @return true if any session tracking cookie configured by this
     * <tt>SessionCookieConfig</tt> will be marked as <i>secure</i> even
     * if the request that initiated the corresponding session is using
     * plain HTTP instead of HTTPS, and false if any session tracking
     * cookie configured by this <tt>SessionCookieConfig</tt> will be marked
     * as <i>secure</i> only if the request that initiated the corresponding
     * session is also secure.
     *
     * @see javax.servlet.http.Cookie#getSecure()
     * @see ServletRequest#isSecure()
     */
    public boolean isSecure() {
        return isSecure;
    }

    /**
     * Gets the name that will be assigned to any session tracking cookies
     * configured by this <tt>SessionCookieConfig</tt>.
     *
     * @return the cookie name, or <tt>null</tt> if the default
     * <tt>JSESSIONID</tt> should be used
     */
    public String getName() {
        return name;
    }
}
