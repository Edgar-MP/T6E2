package clases;

import java.util.ArrayList;

public class Test {

  private int numPreguntas;
  private ArrayList<Pregunta> preguntas;
  private static Pregunta[] arrPreguntas = {
    new Pregunta(
      "¿En qué año se estren� la primera pel�cula de Star Wars?",
      "Se estren� en la d�cada de los 70",
      new String[] { "1980", "1982", "1975", "1977" },
      3
    ),
    new Pregunta(
      "¿En qué año se estren� The Last of Us para ps3?",
      "La fecha de estreno transcurre entre los mundiales de Sud�frica y Brasil",
      new String[] { "2008", "2013", "2012", "2015" },
      1
    ),
    new Pregunta(
      "¿Quiénes son los protagonistas de The Last of Us?",
      "Uno de los dos es Joel",
      new String[] {
        "Joel y Ellie",
        "Joel y Tommiy",
        "Ellie y Dina",
        "Ellie y Abby",
      },
      0
    ),
    new Pregunta(
      "¿Cuál es el apellido de Ellie en The Last of Us?",
      "Comparte apellido con el compositor principal de Star Wars",
      new String[] { "Miller", "Williams", "Zimmer", "Sherlock" },
      1
    ),
  };

  public Test(int numPreguntas) {
    if (numPreguntas > arrPreguntas.length) {
      numPreguntas = arrPreguntas.length;
      for (int j = 0; j < arrPreguntas.length; j++) {
        preguntas.add(arrPreguntas[j]);
      }
    } else {
      this.numPreguntas = numPreguntas;
      ArrayList<Integer> numeros = new ArrayList<>();
      preguntas = new ArrayList<Pregunta>();
      for (int j = 0; j < numPreguntas; j++) {
        int num = (int) (Math.random() * numPreguntas);
        if (!numeros.contains(num)) {
          numeros.add(num);
          preguntas.add(arrPreguntas[num]);
        } else {
          j--;
        }
      }
    }
  }

  public int comprobar(ArrayList<Integer> respuestas) {
    int cont = 0, cant = 0;
    for (Pregunta pregunta : preguntas) {
      if (pregunta.getNumPreguntaCorrecta() == respuestas.get(cont)) {
        cant++;
      }
      cont++;
    }
    return cant;
  }

  public ArrayList<Pregunta> getPreguntas() {
    return preguntas;
  }

  public static Pregunta[] getarrPreguntas() {
    return arrPreguntas;
  }
}
