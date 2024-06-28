package servlets;

import dao.daoKsiazki;
import model.modelWydawnictwo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/kontakt")
public class servletKontakt extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoKsiazki dao = new daoKsiazki();
        ArrayList<modelWydawnictwo> lw = dao.listaWydawnictw();
        HttpSession sesja = request.getSession();
        sesja.setAttribute("lw", lw);
        String nextURL = "/kontakt.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(nextURL);
        rd.forward(request, response);
    }
}
