package fr.imie;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class MyFristSevice
 */
@Stateless
@Path("/helloService")
@Produces({MediaType.APPLICATION_XML})
public class MyFristSevice{

    /**
     * Default constructor. 
     */
    public MyFristSevice() {
        // TODO Auto-generated constructor stub
    }
    
    @GET
    public Response helloService(){
    	TestRestDTO testRestDTO =  new TestRestDTO();
    	return Response.ok(testRestDTO).build();
    }

}
