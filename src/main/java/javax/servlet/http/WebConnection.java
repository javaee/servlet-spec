/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
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
 */

package javax.servlet.http;

import java.io.IOException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;

/**
 * This interface encapsulates the connection for an upgrade request.
 * It allows the protocol handler to sent service requests and status
 * queries to the container.
 *
 * @since Servlet 3.1
 */

public interface WebConnection {
    /**
     * Returns an input stream for this web connection.
     *
     * @return a ServletInputStream for reading binary data
     *
     * @exception IOException if an I/O error occurs
     */
    public ServletInputStream getInputStream() throws IOException;

    /**
     * Returns an output stream for this web connection.
     *
     * @return a ServletOutputStream for writing binary data
     *
     * @exception IOException if an I/O error occurs
     */
    public ServletOutputStream getOutputStream() throws IOException;

    /**
     * Places the input stream for this web connection at "end of stream".
     * Any data sent to the input stream side of the web connection is
     * silently discarded.
     * 
     * Reading from a web connection input stream after invoking
     * shutdownInput() on the web connection returns an EOF.
     *
     * @exception IOException if an I/O error occurs when shutting down the
     * input stream.
     *
     * @see #isInputShutdown
     */
    public void shutdownInput() throws IOException;

    /**
     * Disables the output stream for this web connection.
     * Any previously written data will be sent.
     *
     * Writing to a web connection out stream after invoking
     * shutdownOuput() on the web connection causes an IOException
     * to be thrown.
     *
     * @exception IOException if an I/O error occurs when shutting down the
     * output stream.
     *
     * @see #isOutputShutdown
     */
    public void shutdownOutput() throws IOException;

    /**
     * Returns whether the read-half of the web connection is closed.
     *
     * @return true if the input of the  web connection has been shutdown
     *
     * @see #shutdownInput
     */
    public boolean isInputShutdown();

    /**
     * Returns whether the write-half of the web connection is closed.
     *
     * @return true if the output of the web connection has been shutdown
     *
     * @see #shutdownOutput
     */
    public boolean isOutputShutdown();
}
