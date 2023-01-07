package si.fri.rso.health;

import io.smallrye.health.checks.UrlHealthCheck;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.HttpMethod;

@ApplicationScoped
public class GameDataHealthCheck {

    @ConfigProperty(name = "gamedata.url")
    String gameDataUrl;

    @Readiness
    HealthCheck checkURL() {
        return new UrlHealthCheck(gameDataUrl)
                .name("Game data health check").requestMethod(HttpMethod.GET).statusCode(200);
    }

}