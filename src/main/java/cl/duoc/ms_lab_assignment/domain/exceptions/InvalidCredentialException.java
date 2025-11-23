package cl.duoc.ms_lab_assignment.domain.exceptions;

public class InvalidCredentialException extends RuntimeException {
    public InvalidCredentialException() {
        super("Credenciales incorrectas");
    }
}
