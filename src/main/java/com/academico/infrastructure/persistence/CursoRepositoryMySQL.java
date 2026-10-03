package com.academico.infrastructure.persistence;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;

import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryMySQL implements CursoRepository {

    // Lista simulada en memoria mientras no haya conexión a MySQL real
    private final List<Curso> baseDatosSimulada = new ArrayList<>();

    @Override
    public void guardar(Curso curso) {
        baseDatosSimulada.add(curso);
        System.out.println("[MySQL] Guardando curso en la base de datos...");
    }

    @Override
    public List<Curso> obtenerTodos() {
        System.out.println("[MySQL] Obteniendo cursos desde MySQL...");
        return baseDatosSimulada;
    }

    @Override
    public Curso obtenerPorId(int id) {
        return baseDatosSimulada.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Curso curso) {
        for (int i = 0; i < baseDatosSimulada.size(); i++) {
            if (baseDatosSimulada.get(i).getId() == curso.getId()) {
                baseDatosSimulada.set(i, curso);
                break;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        baseDatosSimulada.removeIf(c -> c.getId() == id);
    }
}