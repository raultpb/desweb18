package figuras;

public abstract class Quadrilatero extends Poligono{
	
	public Quadrilatero(double base, double altura) {
		super(base, altura);
	}
		

	@Override
	public String toString() {
		return "Quadrilatero [getBase()=" + getBase() + ", getAltura()=" + getAltura() + "]";
	}

}
