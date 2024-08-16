package sistemahospitalario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SistemaHospitalario {
    private List<Paciente> pacientes;
    private List<Doctor> doctores;
    private List<Enfermera> enfermeras;
    private List<Cita> citas;
    private List<Expediente> expedientes;

    public SistemaHospitalario() {
        pacientes = new ArrayList<>();
        doctores = new ArrayList<>();
        enfermeras = new ArrayList<>();
        citas = new ArrayList<>();
        expedientes = new ArrayList<>();
    }

    public void agregarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        expedientes.add(new Expediente(paciente));
    }

    public void agregarDoctor(Doctor doctor) {
        doctores.add(doctor);
    }

    public void agregarEnfermera(Enfermera enfermera) {
        enfermeras.add(enfermera);
    }

    public void agendarCita(Cita cita) {
        citas.add(cita);
        Expediente expediente = expedientes.stream()
                .filter(e -> e.getPaciente().equals(cita.getPaciente()))
                .findFirst()
                .orElse(null);

        if (expediente != null) {
            expediente.agregarCita(cita);
        }
    }

    public void listarCitas() {
        for (Cita cita : citas) {
            System.out.println(cita);
        }
    }

    public void listarCitasPorPaciente(String idPaciente) {
        for (Cita cita : citas) {
            if (cita.getPaciente().getIdPaciente().equals(idPaciente)) {
                System.out.println(cita);
            }
        }
    }

    public void listarCitasPorNombrePaciente(String nombrePaciente) {
        for (Cita cita : citas) {
            if (cita.getPaciente().getNombre().equals(nombrePaciente)) {
                System.out.println(cita);
            }
        }
    }

    public void listarExpedientes() {
        // Ordenar antes de listar
        ordenarExpedientesPorNombre();
        for (Expediente expediente : expedientes) {
            System.out.println(expediente);
        }
    }

    public void listarExpedientesPorPaciente(String idPaciente) {
        Expediente expediente = expedientes.stream()
                .filter(e -> e.getPaciente().getIdPaciente().equals(idPaciente))
                .findFirst()
                .orElse(null);

        if (expediente != null) {
            System.out.println(expediente);
        } else {
            System.out.println("Expediente no encontrado.");
        }
    }

    private void ordenarExpedientesPorNombre() {
        // Implementación del método de ordenamiento por inserción
        for (int i = 1; i < expedientes.size(); i++) {
            Expediente key = expedientes.get(i);
            int j = i - 1;

            // Ordenar por el nombre del paciente
            while (j >= 0 && expedientes.get(j).getPaciente().getNombre().compareTo(key.getPaciente().getNombre()) > 0) {
                expedientes.set(j + 1, expedientes.get(j));
                j = j - 1;
            }
            expedientes.set(j + 1, key);
        }
    }

    public static void main(String[] args) {
        SistemaHospitalario sistema = new SistemaHospitalario();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Registrar nuevo paciente");
            System.out.println("2. Registrar cita nueva");
            System.out.println("3. Consultar expedientes");
            System.out.println("4. Registrar doctor o enfermera");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");
            int opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    // Registrar nuevo paciente
                    System.out.println("Ingrese el nombre del paciente:");
                    String nombrePaciente = scanner.nextLine();
                    System.out.println("Ingrese el apellido paterno del paciente:");
                    String apellidoPaterno = scanner.nextLine();
                    System.out.println("Ingrese el apellido materno del paciente:");
                    String apellidoMaterno = scanner.nextLine();
                    System.out.println("Ingrese la edad del paciente:");
                    int edadPaciente = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingrese el ID del paciente:");
                    String idPaciente = scanner.nextLine();
                    System.out.println("Ingrese el CURP del paciente:");
                    String curpPaciente = scanner.nextLine();

                    Paciente paciente = new Paciente(nombrePaciente, apellidoPaterno, apellidoMaterno, edadPaciente, idPaciente, curpPaciente);
                    sistema.agregarPaciente(paciente);
                    break;

                case 2:
                    // Registrar cita nueva
                    System.out.println("Ingrese el ID del paciente para agendar la cita:");
                    String idPacienteParaCita = scanner.nextLine(); // Variable separada para evitar confusión
                    Paciente pacienteEncontrado = sistema.pacientes.stream()
                        .filter(p -> p.getIdPaciente().equals(idPacienteParaCita))
                        .findFirst().orElse(null);

                    if (pacienteEncontrado == null) {
                        System.out.println("Paciente no encontrado.");
                        break;
                    }

                    System.out.println("Ingrese el nombre del doctor para la cita:");
                    String nombreDoctor = scanner.nextLine();
                    Doctor doctor = sistema.doctores.stream()
                        .filter(d -> d.getNombre().equals(nombreDoctor))
                        .findFirst().orElse(null);

                    if (doctor == null) {
                        System.out.println("Doctor no encontrado.");
                        break;
                    }

                    System.out.println("Ingrese la fecha de la cita (AAAA-MM-DD):");
                    String fecha = scanner.nextLine();

                    Cita cita = new Cita(pacienteEncontrado, doctor, fecha);
                    sistema.agendarCita(cita);

                    System.out.println("Ingrese la enfermedad del paciente:");
                    String enfermedad = scanner.nextLine();
                    cita.setEnfermedad(enfermedad);

                    System.out.println("Ingrese el medicamento necesario:");
                    String medicamento = scanner.nextLine();
                    cita.setMedicamento(medicamento);

                    System.out.println("Cita registrada exitosamente.");
                    break;

                case 3:
                    // Consultar expedientes
                    System.out.println("Consultar expedientes por:");
                    System.out.println("1. Todos los expedientes");
                    System.out.println("2. Expediente de un paciente específico");
                    int opcionConsulta = Integer.parseInt(scanner.nextLine());

                    if (opcionConsulta == 1) {
                        sistema.listarExpedientes();
                    } else if (opcionConsulta == 2) {
                        System.out.println("Ingrese el ID del paciente:");
                        String idPacienteConsulta = scanner.nextLine();
                        sistema.listarExpedientesPorPaciente(idPacienteConsulta);
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 4:
                    // Registrar doctor o enfermera
                    System.out.println("Registrar:");
                    System.out.println("1. Doctor");
                    System.out.println("2. Enfermera");
                    int tipoRegistro = Integer.parseInt(scanner.nextLine());

                    if (tipoRegistro == 1) {
                        // Registrar doctor
                        System.out.println("Ingrese el nombre del doctor:");
                        String nombreDoctorRegistro = scanner.nextLine();
                        System.out.println("Ingrese la edad del doctor:");
                        int edadDoctor = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese la especialidad del doctor:");
                        String especialidad = scanner.nextLine();
                        System.out.println("Ingrese el ID del doctor:");
                        String idDoctor = scanner.nextLine();

                        Doctor doctorRegistro = new Doctor(nombreDoctorRegistro, edadDoctor, especialidad, idDoctor);
                        sistema.agregarDoctor(doctorRegistro);
                    } else if (tipoRegistro == 2) {
                        // Registrar enfermera
                        System.out.println("Ingrese el nombre de la enfermera:");
                        String nombreEnfermera = scanner.nextLine();
                        System.out.println("Ingrese la edad de la enfermera:");
                        int edadEnfermera = Integer.parseInt(scanner.nextLine());
                        System.out.println("Ingrese el departamento donde labora la enfermera:");
                        String departamento = scanner.nextLine();
                        System.out.println("Ingrese el ID de la enfermera:");
                        String idEnfermera = scanner.nextLine();

                        Enfermera enfermeraRegistro = new Enfermera(nombreEnfermera, edadEnfermera, departamento, idEnfermera);
                        sistema.agregarEnfermera(enfermeraRegistro);
                    } else {
                        System.out.println("Opción inválida.");
                    }
                    break;

                case 5:
                    // Salir
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
}
