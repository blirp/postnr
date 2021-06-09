package org.larma;

import org.larma.errors.ValidationException;
import org.larma.model.PostnrInfo;
import org.larma.service.PostNrService;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

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
        validate(q);
        return service.search(q);
    }

    private void validate(
            PostnrInfo query)
    {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<PostnrInfo>> violations = validator.validate(query);
        if (violations.size() > 0) {
            throw new ValidationException(violations);
        }
    }
}

