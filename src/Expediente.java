package sistemahospitalario;

import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private Paciente paciente;
    private List<Cita> citas;

    public Expediente(Paciente paciente) {
        this.paciente = paciente;
        this.citas = new ArrayList<>();
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public void agregarCita(Cita cita) {
        citas.add(cita);
    }

    public void agregarDetallesCita(Cita cita, String enfermedad, String medicamento) {
        for (Cita c : citas) {
            if (c.equals(cita)) {
                c.setEnfermedad(enfermedad);
                c.setMedicamento(medicamento);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Expediente{" +
                "paciente=" + paciente +
                ", citas=" + citas +
                '}';
    }
}
