package servicos;

import br.com.clinica.entidades.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class NotificacaoService {
    private static final int DIAS_ANTECEDENCIA_NOTIFICACAO = 2;
    
    public void verificarENotificarConsultasProximas(List<Consulta> consultas) {
        LocalDate hoje = LocalDate.now();
        
        consultas.stream()
            .filter(consulta -> consulta.getStatus() == Consulta.StatusConsulta.AGENDADA)
            .filter(consulta -> {
                long diasAteConsulta = ChronoUnit.DAYS.between(hoje, consulta.getDataConsulta());
                return diasAteConsulta <= DIAS_ANTECEDENCIA_NOTIFICACAO && diasAteConsulta > 0;
            })
            .forEach(this::enviarNotificacaoConsulta);
    }
    
    public void verificarENotificarExamesAgendados(List<Exame> exames) {
        LocalDate hoje = LocalDate.now();
        
        exames.stream()
            .filter(exame -> exame.getDataRealizacao() != null)
            .filter(exame -> {
                long diasAteExame = ChronoUnit.DAYS.between(hoje, exame.getDataRealizacao());
                return diasAteExame <= DIAS_ANTECEDENCIA_NOTIFICACAO && diasAteExame > 0;
            })
            .forEach(this::enviarNotificacaoExame);
    }
    
    private void enviarNotificacaoConsulta(Consulta consulta) {
        // Implementar lógica de envio de notificação (email, SMS, etc)
        System.out.println("Notificação: Você tem uma consulta agendada para " + 
            consulta.getDataConsulta() + " às " + consulta.getHorarioInicio() + 
            " com Dr(a). " + consulta.getMedico().getNome());
    }
    
    private void enviarNotificacaoExame(Exame exame) {
        // Implementar lógica de envio de notificação (email, SMS, etc)
        System.out.println("Notificação: Você tem um exame de " + 
            exame.getTipo() + " agendado para " + exame.getDataRealizacao());
    }
}
