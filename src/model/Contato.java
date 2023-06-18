package model;

public class Contato {
    private String email;
    private Long telefone;
    private Long celular;
    private Boolean celularWhats;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public boolean getCelularWhats() {
        return celularWhats;
    }

    public void setCelularWhats(boolean celularWhats) {
        this.celularWhats = celularWhats;
    }

}
