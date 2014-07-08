/*
 * Copyright 2014 JaggyOrg.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jaggy.EmailLib;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew
 */
public class ISocket {
    Socket socket;
    InputStream istream;
    OutputStream ostream;
    public ISocket(String serverName, int port) {
        try {
            InetAddress server = InetAddress.getByName(serverName);
            System.out.print("server "+server.getHostAddress()+"port "+port+"\n\n");
            socket = new Socket(server.getHostAddress(), port);
            istream = socket.getInputStream();
            ostream = socket.getOutputStream();
            
        } catch (IOException ex) {
            Logger.getLogger(ISocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public InputStream getInputStream() {
        return istream;
    }
    public OutputStream getOutputStream() {
        return ostream;
    }
}
