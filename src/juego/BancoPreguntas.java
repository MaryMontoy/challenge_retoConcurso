package juego;

import modelo.Categoria;
import modelo.Jugador;
import modelo.Opcion;
import modelo.Pregunta;

import java.util.*;

public class BancoPreguntas {

    private final static int numeroCategorias = 5;
    private final static int numeroPreguntas = 5;
    private final static int numeroRespuestas = 4;
    private final static int rondas = 5;

    public static void main(String[] args) {
        //Registrar preguntas
        List<Categoria> listadoGeneral = ingresarCategoria();
        //Jugar
        iniciarJuego(listadoGeneral);
    }

    private static void iniciarJuego(List<Categoria> listado) {
        Scanner sn = new Scanner(System.in);
        int continua = 0;
        int acertoRespuesta = 0;
        Jugador jugador = new Jugador();
        System.out.println("Ingresa tu nombre");
        String nombreJugador = sn.next();
        jugador.setNombre(nombreJugador);

        for (int i = 0; i < rondas; i++) {//recorre ronda
            List<Pregunta> lstPreguntas = listado.get(i).getPreguntas();
            int index = (int) (Math.random() * lstPreguntas.size());
            List<Opcion> lstRespuestas = lstPreguntas.get(index).getOpciones();
            acertoRespuesta = presentarPreguntas(i + 1, lstPreguntas.get(index).getDescripcionPregunta(), lstRespuestas);
            if (acertoRespuesta == 1) {
                jugador.setAcumulado(jugador.getAcumulado() + 100);
            } else {
                jugador.setEstado(i + 1 + " Numero de ronda en la cual perdio");
                break;
            }
            continua = continuarJugando(i);
            if (continua == 0) {
                jugador.setEstado(i + 1 + " Numero de ronda en la cual se retiro");
                break;
            } else if (continua == 2) {
                jugador.setEstado("Ganador");
                System.out.println("finalizo la ronda con exito");
                break;
            }
        }
        System.out.println("Resultado del juego: " + jugador);
    }

    private static int continuarJugando(int rondaActual) {
        Scanner sn = new Scanner(System.in);
        int continua = 0;
        if (rondaActual < rondas - 1) {
            System.out.println("Deseas seguir jugando? si=1 no=0");
            continua = sn.nextInt();
        } else {
            continua = 2;
        }
        return continua;
    }

    private static int presentarPreguntas(int numeroRonda, String pregunta, List<Opcion> lstRespuestas) {
        Scanner sn = new Scanner(System.in);
        Map<String, Integer> mapRespuestas = new HashMap<>();
        System.out.println("Ronda: " + numeroRonda);
        System.out.println("¿ " + pregunta + " ?");
        mapRespuestas.put("a", lstRespuestas.get(0).getEsValida());
        mapRespuestas.put("b", lstRespuestas.get(1).getEsValida());
        mapRespuestas.put("c", lstRespuestas.get(2).getEsValida());
        mapRespuestas.put("d", lstRespuestas.get(3).getEsValida());
        System.out.println("a-> " + lstRespuestas.get(0).getDescripcionRta());
        System.out.println("b-> " + lstRespuestas.get(1).getDescripcionRta());
        System.out.println("c-> " + lstRespuestas.get(2).getDescripcionRta());
        System.out.println("d-> " + lstRespuestas.get(3).getDescripcionRta());
        String respuestaUsuario = sn.next();
        return mapRespuestas.get(respuestaUsuario.toLowerCase(Locale.ROOT));
    }


    public static List<Categoria> ingresarCategoria() {
        Scanner sn = new Scanner(System.in);
        List<Categoria> lstCategorias = new ArrayList<>();
        for (int i = 1; i <= numeroCategorias; i++) {
            Categoria categoria = new Categoria();
            System.out.println("Digita número categoria, inicia con la 1 hasta " + numeroCategorias);
            int numeroCategoria = sn.nextInt();
            categoria.setNum_categoria(numeroCategoria);
            categoria.setPreguntas(ingresarPregunta());
            lstCategorias.add(categoria);
        }
        System.out.println("finaliza proceso de registro de preguntas");
        return lstCategorias;
    }

    public static List<Pregunta> ingresarPregunta() {
        Scanner sn = new Scanner(System.in);
        List<Pregunta> lstPreguntas = new ArrayList<>();
        for (int i = 1; i <= numeroPreguntas; i++) {
            Pregunta pregunta = new Pregunta();
            System.out.println("Ingresa la pregunta");
            String strPregunta = sn.next();
            pregunta.setDescripcionPregunta(strPregunta);
            pregunta.setOpciones(ingresarRespuesta());
            lstPreguntas.add(pregunta);
        }
        return lstPreguntas;
    }

    public static List<Opcion> ingresarRespuesta() {
        Scanner sn = new Scanner(System.in);
        List<Opcion> lstRespuestas = new ArrayList<>();
        for (int i = 1; i <= numeroRespuestas; i++) {
            Opcion respuesta = new Opcion();
            System.out.println("Ingresa la respuesta");
            String strRespuesta = sn.next();
            System.out.println("Por favor ingresa 1 cuando la respuesta es la correcta y 0 si la respuesta es incorrecta");
            int numeroRespuesta = sn.nextInt();
            respuesta.setDescripcionRta(strRespuesta);
            respuesta.setEsValida(numeroRespuesta);
            lstRespuestas.add(respuesta);
        }
        return lstRespuestas;
    }
}
