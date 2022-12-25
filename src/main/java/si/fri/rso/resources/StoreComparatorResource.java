package si.fri.rso.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.entities.GameToCompareEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/storecomparator/gametocompare")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface StoreComparatorResource {

    @POST
    @Operation(summary = "Create gameToCompare.")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "GameToCompare created.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = GameToCompareEntity.class, type = SchemaType.OBJECT))})})
    GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity);

    @DELETE
    @Path("/{id}")
    @Operation(summary = "Delete gameToCompare.")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "GameToCompare delete.")})
    void removeGameToCompare(@PathParam("id") Long id);

    @GET
    @Path("/user/{id}")
    @Operation(summary = "Get gameToCompare by user.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Found games.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = GameToCompareEntity.class, type = SchemaType.ARRAY))})})
    List<GameToCompareEntity> getGameToCompareByUser(@PathParam("id") String sessionId);

}
