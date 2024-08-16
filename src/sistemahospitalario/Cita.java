package sistemahospitalario;

public class Cita {
    private Paciente paciente;
    private Doctor doctor;
    private String fecha;
    private String enfermedad;
    private String medicamento;

    public Cita(Paciente paciente, Doctor doctor, String fecha) {
        this.paciente = paciente;
        this.doctor = doctor;
        this.fecha = fecha;
        this.enfermedad = "";
        this.medicamento = "";
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getFecha() {
        return fecha;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "paciente=" + paciente +
                ", doctor=" + doctor +
                ", fecha='" + fecha + '\'' +
                ", enfermedad='" + enfermedad + '\'' +
                ", medicamento='" + medicamento + '\'' +
                '}';
    }
}
