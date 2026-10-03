package com.academico.application;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;
import java.util.List;

public class CursoService {
    private final CursoRepository repository;

    public CursoService(CursoRepository repository) {
        this.repository = repository;
    }

    public void registrarCurso(int id, String nombre, int creditos) {
        Curso curso = new Curso(id, nombre, creditos);
        repository.guardar(curso);
    }

    public List<Curso> listarCursos() {
        return repository.obtenerTodos();
    }

    public Curso buscarPorId(int id) {
        return repository.obtenerPorId(id);
    }

    public void actualizarCurso(int id, String nombre, int creditos) {
        Curso curso = new Curso(id, nombre, creditos);
        repository.actualizar(curso);
    }

    public void eliminarCurso(int id) {
        repository.eliminar(id);
    }
}
