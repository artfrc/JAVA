import java.time.LocalDate;
import java.time.LocalTime;

import com.petland.domain.atendimento.Atendimento;
import com.petland.domain.atendimento.AtendimentoStatus;
import com.petland.domain.atendimento.AtendimentoTipo;
import com.petland.domain.cadastro.Animal;
import com.petland.domain.cadastro.Cadastro;
import com.petland.domain.cadastro.Endereco;
import com.petland.domain.cadastro.Especie;
import com.petland.domain.cadastro.Perfil;
import com.petland.domain.cadastro.ProdutoServico;

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
    

        Animal animal = new Animal();
        animal.setId(1);
        animal.setNome("Rex");
        animal.setEspecie(Especie.CACHORRO);
        animal.setAniversario(LocalDate.of(2015, 1, 1));  

        ProdutoServico produtoServico = new ProdutoServico();
        produtoServico.setId(1);
        produtoServico.setNome("Ração");
        produtoServico.setValor(50.0);
        produtoServico.setServico(true);

        Atendimento atendimento = new Atendimento();
        atendimento.setId(1);
        atendimento.setData(LocalDate.now());
        atendimento.setHora(LocalTime.now());
        atendimento.setDescricao(produtoServico.getNome());
        atendimento.setStatus(AtendimentoStatus.REALIZANDO);
        atendimento.setTipo(AtendimentoTipo.HIGIENIZACAO);
        atendimento.setSolicitante(cadastro);
        atendimento.setPaciente(animal);
        atendimento.setServico(produtoServico);
        atendimento.setValor(produtoServico.getValor());

        System.out.println("Id atendimento: " + atendimento.getId());
        System.out.println("Data atendimento: " + atendimento.getData());
        System.out.println("Hora atendimento: " + atendimento.getHora());
        System.out.println("Descrição atendimento: " + atendimento.getDescricao());
        System.out.println("Status atendimento: " + atendimento.getStatus());
        System.out.println("Tipo atendimento: " + atendimento.getTipo());
        System.out.println("Solicitante atendimento: " + atendimento.getSolicitante().getNome());
        System.out.println("Paciente atendimento: " + atendimento.getPaciente().getNome());
        System.out.println("Serviço atendimento: " + atendimento.getServico().getNome());
        System.out.println("Valor atendimento: " + atendimento.getValor());
    }
}
