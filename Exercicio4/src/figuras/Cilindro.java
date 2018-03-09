package figuras;

public class Cilindro extends Circulo implements Poliedro1 {
	private double altura;

	public Cilindro(double raio, double altura) {
		super(raio);
		setAltura(altura);
	}

	@Override
	public double volume() {
		return (Math.PI * Math.pow(getRaio(), 3)) * altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Cilindro [Raio = " + getRaio() +", Altura=" + altura + ", Volume = " + volume() + "]";
	}

	
}
