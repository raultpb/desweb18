package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.Olimpiada;
import Service.OlimpiadaService;

public class CriarOlimpiada implements Command{

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oId = request.getParameter("id");
		String oOuro = request.getParameter("ouro");
		String oPrata = request.getParameter("prata");
		String oBronze = request.getParameter("bronze");
		String oNomePais = request.getParameter("nomePais");
		String oNomeModalidade = request.getParameter("nomeModalidade");
		String oAno= request.getParameter("ano");
		
		Olimpiada o = new Olimpiada();
		
		if (oOuro != null && oOuro.length() > 0) {
			o.setOuro(Integer.parseInt(oOuro));
		}
		
		if (oPrata != null && oPrata.length() > 0) {
			o.setPrata(Integer.parseInt(oPrata));
		}
		
		if (oBronze!= null && oBronze.length() > 0) {
			o.setBronze(Integer.parseInt(oBronze));
		}
		
		o.setNomePais(oNomePais);
		o.setNomeModalidade(oNomeModalidade);
		
		if (oAno != null && oAno.length() > 0) {
			o.setAno(Integer.parseInt(oAno));
		}
		
		OlimpiadaService os = new OlimpiadaService();
			os.criar(o);
			os.carregar(o.getId());
			
			request.setAttribute("olimpiada", o);
			RequestDispatcher view = request.getRequestDispatcher("VisualizarOlimpiada.jsp");
			view.forward(request, response);
		
	}

}

