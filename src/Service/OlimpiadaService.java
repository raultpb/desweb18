package Service;

import java.io.IOException;
import java.util.ArrayList;

import DAO.OlimpiadaDao;
import Model.Olimpiada;

public class OlimpiadaService {
	OlimpiadaDao dao;
	
	public OlimpiadaService() {
	 dao = new OlimpiadaDao();
	}
	
	public int criar(Olimpiada olimpiada) {
		return dao.criar(olimpiada);
	}
	
	public void atualizar(Olimpiada olimpiada) {
		dao.atualizar(olimpiada);
	}
	
	public void excluir(int id) {
		dao.excluir(id);
	}
	
	public Olimpiada carregar(int id) {
		return  dao.carregar(id);
	}
	
	public String[] vetOlimpiada(String vet[]) {
		dao.vetPaises(vet);
		return vet;
	}
	
	public ArrayList<Olimpiada> listarOlimpiadas(String sqlListar) throws IOException {
		return dao.listarOlimpiadas(sqlListar);
	}
	public ArrayList<Olimpiada> listarOlimpiadas() throws IOException{
		return dao.listarOlimpiadas();
	}
}
