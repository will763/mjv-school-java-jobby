package data;

import enumeration.DataFormato;
import enumeration.Genero;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TratamentoDado {

    public static String formatarDoubleCSV(Double valor){
        DecimalFormat decimalFormat = new DecimalFormat("#00.00");
        String valorFormatado = decimalFormat.format(valor);
        return valorFormatado.replaceAll("\\,", "\\.");
    }

    public static String formatarNumeroEndereco(String str){
        if (str != "S/N"){
            return String.format("%5s", str);
        }

        return str;
    }

    public static String formatarData(LocalDate data, DataFormato formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato.getFormat());
        return  formatter.format(data);
    }

    public static String formatarData(LocalDate data){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DataFormato.YYYY_MM_DD.getFormat());
        String dataFormatada = formatter.format(data);
        return dataFormatada.replaceAll("\\D", "");
    }

    public static String converterParaVazio(String str){
        return str == null ? "" : str;
    }

    public static String converterParaVazio(List<String> list){
        return list.isEmpty() ? "" : list.toString();
    }

    public static String formatarCampoTexto(String str, Integer comprimento, Boolean paraMaiusculo){
        String nome = "";
        if (str.length() > comprimento)
            nome = str.substring(0, comprimento);

        if (str.length() < comprimento)
            nome = String.format("%" + comprimento + "s", str);

        return paraMaiusculo ? nome.toUpperCase() : nome.toLowerCase();
    }

    public static String formatarNumeroContato(Long numero, Integer comprimento){
        if (numero.toString().isEmpty()){
            return String.format("%0" + comprimento + "d", 0);
        }

        String numeroContato = numero.toString().replaceAll("[^0-9]", "");
        return String.format("%" + comprimento + "s", numeroContato);
    }

    public static String formatarWhatsContato(Boolean whats){
        if (whats == null){
            return "0";
        }

        return whats ? "T" : "F";
    }

    public static String formatarCampoTexto(List<String> list, Integer comprimento, Boolean paraMaiusculo){
        String nome = "";
        if (list.size() > comprimento)
            nome = list.toString().substring(0, comprimento);

        if (list.size() < comprimento)
            nome = String.format("%" + comprimento + "s", list.toString());

        return paraMaiusculo ? nome.toUpperCase() : nome.toLowerCase();
    }

    public static String formatarCpf(String cpf){
        return cpf.replaceAll("\\D", "");
    }

    public static String formatarGenero(Genero genero){
        return genero == Genero.MASCULINO ? "M" : "F";
    }

    public static String formatarDinheiro(Double dinheiro){
        String dinheiroPuro = dinheiro.toString().replaceAll("[^0-9]", "");
        return String.format("%10s",dinheiroPuro).replaceAll(" ","0");
    }

    public static String formatarEmpregoAtual(Boolean empregado){
        if (empregado == null){
            return " ";
        }

        return empregado ? "T" : "F";
    }
}
