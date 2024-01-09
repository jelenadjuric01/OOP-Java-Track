package skijanje;

public class Teska extends Deonica {
	
	public Teska(double duzina, double stepeni) {
		super(duzina, stepeni);
	}

	@Override
	public char oznaka() {
		return 'T';
	}

	@Override
	public double ubrzanje() {
		return 9.81*Math.sin(nagib()/180*Math.PI);
	}

}
