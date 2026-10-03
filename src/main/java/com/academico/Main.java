package com.academico;

import com.academico.application.CursoService;
import com.academico.application.EstudianteService;
import com.academico.domain.repository.CursoRepository;
import com.academico.domain.repository.EstudianteRepository;
import com.academico.infrastructure.persistence.CursoRepositoryJson;
import com.academico.infrastructure.persistence.CursoRepositoryMySQL;
import com.academico.infrastructure.persistence.EstudianteRepositoryJson;
import com.academico.infrastructure.persistence.EstudianteRepositoryMySQL;
import com.academico.presentation.CursoUI;
import com.academico.presentation.EstudianteUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // =========================================================================
        // INYECCIÓN DE DEPENDENCIAS - MÓDULO ESTUDIANTES
        // =========================================================================
        // Opción 1: Guardar en archivo JSON (Desactivado/Comentado)
        // EstudianteRepository estudianteRepo = new EstudianteRepositoryJson();

        // Opción 2: Guardar en Base de Datos MySQL (ACTIVADO)
        EstudianteRepository estudianteRepo = new EstudianteRepositoryMySQL();

        EstudianteService estudianteService = new EstudianteService(estudianteRepo);
        EstudianteUI estudianteUI = new EstudianteUI(estudianteService);

        // =========================================================================
        // INYECCIÓN DE DEPENDENCIAS - MÓDULO CURSOS
        // =========================================================================
        // Opción 1: Guardar en archivo JSON (Desactivado/Comentado)
        // CursoRepository cursoRepo = new CursoRepositoryJson();

        // Opción 2: Guardar en Base de Datos MySQL (ACTIVADO)
        CursoRepository cursoRepo = new CursoRepositoryMySQL();

        CursoService cursoService = new CursoService(cursoRepo);
        CursoUI cursoUI = new CursoUI(cursoService);

        // =========================================================================
        // MENÚ PRINCIPAL DE LA APLICACIÓN
        // =========================================================================
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n==================================");
            System.out.println("   SISTEMA DE GESTIÓN ACADÉMICA   ");
            System.out.println("==================================");
            System.out.println("1. Gestionar Estudiantes");
            System.out.println("2. Gestionar Cursos");
            System.out.println("3. Salir del Sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> estudianteUI.iniciar();
                case 2 -> cursoUI.iniciar();
                case 3 -> System.out.println("¡Aplicación finalizada!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }
}