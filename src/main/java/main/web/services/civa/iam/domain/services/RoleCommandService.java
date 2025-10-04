package main.web.services.civa.iam.domain.services;

import main.web.services.civa.iam.domain.model.commands.SeedRolesCommand;

public interface RoleCommandService {
    void handle(SeedRolesCommand command);
}