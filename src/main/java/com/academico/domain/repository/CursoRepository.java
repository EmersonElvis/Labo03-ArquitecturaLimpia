package com.academico.domain.repository;

import com.academico.domain.model.Curso;
import java.util.List;

public interface CursoRepository {
    void guardar(Curso curso);
    List<Curso> obtenerTodos();
    Curso obtenerPorId(int id);
    void actualizar(Curso curso);
    void eliminar(int id);
}
