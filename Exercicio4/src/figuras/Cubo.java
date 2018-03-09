package figuras;

public class Cubo extends Quadrilatero implements Poliedro1 {
	private double profundidade;
	
	public Cubo(double lado) {
		super(lado, lado);
		this.profundidade = lado;
	}
	
	public double volume() {
		return Math.pow(getBase(), 3);
	}

	@Override
	public String toString() {
		return "Cubo [Base = " + getBase() + ", Altura = " + getAltura() + ", Profundidade=" + profundidade + ", Volume = " + volume() + "]";
	}
	
	
	

}
