package util;

import static data.TratamentoDado.*;
import enumeration.DataFormato;
import model.Cadastro;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class ArquivoUtils {
    private final String PATH = "/home/will//Projects/mjv-school-java-jobby/jobby/files";

    public void gravarArquivoCSV(List<Cadastro> cadastro){
        Path arquivoDestino = Paths.get(PATH + "/cadastro.csv");

        try {
            for (Cadastro c1: cadastro) {
                byte[] conteudo = obterBytesCadastroCSV(c1);
                Files.write(arquivoDestino, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    public void gravarArquivoTXT(List<Cadastro>  cadastro){
        Path arquivoDestino = Paths.get(PATH + "/cadastro-{CPF}.txt");

        try {
            for (Cadastro c1: cadastro) {
                byte[] conteudo = obterBytesCadastroTXT(c1);
                Files.write(arquivoDestino, conteudo, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }
        }catch (IOException ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

    private byte[] obterBytesCadastroCSV(Cadastro cadastro){
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(converterParaVazio(cadastro.getPessoa().getNome()) + ";");
        conteudo.append(converterParaVazio(cadastro.getPessoa().getCpf())+ ";");
        conteudo.append(formatarData(cadastro.getPessoa().getDataNascimento(), DataFormato.YYYY_MM_DD)+ ";");
        conteudo.append(cadastro.getPessoa().getSexo()+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getLogradouro())+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getNumero())+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getBairro())+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getComplemento())+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getCidade())+ ";");
        conteudo.append(converterParaVazio(cadastro.getEndereco().getEstado())+ ";");
        conteudo.append(converterParaVazio(cadastro.getContato().getEmail())+ ";");
        conteudo.append(cadastro.getContato().getTelefone()+ ";");
        conteudo.append(cadastro.getContato().getCelular()+ ";");
        conteudo.append(cadastro.getContato().getCelularWhats()+ ";");
        conteudo.append(converterParaVazio(cadastro.getProfissional().getProfissão())+ ";");
        conteudo.append(converterParaVazio(cadastro.getProfissional().getEmpresa())+ ";");
        conteudo.append(formatarDoubleCSV(cadastro.getProfissional().getSalario())+ ";");
        conteudo.append(cadastro.getProfissional().getEmpregoAtual()+ ";");
        conteudo.append(formatarDoubleCSV(cadastro.getPretencaoSalarial().getValorMinimo())+ ";");
        conteudo.append(formatarDoubleCSV(cadastro.getPretencaoSalarial().getValorMaximo())+ ";");
        conteudo.append(converterParaVazio(cadastro.getHabilidade().getHabilidades())+ ";");
        conteudo.append(System.lineSeparator());

        return conteudo.toString().getBytes(StandardCharsets.UTF_8);
    }

    private byte[] obterBytesCadastroTXT(Cadastro cadastro) {
        StringBuilder conteudo = new StringBuilder();

        conteudo.append(formatarCampoTexto(cadastro.getPessoa().getNome(), 30, true) + " ");
        conteudo.append(formatarCpf(cadastro.getPessoa().getCpf())+ " ");
        conteudo.append(formatarData(cadastro.getPessoa().getDataNascimento())+ " ");
        conteudo.append(formatarGenero(cadastro.getPessoa().getSexo())+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getEndereco().getLogradouro(),40, true)+ " ");
        conteudo.append(formatarNumeroEndereco(cadastro.getEndereco().getNumero())+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getEndereco().getBairro(),30,true)+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getEndereco().getComplemento(),20,true)+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getEndereco().getCidade(),40,true)+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getEndereco().getEstado(),2,true)+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getContato().getEmail(),50,false)+ " ");
        conteudo.append(formatarNumeroContato(cadastro.getContato().getTelefone(),10) + " ");
        conteudo.append(formatarNumeroContato(cadastro.getContato().getCelular(),11)+ " ");
        conteudo.append(formatarWhatsContato(cadastro.getContato().getCelularWhats())+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getProfissional().getProfissão(),30,true)+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getProfissional().getEmpresa(),30,true)+ " ");
        conteudo.append(formatarDinheiro(cadastro.getProfissional().getSalario())+ " ");
        conteudo.append(formatarEmpregoAtual(cadastro.getProfissional().getEmpregoAtual()) + " ");
        conteudo.append(formatarDinheiro(cadastro.getPretencaoSalarial().getValorMinimo())+ " ");
        conteudo.append(formatarDinheiro(cadastro.getPretencaoSalarial().getValorMaximo())+ " ");
        conteudo.append(formatarCampoTexto(cadastro.getHabilidade().getHabilidades(),50,true)+ " ");
        conteudo.append(System.lineSeparator());

        return conteudo.toString().getBytes(StandardCharsets.UTF_8);
    }

}
