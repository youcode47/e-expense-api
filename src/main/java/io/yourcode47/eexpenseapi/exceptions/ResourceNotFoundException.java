package io.yourcode47.eexpenseapi.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Could not find resource with " + id + ".");
    }
    public ResourceNotFoundException() {
        super("Could not find resource .");
    }
}
