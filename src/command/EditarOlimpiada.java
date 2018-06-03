package command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Olimpiada;
import Service.OlimpiadaService;

public class EditarOlimpiada implements Command {
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		int id = -1;
		try {
			id = Integer.parseInt(pId);
		} catch (NumberFormatException e) {
		}
		Olimpiada olimpiada = new Olimpiada();
		olimpiada.setId(id);
		OlimpiadaService os = new OlimpiadaService();
		RequestDispatcher view = null;
		olimpiada = os.carregar(olimpiada.getId());
		request.setAttribute("olimpiada", olimpiada);
		view = request.getRequestDispatcher("AlterarOlimpiada.jsp");
		view.forward(request, response);
	}

	public int busca(Olimpiada olimpiada, ArrayList<Olimpiada> lista) {
		Olimpiada to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == olimpiada.getId()) {
				return i;
			}
		}
		return -1;
	}
}