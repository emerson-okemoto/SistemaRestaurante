package connection;

// Importação das classes necessárias para trabalhar com banco de dados
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe responsável por gerenciar a conexão com o banco de dados.
 * Implementa o padrão Singleton para garantir que apenas uma conexão seja criada durante o ciclo de vida da aplicação.
 */
public class Conexao {

    // Variável estática que armazenará a conexão com o banco de dados
    private static Connection con;

    // Instância única da própria classe Conexao (Singleton)
    private static Conexao obj;

    // Dados de conexão com o banco de dados
    private final String url = "jdbc:postgresql://localhost:5432/postgres"; // URL do banco de dados (PostgreSQL)
    private final String user = "postgres"; // Usuário do banco
    private final String password = "1234"; // Senha do banco

    /**
     * Construtor privado.
     * Garante que a classe só possa ser instanciada de dentro dela mesma (padrão Singleton).
     */
    private Conexao() throws SQLException {
        // Estabelece a conexão com o banco de dados
        con = DriverManager.getConnection(url, user, password);

        // Define que as transações serão automaticamente confirmadas
        con.setAutoCommit(true);
    }

    /**
     * Método responsável por retornar a instância única da classe Conexao.
     * Se ainda não existir uma instância, cria uma nova.
     * @return Instância da classe Conexao
     * @throws SQLException Caso ocorra um erro ao tentar conectar com o banco
     */
    public static Conexao getInstance() throws SQLException {
        if (obj == null) { // Se a instância ainda não foi criada
            obj = new Conexao();
        }
        return obj; // Retorna a instância
    }

    /**
     * Método que retorna o objeto de conexão com o banco de dados.
     * @return Objeto Connection
     */
    public Connection getConexao() {
        return con;
    }

    /**
     * Método responsável por fechar a conexão com o banco de dados.
     * Importante ser chamado ao finalizar a aplicação ou quando não for mais necessário usar o banco.
     * @throws SQLException Caso ocorra um erro ao tentar fechar a conexão
     */
    public void fecharConexao() throws SQLException {
        // Verifica se a conexão existe e está aberta
        if (con != null && !con.isClosed()) {
            con.close(); // Fecha a conexão
        }
    }

    // Exemplo de uso para fechar a conexão:
    // Conexao.getInstance().fecharConexao();
}
