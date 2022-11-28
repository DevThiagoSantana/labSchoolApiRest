package tech.devinhouse.labschoolapirest.exception;

public class RegistroExistenteException extends RuntimeException {

    public RegistroExistenteException(String nomeRecurso, String id) {
        super(nomeRecurso + " com identificador " + id + " já existente!");
    }

    public RegistroExistenteException(String nomeRecurso, Long id) {
        this(nomeRecurso, String.valueOf(id));
    }

}
