package main.web.services.civa.iam.interfaces.rest.transform;

import main.web.services.civa.iam.domain.model.aggregates.User;
import main.web.services.civa.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token) {
        return new AuthenticatedUserResource(user.getId(), user.getUsername(), token);
    }
}