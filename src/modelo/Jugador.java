package modelo;

public class Jugador {

    private String nombre;
    private String estado;
    private int acumulado;

    public Jugador(String nombre, String estado, int acumulado) {
        this.nombre = nombre;
        this.estado = estado;
        this.acumulado = acumulado;
    }

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getAcumulado() {
        return acumulado;
    }

    public void setAcumulado(int acumulado) {
        this.acumulado = acumulado;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", acumulado=" + acumulado +
                '}';
    }
}
