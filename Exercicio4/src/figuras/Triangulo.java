package figuras;

public class Triangulo extends Poligono {

	public Triangulo(double base, double altura) {
		super(base, altura);
	}

	@Override
	double area() {
		return super.area() / 2;
	}

	@Override
	double perimetro() {
		return 3.0 * getBase();
	}

	@Override
	public String toString() {
		return "Triangulo [Base = " + getBase() +", Altura = " + getAltura() +"]";
	}
	
	

}
