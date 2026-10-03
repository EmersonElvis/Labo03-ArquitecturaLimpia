package com.academico.infrastructure.persistence;

import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;

import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryMySQL implements EstudianteRepository {

    @Override
    public void guardar(Estudiante estudiante) {
        System.out.println("[MySQL] Guardando estudiante en la base de datos...");
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        System.out.println("[MySQL] Obteniendo lista desde MySQL...");
        return new ArrayList<>();
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        System.out.println("[MySQL] Buscando ID " + id + " en MySQL...");
        return null;
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        System.out.println("[MySQL] Actualizando estudiante...");
    }

    @Override
    public void eliminar(int id) {
        System.out.println("[MySQL] Eliminando estudiante...");
    }
}