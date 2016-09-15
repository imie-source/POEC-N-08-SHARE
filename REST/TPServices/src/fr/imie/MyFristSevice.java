package fr.imie;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class MyFristSevice
 */
@Stateless
@Path("/helloService/{textDTO}")
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public class MyFristSevice{

    /**
     * Default constructor. 
     */
    public MyFristSevice() {
        // TODO Auto-generated constructor stub
    }
    
    @GET
    public Response helloService(@PathParam("textDTO") String text){
    	TestRestDTO testRestDTO =  new TestRestDTO();
    	testRestDTO.setText(text);
    	return Response.ok(testRestDTO).build();
    }

}
