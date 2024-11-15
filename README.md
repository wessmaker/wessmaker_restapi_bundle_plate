## wessmaker's OSGI REST api bundle plate
This project was created mostly for personal usage but may help simplify the 




#### Setting up karaf to expose REST endpoint

- Open config file "KARAF_HOME/etc/user.properties", uncomment or add following lines
   ```properties
   karaf = karaf,_g_:admingroup
   _g_\:admingroup = group,admin,manager,viewer,systembundles,ssh
   ```


- Add missing packages **"java.nio."** into **"KARAF_HOME/etc/jre.properties"** "jre-base"-file
   ```properties
   jre-base= \
    .
    .
    java.nio.file, \
    java.nio.file.spi, \
    .
    .
   ```

- Run karaf.bat in KARAF_HOME/bin


- Run following commands in karaf shell through SSH or directly in container
   ```powershell
   feature:repo-add cxf;
   feature:install -s cxf
   feature:install -s cxf-jaxrs;
   feature:install -s http;
   feature:install -s webconsole;
   ```


- Install the bundle with maven in karaf shell
  ```powershell
  bundle:install -s mvn:fi.wessmaker/wessmaker_restapi_bundle_plate_bundle/1.0.0
  ```

   **Generic bundle install:**  
   ```powershell
   bundle:install -s mvn:group.id/artifactid/verion
   ```


### Additional tips:
- Webconsole: http://localhost:8181/system/console

- Add java.nio.file to KARAF_HOME/etc/jre.properties
   ```properties
   jre-base= \
    java.applet, \
    java.awt, \
    .
    .
    java.nio.file, \
    java.nio.file.spi, \
    .
    .
   ```


-  Explicitly setting the RunTimeDelegate to avoid issues of classes not found
   ```java
   javax.ws.rs.ext.RuntimeDelegate.setInstance(new org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl());
   // This explicitly sets the RunTimeDelegate
   ```