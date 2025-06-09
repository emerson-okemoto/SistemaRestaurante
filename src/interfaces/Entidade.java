package interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Classe abstrata que define uma entidade base para outras classes de modelo.
 * Todas as classes que estendem Entidade devem implementar os métodos abstratos.
 */
public abstract class Entidade {

    private Integer id;
    
    /**
     * Retorna o identificador da entidade.
     * 
     * @return id da entidade.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Define o identificador da entidade.
     * 
     * @param id Novo valor do identificador.
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Define o identificador a partir de uma string.
     * Caso a string seja inválida, o id será definido como 0.
     * 
     * @param id Valor do identificador em formato de string.
     */
    public void setId(String id) {
        this.id = (id == null || id.isEmpty() || !id.matches("[0-9.]+")) ? 0
                : Integer.valueOf(id);
    }

    /**
     * Retorna a query SQL para inserção de registros.
     * As classes concretas devem implementar este método.
     * 
     * @return Query SQL de inserção.
     */
    public abstract String getInsert();

    /**
     * Retorna a query SQL para atualização de registros.
     * As classes concretas devem implementar este método.
     * 
     * @return Query SQL de atualização.
     */
    public abstract String getUpdate();
    
     /**
     * Define os parâmetros da query SQL a partir de um PreparedStatement.
     * As classes concretas devem implementar este método.
     * 
     * @param prepareStatement PreparedStatement a ser preenchido com parâmetros.
     * @throws SQLException Em caso de erro ao definir parâmetros.
     */
    public abstract void setParameter(PreparedStatement prepareStatement) throws SQLException;
}
