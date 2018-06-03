package DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Olimpiada;

public class OlimpiadaDao {

	ConnectionFactory cf = new ConnectionFactory();
	Olimpiada olimpiada;
	
	public int criar(Olimpiada olimpiada) {
		String sqlInsert = "INSERT INTO olimpiada(ouro, prata, bronze, nomePais, nomeModalidade, ano) VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = cf.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
				stm.setInt(1, olimpiada.getOuro());
				stm.setInt(2, olimpiada.getPrata());
				stm.setInt(3, olimpiada.getBronze());
				stm.setString(4, olimpiada.getNomePais());
				stm.setString(5, olimpiada.getNomeModalidade());
				stm.setInt(6, olimpiada.getAno());
				stm.execute();
				String sqlQuery = "SELECT LAST_INSERT_ID()";
				try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
				ResultSet rs = stm2.executeQuery();) {
					if (rs.next()) {
						olimpiada.setId(rs.getInt(1));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return olimpiada.getId();
	}

	public void atualizar(Olimpiada olimpiada) {
		String sqlUpdate = "UPDATE olimpiada SET ouro=?, prata=?, bronze=?, nomePais=?, nomeModalidade=?, ano=? WHERE id=?";
		
		try (Connection conn = cf.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				stm.setInt(1, olimpiada.getOuro());
				stm.setInt(2, olimpiada.getPrata());
				stm.setInt(3, olimpiada.getBronze());
				stm.setString(4, olimpiada.getNomePais());
				stm.setString(5, olimpiada.getNomeModalidade());
				stm.setInt(6, olimpiada.getAno());
				stm.setInt(7, olimpiada.getId());
				stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(int id) {
		String sqlDelete = "DELETE FROM olimpiada WHERE id = ?";
		try (Connection conn = cf.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
				stm.setInt(1, olimpiada.getId());
				stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Olimpiada carregar(int id) {
		Olimpiada olimpiada = new Olimpiada();
		String sqlSelect = "SELECT id, ouro, prata, bronze, nomePais, nomeModalidade, ano FROM olimpiada WHERE id = ?";
		
		try (Connection conn = cf.obterConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					olimpiada.setId(rs.getInt("id"));
					olimpiada.setOuro(rs.getInt("ouro"));
					olimpiada.setPrata(rs.getInt("prata"));
					olimpiada.setBronze(rs.getInt("bronze"));
					olimpiada.setNomePais(rs.getString("nomePais"));
					olimpiada.setNomeModalidade(rs.getString("nomeModalidade"));
					olimpiada.setAno(rs.getInt("ano"));
				} else {
					olimpiada.setId(-1);
					olimpiada.setOuro(-1);
					olimpiada.setPrata(-1);
					olimpiada.setBronze(-1);
					olimpiada.setNomePais(null);
					olimpiada.setNomeModalidade(null);
					olimpiada.setAno(-1);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return olimpiada;
	}

	public void vetPaises(String vet[]) {	
		String sqlGet = "SELECT nomePais FROM olimpiada ORDER BY nomePais";
		int cont = 0 ;
		try (Connection conn = cf.obterConexao()){
			PreparedStatement stm = conn.prepareStatement(sqlGet);
			ResultSet rs = stm.executeQuery();
			while(rs.next() && cont < 3 ) {
				vet[cont] = rs.getString("nomePais");
				cont ++;
			}
		}catch (SQLException e) {
		System.out.println(e);
		}
	}
	
	public ArrayList<Olimpiada> listarOlimpiadas() throws IOException {
		Olimpiada olimpiada;
		ArrayList<Olimpiada> lista = new ArrayList<>();
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obterConexao();
			String sqlSelect = "SELECT id, ouro, prata, bronze, nomePais, nomeModalidade, ano FROM olimpiada";
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						olimpiada = new Olimpiada();
						olimpiada.setId(rs.getInt("id"));
						olimpiada.setOuro(rs.getInt("ouro"));
						olimpiada.setPrata(rs.getInt("prata"));
						olimpiada.setBronze(rs.getInt("bronze"));
						olimpiada.setNomePais(rs.getString("nomePais"));
						olimpiada.setNomeModalidade(rs.getString("nomeModalidade"));
						olimpiada.setAno(rs.getInt("ano"));
						lista.add(olimpiada);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return lista;
	}

	public ArrayList<Olimpiada> listarOlimpiadas(String chave) throws IOException {
		Olimpiada olimpiada;
		ArrayList<Olimpiada> lista = new ArrayList<>();
		String sqlSelect = "SELECT id, ouro, prata, bronze, nomePais, nomeModalidade, ano FROM olimpiada where upper(nome) like ?";
		// pega a conexão em um try normal para que ela não seja fechada
		try {
			Connection conn = ConnectionFactory.obterConexao();
			// usando o try with resources do Java 7, que fecha o que abriu
			try (PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
				try (ResultSet rs = stm.executeQuery();) {
					while (rs.next()) {
						olimpiada = new Olimpiada();
						olimpiada.setId(rs.getInt("id"));
						olimpiada.setOuro(rs.getInt("ouro"));
						olimpiada.setPrata(rs.getInt("prata"));
						olimpiada.setBronze(rs.getInt("bronze"));
						olimpiada.setNomePais(rs.getString("nomePais"));
						olimpiada.setNomeModalidade(rs.getString("nomeModalidade"));
						olimpiada.setAno(rs.getInt("ano"));
						lista.add(olimpiada);
					}
				} catch (SQLException e) {
					e.printStackTrace();
					throw new IOException();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
				throw new IOException();
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
			throw new IOException();
		}
		return lista;
	}
}