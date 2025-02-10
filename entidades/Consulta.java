package clinica.entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Consulta {
    public enum StatusConsulta {
        AGENDADA,
        CANCELADA,
        REALIZADA
    }

    private LocalDate dataConsulta;
    private LocalTime horarioInicio;
    private int duracaoMinutos;
    private StatusConsulta status;
    private Paciente paciente;
    private Medico medico;
    private List<Exame> examesPrescritos;
    private List<Medicamento> medicamentosPrescritos;
    private double valor;

    public Consulta(LocalDate dataConsulta, LocalTime horarioInicio, Paciente paciente, Medico medico, double valor) {
        this.dataConsulta = dataConsulta;
        this.horarioInicio = horarioInicio;
        this.duracaoMinutos = 30; // Duração padrão
        this.status = StatusConsulta.AGENDADA;
        this.paciente = paciente;
        this.medico = medico;
        this.valor = valor;
        this.examesPrescritos = new ArrayList<>();
        this.medicamentosPrescritos = new ArrayList<>();
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public LocalTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public StatusConsulta getStatus() {
        return status;
    }

    public void setStatus(StatusConsulta status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public List<Exame> getExamesPrescritos() {
        return Collections.unmodifiableList(examesPrescritos);
    }

    public List<Medicamento> getMedicamentosPrescritos() {
        return Collections.unmodifiableList(medicamentosPrescritos);
    }

    public void adicionarExame(Exame exame) {
        if (exame != null) {
            this.examesPrescritos.add(exame);
        }
    }

    public void adicionarMedicamento(Medicamento medicamento) {
        if (medicamento != null) {
            this.medicamentosPrescritos.add(medicamento);
        }
    }
}
