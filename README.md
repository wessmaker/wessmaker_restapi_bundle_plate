Wessmaker's OSGI REST api bundle plate
==========

> This project's goal is to be the most intuitive way to implement OSGI api. This project is ready template to start building on. But it works as simple api without modifications

> There are 2 different projects, one with **clarifying comments** and one **without**. **Both projects are identical** ignoring comments and artifactId in pom.xml 


> Naming convention for this project is mostly "CustomSomething" which should clarify the parts which are **not part of some library** but are **custom made**

> **Most important part** atleast for me is that there is **no boilerplate configuration madness** going on


<br>

***
## Setting up karaf for REST api 

 First install [apache karaf](https://karaf.apache.org/download.html)

 >In this documentation **KARAF_HOME** refers the root folder of *karaf* (containing bin, lib, etc)


- **(OPTIONAL but necessary for webconsole & ssh)** Open file "user.properties" in "KARAF_HOME/etc/" and uncomment or add following lines at the bottom 
   ```properties
   karaf = karaf,_g_:admingroup
   _g_\:admingroup = group,admin,manager,viewer,systembundles,ssh
   ```


- Add missing packages **"jav.nio.file"** & **"jav.nio.file.spi"** to file **"jre.properties"** in diretory **"KARAF_HOME/etc/"** under **"jre-base"**
   ```properties
   jre-base= \
    .
    .
    java.nio.file, \
    java.nio.file.spi, \
    .
    .
   ```

- Run **karaf.bat** in terminal in **KARAF_HOME/bin** to start karaf in terminal


- Run following commands in **karaf shell** (webconsole is optional). Directly **copy-pasting whole block works** as there are **semicolons** at the end of lines
   ```powershell
   feature:repo-add cxf;
   feature:install -s cxf;
   feature:install -s cxf-jaxrs;
   feature:install -s http;
   feature:install -s webconsole;   
   ```


- Open **"wessmaker_restapi_bundle_plate/wessmaker_restapi_bundle_plate_bundle/"** (directory with pom.xml) in **terminal** and run `mvn clean install`


- Install the bundle with maven in karaf shell
  ```powershell
  bundle:install -s mvn:fi.wessmaker/wessmaker_restapi_bundle_plate_bundle/1.0.0
  ```

   >**Generic command for installing:**  
   >```powershell
   >bundle:install -s mvn:group.id/artifactid/version
   >```


<br>


***
## Using the default REST api 
> Use postman, curl or insomnia to do HTTP calls

- Default address for api is http://localhost:8080/custompath
- There is GET and POST method implemented by default
- GET method returns (produces) JSON object 
- POST method takes (consumes) JSON object and also returns (produces) echo JSON object
- After alling GET or POST to the address api should return the JSON and code also "200 OK"


<br>


***
### Avoiding errors 

> **java.lang.ClassNotFoundException: org.glassfish.jersey.internal.RuntimeDelegateImpl not found by org.eclipse.jetty.util**
-  Fixed by explicitly setting the RunTimeDelegate in Activator.java to avoid issues of classes not found
   ```java
   javax.ws.rs.ext.RuntimeDelegate.setInstance(new org.apache.cxf.jaxrs.impl.RuntimeDelegateImpl());
   ```


> **MessageBodyWriter or MessageBodyReader not found**
- Fixed by setting the provider
   ```java
   customBean.setProvider(new JacksonJsonProvider());
   ```
