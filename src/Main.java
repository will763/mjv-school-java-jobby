import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ArquivoUtils arquivoUtils = new ArquivoUtils();
        Cadastro candidato1 = new Cadastro();

        candidato1.getPessoa().setNome("william");
        candidato1.getPessoa().setCpf("123.768.877-25");
        candidato1.getPessoa().setDataNascimento(LocalDate.of(2001, Month.MAY,10));
        candidato1.getPessoa().setSexo(Genero.MASCULINO);

        candidato1.getEndereco().setLogradouro("Avenida São Paulo");
        candidato1.getEndereco().setEstado("Paraíba");
        candidato1.getEndereco().setCidade("Jão Pessoa");
        candidato1.getEndereco().setNumero("375");
        candidato1.getEndereco().setBairro("Estados");
        candidato1.getEndereco().setComplemento("até 1057/1058");

        candidato1.getContato().setEmail("william@gmail.com");
        candidato1.getContato().setTelefone(8399952888L);
        candidato1.getContato().setCelular(83997864543L);
        candidato1.getContato().setCelularWhats(true);

        candidato1.getProfissional().setProfissão("Desenvolvedor");
        candidato1.getProfissional().setEmpresa("Open Source");
        candidato1.getProfissional().setEmpregoAtual(true);
        candidato1.getProfissional().setSalario(0.00);

        candidato1.getPretencaoSalarial().setValorMinimo(1400.00);
        candidato1.getPretencaoSalarial().setValorMaximo(1500.00);
        candidato1.getHabilidade().setHabilidades(List.of("Java, Vue3, Postgres, Spring"));

        List<Cadastro> cadastros = new ArrayList(List.of(candidato1,candidato1));
        arquivoUtils.gravarArquivoCSV(cadastros);
        arquivoUtils.gravarArquivoTXT(cadastros);
    }
}