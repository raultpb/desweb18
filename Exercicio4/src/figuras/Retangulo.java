package figuras;

public class Retangulo extends Quadrilatero implements Diagonal{

	public Retangulo(double base, double altura) {
		super(base, altura);
	}

	@Override
	public double diagonal() {
		return Math.sqrt(Math.pow(getBase(), 2) + Math.pow(getAltura(), 2));
	}

	@Override
	public String toString() {
		return "Retangulo [Base = " + getBase() + ", Altura = " + getAltura() + "]";
	}

	
}
