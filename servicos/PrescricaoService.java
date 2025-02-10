package br.com.clinica.servicos;

import br.com.clinica.entidades.*;
import java.time.LocalDate;
import java.util.List;

public class PrescricaoService {
    
    public Prescricao criarPrescricao(Consulta consulta, LocalDate dataValidade) {
        if (consulta.getStatus() != StatusConsulta.REALIZADA) {
            throw new IllegalStateException("Só é possível criar prescrição para consultas realizadas");
        }
        
        return new Prescricao(consulta, dataValidade);
    }
    
    public void adicionarExame(Prescricao prescricao, TipoExame tipo, double custo) {
        Exame exame = new Exame(tipo, LocalDate.now(), custo);
        prescricao.adicionarExame(exame);
        prescricao.getConsultaAssociada().adicionarExame(exame);
    }
    
    public void adicionarMedicamento(Prescricao prescricao, String nome, String posologia, String duracao) {
        Medicamento medicamento = new Medicamento(nome, posologia, duracao);
        prescricao.adicionarMedicamento(medicamento);
        prescricao.getConsultaAssociada().adicionarMedicamento(medicamento);
    }
    
    public void registrarResultadoExame(Exame exame, String resultado, LocalDate dataRealizacao) {
        exame.setResultado(resultado);
        exame.setDataRealizacao(dataRealizacao);
    }
}
