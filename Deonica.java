package skijanje;

//import java.util.Locale;

public abstract class Deonica {
	private double duzina;
	private double stepeni;
	/*static {
		Locale.setDefault(Locale.US);
	}*/
	public Deonica(double duzina, double stepeni) {
		this.duzina = duzina;
		this.stepeni = stepeni;
	}
	public double duzina() {
		return duzina;
	}
	public double nagib() {
		return stepeni;
	}
	abstract public char oznaka();
	abstract public double ubrzanje();
	public double brzina(double poc) {
		return Math.sqrt((2*ubrzanje()*duzina) + Math.pow(poc,2));
	}
	public double vreme(double poc) {
		return (brzina(poc)-poc)/ubrzanje();
	}
	@Override
	public String toString() {
		return  oznaka()+"("+ duzina + "," + stepeni + ")";
	}
	
}
