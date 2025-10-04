package main.web.services.civa.iam.domain.model.commands;

import main.web.services.civa.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpCommand(String username, String password, List<Role> roles) {
}
