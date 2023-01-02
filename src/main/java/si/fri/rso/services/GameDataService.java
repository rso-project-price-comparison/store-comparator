package si.fri.rso.services;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import si.fri.rso.services.dtos.GameDto;
import si.fri.rso.services.dtos.GamePriceDto;
import si.fri.rso.services.dtos.PriceRequest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.List;

@Path("/api/v1/gamedata")
@RegisterRestClient(configKey = "game-data")
public interface GameDataService {

    @GET
    @Path("/game")
    List<GameDto> getGames(@QueryParam("searchString") String searchString);

    @POST
    @Path("/price")
    List<GamePriceDto> getPrices(List<PriceRequest> request);
}