package pianoboard.service.Resources;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PATCH;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Response;

import java.util.List;
import java.util.Map;

import pianoboard.service.Requests.AuthenticationRequest;
import pianoboard.service.Activities.AccountActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;

@Path("/")
public class LandingPageService implements Service {

	private final CORSFilter filter = new CORSFilter();
	private AccountActivity activity = new AccountActivity();

	public LandingPageService() {}

	@POST
	@Produces("application/json")
	public Response createAccount(AuthenticationRequest a) {
		// TODO make an account from the given username and password in the authorization request
		try {
			return filter.addCORS(Response.status(201).entity(activity.create(a.getUsername(), a.getPassword())));
		} catch(IOException e) {
			return filter.addCORS(Response.status(500));
		}
	}
}
