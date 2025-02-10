package br.com.clinica.servicos;

import br.com.clinica.entidades.*;
import br.com.clinica.excecoes.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AgendamentoService {
    private static final int MAX_CONSULTAS_POR_DIA = 8;

    public void agendarConsulta(Paciente paciente, Medico medico, LocalDate data, LocalTime horario, String especialidade) {
        validarHorarioDisponivel(medico, data, horario);
        validarLimiteConsultasDiarias(medico, data);
        validarEspecialidade(medico, especialidade);
        validarPagamentosPendentes(paciente);
        validarConsultaMesmoDia(paciente, data);

        Consulta consulta = new Consulta(data, horario, paciente, medico, calcularValorConsulta(medico));
        paciente.adicionarConsulta(consulta);
        medico.adicionarConsulta(consulta);
    }

    private void validarHorarioDisponivel(Medico medico, LocalDate data, LocalTime horario) {
        boolean horarioOcupado = medico.getHistoricoConsultas().stream()
            .anyMatch(consulta -> 
                consulta.getDataConsulta().equals(data) && 
                consulta.getHorarioInicio().equals(horario) &&
                consulta.getStatus() != StatusConsulta.CANCELADA);

        if (horarioOcupado) {
            throw new HorarioIndisponivelException("Médico já possui consulta agendada neste horário");
        }
    }

    private void validarLimiteConsultasDiarias(Medico medico, LocalDate data) {
        long consultasNoDia = medico.getHistoricoConsultas().stream()
            .filter(consulta -> 
                consulta.getDataConsulta().equals(data) && 
                consulta.getStatus() != StatusConsulta.CANCELADA)
            .count();

        if (consultasNoDia >= MAX_CONSULTAS_POR_DIA) {
            throw new HorarioIndisponivelException("Médico já atingiu o limite de consultas para este dia");
        }
    }

    private void validarEspecialidade(Medico medico, String especialidade) {
        if (!medico.getEspecialidade().equalsIgnoreCase(especialidade)) {
            throw new EspecialidadeInvalidaException(
                "Médico não atende a especialidade " + especialidade);
        }
    }

    private void validarPagamentosPendentes(Paciente paciente) {
        // Aqui você deve implementar a lógica para verificar pagamentos pendentes
        // Esta é uma implementação simplificada
        boolean temPagamentosPendentes = false; // Deve ser implementado
        if (temPagamentosPendentes) {
            throw new PagamentoPendenteException("Paciente possui pagamentos pendentes");
        }
    }

    private void validarConsultaMesmoDia(Paciente paciente, LocalDate data) {
        boolean temConsultaNoDia = paciente.getHistoricoConsultas().stream()
            .anyMatch(consulta -> 
                consulta.getDataConsulta().equals(data) && 
                consulta.getStatus() != StatusConsulta.CANCELADA);

        if (temConsultaNoDia) {
            throw new HorarioIndisponivelException("Paciente já possui consulta agendada neste dia");
        }
    }

    private double calcularValorConsulta(Medico medico) {
        // Implementar lógica de cálculo do valor da consulta
        return 150.00; // Valor padrão
    }

    public void cancelarConsulta(Consulta consulta) {
        if (consulta.getStatus() != StatusConsulta.AGENDADA) {
            throw new IllegalStateException("Não é possível cancelar uma consulta que não está agendada");
        }
        consulta.setStatus(StatusConsulta.CANCELADA);
    }

    public void finalizarConsulta(Consulta consulta) {
        if (consulta.getStatus() != StatusConsulta.AGENDADA) {
            throw new IllegalStateException("Não é possível finalizar uma consulta que não está agendada");
        }
        consulta.setStatus(StatusConsulta.REALIZADA);
    }
}
