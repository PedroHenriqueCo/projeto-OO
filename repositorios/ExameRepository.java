package clinica.repositorios;

import clinica.entidades.Exame;
import java.util.*;

public class ExameRepository implements Repository<Exame, Long> {
    private final Map<Long, Exame> exames = new HashMap<>();
    private long nextId = 1;

    @Override
    public Exame save(Exame exame) {
        if (exame.getId() == null) {
            exame.setId(nextId++);
        }
        exames.put(exame.getId(), exame);
        return exame;
    }

    @Override
    public Optional<Exame> findById(Long id) {
        return Optional.ofNullable(exames.get(id));
    }

    @Override
    public List<Exame> findAll() {
        return new ArrayList<>(exames.values());
    }

    @Override
    public void delete(Exame exame) {
        exames.remove(exame.getId());
    }

    @Override
    public boolean exists(Long id) {
        return exames.containsKey(id);
    }
}
