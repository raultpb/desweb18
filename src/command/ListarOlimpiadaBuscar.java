package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Olimpiada;
import Service.OlimpiadaService;

public class ListarOlimpiadaBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String chave = request.getParameter("data[search]");
		OlimpiadaService olimpiada = new OlimpiadaService();
		ArrayList<Olimpiada> lista = null;
		HttpSession session = request.getSession();
		if (chave != null && chave.length() > 0) {
			lista = olimpiada.listarOlimpiadas(chave);
		} else {
			lista = olimpiada.listarOlimpiadas();
		}
		session.setAttribute("lista", lista);

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarOlimpiada.jsp");
		dispatcher.forward(request, response);
	}
}
