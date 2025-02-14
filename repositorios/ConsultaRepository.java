package repositorios;

import entidades.Consulta;
import entidades.Medico;
import entidades.Paciente;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ConsultaRepository implements Repository<Consulta, Long> {
    private final Map<Long, Consulta> consultas = new HashMap<>();
    private long nextId = 1;

    @Override
    public Consulta save(Consulta consulta) {
        if (consulta.getId() == null) {
            consulta.setId(nextId++);
        }
        consultas.put(consulta.getId(), consulta);
        return consulta;
    }

    @Override
    public Optional<Consulta> findById(Long id) {
        return Optional.ofNullable(consultas.get(id));
    }

    @Override
    public List<Consulta> findAll() {
        return new ArrayList<>(consultas.values());
    }

    @Override
    public void delete(Consulta consulta) {
        consultas.remove(consulta.getId());
    }

    @Override
    public boolean exists(Long id) {
        return consultas.containsKey(id);
    }

    public List<Consulta> findByMedicoAndData(Medico medico, LocalDate data) {
        return consultas.values().stream()
            .filter(consulta -> consulta.getMedico().equals(medico) &&
                    consulta.getDataConsulta().equals(data))
            .collect(Collectors.toList());
    }

    public List<Consulta> findByPacienteAndData(Paciente paciente, LocalDate data) {
        return consultas.values().stream()
            .filter(consulta -> consulta.getPaciente().equals(paciente) &&
                    consulta.getDataConsulta().equals(data))
            .collect(Collectors.toList());
    }
}
