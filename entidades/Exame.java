package clinica.entidades;

import java.time.LocalDate;

public class Exame {
    public enum TipoExame {
        SANGUE,
        RAIO_X,
        ULTRASSOM
    }

    private TipoExame tipo;
    private LocalDate dataPrescricao;
    private LocalDate dataRealizacao;
    private String resultado;
    private double custo;

    public Exame(TipoExame tipo, LocalDate dataPrescricao, double custo) {
        this.tipo = tipo;
        this.dataPrescricao = dataPrescricao;
        this.custo = custo;
    }

    public TipoExame getTipo() {
        return tipo;
    }

    public void setTipo(TipoExame tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPrescricao() {
        return dataPrescricao;
    }

    public LocalDate getDataRealizacao() {
        return dataRealizacao;
    }

    public void setDataRealizacao(LocalDate dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}

