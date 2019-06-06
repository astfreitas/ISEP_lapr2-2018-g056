package lapr.project.utils;

/**
 *  Exceção lançada quando tenta-se criar uma instância de Hora inválida
 */
public class HoraInvalidaException extends IllegalArgumentException{
    /**
      * Constrói uma HoraInvalidaException com a mensagem "Hora é inválida!".
     */    
    public HoraInvalidaException() {
        super("Hora é inválida!!");
    }
    
    /**
     * Constrói uma HoraInvalidaException contendo a mensagem recebida.
     * 
     * @param mensagem a mensagem transmitida pela exceção
     */
    public HoraInvalidaException(String mensagem) {
        super(mensagem);
    }
}
