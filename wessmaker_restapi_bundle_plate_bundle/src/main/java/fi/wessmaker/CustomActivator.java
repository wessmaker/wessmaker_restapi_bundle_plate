/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package fi.wessmaker;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

// 
/**
 * CustomActivator class is declared in pom.xml
 * and it must implement the BundleActivator
 * 
 * "<Bundle-Activator>fi.wessmaker.CustomActivator</Bundle-Activator>"
 */
public class CustomActivator implements BundleActivator {
    JAXRSServerFactoryBean bean = new JAXRSServerFactoryBean();
    Server server;

    public void start(BundleContext context) {
        System.out.println("START method called of: " + this.getClass());

        // Without explicitly declaring the "RunTimeDelegate", REST api
        // cannot handle HTTP method calls (GET, POST, PUT, etc.).
        /*
         * This fixes error: "java.lang.ClassNotFoundException:
         * org.glassfish.jersey.internal.RuntimeDelegateImpl
         * not found by org.eclipse.jetty.util".
         */
        javax.ws.rs.ext.RuntimeDelegate
                .setInstance(new org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl());

        // Declares which classes will handle HTTP method calls
        // It's that class where serviceinterface methods are implemented
        bean.setResourceClasses(CustomApiServiceImpl.class);

        // Address to make HTTP method calls
        bean.setAddress("http://localhost:8080/");

        // JaksonJsonProvider is registered as JSON serializator for JAX-RS
        bean.setProvider(new JacksonJsonProvider());

        // Creates and starts the server
        // using parameters set to the bean above
        server = bean.create();
    }

    public void stop(BundleContext context) {
        System.out.println("STOP method called of: " + this.getClass());
        if (server != null) {
            server.destroy();
        }
    }
}
