import java.util.List;

public class Habilidade {
    private List<String> habilidades;

    public String getHabilidades() {
        return String.join(", ", habilidades);
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }
}
