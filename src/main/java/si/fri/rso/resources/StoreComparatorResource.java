package si.fri.rso.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.domain.dto.StoreComparisonDto;
import si.fri.rso.entities.GameToCompareEntity;
import si.fri.rso.services.dtos.StoreEnum;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1/storecomparator")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface StoreComparatorResource {

    @POST
    @Path("/gametocompare")
    @Operation(summary = "Create gameToCompare.")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "GameToCompare created.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = GameToCompareEntity.class, type = SchemaType.OBJECT))})})
    GameToCompareEntity createGameToCompare(GameToCompareEntity gameToCompareEntity);

    @DELETE
    @Path("gametocompare/{id}")
    @Operation(summary = "Delete gameToCompare.")
    @APIResponses(value = {
            @APIResponse(responseCode = "204", description = "GameToCompare delete.")})
    void removeGameToCompare(@PathParam("id") Long id);

    @GET
    @Path("/compare/{id}")
    @Operation(summary = "Compare store items from different stores for selected user.")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", description = "Stores compared.",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON,
                            schema = @Schema(implementation = StoreComparisonDto.class, type = SchemaType.ARRAY))})})
    List<StoreComparisonDto> compareStores(@PathParam("id") String sessionId, @QueryParam("favouriteStore") StoreEnum favouriteStore);
}
