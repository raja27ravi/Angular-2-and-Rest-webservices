package org.gsr.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/injectdemo")
@Consumes(javax.ws.rs.core.MediaType.TEXT_PLAIN)
@Produces(javax.ws.rs.core.MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	


	@GET
	@Path("annotations")
	public  String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
											 @HeaderParam("customHeaderValue") String header,
											 @CookieParam("name") String cookie){
		return " MatrixParam : " + matrixParam +  " \nHeader Param : " + header + "\nCookie : " +  " " + cookie; 
		
	} 

}
