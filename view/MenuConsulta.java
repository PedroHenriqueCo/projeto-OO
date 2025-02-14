package br.com.clinica.view;

import br.com.clinica.servicos.*;
import br.com.clinica.entidades.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MenuConsulta {
    private AgendamentoService agendamentoService;
    private PacienteService pacienteService;
    private MedicoService medicoService;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

    public MenuConsulta(AgendamentoService agendamentoService, PacienteService pacienteService, MedicoService medicoService) {
        this.agendamentoService = agendamentoService;
        this.pacienteService = pacienteService;
        this.medicoService = medicoService;
    }

    public void exibirMenu() {
        String[] opcoes = {
            "Agendar Consulta",
            "Voltar"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(
                null,
                "Gerenciamento de Consultas",
                "Menu Consultas",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (escolha == 0) {
                agendarConsulta();
            }
        } while (escolha != 1);
    }

    private void agendarConsulta() {
        try {
            String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente:");
            if (cpfPaciente == null) return;

            Paciente paciente = pacienteService.buscarPorCPF(cpfPaciente)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

            String cpfMedico = JOptionPane.showInputDialog("CPF do Médico:");
            if (cpfMedico == null) return;

            Medico medico = medicoService.buscarPorCPF(cpfMedico)
                .orElseThrow(() -> new IllegalArgumentException("Médico não encontrado"));

            String dataStr = JOptionPane.showInputDialog("Data da Consulta (dd/MM/yyyy):");
            if (dataStr == null) return;
            LocalDate data = LocalDate.parse(dataStr, dateFormatter);

            String horaStr = JOptionPane.showInputDialog("Horário da Consulta (HH:mm):");
            if (horaStr == null) return;
            LocalTime hora = LocalTime.parse(horaStr, timeFormatter);

            agendamentoService.agendarConsulta(paciente, medico, data, hora, medico.getEspecialidade());
            JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar consulta: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
