package payaraadventcalendar;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("user")
public class UserResource {
    @GET
    @Path("register")
    public Response register(@QueryParam("firstName") String firstName,
                             @QueryParam("lastName") String lastName,
                             @Context HttpServletRequest request,
                             @Context UriInfo uriInfo) {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLoginTime(LocalDateTime.now());

        request.getSession().setAttribute("user", user);

        return Response.created(uriInfo.getRequestUri()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User get(@Context HttpServletRequest request) {
        return (User) request.getSession().getAttribute("user");
    }

    public static class User implements Serializable {
        private static final long serialVersionUID = 1L;

        private String id;

        private String firstName;

        private String lastName;

        private LocalDateTime loginTime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public LocalDateTime getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(LocalDateTime loginTime) {
            this.loginTime = loginTime;
        }
    }
}
