package servlets;

import dao.daoKsiazki;
import model.modelKategoria;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/menu")
public class servletMenu extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        daoKsiazki dao = new daoKsiazki();
        ArrayList<modelKategoria> lk = dao.listaKategorii();
        HttpSession sesja = request.getSession();
        sesja.setAttribute("lk", lk);
        String nextURL = "/menu.jsp";
        RequestDispatcher rd = getServletContext().getRequestDispatcher(nextURL);
        rd.forward(request, response);
    }
}
