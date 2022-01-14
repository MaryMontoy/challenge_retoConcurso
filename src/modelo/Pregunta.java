package modelo;

import java.util.List;

public class Pregunta {

    private String descripcionPregunta;
    private List<Opcion> opciones;


    public Pregunta() {
    }

    public Pregunta(String descripcionPregunta, List<Opcion> opciones) {
        this.descripcionPregunta = descripcionPregunta;
        this.opciones = opciones;
    }

    public Pregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }



    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "descripcionPregunta='" + descripcionPregunta + '\'' +
                ", opciones=" + opciones +
                '}';
    }
}
