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

import java.io.OutputStream;

/**
 *
 * @author Matthew
 */
 public class Worker implements Runnable {
        private final String line;
        private OutputStream os;

        public Worker(String line, Session session) {
            this.line = line;
            os = session.isocket.getOutputStream();
        }

        @Override
        public void run() {
            // Process line here.
            System.out.println("Processing line: " + line);
        }
    }
