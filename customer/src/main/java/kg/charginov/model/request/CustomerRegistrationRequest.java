package kg.charginov.model.request;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email) {
}
