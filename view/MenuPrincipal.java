package view;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    public static int menuOpcoes() {
        String[] opcoes = {
            "Pacientes",
            "Médicos",
            "Consultas",
            "Exames",
            "Pagamentos",
            "Sair"
        };
        
        int escolha = JOptionPane.showOptionDialog(
            null,
            "Escolha uma opção:",
            "Sistema de Clínica Médica",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcoes,
            opcoes[0]
        );

        return escolha;
    }
}
