import com.petland.domain.cadastro.Cadastro;
import com.petland.domain.cadastro.Endereco;
import com.petland.domain.cadastro.Perfil;

public class App {
    public static void main(String[] args) throws Exception {

        Cadastro cadastro = new Cadastro();
        cadastro.setId(1);
        cadastro.setNome("João");
        
        Perfil perfil = new Perfil();
        perfil.setCliente(true);
        perfil.setFornecedor(false);
        perfil.setPrestador(false);
        cadastro.setPerfil(perfil);

        Endereco endereco = new Endereco();
        endereco.setLogradouro("Rua 1");
        endereco.setNumero("123");
        cadastro.setEndereco(endereco);
    
        System.out.println("Id: " + cadastro.getId());
        System.out.println("Nome: " + cadastro.getNome());
        System.out.println("Cliente: " + cadastro.getPerfil().getCliente());
        System.out.println("Fornecedor: " + cadastro.getPerfil().getFornecedor());
        System.out.println("Prestador: " + cadastro.getPerfil().getPrestador());
        System.out.println("Logradouro: " + cadastro.getEndereco().getLogradouro());
        System.out.println("Número: " + cadastro.getEndereco().getNumero());
    }
}
