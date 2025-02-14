package br.com.clinica.repositorios;

import br.com.clinica.entidades.Paciente;
import java.util.*;

public class PacienteRepository implements Repository<Paciente, String> {
    private final Map<String, Paciente> pacientes = new HashMap<>();

    @Override
    public Paciente save(Paciente paciente) {
        if (exists(paciente.getCpf()) && !pacientes.get(paciente.getCpf()).equals(paciente)) {
            throw new IllegalArgumentException("Já existe um paciente cadastrado com este CPF");
        }
        pacientes.put(paciente.getCpf(), paciente);
        return paciente;
    }

    @Override
    public Optional<Paciente> findById(String cpf) {
        return Optional.ofNullable(pacientes.get(cpf));
    }

    @Override
    public List<Paciente> findAll() {
        return new ArrayList<>(pacientes.values());
    }

    @Override
    public void delete(Paciente paciente) {
        pacientes.remove(paciente.getCpf());
    }

    @Override
    public boolean exists(String cpf) {
        return pacientes.containsKey(cpf);
    }
}
