package clinica.entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Paciente extends Pessoa {
    private List<Consulta> historicoConsultas;
    private List<Exame> historicoExames;

    public Paciente(String nome, String cpf, LocalDate dataNascimento) {
        super(nome, cpf, dataNascimento);
        this.historicoConsultas = new ArrayList<>();
        this.historicoExames = new ArrayList<>();
    }

    public List<Consulta> getHistoricoConsultas() {
        return Collections.unmodifiableList(historicoConsultas);
    }

    public List<Exame> getHistoricoExames() {
        return Collections.unmodifiableList(historicoExames);
    }

    public void adicionarConsulta(Consulta consulta) {
        if (consulta != null) {
            this.historicoConsultas.add(consulta);
        }
    }

    public void adicionarExame(Exame exame) {
        if (exame != null) {
            this.historicoExames.add(exame);
        }
    }
}
