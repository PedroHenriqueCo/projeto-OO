package servicos;

import br.com.clinica.entidades.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PagamentoService {
    private Map<Paciente, List<Pagamento>> pagamentosPorPaciente;
    
    public PagamentoService() {
        this.pagamentosPorPaciente = new HashMap<>();
    }
    
    public void registrarPagamentoConsulta(Consulta consulta, double valorPago) {
        if (valorPago < consulta.getValor()) {
            throw new IllegalArgumentException("Valor pago é menor que o valor da consulta");
        }
        
        Pagamento pagamento = new Pagamento(consulta.getValor(), valorPago, LocalDateTime.now(), TipoPagamento.CONSULTA);
        registrarPagamento(consulta.getPaciente(), pagamento);
    }
    
    public void registrarPagamentoExame(Exame exame, Paciente paciente, double valorPago) {
        if (valorPago < exame.getCusto()) {
            throw new IllegalArgumentException("Valor pago é menor que o valor do exame");
        }
        
        Pagamento pagamento = new Pagamento(exame.getCusto(), valorPago, LocalDateTime.now(), TipoPagamento.EXAME);
        registrarPagamento(paciente, pagamento);
    }
    
    private void registrarPagamento(Paciente paciente, Pagamento pagamento) {
        pagamentosPorPaciente.computeIfAbsent(paciente, k -> new ArrayList<>()).add(pagamento);
    }
    
    public boolean temPagamentosPendentes(Paciente paciente) {
        List<Pagamento> pagamentos = pagamentosPorPaciente.get(paciente);
        if (pagamentos == null || pagamentos.isEmpty()) {
            return false;
        }
        
        return pagamentos.stream()
            .anyMatch(pagamento -> !pagamento.isQuitado());
    }
    
    private static class Pagamento {
        private final double valorCobrado;
        private final double valorPago;
        private final LocalDateTime dataPagamento;
        private final TipoPagamento tipo;
        
        public Pagamento(double valorCobrado, double valorPago, LocalDateTime dataPagamento, TipoPagamento tipo) {
            this.valorCobrado = valorCobrado;
            this.valorPago = valorPago;
            this.dataPagamento = dataPagamento;
            this.tipo = tipo;
        }
        
        public boolean isQuitado() {
            return valorPago >= valorCobrado;
        }
    }
    
    private enum TipoPagamento {
        CONSULTA,
        EXAME
    }
}
