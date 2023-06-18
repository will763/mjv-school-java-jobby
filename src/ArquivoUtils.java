import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ArquivoUtils {
    private final String PATH = "/home/will//Projects/mjv-school-java-jobby/jobby/files";

    public void gravarArquivoCSV(List<Cadastro> cadastro) throws IOException {
        Path arquivoDestino = Paths.get(PATH + "/cadastro.csv");

        for (Cadastro c1: cadastro) {
            byte[] conteudo = obterBytesCadastroCSV(c1);
            Files.write(arquivoDestino, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }
    }

    public void gravarArquivoTXT(List<Cadastro>  cadastro) throws IOException{
        Path arquivoDestino = Paths.get(PATH + "/cadastro-{CPF}.txt");

        for (Cadastro c1: cadastro) {
            byte[] conteudo = obterBytesCadastroTXT(c1);
            Files.write(arquivoDestino, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        }

    }

    private byte[] obterBytesCadastroCSV(Cadastro cadastro){
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getPessoa().getNome()) + ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getPessoa().getCpf())+ ";");
        conteudo.append(TratamentoDado.formatarData(cadastro.getPessoa().getDataNascimento(), DataFormato.YYYY_MM_DD)+ ";");
        conteudo.append(cadastro.getPessoa().getSexo()+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getLogradouro())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getNumero())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getBairro())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getComplemento())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getCidade())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getEndereco().getEstado())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getContato().getEmail())+ ";");
        conteudo.append(cadastro.getContato().getTelefone()+ ";");
        conteudo.append(cadastro.getContato().getCelular()+ ";");
        conteudo.append(cadastro.getContato().getCelularWhats()+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getProfissional().getProfissão())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getProfissional().getEmpresa())+ ";");
        conteudo.append(TratamentoDado.formatarDoubleCSV(cadastro.getProfissional().getSalario())+ ";");
        conteudo.append(cadastro.getProfissional().getEmpregoAtual()+ ";");
        conteudo.append(TratamentoDado.formatarDoubleCSV(cadastro.getPretencaoSalarial().getValorMinimo())+ ";");
        conteudo.append(TratamentoDado.formatarDoubleCSV(cadastro.getPretencaoSalarial().getValorMaximo())+ ";");
        conteudo.append(TratamentoDado.converterParaVazio(cadastro.getHabilidade().getHabilidades())+ ";");
        conteudo.append(System.lineSeparator());

        return conteudo.toString().getBytes(StandardCharsets.UTF_8);
    }

    private byte[] obterBytesCadastroTXT(Cadastro cadastro) {
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getPessoa().getNome(), 30, true) + " ");
        conteudo.append(TratamentoDado.formatarCpf(cadastro.getPessoa().getCpf())+ " ");
        conteudo.append(TratamentoDado.formatarData(cadastro.getPessoa().getDataNascimento())+ " ");
        conteudo.append(TratamentoDado.formatarGenero(cadastro.getPessoa().getSexo())+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getEndereco().getLogradouro(),40, true)+ " ");
        conteudo.append(TratamentoDado.formatarNumeroEndereco(cadastro.getEndereco().getNumero())+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getEndereco().getBairro(),30,true)+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getEndereco().getComplemento(),20,true)+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getEndereco().getCidade(),40,true)+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getEndereco().getEstado(),2,true)+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getContato().getEmail(),50,false)+ " ");
        conteudo.append(TratamentoDado.formatarNumeroContato(cadastro.getContato().getTelefone(),10) + " ");
        conteudo.append(TratamentoDado.formatarNumeroContato(cadastro.getContato().getCelular(),11)+ " ");
        conteudo.append(TratamentoDado.formatarWhatsContato(cadastro.getContato().getCelularWhats())+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getProfissional().getProfissão(),30,true)+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getProfissional().getEmpresa(),30,true)+ " ");
        conteudo.append(TratamentoDado.formatarDinheiro(cadastro.getProfissional().getSalario())+ " ");
        conteudo.append(TratamentoDado.formatarEmpregoAtual(cadastro.getProfissional().getEmpregoAtual()) + " ");
        conteudo.append(TratamentoDado.formatarDinheiro(cadastro.getPretencaoSalarial().getValorMinimo())+ " ");
        conteudo.append(TratamentoDado.formatarDinheiro(cadastro.getPretencaoSalarial().getValorMaximo())+ " ");
        conteudo.append(TratamentoDado.formatarCampoTexto(cadastro.getHabilidade().getHabilidades(),50,true)+ " ");
        conteudo.append(System.lineSeparator());

        return conteudo.toString().getBytes(StandardCharsets.UTF_8);
    }

}
