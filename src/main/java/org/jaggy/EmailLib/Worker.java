/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.jaggy.EmailLib;

import java.io.OutputStream;

/**
 *
 * @author Matthew
 */
 public class Worker implements Runnable {
        private final String line;
        private OutputStream os;

        public Worker(String line, EmailLib lib) {
            this.line = line;
            os = lib.socket.getOutputStream();
        }

        @Override
        public void run() {
            // Process line here.
            System.out.println("Processing line: " + line);
        }
    }
