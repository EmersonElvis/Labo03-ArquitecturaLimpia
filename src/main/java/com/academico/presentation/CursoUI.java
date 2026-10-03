package com.academico.presentation;

import com.academico.application.CursoService;
import com.academico.domain.model.Curso;

import java.util.List;
import java.util.Scanner;

public class CursoUI {
    private final CursoService service;
    private final Scanner scanner;

    public CursoUI(CursoService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== GESTIÓN DE CURSOS ===");
            System.out.println("1. Registrar Curso");
            System.out.println("2. Listar Cursos");
            System.out.println("3. Buscar Curso por ID");
            System.out.println("4. Actualizar Curso");
            System.out.println("5. Eliminar Curso");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> actualizar();
                case 5 -> eliminar();
                case 6 -> System.out.println("Regresando...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        System.out.print("Ingrese ID del curso: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Nombre del curso: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Créditos: ");
        int creditos = scanner.nextInt();

        service.registrarCurso(id, nombre, creditos);
        System.out.println("Curso registrado correctamente.");
    }

    private void listar() {
        List<Curso> lista = service.listarCursos();
        if (lista.isEmpty()) {
            System.out.println("No hay cursos registrados.");
        } else {
            System.out.println("\n--- LISTA DE CURSOS ---");
            lista.forEach(System.out::println);
        }
    }

    private void buscar() {
        System.out.print("Ingrese ID a buscar: ");
        int id = scanner.nextInt();
        Curso c = service.buscarPorId(id);
        if (c != null) {
            System.out.println("Encontrado: " + c);
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    private void actualizar() {
        System.out.print("Ingrese ID del curso a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Nuevos Créditos: ");
        int creditos = scanner.nextInt();

        service.actualizarCurso(id, nombre, creditos);
        System.out.println("Curso actualizado correctamente.");
    }

    private void eliminar() {
        System.out.print("Ingrese ID del curso a eliminar: ");
        int id = scanner.nextInt();
        service.eliminarCurso(id);
        System.out.println("Curso eliminado correctamente.");
    }
}