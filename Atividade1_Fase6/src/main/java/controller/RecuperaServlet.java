package controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;

@WebServlet("/busca.usuario")
public class RecuperaServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, 
                HttpServletResponse response) 
             throws IOException, ServletException {
/* Bloco 1 - iniciando um vetor de usuários para simular um Banco
             de Dados */
		ArrayList<Usuario> bd = new ArrayList<Usuario>();
		bd.add(new Usuario(1,"Usuario 01",
                             "usuario01@email.com"));
		bd.add(new Usuario(2,"Usuario 02",
                             "usuario02@email.com"));
		bd.add(new Usuario(3,"Usuario 03", 
                             "usuario03@email.com"));
		bd.add(new Usuario(4,"Usuario 04", 
                             "usuario04@email.com"));
/* Bloco 2 - simulando a recuperação do banco (só que no vetor)*/
		
		// recuperando o ID da requisição
		int id = Integer.parseInt(
                           request.getParameter("id"));
		Usuario result = null;
		for (Usuario user : bd) {
			if (user.getId() == id) {
				result = user;
				break;
			}
		}
/* Bloco 3 - Definindo qual página será exibida em função do que foi recuperado */
		String paginaDestino;
		if (result != null) {
			paginaDestino ="/Info.jsp";
		}
		else {
			paginaDestino  ="/Erro.jsp";
		}
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(paginaDestino);
		dispatcher.forward(request, response);
	}

}
