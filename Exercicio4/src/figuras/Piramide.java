package figuras;

public class Piramide extends Triangulo implements Poliedro1 {
	private double profundidade;

	public Piramide(double base, double altura, double profundidade) {
		super(base, altura);
		setProfundidade(profundidade);
	}
	

	@Override
	public double volume() {
		return (1 / 3) * (getBase() * getAltura() * profundidade);
	}

	public double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(double profundidade) {
		this.profundidade = profundidade;
	}

	@Override
	public String toString() {
		return "Piramide [Base = " + getBase() + ", Altura = " + getAltura() + ", Profundidade=" + profundidade + ", Volume = " + volume() + "]";
	}

}
