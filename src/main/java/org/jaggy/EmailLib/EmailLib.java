/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jaggy.EmailLib;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author Matthew
 */
public class EmailLib {
    ISocket socket;
    private final OutputStream os;
    private final InputStream is;
    public EmailLib(String server, String username, int port) {
        socket = new ISocket(server, port);
        os = socket.getOutputStream();
        is = socket.getInputStream();
    }
    
}
