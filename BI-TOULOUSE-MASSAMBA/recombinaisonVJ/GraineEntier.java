package recombinaisonVJ;

import java.util.HashSet;

public class GraineEntier extends Graine {

	int longueur;
	String graine;
	
	public GraineEntier(int length) {
		this.longueur = length;
		
		String res = "";
		for (int i=0; i<length; i++) {
			res = res.concat("#");
		}
		
		this.graine = res;
	}


	public HashSet<String> liste(Sequence sequence){
		HashSet<String> kmer = new HashSet<String>();
		for(int i =0; i<(sequence.getPhrase().length() - this.longueur); i++){
			String tmp = sequence.getPhrase().substring(i, i+this.longueur).toLowerCase();
				kmer.add(tmp);
		}
		return kmer;			
	}
	
	
	
	
	
}
