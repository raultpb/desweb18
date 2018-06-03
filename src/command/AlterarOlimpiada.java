package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Olimpiada;
import Service.OlimpiadaService;

public class AlterarOlimpiada implements Command {
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String oId = request.getParameter("id");
		String oOuro = request.getParameter("ouro");
		String oPrata = request.getParameter("prata");
		String oBronze = request.getParameter("bronze");
		String oNomePais = request.getParameter("nomePais");
		String oNomeModalidade = request.getParameter("nomeModalidade");
		String oAno = request.getParameter("ano");
		HttpSession session = request.getSession();
		String pagina = "";
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
		os.atualizar(olimpiada);
		RequestDispatcher view = null;
		olimpiada = os.carregar(olimpiada.getId());
		request.setAttribute("olimpiada", olimpiada);
		view = request.getRequestDispatcher("VisualizarOlimpiada.jsp");
		view.forward(request, response);		
	}
}
