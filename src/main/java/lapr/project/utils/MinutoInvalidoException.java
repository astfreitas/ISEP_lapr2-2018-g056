package lapr.project.utils;

/**
 *  Exceção lançada quando da criação de uma instância de Tempo é inserido
 * um valor inteiro para minuto invalido.
 */
public class MinutoInvalidoException extends IllegalArgumentException{
    /**
      * Constrói uma MinutoInvalidoException com a mensagem "Minuto é inválido!".
     */    
    public MinutoInvalidoException() {
        super("Minuto é inválido!!");
    }
    
    /**
     * Constrói uma MinutoInvalidoException contendo a mensagem recebida.
     * 
     * @param mensagem a mensagem transmitida pela exceção
     */
    public MinutoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
