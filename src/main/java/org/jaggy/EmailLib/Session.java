/*
 * Copyright 2014 Matthew.
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matthew
 */
public class Session {
    private final Properties props; 
    public ISocket isocket;
    
   public Session(Properties prop) {
    props = new Properties(prop);
    }

    Session() {
        Properties defaults = new Properties();
        defaults.put("mail.server", "localhost");
        defaults.put("mail.port", "25");
        props = new Properties(defaults);
    }
    public Properties getProperties() { return props; }
    public String getProperty(String String) { return props.getProperty(String); }
    
    
    public void connect() {
        String server = getProperty("mail.server");
        int port = Integer.parseInt(getProperty("mail.port"));
        isocket = new ISocket(server, port);
        InputStream is = isocket.getInputStream();
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
