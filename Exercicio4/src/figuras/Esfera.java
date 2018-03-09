package figuras;

public class Esfera extends Circulo implements Poliedro1{

	public Esfera(double raio) {
		super(raio);
	}

	@Override
	public double volume() {
		return (4 / 3) * (Math.PI * Math.pow(getRaio(), 3));
	}

	@Override
	public String toString() {
		return "Esfera [Raio " + getRaio() +", Volume = " + volume() + "]";
	}
	
	

}
