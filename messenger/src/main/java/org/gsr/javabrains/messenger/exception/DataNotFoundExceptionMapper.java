package org.gsr.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import org.gsr.javabrains.messenger.model.ErrorMessage;


public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException ex) {
		// TODO Auto-generated method stub
		ErrorMessage errorMessage  = new ErrorMessage(ex.getMessage(), 404 ,"http://javabrains.gsr.org");
		return Response.status(Status.NOT_FOUND).build();
	}

}
