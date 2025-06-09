package dto;

import interfaces.Entidade;
import interfaces.InterfaceDTO;
import model.Delivery;
import model.Endereco;

/**
 * Classe responsável por transferir dados da entidade Delivery
 * entre as camadas da aplicação.
 */
public class DeliveryDTO extends InterfaceDTO {

    public String chaveEntrega;
    public String numero;
    public String complemento;
    public String enderecoId;

    @Override
    public InterfaceDTO buildDTO(Entidade e) {
        DeliveryDTO dto = new DeliveryDTO();
        Delivery delivery = (Delivery) e;
        dto.id = delivery.getId() == null ? "" : delivery.getId() + "";
        dto.chaveEntrega = delivery.getChaveEntrega();
        dto.numero = delivery.getNumero();
        dto.complemento = delivery.getComplemento();
        dto.enderecoId = (delivery.getEndereco() != null && delivery.getEndereco().getId() != null)
            ? delivery.getEndereco().getId() + "" : "";
        return dto;
    }

    @Override
    public Entidade buildEntidade() {
        Delivery delivery = new Delivery();

        delivery.setId(id == null || id.isEmpty() ? null : Integer.valueOf(id));
        delivery.setChaveEntrega(chaveEntrega);
        delivery.setNumero(numero);
        delivery.setComplemento(complemento);

        try {
            int idEndereco = enderecoId == null || enderecoId.isEmpty() ? 0 : Integer.parseInt(enderecoId);
            Endereco endereco = new Endereco();
            endereco.setId(idEndereco);
            delivery.setEndereco(endereco);
        } catch (NumberFormatException e) {
            delivery.setEndereco(null);
        }

        return delivery;
    }

    @Override
    public String[] cabecalhoTable() {
        return new String[]{"ID", "Chave Entrega", "Número", "Complemento", "Endereco ID"};
    }

    @Override
    public Object[] dadosTable() {
        return new Object[]{id, chaveEntrega, numero, complemento, enderecoId};
    }

}
