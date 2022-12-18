package servlets;

import clases.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Resultado extends HttpServlet {

  protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession session = request.getSession(true);

    if (request.getParameter("respuesta") == null) {
      response.sendRedirect(request.getContextPath() + "/servlets/ProcesoPregunta");
      session.setAttribute("error", "Seleccione una respueta");
    } else {
      int numeroPregunta = (int) (session.getAttribute("numeroPregunta")) + 1;
      ArrayList<Integer> respuestas = (ArrayList<Integer>) session.getAttribute("respuestas");
      Test test = (Test) session.getAttribute("test");
      respuestas.add(Integer.parseInt(request.getParameter("respuesta")));
      long t = System.currentTimeMillis() - (long) session.getAttribute("t");
      long sec = TimeUnit.MILLISECONDS.toSeconds(t);
      long min = 0;
      if (sec > 60) {
        min = sec / 60;
        sec = sec - (min * 60);
      }

      int aciertos = test.comprobar(respuestas);
      String usuario = (String) session.getAttribute("nombre");
      int numPreguntas = (int) session.getAttribute("numPreguntas");

      try (PrintWriter out = response.getWriter()) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Resultado</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><strong>" + usuario + "</strong>, has acertado <strong>" + aciertos + "</strong> preguntas de un total de <strong>" + numPreguntas + "</strong></p>");
        out.println("<p>Tienes muy buenos conocimientos de cine</p>");
        if (min == 0) {
            if (sec == 1) {
                out.println("<p>Tiempo de respuesta: 1 segundo</p>");
            } else {
                out.println("<p>Tiempo de respuesta: " + sec + " segundos</p>");
            }
        } else {
            if (min == 1) {
                if (sec == 1) {
                    out.println("<p>Tiempo de respuesta: 1 minuto, 1 segundo</p>");
                } else {
                    out.println("<p>Tiempo de respuesta: 1 minuto, " + sec + " segundos</p>");
                }
            } else {
                if (sec == 1) {
                    out.println("<p>Tiempo de respuesta: " + min + " minutos, 1 segundo</p>");
                } else {
                    out.println("<p>Tiempo de respuesta: " + min + " minutos, " + sec + " segundos</p>");
                }
            }
        }
        out.println("<a href='" + request.getContextPath());
        out.println("</body>");
        out.println("</html>");
      }
      session.invalidate();
    }
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);
  }

  @Override
  public String getServletInfo() {
    return "Servlet para Mostrar el Resultado";
  }
}