package sistemahospitalario;

public class Paciente extends Persona implements Identificable {
    private String idPaciente;
    private String curp;

    public Paciente(String nombre, String apellidop, String apellidom, int edad, String idPaciente, String curp) {
        super(nombre, apellidop, apellidom, edad);
        this.idPaciente = idPaciente;
        this.curp = curp;
    }

    @Override
    public String getIdentificacion() {
        return idPaciente;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getCurp() {
        return curp;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + getNombre() + '\'' +
                ", apellidop='" + getApellidoPaterno() + '\'' +
                ", apellidom='" + getApellidoMaterno() + '\'' +
                ", edad=" + getEdad() +
                ", idPaciente='" + idPaciente + '\'' +
                ", curp='" + curp + '\'' +
                '}';
    }
}
