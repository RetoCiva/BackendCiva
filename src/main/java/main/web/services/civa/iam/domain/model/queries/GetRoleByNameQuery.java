package main.web.services.civa.iam.domain.model.queries;

import main.web.services.civa.iam.domain.model.valueobjects.Roles;

public record GetRoleByNameQuery(Roles name) {
}