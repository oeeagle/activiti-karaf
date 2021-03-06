/*
 * Copyright 2012 Cisco Systems
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

package org.activiti.karaf.support;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.h2.tools.Server;

/**
 * Lightweight H2 DB setup control bean. enabled in the dev environment by default and configured through
 * external configuration (org.activiti.karaf.cfg) to disable it and use external db (e.g. mysql, oracle etc).
 * 
 * @author Srinivasan Chikkala
 * 
 */
public class H2DBSetup {
    private static final Logger LOG = Logger.getLogger(H2DBSetup.class.getName());
    private boolean enabled;
    private String tcpPort = "9092";
    private Server h2Server;

    public H2DBSetup() {
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setTcpPort(String tcpPort) {
        this.tcpPort = tcpPort;
    }

    private String[] getOptions() {
        // TODO: externalize these options
        String[] options = { "-tcp", "-tcpAllowOthers", "-tcpPort",
                this.tcpPort };
        return options;
    }

    public void start() throws SQLException {
        if (enabled) {
            // stop(); // try stoping it if it is running
            LOG.info("Creating H2 DB TCP Server with Args " + this.getOptions());
            this.h2Server = Server.createTcpServer(this.getOptions());
            LOG.info("Starting H2 DB...");
            this.h2Server.start();
            LOG.info("H2 DB Started on Port:  "  + this.h2Server.getPort());
        } else {
            LOG.info("H2 DB is not enabled");
        }
    }

    public void stop() {
        if (this.h2Server != null) {
            LOG.info("Stopping H2 DB...");
            this.h2Server.stop();
            this.h2Server = null;
        } else {
            LOG.info("Cannot stop H2 DB Server : Server not enabled or not started");
        }
    }
}
