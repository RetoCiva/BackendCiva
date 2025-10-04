package main.web.services.civa.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String username, String token) {
}