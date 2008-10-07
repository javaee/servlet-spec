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

package javax.servlet.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Documented;

/**
 *Annotation used to declare a servlet that the container then
 * processes at deployment time and makes available as per the url mapping
 * rules.
 *
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebServlet {
    
    /**
     *  Name of the servlet
     *
     */
    String name() default "";
    
    /**
     * url pattern(s) for the servlet
     */
    String[] value() default {};

    /**
     * url pattern(s) for the servlet
     */
    String[] urlPatterns() default {};

    
    /**
     * Define load on startup for the servlet 
     *
     */
    int loadOnStartup() default -1;
    
    /**
     * Init params for the servlet
     */
    InitParam [] initParams() default {};
    
    /**
     * auto-commit controls whether a response is open or not after the service 
     * method has exited
     */
    boolean supportsAsync() default false;
    
    /**
     * Specifies the timeout - can be used only when auto_commit is set to false
     * 
     */
    long timeout() default 0;
    
    /**
     * The icon defined for the servlet
     */
    String icon() default "";
    
    /**
     * Description of the servlet
     * 
     */
    String description() default "";

}
