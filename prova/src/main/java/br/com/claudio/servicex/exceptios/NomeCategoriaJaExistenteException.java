package br.com.claudio.servicex.exceptios;

public class NomeCategoriaJaExistenteException extends RuntimeException {

    public NomeCategoriaJaExistenteException(String mensagem) {
        super(mensagem);
    }

    public NomeCategoriaJaExistenteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}