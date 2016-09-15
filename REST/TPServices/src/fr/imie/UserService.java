package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Session Bean implementation class UserService
 */
@Stateless
@Path("/userService")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class UserService {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}

	@GET
	public Response getAllUser() {
		List<UserEntity> userEntities = entityManager.createNamedQuery("UserEntity.findAll").getResultList();
		return Response.ok(userEntities).build();
	}
	
	@POST
	public UserEntity insertUser(UserEntity entity){
		entityManager.persist(entity);
		return(entity);
	}

}
