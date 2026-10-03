package com.academico.domain.repository;

import com.academico.domain.model.Estudiante;
import java.util.List;

public interface EstudianteRepository {
    void guardar(Estudiante estudiante);
    List<Estudiante> obtenerTodos();
    Estudiante obtenerPorId(int id);
    void actualizar(Estudiante estudiante);
    void eliminar(int id);
}
