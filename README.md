## conclusion

>we can pass extra information header cookies status code through this


## dependencies
```xml
<dependencies>

		<dependency>
			<groupId>org.glassfish.jersey.inject</groupId>
			<artifactId>jersey-hk2</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.containers</groupId>
			<artifactId>jersey-container-servlet</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.core</groupId>
			<artifactId>jersey-server</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>org.glassfish.jersey.core</groupId>
			<artifactId>jersey-common</artifactId>
			<version>3.0.8</version>
		</dependency>
		<dependency>
			<groupId>jakarta.json.bind</groupId>
			<artifactId>jakarta.json.bind-api</artifactId>
			<version>3.0.0</version>
		</dependency>
		<dependency>
			<groupId>org.eclipse</groupId>
			<artifactId>yasson</artifactId>
			<version>3.0.2</version>
		</dependency>
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.11</version>
			<scope>test</scope>
		</dependency>
	</dependencies>
```

## boot class

```java
package com.lavesh.init;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/app")
public class AppBoot extends Application {

}

```

## controller

```java
package com.lavesh.init;

import jakarta.ws.rs.GET;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Cookie;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.NewCookie;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;

@Path("/score")
public class Score {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{id}/{name}/check")
	public Response getScore(@PathParam("id") String id, @PathParam("name") String name) {

		Response response = null;
		ResponseBuilder builder = null;

		builder = Response.status(200);
		builder = builder.header("maths", "98");
		builder = builder.cookie(new NewCookie("physics", "100"));
		builder = builder.cookie(new NewCookie("name", name));
		builder = builder.entity("chemistry 100");
		response = builder.build();

		return Response.status(200).entity("chemmistry 200").cookie(new NewCookie("name", name))
				.cookie(new NewCookie("physics", "100")).header("maths", "98").build();

	}
}

```
