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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.servlet.DispatcherType;

/**
 **Annotation used to declare a ServletFilter that the container then
 * processes at deployment time and makes available as per the url mapping
 * rules, the servlets it applies to and the dispatcher types that it applies
 * to.
 * 
 * @since Servlet 3.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ServletFilter {
    /**
     * Description of the filter
     */
    String description() default "";
    
    /**
     * Display name of the ServletFilter
     */
    String displayName() default "";
    
    /**
     * Init params for the filter
     */
    InitParam [] initParams() default {};
    
    /**
     * Name of the filter
     */
    String filterName() default "";
    
    /**
     * Icon for the filter
     */
    String icon() default "";
        /**
     * The servlets on which this ServletFilter applies.
     */
    String [] servletNames() default {};
    
    /**
     * The url patterns on which the ServletFilter would apply
     */
    String [] value() default {};

    /**
     * The url patterns on which the ServletFilter would apply
     */
    String [] urlPatterns() default {};

    /**
     * The Dispatcher types that the ServletFilter would apply on.
     */
    DispatcherType [] dispatcherTypes() default {DispatcherType.REQUEST};
    
    /**
     * Indicates whether the Filter supports async processing or not.
     */
    boolean asyncSupported() default false;

    /**
     * Specifies the timeout - can be used only when auto_commit is set to false
     * 
     */
    long asyncTimeout() default 0;
}
