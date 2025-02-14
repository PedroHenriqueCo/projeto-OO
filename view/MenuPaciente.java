package clinica.view;

import clinica.servicos.PacienteService;
import clinica.entidades.Paciente;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuPaciente {
    private PacienteService pacienteService;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuPaciente(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    public void exibirMenu() {
        String[] opcoes = {
            "Cadastrar Paciente",
            "Buscar Paciente",
            "Listar Pacientes",
            "Voltar"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(
                null,
                "Gerenciamento de Pacientes",
                "Menu Pacientes",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    cadastrarPaciente();
                    break;
                case 1:
                    buscarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    return;
            }
        } while (escolha != 3);
    }

    private void cadastrarPaciente() {
        try {
            String nome = JOptionPane.showInputDialog("Nome do Paciente:");
            if (nome == null) return;

            String cpf = JOptionPane.showInputDialog("CPF (formato: XXX.XXX.XXX-XX):");
            if (cpf == null) return;

            String dataNascStr = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy):");
            if (dataNascStr == null) return;

            LocalDate dataNascimento = LocalDate.parse(dataNascStr, dateFormatter);
            Paciente paciente = pacienteService.cadastrarPaciente(nome, cpf, dataNascimento);
            
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!\nNome: " + paciente.getNome());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar paciente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPaciente() {
        try {
            String cpf = JOptionPane.showInputDialog("Digite o CPF do paciente:");
            if (cpf == null) return;

            pacienteService.buscarPorCPF(cpf).ifPresentOrElse(
                paciente -> JOptionPane.showMessageDialog(null, 
                    "Paciente encontrado:\n" +
                    "Nome: " + paciente.getNome() + "\n" +
                    "CPF: " + paciente.getCpf() + "\n" +
                    "Data Nascimento: " + paciente.getDataNascimento().format(dateFormatter)),
                () -> JOptionPane.showMessageDialog(null, "Paciente não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE)
            );
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar paciente: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarPacientes() {
        try {
            var pacientes = pacienteService.listarTodos();
            if (pacientes.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Não há pacientes cadastrados", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            StringBuilder lista = new StringBuilder("Lista de Pacientes:\n\n");
            for (Paciente paciente : pacientes) {
                lista.append("Nome: ").append(paciente.getNome())
                     .append("\nCPF: ").append(paciente.getCpf())
                     .append("\nData Nascimento: ").append(paciente.getDataNascimento().format(dateFormatter))
                     .append("\n\n");
            }

            JOptionPane.showMessageDialog(null, lista.toString(), "Pacientes Cadastrados", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pacientes: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
