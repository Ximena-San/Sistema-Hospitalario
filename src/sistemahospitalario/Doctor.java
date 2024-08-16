package sistemahospitalario;

public class Doctor {
    private String nombre;
    private int edad;
    private String especialidad;
    private String idDoctor;

    public Doctor(String nombre, int edad, String especialidad, String idDoctor) {
        this.nombre = nombre;
        this.edad = edad;
        this.especialidad = especialidad;
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", especialidad='" + especialidad + '\'' +
                ", idDoctor='" + idDoctor + '\'' +
                '}';
    }
}
