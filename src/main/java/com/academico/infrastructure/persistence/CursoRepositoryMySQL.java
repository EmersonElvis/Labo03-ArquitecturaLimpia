package com.academico.infrastructure.persistence;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;

import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryMySQL implements CursoRepository {

    @Override
    public void guardar(Curso curso) {
        System.out.println("[MySQL] Guardando curso en la base de datos...");
    }

    @Override
    public List<Curso> obtenerTodos() {
        System.out.println("[MySQL] Obteniendo cursos desde MySQL...");
        return new ArrayList<>();
    }

    @Override
    public Curso obtenerPorId(int id) {
        System.out.println("[MySQL] Buscando curso con ID " + id + " en MySQL...");
        return null;
    }

    @Override
    public void actualizar(Curso curso) {
        System.out.println("[MySQL] Actualizando curso en MySQL...");
    }

    @Override
    public void eliminar(int id) {
        System.out.println("[MySQL] Eliminando curso en MySQL...");
    }
}