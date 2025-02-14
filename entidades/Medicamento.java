package clinica.entidades;

public class Medicamento {
    private String nome;
    private String posologia;
    private String duracao;

    public Medicamento(String nome, String posologia, String duracao) {
        this.nome = nome;
        this.posologia = posologia;
        this.duracao = duracao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }
}
