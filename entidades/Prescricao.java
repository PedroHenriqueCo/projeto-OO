package br.com.clinica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prescricao {
    private Consulta consultaAssociada;
    private List<Exame> examesPrescritos;
    private List<Medicamento> medicamentos;
    private LocalDate dataValidade;

    public Prescricao(Consulta consultaAssociada, LocalDate dataValidade) {
        this.consultaAssociada = consultaAssociada;
        this.dataValidade = dataValidade;
        this.examesPrescritos = new ArrayList<>();
        this.medicamentos = new ArrayList<>();
    }

    public Consulta getConsultaAssociada() {
        return consultaAssociada;
    }

    public List<Exame> getExamesPrescritos() {
        return Collections.unmodifiableList(examesPrescritos);
    }

    public void adicionarExame(Exame exame) {
        if (exame != null) {
            this.examesPrescritos.add(exame);
        }
    }

    public List<Medicamento> getMedicamentos() {
        return Collections.unmodifiableList(medicamentos);
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        if (medicamento != null) {
            this.medicamentos.add(medicamento);
        }
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
