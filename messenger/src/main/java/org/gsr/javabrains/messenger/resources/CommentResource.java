package org.gsr.javabrains.messenger.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/")
public class CommentResource {

	
	
	@GET
	public String Test(){
		
		return "Coming form Sub resource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") long commentID,
						@PathParam("messageId") long messageId){
		return "Test2's comment id is : " + commentID + " and Message ID is : " + messageId;
	}
	
}
