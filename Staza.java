package skijanje;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;



public class Staza {
	private LinkedList<Deonica> deo;
	private String naziv;
	public Staza(String naziv) {
		this.naziv = naziv;
		deo=new LinkedList<Deonica>();
	}
	public void dodaj(Deonica s) {
		deo.addLast(s);
	}
	public int broj() {
		return deo.size();
	}
	public double duzina() {
		double duz=0;
		for(Deonica d:deo) {
			duz+=d.duzina();
		}
		return duz;
	}
	public double nagib() {
		double max=0;
		for(Deonica d:deo) {
			if(d.nagib()>max) {
				max=d.nagib();
			}
		}
		return max;
	}
	public double brzina(double poc) {
		double tren;
		for(Deonica d:deo) {
			tren=d.brzina(poc);
			poc=tren;
		}
		return poc;
	}
	public double vreme(double poc) {
		double t=0;
		double tren;
		for(Deonica d:deo) {
			tren=d.brzina(poc);
			t+=d.vreme(poc);
			poc=tren;
		}
		return t;
	}
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append(naziv);
		sb.append('|');
		sb.append(broj());
		sb.append('|');
		sb.append(duzina());
		sb.append('|');
		sb.append(nagib());
		sb.append('\n');
		sb.append('[');
		for( int i=0;i<deo.size();i++) {
			
			sb.append(deo.get(i));
			if(i!=deo.size()-1) {
				sb.append(',');
			}
		}
		sb.append(']');
		return sb.toString();
	}
	public char oznaka() throws GOznaka {
		if (deo.size() == 0) throw new GOznaka();
		Set<Character> oznake = new HashSet<Character>();
		for(Deonica d:deo) {
			oznake.add(d.oznaka());
		}
		Integer[] o= new Integer[oznake.size()];
		Character[] oz= new Character[oznake.size()];
		int j=0;
		for(char k:oznake) {
			oz[j++]=k;
		}
		for(int i=0;i<oz.length;i++) {
			int count=0;
			for(Deonica d:deo) {
				if(d.oznaka()==oz[i]) {
					o[i]=++count;
				}
			}
		}
		int max=0;
		int c=0;
		for(int i=0;i<o.length;i++) {
			if(o[i]>max) {
				max=o[i];
				c=i;
			}
		}
		return oz[c];	
	}
	/*public static void main(String[] args) {
		// DZ main
		Deonica deo1 = new Teska(100., 10.), deo2 = new Srednja(500., 5.);
		Deonica deo3=new Laka(100.,10.),deo4=new Laka(400.,40.),deo5=new Teska(340.,43.);
		Staza gradac = new Staza("Gradac");
		gradac.dodaj(deo1);
		gradac.dodaj(deo2);
		gradac.dodaj(deo3);
		gradac.dodaj(deo4);
		gradac.dodaj(deo5);
		System.out.println(gradac);
		System.out.println("staza | broj delova: " + gradac.broj());
		System.out.println("staza | uk duzina: " + gradac.duzina());
		try {
			System.out.println("staza | oznaka: " + gradac.oznaka());
		} catch (GOznaka o) {
			System.out.println(o);
		}*/
	//}
	
}
