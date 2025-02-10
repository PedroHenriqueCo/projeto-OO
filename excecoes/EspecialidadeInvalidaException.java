package excecoes;

public class EspecialidadeInvalidaException extends RuntimeException {
    public EspecialidadeInvalidaException(String message) {
        super(message);
    }

    public EspecialidadeInvalidaException(String message, Throwable cause) {
        super(message, cause);
    }
}
