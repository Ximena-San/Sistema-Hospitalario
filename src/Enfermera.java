package sistemahospitalario;

public class Enfermera {
    private String nombre;
    private int edad;
    private String departamento;
    private String idEnfermera;

    public Enfermera(String nombre, int edad, String departamento, String idEnfermera) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
        this.idEnfermera = idEnfermera;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getIdEnfermera() {
        return idEnfermera;
    }

    @Override
    public String toString() {
        return "Enfermera{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", departamento='" + departamento + '\'' +
                ", idEnfermera='" + idEnfermera + '\'' +
                '}';
    }
}
