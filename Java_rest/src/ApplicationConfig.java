import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/rest")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        packages("rest");
    }
}
