package main.web.services.civa.iam.domain.services;

import main.web.services.civa.iam.domain.model.aggregates.User;
import main.web.services.civa.iam.domain.model.queries.GetAllUsersQuery;
import main.web.services.civa.iam.domain.model.queries.GetUserByIdQuery;
import main.web.services.civa.iam.domain.model.queries.GetUserByUsernameQuery;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    List<User> handle(GetAllUsersQuery query);
    Optional<User> handle(GetUserByIdQuery query);
    Optional<User> handle(GetUserByUsernameQuery query);
}