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

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew
 */
 public class Worker implements Runnable {
        private final String line;
        private OutputStream os;
        boolean userSent = false;
        private Session Session;
        private DataOutputStream write;

        public Worker(String line, Session session) {
            this.line = line;
            Session = session;
            os = Session.isocket.getOutputStream();
            write = new DataOutputStream(os);
        }

        @Override
        public void run() {
            try {
                String[] parsed = line.split(" ", 2);
                String r1 = parsed[0].toString();
                String r2 = "", r3 = "";
                if(parsed.length > 1 )r2 = parsed[1];
                if(parsed.length > 2 )r3 = parsed[2];
                String extras = "";
                if(parsed.length > 3 ) extras = parsed[3];
                if(r1.equals("220")) write.writeBytes("EHLO guess-me.mozilla.org\r\n");
                 System.out.print("Processing line: " + r1+"-"+r2+" r3:"+r3+"\n");
            } catch (IOException ex) {
                Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
