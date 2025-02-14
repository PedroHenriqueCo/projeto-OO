package clinica.view;

import clinica.servicos.*;
import clinica.entidades.*;
import javax.swing.JOptionPane;

public class MenuPagamento {
    private PagamentoService pagamentoService;
    private PacienteService pacienteService;

    public MenuPagamento(PagamentoService pagamentoService, PacienteService pacienteService) {
        this.pagamentoService = pagamentoService;
        this.pacienteService = pacienteService;
    }

    public void exibirMenu() {
        String[] opcoes = {
            "Registrar Pagamento",
            "Voltar"
        };

        int escolha;
        do {
            escolha = JOptionPane.showOptionDialog(
                null,
                "Gerenciamento de Pagamentos",
                "Menu Pagamentos",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoes,
                opcoes[0]
            );

            if (escolha == 0) {
                registrarPagamento();
            }
        } while (escolha != 1);
    }

    private void registrarPagamento() {
        try {
            String cpfPaciente = JOptionPane.showInputDialog("CPF do Paciente:");
            if (cpfPaciente == null) return;

            Paciente paciente = pacienteService.buscarPorCPF(cpfPaciente)
                .orElseThrow(() -> new IllegalArgumentException("Paciente não encontrado"));

            String[] tipos = {"Consulta", "Exame"};
            String tipoSelecionado = (String) JOptionPane.showInputDialog(
                null,
                "Selecione o tipo de pagamento:",
                "Tipo de Pagamento",
                JOptionPane.QUESTION_MESSAGE,
                null,
                tipos,
                tipos[0]
            );
            if (tipoSelecionado == null) return;

            String valorStr = JOptionPane.showInputDialog("Valor do Pagamento (R$):");
            if (valorStr == null) return;
            double valor = Double.parseDouble(valorStr);

            if (tipoSelecionado.equals("Consulta")) {
                pagamentoService.registrarPagamentoConsulta(null, paciente, valor);
            } else {
                pagamentoService.registrarPagamentoExame(null, paciente, valor);
            }

            JOptionPane.showMessageDialog(null, "Pagamento registrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao registrar pagamento: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
