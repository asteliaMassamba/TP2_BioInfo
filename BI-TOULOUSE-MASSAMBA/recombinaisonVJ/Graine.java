package recombinaisonVJ;

import java.util.HashSet;

public abstract class Graine {
	
	int longueur;
	String graine;
	
	public Graine() {}
	
	public abstract HashSet<String> liste(Sequence sequence);

}
