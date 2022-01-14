package modelo;

import java.util.List;

public class Categoria {

    private int num_categoria;
    private List<Pregunta> preguntas;

    public Categoria() {
    }

    public Categoria(int num_categoria, List<Pregunta> preguntas) {
        this.num_categoria = num_categoria;
        this.preguntas = preguntas;
    }



    public int getNum_categoria() {
        return num_categoria;
    }

    public void setNum_categoria(int num_categoria) {
        this.num_categoria = num_categoria;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }


    @Override
    public String toString() {
        return "Categoria{" +
                "num_categoria=" + num_categoria +
                ", preguntas=" + preguntas +
                '}';
    }
}
