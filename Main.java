package clinica;

import clinica.repositorios.*;
import clinica.servicos.*;
import clinica.view.*;
import javax.swing.JOptionPane;

public class Main {
    private static PacienteService pacienteService;
    private static MedicoService medicoService;
    private static AgendamentoService agendamentoService;
    private static ExameService exameService;
    private static PagamentoService pagamentoService;

    public static void main(String[] args) {
        inicializarServicos();

        MenuPaciente menuPaciente = new MenuPaciente(pacienteService);
        MenuMedico menuMedico = new MenuMedico(medicoService);
        MenuConsulta menuConsulta = new MenuConsulta(agendamentoService, pacienteService, medicoService);
        MenuExame menuExame = new MenuExame(exameService, pacienteService);
        MenuPagamento menuPagamento = new MenuPagamento(pagamentoService, pacienteService);

        int opcao;
        do {
            opcao = MenuPrincipal.menuOpcoes();
            switch (opcao) {
                case 0: // Pacientes
                    menuPaciente.exibirMenu();
                    break;
                case 1: // Médicos
                    menuMedico.exibirMenu();
                    break;
                case 2: // Consultas
                    menuConsulta.exibirMenu();
                    break;
                case 3: // Exames
                    menuExame.exibirMenu();
                    break;
                case 4: // Pagamentos
                    menuPagamento.exibirMenu();
                    break;
                case 5: // Sair
                    JOptionPane.showMessageDialog(null, "Encerrando o sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
                    break;
            }
        } while (opcao != 5);
    }

    private static void inicializarServicos() {
        PacienteRepository pacienteRepository = new PacienteRepository();
        MedicoRepository medicoRepository = new MedicoRepository();
        ConsultaRepository consultaRepository = new ConsultaRepository();
        ExameRepository exameRepository = new ExameRepository();

        pagamentoService = new PagamentoService();
        pacienteService = new PacienteService(pacienteRepository);
        medicoService = new MedicoService(medicoRepository);
        agendamentoService = new AgendamentoService();
        exameService = new ExameService(exameRepository, pagamentoService);
    }
}
