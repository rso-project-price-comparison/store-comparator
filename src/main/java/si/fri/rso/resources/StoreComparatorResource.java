package si.fri.rso.resources;

import si.fri.rso.entities.GameToCompareEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/storecomparator/gametocompare")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface StoreComparatorResource {

    @POST
    GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity);

    @DELETE
    @Path("/{id}")
    void removeGameToCompare(@PathParam("id") Long id);

    @GET
    @Path("/user/{id}")
    List<GameToCompareEntity> getGameToCompareByUser(@PathParam("id") String sessionId);

}
