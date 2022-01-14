package modelo;

public class Opcion {

    private String descripcionRta;
    private int esValida;

    public Opcion(String descripcionRta, int esValida) {
        this.descripcionRta = descripcionRta;
        this.esValida = esValida;
    }

    public Opcion() {
    }

    public String getDescripcionRta() {
        return descripcionRta;
    }

    public void setDescripcionRta(String descripcionRta) {
        this.descripcionRta = descripcionRta;
    }

    public int getEsValida() {
        return esValida;
    }

    public void setEsValida(int esValida) {
        this.esValida = esValida;
    }

    @Override
    public String toString() {
        return "Opcion{" +
                "descripcionRta='" + descripcionRta + '\'' +
                ", esValida=" + esValida +
                '}';
    }
}
