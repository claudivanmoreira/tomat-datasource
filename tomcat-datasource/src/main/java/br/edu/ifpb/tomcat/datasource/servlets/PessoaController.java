/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.tomcat.datasource.servlets;

import br.edu.ifpb.tomcat.datasource.entidades.Pessoa;
import br.edu.ifpb.tomcat.datasource.persistencia.HibernatePersistence;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Desenvolvedor01
 */
@WebServlet(name = "PessoaController", urlPatterns = {"/pessoa"})
public class PessoaController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(request.getParameter("nome"));
        pessoa.setEmail(request.getParameter("email"));

        HibernatePersistence persistence = new HibernatePersistence(entityManager, pessoa);

        try {
            persistence.persist();
            request.setAttribute("mensagem", "Pessoa cadastrada com sucesso!");
        } catch (Exception ex) {
            request.setAttribute("mensagem", "Um erro inesperado ocorreu! Detalhes: " + ex.getMessage());
        }

        request.getRequestDispatcher("resultado.jsp").forward(request, response);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
