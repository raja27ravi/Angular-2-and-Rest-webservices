package org.gsr.javabrains.messenger.resources;

import java.awt.PageAttributes.MediaType;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import org.gsr.javabrains.messenger.model.Message;
import org.gsr.javabrains.messenger.service.MessageService;	


@Path("/messages")
@Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
@Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
public class MessageResource {
	
	
	MessageService messageService = new MessageService();

	@GET
	
	public List<Message> getMessages(@QueryParam("year") int year,
									 @QueryParam("start") int start,
									 @QueryParam("size") int size){
								
		if(year > 0)
		{
			return messageService.getAllMessagesForid(year);
		}
		if(start >= 0 & size > 0)
		{
			System.out.println("Start is : " + start + " size is : " + size);
			
			return messageService.getAllMessagesPaginate(start, size);
		}
		return messageService.getAllMessages();
	}
	
	@POST
	public Response addMessages(Message message,@Context UriInfo info) throws URISyntaxException{
		
		Message newmessage = messageService.addMessage(message);
		//return Response.status(Status.CREATED).entity(newmessage).build();
	/*	return Response.created(new URI("/messenger/webapi/messages/" + newmessage.getId()))
				.entity(newmessage)
				.build();*/
		String newId = String.valueOf(newmessage.getId());
		URI uri = info.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newmessage)
				.build();
		//return messageService.addMessage(message);
	}
	
	@GET 
	@Path("/{messageId}")
	
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMassage(messageId);
		//return "Got Path param : " + messageId;
	}
	
	@PUT
	@Path("/{messageId}")

	public Message updateMessage(@PathParam("messageId") long messageId,Message message)
	{
		message.setId(messageId);
		return messageService.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")

	public void deleteMessage(@PathParam("messageId") long messageId,Message message){
	 messageService.removeMessages(messageId)	;
	}
	

	
	@Path("/{messageId}/comments")
	public CommentResource Test(){
		return new CommentResource();
	}
	
	
}
