package lapr.project.utils;

/**
 *  Exceção lançada quando da criação de uma instância de Tempo é inserido
 * um valor inteiro para segundo invalido.
 */
public class SegundoInvalidoException extends IllegalArgumentException {

    /**
     * Constrói uma SegundoInvalidoException com a mensagem "Segundo é inválido!".
     */
    public SegundoInvalidoException() {
        super("Minuto é inválido!!");
    }

    /**
     * Constrói uma SegundoInvalidoException contendo a mensagem recebida.
     *
     * @param mensagem a mensagem transmitida pela exceção
     */
    public SegundoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
