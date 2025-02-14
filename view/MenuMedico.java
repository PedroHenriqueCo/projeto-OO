package br.com.clinica.view;

import br.com.clinica.servicos.MedicoService;
import br.com.clinica.entidades.Medico;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuMedico {
    private MedicoService medicoService;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuMedico(MedicoService medicoService) {
        this.medicoService = medicoService;
    }

    public void exibirMenu() {
        String[] opcoes = {
            "Cadastrar Médico",
            "Buscar Médico",
            "Listar Médicos",
            "Voltar"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(
                null,
                "Gerenciamento de Médicos",
                "Menu Médicos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    cadastrarMedico();
                    break;
                case 1:
                    buscarMedico();
                    break;
                case 2:
                    listarMedicos();
                    break;
                case 3:
                    return;
            }
        } while (escolha != 3);
    }

    private void cadastrarMedico() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Médico:");
            if (nome == null) return;

            String cpf = JOptionPane.showInputDialog("CPF (formato: XXX.XXX.XXX-XX):");
            if (cpf == null) return;

            String dataNascStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy):");
            if (dataNascStr == null) return;

            String crm = JOptionPane.showInputDialog("CRM:");
            if (crm == null) return;

            String especialidade = JOptionPane.showInputDialog("Especialidade:");
            if (especialidade == null) return;

            LocalDate dataNascimento = LocalDate.parse(dataNascStr, dateFormatter);
            Medico medico = medicoService.cadastrarMedico(nome, cpf, dataNascimento, crm, especialidade);
            
            JOptionPane.showMessageDialog(null, "Médico cadastrado com sucesso!\nNome: " + medico.getNome());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar médico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarMedico() {
        try {
            String cpf = JOptionPane.showInputDialog("Digite o CPF do médico:");
            if (cpf == null) return;

            medicoService.buscarPorCPF(cpf).ifPresentOrElse(
                medico -> JOptionPane.showMessageDialog(null, 
                    "Médico encontrado:\n" +
                    "Nome: " + medico.getNome() + "\n" +
                    "CPF: " + medico.getCpf() + "\n" +
                    "CRM: " + medico.getCrm() + "\n" +
                    "Especialidade: " + medico.getEspecialidade() + "\n" +
                    "Data Nascimento: " + medico.getDataNascimento().format(dateFormatter)),
                () -> JOptionPane.showMessageDialog(null, "Médico não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE)
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar médico: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarMedicos() {
        try {
            var medicos = medicoService.listarTodos();
            if (medicos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há médicos cadastrados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder lista = new StringBuilder("Lista de Médicos:\n\n");
            for (Medico medico : medicos) {
                lista.append("Nome: ").append(medico.getNome())
                     .append("\nCPF: ").append(medico.getCpf())
                     .append("\nCRM: ").append(medico.getCrm())
                     .append("\nEspecialidade: ").append(medico.getEspecialidade())
                     .append("\nData Nascimento: ").append(medico.getDataNascimento().format(dateFormatter))
                     .append("\n\n");
            }

            JOptionPane.showMessageDialog(null, lista.toString(), "Médicos Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar médicos: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
