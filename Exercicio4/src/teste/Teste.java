package teste;

import figuras.Cilindro;
import figuras.Circulo;
import figuras.Cubo;
import figuras.Diagonal;
import figuras.Esfera;
import figuras.Figura;
import figuras.Geometria;
import figuras.Losango;
import figuras.Piramide;
import figuras.Quadrado;
import figuras.Retangulo;
import figuras.Trapezio;
import figuras.Triangulo;

public class Teste {
	public static void main(String[] args) {
		Geometria geometria = new Geometria();
		geometria.add(new Losango(20, 10));
		geometria.add(new Triangulo(5, 5));
		geometria.add(new Quadrado(10));
		geometria.add(new Retangulo(10, 7));
		geometria.add(new Circulo(5));
		geometria.add(new Trapezio(10, 20, 5));
		geometria.add(new Cubo(5));
		geometria.add(new Esfera(3));
		geometria.add(new Cilindro(2, 7));
		geometria.add(new Piramide(20,20,10));
		
		for(Figura figura : geometria.getFiguras()) {
			System.out.println(geometria.area(figura));
			System.out.println(geometria.perimetro(figura));
			
			if(figura instanceof Diagonal) {
				System.out.println(geometria.diagonal((Diagonal)figura));
			}
		}
	}
}