package main.web.services.civa.iam.interfaces.rest.transform;

import main.web.services.civa.iam.domain.model.commands.SignInCommand;
import main.web.services.civa.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
}