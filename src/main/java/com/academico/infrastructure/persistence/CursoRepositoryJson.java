package com.academico.infrastructure.persistence;

import com.academico.domain.model.Curso;
import com.academico.domain.repository.CursoRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositoryJson implements CursoRepository {
    private static final String FILE_PATH = "cursos.json";
    private final Gson gson;

    public CursoRepositoryJson() {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
    }

    private List<Curso> cargarDesdeArchivo() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(file)) {
            Type listType = new TypeToken<ArrayList<Curso>>() {}.getType();
            List<Curso> lista = gson.fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void guardarEnArchivo(List<Curso> cursos) {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            gson.toJson(cursos, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void guardar(Curso curso) {
        List<Curso> cursos = cargarDesdeArchivo();
        cursos.add(curso);
        guardarEnArchivo(cursos);
    }

    @Override
    public List<Curso> obtenerTodos() {
        return cargarDesdeArchivo();
    }

    @Override
    public Curso obtenerPorId(int id) {
        return cargarDesdeArchivo().stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void actualizar(Curso curso) {
        List<Curso> cursos = cargarDesdeArchivo();
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getId() == curso.getId()) {
                cursos.set(i, curso);
                break;
            }
        }
        guardarEnArchivo(cursos);
    }

    @Override
    public void eliminar(int id) {
        List<Curso> cursos = cargarDesdeArchivo();
        cursos.removeIf(c -> c.getId() == id);
        guardarEnArchivo(cursos);
    }
}