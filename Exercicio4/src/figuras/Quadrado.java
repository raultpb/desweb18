package figuras;

public class Quadrado extends Quadrilatero implements Diagonal{

	public Quadrado(double lado) {
		super(lado, lado);
	}
	
	@Override
	public double diagonal() {
		return area() * Math.sqrt(2);
	}

	@Override
	public String toString() {
		return "Quadrado [Lado = " + getBase() +"]";
	}
	
	


}
