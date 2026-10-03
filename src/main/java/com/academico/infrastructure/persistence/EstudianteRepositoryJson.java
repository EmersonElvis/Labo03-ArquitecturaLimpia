package com.academico.infrastructure.persistence;

import com.academico.domain.model.Estudiante;
import com.academico.domain.repository.EstudianteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EstudianteRepositoryJson implements EstudianteRepository {
    private static final String FILE_PATH = "estudiantes.json";
    private final Gson gson;

    public EstudianteRepositoryJson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private List<Estudiante> cargarDesdeArchivo() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Estudiante>>() {}.getType();
            List<Estudiante> lista = gson.fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarEnArchivo(List<Estudiante> estudiantes) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(estudiantes, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Estudiante estudiante) {
        List<Estudiante> estudiantes = cargarDesdeArchivo();
        estudiantes.add(estudiante);
        guardarEnArchivo(estudiantes);
    }

    @Override
    public List<Estudiante> obtenerTodos() {
        return cargarDesdeArchivo();
    }

    @Override
    public Estudiante obtenerPorId(int id) {
        return cargarDesdeArchivo().stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        List<Estudiante> estudiantes = cargarDesdeArchivo();
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getId() == estudiante.getId()) {
                estudiantes.set(i, estudiante);
                break;
            }
        }
        guardarEnArchivo(estudiantes);
    }

    @Override
    public void eliminar(int id) {
        List<Estudiante> estudiantes = cargarDesdeArchivo();
        estudiantes.removeIf(e -> e.getId() == id);
        guardarEnArchivo(estudiantes);
    }
}