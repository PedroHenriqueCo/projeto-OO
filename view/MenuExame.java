package clinica.view;

import clinica.servicos.*;
import clinica.entidades.*;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MenuExame {
    private ExameService exameService;
    private PacienteService pacienteService;
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public MenuExame(ExameService exameService, PacienteService pacienteService) {
        this.exameService = exameService;
        this.pacienteService = pacienteService;
    }

    public void exibirMenu() {
        String[] opcoes = {
            "Agendar Exame",
            "Registrar Resultado",
            "Voltar"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(
                null,
                "Gerenciamento de Exames",
                "Menu Exames",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            switch (escolha) {
                case 0:
                    agendarExame();
                    break;
                case 1:
                    registrarResultado();
                    break;
            }
        } while (escolha != 2);
    }

    private void agendarExame() {
        try {
            String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente:");
            if (cpfPaciente == null) return;

            Paciente paciente = pacienteService.buscarPorCPF(cpfPaciente)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

            String[] tipos = new String[Exame.TipoExame.values().length];
            for (int i = 0; i < tipos.length; i++) {
                tipos[i] = Exame.TipoExame.values()[i].toString();
            }

            String tipoSelecionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecione o tipo de exame:",
                "Tipo de Exame",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
            );
            if (tipoSelecionado == null) return;

            String dataStr = JOptionPane.showInputDialog("Data do Exame (dd/MM/yyyy):");
            if (dataStr == null) return;
            LocalDate data = LocalDate.parse(dataStr, dateFormatter);

            String valorStr = JOptionPane.showInputDialog("Valor do Exame (R$):");
            if (valorStr == null) return;
            double valor = Double.parseDouble(valorStr);

            Exame exame = exameService.criarExame(Exame.TipoExame.valueOf(tipoSelecionado), data, valor);
            exameService.agendarExame(exame, paciente, data);
            JOptionPane.showMessageDialog(null, "Exame agendado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao agendar exame: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void registrarResultado() {
        try {
            String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente:");
            if (cpfPaciente == null) return;

            Paciente paciente = pacienteService.buscarPorCPF(cpfPaciente)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

            var exames = paciente.getHistoricoExames();
            if (exames.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Paciente não possui exames agendados");
                return;
            }

            StringBuilder listaExames = new StringBuilder("Exames do paciente:\n");
            for (int i = 0; i < exames.size(); i++) {
                Exame exame = exames.get(i);
                listaExames.append(i + 1).append(". ")
                          .append(exame.getTipo())
                          .append(" - ")
                          .append(exame.getDataRealizacao().format(dateFormatter))
                          .append("\n");
            }

            String escolhaStr = JOptionPane.showInputDialog(listaExames.toString() + "\nEscolha o número do exame:");
            if (escolhaStr == null) return;
            
            int escolha = Integer.parseInt(escolhaStr) - 1;
            if (escolha < 0 || escolha >= exames.size()) {
                JOptionPane.showMessageDialog(null, "Número de exame inválido");
                return;
            }

            String resultado = JOptionPane.showInputDialog("Digite o resultado do exame:");
            if (resultado == null) return;

            exameService.registrarResultado(exames.get(escolha), resultado);
            JOptionPane.showMessageDialog(null, "Resultado registrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar resultado: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
