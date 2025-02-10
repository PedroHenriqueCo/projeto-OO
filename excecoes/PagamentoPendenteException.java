package br.com.clinica.excecoes;

public class PagamentoPendenteException extends RuntimeException {
    public PagamentoPendenteException(String message) {
        super(message);
    }

    public PagamentoPendenteException(String message, Throwable cause) {
        super(message, cause);
    }
}
