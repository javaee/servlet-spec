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

import java.util.HashSet;
import java.util.Set;
import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.annotation.ServletSecurity;

/**
 * Java Class represntation of a {@link ServletSecurity} annotation value.
 *
 * @since Servlet 3.0
 */
public class ServletSecurityElement extends HttpConstraintElement {

    private Set<String> methodNames;
    private HttpMethodConstraintElement[] methodConstraints;

    /**
     * Constructs an instance using the default
     * <code>HttpConstraintElement</code> value as the default Constraint
     * element and with no HTTP Method specific constraint elements.
     */
    public ServletSecurityElement() {
        methodConstraints = new HttpMethodConstraintElement[0];
        methodNames = new HashSet<String>();
    }

    /**
     * Constructs an instance with a default Constraint element
     * and with no HTTP Method specific constraint elements.
     *
     * @param constraint the HttpConstraintElement to be
     * applied to all HTTP methods other than those represented in the
     * <tt>methodConstraints</tt>
     */
    public ServletSecurityElement(HttpConstraintElement constraint) {
        super(constraint.getEmptyRoleSemantic(),
                constraint.getRolesAllowed(),
                constraint.getTransportGuarantee());
        methodConstraints = new HttpMethodConstraintElement[0];
        methodNames = new HashSet<String>();
    }

    /**
     * Constructs an instance using the default
     * <code>HttpConstraintElement</code> value as the default Constraint
     * element and with an array of HTTP Method specific constraint elements.
     *
     * @param methodConstraints the array of HTTP method specific constraint
     * elements
     *
     * @throws IllegalArgumentException if duplicate method names are
     * detected
     */
    public ServletSecurityElement(HttpMethodConstraintElement[] methodConstraints) {
        this.methodConstraints = (methodConstraints == null ? new HttpMethodConstraintElement[0] : methodConstraints);
        methodNames = checkMethodNames(this.methodConstraints);
    }

    /**
     * Constructs an instance with a default Constraint element
     * and an with array of HTTP Method specific constraint elements
     *
     * @param constraint the HttpConstraintElement to be
     * applied to all HTTP methods other than those represented in the
     * <tt>methodConstraints</tt>
     * @param methodConstraints the array of HTTP method specific constraint
     * elements.
     *
     * @throws IllegalArgumentException if duplicate method names are
     * detected
     */
    public ServletSecurityElement(HttpConstraintElement constraint,
            HttpMethodConstraintElement[] methodConstraints) {
        super(constraint.getEmptyRoleSemantic(),
                constraint.getRolesAllowed(),
                constraint.getTransportGuarantee());
        this.methodConstraints = (methodConstraints == null ? new HttpMethodConstraintElement[0] : methodConstraints);
        methodNames = checkMethodNames(this.methodConstraints);
    }

    /**
     * Constructs an instance from a {@link ServletSecurity} annotation value.
     *
     * @param annotation the annotation value
     *
     * @throws IllegalArgumentException if duplicate method names are
     * detected
     */
    public ServletSecurityElement(ServletSecurity annotation) {
        super(annotation.value().value(),
                annotation.value().rolesAllowed(),
                annotation.value().transportGuarantee());
        HttpMethodConstraint[] constraints = annotation.httpMethodConstraints();
        for (int i = 0; i < constraints.length; i++) {
            this.methodConstraints[i] =
                    new HttpMethodConstraintElement(constraints[i].value(),
                    new HttpConstraintElement(constraints[i].emptyRoleSemantic(),
                    constraints[i].rolesAllowed(), constraints[i].transportGuarantee()));
        }
        methodNames = checkMethodNames(this.methodConstraints);
    }

    /**
     * Gets the array of HTTP Method specific constraint elements.
     *
     * @return the array of HttpMethodConstraintElement objects
     */
    public HttpMethodConstraintElement[] getHttpMethodConstraints() {
        return methodConstraints;
    }

    /**
     * Gets the set of HTTP methid names named by the HttpMethodConstraints.
     *
     * @return the set of String method names
     */
    public Set<String> getMethodNames() {
        return methodNames;
    }

    /**
     * Checks for duplicate method names in methodConstraints.
     *
     * @param methodConstraints
     *
     * @retrun Set of method names
     *
     * @throws IllegalArgumentException if duplicate method names are
     * detected
     */
    private Set<String> checkMethodNames(
            HttpMethodConstraintElement[] methodConstraints) {
        Set<String> methodNames = new HashSet<String>();
        for (int i = 0; methodConstraints != null && i < methodConstraints.length; i++) {
            String methodName = methodConstraints[i].getMethodName();
            if (methodNames.contains(methodName)) {
                throw new IllegalArgumentException(
                    "Duplicate HTTP method name: " + methodName);
            }
        }
        return methodNames;
    }
}
