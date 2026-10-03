package com.academico.application;

import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;
import java.util.List;

public class EstudianteService {
    private final EstudianteRepository repository;

    // Inyección de dependencia a través de la interfaz
    public EstudianteService(EstudianteRepository repository) {
        this.repository = repository;
    }

    public void registrarEstudiante(int id, String nombre, String correo) {
        Estudiante estudiante = new Estudiante(id, nombre, correo);
        repository.guardar(estudiante);
    }

    public List<Estudiante> listarEstudiantes() {
        return repository.obtenerTodos();
    }

    public Estudiante buscarPorId(int id) {
        return repository.obtenerPorId(id);
    }

    public void actualizarEstudiante(int id, String nombre, String correo) {
        Estudiante estudiante = new Estudiante(id, nombre, correo);
        repository.actualizar(estudiante);
    }

    public void eliminarEstudiante(int id) {
        repository.eliminar(id);
    }
}