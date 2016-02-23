import java.util.ArrayList;
import java.util.HashSet;


public class BestMatches {
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
		if (args[1].contains("#")) {
			realiserCalculMot(n, args[1], args[2], args[3]);
		}
		else {
			realiserCalculEntier(n, Integer.parseInt(args[1]), args[2], args[3]);
		}
		
	}
	
	
	private static void realiserCalculEntier(int args0, int args1, String args2, String args3) {
		Graine graine = new GraineEntier(args1);
		IDsKmers fichier1 = new IDsKmers(graine, args2);
		IDsKmers fichier2 = new IDsKmers(graine, args3);
		ArrayList<Sequence> iD2 = fichier2.listeID_phrases;
		ArrayList<Integer> valeurs = new ArrayList<Integer>();
		
		for (HashSet<String> f1 : fichier1.listesKmers) {
			for (HashSet<String> f2 : fichier2.listesKmers) {
				valeurs.add((IDsKmers.compare(f1, f2)).size());
			}
		}

		affichage(args0, iD2, valeurs);
	}
	
	
	private static void realiserCalculMot(int args0, String args1, String args2, String args3) {
		Graine graine = new GraineMot(args1);
		IDsKmers fichier1 = new IDsKmers(graine, args2);
		IDsKmers fichier2 = new IDsKmers(graine, args3);
		ArrayList<Sequence> iD2 = fichier2.listeID_phrases;
		ArrayList<Integer> valeurs = new ArrayList<Integer>();
		
		for (HashSet<String> f1 : fichier1.listesKmers) {
			for (HashSet<String> f2 : fichier2.listesKmers) {
				valeurs.add((IDsKmers.compare(f1, f2)).size());
			}
		}

		affichage(args0, iD2, valeurs);
	}
	

	private static void affichage(int n, ArrayList<Sequence> listeId, ArrayList<Integer> listeValeurs) {
		int m = listeId.size();
		
		for (int i=0; i<n; i++) {
			if (m > 0) {
				int best = listeValeurs.get(0);
				int ind = 0;
				
				for (int j=0; j<m; j++) {
					if (best < listeValeurs.get(j)) {
						best = listeValeurs.get(j);
						ind = j;
					}
				}
			
				System.out.println(listeId.get(ind).getId() + " \t" + best);
				listeId.remove(ind);
				listeValeurs.remove(ind);
				m--;
			}
		}
	
	}
	
}
