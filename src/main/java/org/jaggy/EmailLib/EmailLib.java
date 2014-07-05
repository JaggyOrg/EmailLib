/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jaggy.EmailLib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew
 */
public class EmailLib {
    public ISocket socket;
    private InputStream is;

    public void session(String server, String username, String password, int port) {
        socket = new ISocket(server, port);
        is = socket.getInputStream();
         ExecutorService service = Executors.newFixedThreadPool(4);
        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader buffer = new BufferedReader(reader);
        try {
            int i = 1;
            String line;
            while ((line = buffer.readLine()) != null) {
                service.execute(new Worker(line, this));
            }
        } catch (IOException ex) {
            Logger.getLogger(EmailLib.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
