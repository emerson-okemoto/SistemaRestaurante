package interfaces;

//import interfaces.Entidade; //// Isso não é necessário, pois Entidade está no mesmo pacote
import java.util.LinkedList;
import java.util.List;

public abstract class InterfaceDTO {
    public String id;
    public abstract InterfaceDTO buildDTO(Entidade e);
    public abstract Entidade buildEntidade();
    public abstract String[] cabecalhoTable();
    public abstract Object[] dadosTable();
    
    public List<InterfaceDTO> preencheLista(List<Entidade> e){
       List<InterfaceDTO> retorno = new LinkedList<>();
        for (Entidade entidade : e) {
            retorno.add(this.buildDTO(entidade));
        }
        return retorno;
    }
 }
