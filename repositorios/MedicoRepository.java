package clinica.repositorios;

import clinica.entidades.Medico;
import java.util.*;
import java.util.stream.Collectors;

public class MedicoRepository implements Repository<Medico, String> {
    private final Map<String, Medico> medicos = new HashMap<>();

    @Override
    public Medico save(Medico medico) {
        if (exists(medico.getCpf()) && !medicos.get(medico.getCpf()).equals(medico)) {
            throw new IllegalArgumentException("Já existe um médico cadastrado com este CPF");
        }
        medicos.put(medico.getCpf(), medico);
        return medico;
    }

    @Override
    public Optional<Medico> findById(String cpf) {
        return Optional.ofNullable(medicos.get(cpf));
    }

    @Override
    public List<Medico> findAll() {
        return new ArrayList<>(medicos.values());
    }

    @Override
    public void delete(Medico medico) {
        medicos.remove(medico.getCpf());
    }

    @Override
    public boolean exists(String cpf) {
        return medicos.containsKey(cpf);
    }

    public List<Medico> findByEspecialidade(String especialidade) {
        return medicos.values().stream()
            .filter(medico -> medico.getEspecialidade().equalsIgnoreCase(especialidade))
            .collect(Collectors.toList());
    }
}
