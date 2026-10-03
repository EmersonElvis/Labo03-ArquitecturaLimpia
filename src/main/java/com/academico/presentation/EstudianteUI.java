package com.academico.presentation;

import com.academico.application.EstudianteService;
import com.academico.domain.model.Estudiante;

import java.util.List;
import java.util.Scanner;

public class EstudianteUI {
    private final EstudianteService service;
    private final Scanner scanner;

    public EstudianteUI(EstudianteService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE ESTUDIANTES ===");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Listar Estudiantes");
            System.out.println("3. Buscar Estudiante por ID");
            System.out.println("4. Actualizar Estudiante");
            System.out.println("5. Eliminar Estudiante");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> listar();
                case 3 -> buscar();
                case 4 -> actualizar();
                case 5 -> eliminar();
                case 6 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void registrar() {
        System.out.print("Ingrese ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Correo: ");
        String correo = scanner.nextLine();

        service.registrarEstudiante(id, nombre, correo);
        System.out.println("Estudiante registrado correctamente.");
    }

    private void listar() {
        List<Estudiante> lista = service.listarEstudiantes();
        if (lista.isEmpty()) {
            System.out.println("No hay estudiantes registrados.");
        } else {
            System.out.println("\n--- LISTA DE ESTUDIANTES ---");
            lista.forEach(e -> System.out.println(e));
        }
    }

    private void buscar() {
        System.out.print("Ingrese ID a buscar: ");
        int id = scanner.nextInt();
        Estudiante e = service.buscarPorId(id);
        if (e != null) {
            System.out.println("Encontrado: " + e);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    private void actualizar() {
        System.out.print("Ingrese ID del estudiante a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese Nuevo Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese Nuevo Correo: ");
        String correo = scanner.nextLine();

        service.actualizarEstudiante(id, nombre, correo);
        System.out.println("Estudiante actualizado correctamente.");
    }

    private void eliminar() {
        System.out.print("Ingrese ID del estudiante a eliminar: ");
        int id = scanner.nextInt();
        service.eliminarEstudiante(id);
        System.out.println("Estudiante eliminado correctamente.");
    }
}
