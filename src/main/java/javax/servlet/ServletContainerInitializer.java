/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 2008-2009 Sun Microsystems, Inc. All rights reserved.
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

package javax.servlet;

import java.util.Set;

/**
 * Interface which may be implemented by a library/runtime in order
 * to be notified by the container of any of the classes/interfaces 
 * in which it has expressed interest via the
 * {@link javax.servlet.annotation.HandlesTypes HandlesTypes} annotation.
 *
 * <p>If an implementation of this interface does not have any such
 * annotation, the container must pass a <tt>null</tt> set of classes to
 * its {@link #onStartup} method.
 *
 * <p>Implementations of this interface may be declared by a JAR file
 * resource located inside the <tt>META-INF/services</tt> directory and
 * named for the fully qualified class name of this interface, and will be 
 * discovered using the runtime's service provider lookup mechanism.
 *
 * @see javax.servlet.annotation.HandlesTypes
 *
 * @since Servlet 3.0
 */
public interface ServletContainerInitializer {

    /**
     * Notifies this <tt>ServletContainerInitializer</tt> of the startup
     * of the application represented by the given <tt>ServletContext</tt>.
     *
     * <p>If this <tt>ServletContainerInitializer</tt> is bundled in a JAR
     * file inside the <tt>WEB-INF/lib</tt> directory of an application,
     * its <tt>onStartup</tt> method will be invoked only once during the
     * startup of the bundling application. If this
     * <tt>ServletContainerInitializer</tt> is bundled inside a JAR file
     * outside of any <tt>WEB-INF/lib</tt> directory, but still
     * discoverable by the runtime's service provider lookup mechanism,
     * its <tt>onStartup</tt> method will be invoked every time an 
     * application is started.
     *
     * @param c The set of classes in which this
     * <tt>ServletContainerInitializer</tt> has expressed interest via
     * the <tt>HandlesTypes</tt> annotation, or <tt>null</tt> if this
     * <tt>ServletContainerInitializer</tt> does not have any such
     * annotation
     *
     * @param ctx The <tt>ServletContext</tt> instance in which the types
     * defined via the <tt>HandlesTypes</tt> annotation were found.
     */
    public void onStartup(Set<Class<?>> c, ServletContext ctx); 
}
