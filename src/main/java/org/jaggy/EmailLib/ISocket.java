/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
