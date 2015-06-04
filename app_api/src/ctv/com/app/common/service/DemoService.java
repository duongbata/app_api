package ctv.com.app.common.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import ctv.com.app.common.application.SpringApplicationContext;
import ctv.com.app.common.logic.BaseLogicIF;

@Path("/message")
public class DemoService {
	private BaseLogicIF baseLogic;
	@GET
	@Path("/{param}")
	public Response sendHello(@PathParam("param") int id) {
		baseLogic = (BaseLogicIF) SpringApplicationContext.getBean("baseLogic");
		String hello = null;
		try {
			hello = baseLogic.getMessage(id);
		} catch(Throwable th) {
			System.out.println(th.getMessage());
		}
		return Response.status(200).entity(hello).build();
	}
}
