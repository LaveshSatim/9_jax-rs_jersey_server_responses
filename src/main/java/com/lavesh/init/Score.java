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
