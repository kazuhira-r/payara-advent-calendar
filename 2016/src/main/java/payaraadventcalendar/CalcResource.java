package payaraadventcalendar;

import java.util.concurrent.TimeUnit;
import javax.cache.annotation.CacheDefaults;
import javax.cache.annotation.CacheResult;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("calc")
@ApplicationScoped
@CacheDefaults(cacheName = "calcCache")
public class CalcResource {
    @GET
    @Path("add")
    @CacheResult
    public int add(@QueryParam("a") int a, @QueryParam("b") int b) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5L);

        return a + b;
    }
}
