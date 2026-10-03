package com.academico.infrastructure.persistence;

import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryMySQL implements EstudianteRepository {

    // Lista simulada en memoria mientras no haya conexión a MySQL real
    private final List<Estudiante> baseDatosSimulada = new ArrayList<>();

    @Override
    public void guardar(Estudiante estudiante) {
        baseDatosSimulada.add(estudiante);
        System.out.println("[MySQL] Guardando estudiante en la base de datos...");
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        System.out.println("[MySQL] Obteniendo lista desde MySQL...");
        return baseDatosSimulada;
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        return baseDatosSimulada.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        for (int i = 0; i < baseDatosSimulada.size(); i++) {
            if (baseDatosSimulada.get(i).getId() == estudiante.getId()) {
                baseDatosSimulada.set(i, estudiante);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        baseDatosSimulada.removeIf(e -> e.getId() == id);
    }
}