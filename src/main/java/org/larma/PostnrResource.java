package org.larma;

import org.larma.model.PostnrInfo;
import org.larma.service.PostNrService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class PostnrResource {
    private final static PostNrService service = new PostNrService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PostnrInfo> search(
            @QueryParam("pn") final String postnr,
            @QueryParam("ps") final String poststed,
            @QueryParam("kn") final String kommunenr,
            @QueryParam("k") final String kommune)
    {
        final PostnrInfo q = new PostnrInfo(postnr, poststed, kommunenr, kommune);
        return service.search(q);
    }
}

