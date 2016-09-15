package fr.imie;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	public Response insertUser(UserEntity entity){
		entityManager.persist(entity);
		return Response.ok(entity).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteUser(@PathParam("id") Integer id){

		UserEntity userEntity = entityManager.find(UserEntity.class, id);
		entityManager.remove(userEntity);
		return Response.ok("done").build();
	}
	
	@PUT
	@Path("/{id}")
	public Response updateUser(@PathParam("id") Integer id, UserEntity entityIn){
		UserEntity userEntity = entityManager.find(UserEntity.class, id);
		userEntity.setLogin(entityIn.getLogin());
		userEntity.setPassw(entityIn.getPassw());
		return Response.ok(userEntity).build();
	}

}
