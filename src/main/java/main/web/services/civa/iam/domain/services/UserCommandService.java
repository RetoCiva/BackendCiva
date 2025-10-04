package main.web.services.civa.iam.domain.services;

import main.web.services.civa.iam.domain.model.aggregates.User;
import main.web.services.civa.iam.domain.model.commands.SignInCommand;
import main.web.services.civa.iam.domain.model.commands.SignUpCommand;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Optional;

public interface UserCommandService {
    Optional<ImmutablePair<User, String>> handle(SignInCommand command);
    Optional<User> handle(SignUpCommand command);
}
