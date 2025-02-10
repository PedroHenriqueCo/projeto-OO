package br.com.clinica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private List<Consulta> historicoConsultas;

    public Medico(String nome, String cpf, LocalDate dataNascimento, String crm, String especialidade) {
        super(nome, cpf, dataNascimento);
        this.crm = crm;
        this.especialidade = especialidade;
        this.historicoConsultas = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<Consulta> getHistoricoConsultas() {
        return Collections.unmodifiableList(historicoConsultas);
    }

    public void adicionarConsulta(Consulta consulta) {
        if (consulta != null) {
            this.historicoConsultas.add(consulta);
        }
    }
}
