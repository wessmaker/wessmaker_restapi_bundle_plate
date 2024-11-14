#### Setting up karaf to expose REST endpoint

```powershell
feature:repo-add cxf;
feature:install -s cxf
feature:install -s cxf-jaxrs;
feature:install -s http;
feature:install -s webconsole;
```

- Open config file "KARAF_HOME/etc/user.properties", uncomment or add following lines
   ```properties
   karaf = karaf,_g_:admingroup
   _g_\:admingroup = group,admin,manager,viewer,systembundles,ssh
   ```


- Add missing packages **"java.nio."** to **KARAF_HOME/etc/jre.properties** jre-base
   ```properties
   jre-base= \
    .
    .
    java.nio.file, \
    java.nio.file.spi, \
    .
    .
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


-  Explicitly set the RunTimeDelegate to avoid issues of classes not found
   ```java
   javax.ws.rs.ext.RuntimeDelegate.setInstance(new org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl());
   // This explicitly sets the RunTimeDelegate
   ```