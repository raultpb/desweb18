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

public class ExcluirOlimpiada implements Command {

	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String oId = request.getParameter("id");
		String oOuro = request.getParameter("ouro");
		String oPrata = request.getParameter("prata");
		String oBronze = request.getParameter("bronze");
		String oNomePais = request.getParameter("nomePais");
		String oNomeModalidade = request.getParameter("nomeModalidade");
		String oAno = request.getParameter("ano");
		int id = -1;
		try {
			id = Integer.parseInt(oId);
		} catch (NumberFormatException e) {

		}
		
		Olimpiada olimpiada = new Olimpiada();
		olimpiada.setId(id);
		
		
		if (oOuro != null && oOuro.length() > 0) {
			olimpiada.setOuro(Integer.parseInt(oOuro));
		}
		
		if (oPrata != null && oPrata.length() > 0) {
			olimpiada.setPrata(Integer.parseInt(oPrata));
		}
		
		if (oBronze!= null && oBronze.length() > 0) {
			olimpiada.setBronze(Integer.parseInt(oBronze));
		}
		
		olimpiada.setNomePais(oNomePais);
		olimpiada.setNomeModalidade(oNomeModalidade);
		
		if (oAno != null && oAno.length() > 0) {
			olimpiada.setAno(Integer.parseInt(oAno));
		}
		OlimpiadaService os = new OlimpiadaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		os.excluir(olimpiada.getId());
		@SuppressWarnings("unchecked")
		ArrayList<Olimpiada> lista = (ArrayList<Olimpiada>) session
				.getAttribute("lista");
		lista.remove(busca(olimpiada, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarOlimpiada.jsp");
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
