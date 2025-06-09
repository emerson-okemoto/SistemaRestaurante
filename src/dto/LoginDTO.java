package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Login;

/**
 * DTO para a entidade Login.
 * Responsável por transferir os dados entre as camadas da aplicação.
 */
public class LoginDTO extends InterfaceDTO {

    public String usuario;
    public String senha;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        LoginDTO dto = new LoginDTO();
        Login login = (Login) e;

        dto.id = login.getId() == null ? "" : login.getId() + "";
        dto.usuario = login.getUsuario();
        dto.senha = login.getSenha();

        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Login login = new Login();

        login.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        login.setUsuario(usuario);
        login.setSenha(senha);

        return login;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Usuário", "Senha"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, usuario, senha};
    }
}
