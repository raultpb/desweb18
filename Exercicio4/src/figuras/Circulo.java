package figuras;

public class Circulo extends Figura {
	private double raio;

	public Circulo(double raio) {
		super();
		this.raio = raio;
	}

	@Override
	double area() {
		return Math.PI * Math.pow(raio, 2);
	}

	@Override
	double perimetro() {
		return 2.0 * Math.PI * raio;
	}

	public double getRaio() {
		return raio;
	}

	public void setRaio(double raio) {
		this.raio = raio;
	}

	@Override
	public String toString() {
		return "Circulo [raio=" + raio + "]";
	}


}
