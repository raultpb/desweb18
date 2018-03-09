package figuras;

public abstract class Poligono extends Figura {
	private double base, altura;

	public Poligono(double base, double altura) {
		super();
		this.base = base;
		this.altura = altura;
	}

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	double area() {
		return base * altura;
	}
	
	@Override
	double perimetro() {
		return 2.0 * getBase() + 2.0 * getAltura();
	}

}
