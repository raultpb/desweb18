package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import Model.Olimpiada;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import Service.OlimpiadaService;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OlimpiadaTest {
	Olimpiada olimpiada, copia;
	OlimpiadaService olimpiadaService;
	static int id = 0;

	@Before
	public void setUp() throws Exception {
		System.out.println("setup");
		olimpiada = new Olimpiada();
		olimpiada.setId(id);
		olimpiada.setOuro(100);
		olimpiada.setPrata(200);
		olimpiada.setBronze(300);
		olimpiada.setNomePais("Venezuela");
		olimpiada.setNomeModalidade("Futebol");
		olimpiada.setAno(2000);
		
		
		copia = new Olimpiada();
		copia.setId(id);
		copia.setOuro(100);
		copia.setPrata(200);
		copia.setBronze(300);
		copia.setNomePais("Venezuela");
		copia.setNomeModalidade("Futebol");
		copia.setAno(2000);
		olimpiadaService = new OlimpiadaService();
		System.out.println(olimpiada);
		System.out.println(copia);
		System.out.println(id);
	}
	
	@Test
	public void test00Carregar() throws IOException {
		System.out.println("carregar");
		Olimpiada fixture = new Olimpiada();
		fixture.setId(1);
		fixture.setOuro(300);
		fixture.setPrata(200);
		fixture.setBronze(100);
		fixture.setNomePais("Argentina");
		fixture.setNomeModalidade("Futebol");
		fixture.setAno(2020);
		OlimpiadaService novoService = new OlimpiadaService();
		Olimpiada novo = novoService.carregar(1);
		assertEquals("testa inclusao", novo, fixture);
	}

	@Test
	public void test01Criar() throws IOException {
		System.out.println("criar");
		id = olimpiadaService.criar(olimpiada);
		System.out.println(id);
		copia.setId(id);
		assertEquals("testa criacao", olimpiada, copia);
	}

	@Test
	public void test02Atualizar() throws IOException {
		System.out.println("atualizar");
		olimpiada.setOuro(999);
		copia.setOuro(999);		
		olimpiadaService.atualizar(olimpiada);
		olimpiada = olimpiadaService.carregar(olimpiada.getId());
		assertEquals("testa atualizacao", olimpiada, copia);
	}

	@Test
	public void test03Excluir() throws IOException {
		System.out.println("excluir");
		copia.setId(-1);
		copia.setOuro(0);
		copia.setPrata(0);
		copia.setBronze(0);
		copia.setNomePais(null);
		copia.setNomeModalidade(null);
		copia.setAno(0);
		olimpiadaService.excluir(id);
		olimpiada = olimpiadaService.carregar(id);
		assertEquals("testa exclusao", olimpiada, copia);
	}
}
