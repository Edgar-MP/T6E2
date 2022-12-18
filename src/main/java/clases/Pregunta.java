package clases;

public class Pregunta {
    private String enunciado, pista;
    private String[] respuestas;
    private int numPreguntaCorrecta;

    public Pregunta(String enunciado, String pista, String[] respuestas, int numPreguntaCorrecta) {
        this.enunciado = enunciado;
        this.pista = pista;
        this.respuestas = respuestas;
        this.numPreguntaCorrecta = numPreguntaCorrecta;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public String getPista() {
        return pista;
    }

    public String[] getRespuestas() {
        return respuestas;
    }
    
    public int getNumPreguntaCorrecta() {
        return numPreguntaCorrecta;
    }
    
}
