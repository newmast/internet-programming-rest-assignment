package bg.elsys.ip.rest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import bg.elsys.ip.rest.data.AnimalRepository;
import bg.elsys.ip.rest.models.Animal;
import bg.elsys.ip.rest.services.AnimalService;
import bg.elsys.ip.rest.viewmodels.AddAnimalViewModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/animals")
@Api("Animals")
public class AnimalResource {
	
	private AnimalService animalService = new AnimalService();
	
	@GET
	@ApiOperation(value = "Get list of animals.", response = Animal.class, responseContainer = "List")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAnimals(@QueryParam("page") int page) {
		return Response.ok(animalService.getAnimals(page)).build();
	}

	@POST
	@ApiOperation(value = "Create a new animal entry.", response = Animal.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createAnimal(AddAnimalViewModel vmAnimal) {
		
		Animal newAnimal = animalService.addAnimal(
				vmAnimal.getSpecies(),
				vmAnimal.getNumberOfLegs(),
				vmAnimal.getColor(),
				vmAnimal.getAge());
		return Response.ok(newAnimal).status(Status.CREATED).build();
	}
}
