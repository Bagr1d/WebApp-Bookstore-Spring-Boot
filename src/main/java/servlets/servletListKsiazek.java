package servlets;

import dao.daoKsiazki;
import model.modelKsiazka;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/listaKsiazek")
public class servletListaKsiazek extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoKsiazki dao = new daoKsiazki();
        ArrayList<modelKsiazka> tk;
        String idkatParam = request.getParameter("idkat");
        if (idkatParam != null) {
            int idkat = Integer.parseInt(idkatParam);
            tk = dao.listaKsiazekKategorii(idkat);
        } else {
            tk = dao.listaKsiazek();
        }
        HttpSession sesja = request.getSession();
        sesja.setAttribute("tk", tk);
        String nextURL = "/listaKsiazek.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(nextURL);
        rd.forward(request, response);
    }
}
