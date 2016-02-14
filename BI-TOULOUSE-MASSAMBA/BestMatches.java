import java.util.ArrayList;
import java.util.HashSet;


public class BestMatches {
	
	ArrayList<HashSet<String>> listesKmers;
	ArrayList<String> listeIDs;
	ArrayList<String> sequence;
	
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int graine = Integer.parseInt(args[1]);
		BestMatches fichier1 = new BestMatches(graine, args[2]);
		BestMatches fichier2 = new BestMatches(graine, args[3]);
		
		ArrayList<String> iD2 = fichier2.listeIDs;
		ArrayList<Integer> valeurs = new ArrayList<Integer>();
		
		for (HashSet<String> f1 : fichier1.listesKmers) {
			for (HashSet<String> f2 : fichier2.listesKmers) {
				valeurs.add((compare(f1, f2)).size());
			}
		}

		affichage(n, iD2, valeurs);
		
	}
	
	
	public BestMatches(int longueur, String path) {
		ReadFile fichier = new ReadFile(path);
		ArrayList<HashSet<String>> temp = new ArrayList<HashSet<String>>();
		ArrayList<String> tableau = fichier.getTab().get(1);
		int nbPhrases = fichier.getTab().get(1).size();
		
		for (int i=0; i<nbPhrases; i++) {
			
			temp.add(list(longueur,tableau.get(i)));
			
		}
		
		listeIDs = fichier.getTab().get(0);
		listesKmers = new ArrayList<HashSet<String>>();
		listesKmers.addAll(temp);
		sequence = fichier.getTab().get(1);
		
	}
	
	
	public static HashSet<String> list(int longueur,String phrase){
		
		HashSet<String> kmer = new HashSet<String>();
		for(int i =0; i<(phrase.length()-longueur); i++){
			String tmp = phrase.substring(i, i+longueur).toLowerCase();
				kmer.add(tmp);
		}
		return kmer;			
	}
	
	
	/* Trouver le type de ce que retournera cette fonction pour le main. */
	/* Elle va faire un max de chaque truc puis le second prend la place de l'autre.*/
	private static void affichage(int n, ArrayList<String> listeId, ArrayList<Integer> listeValeurs) {
		
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
			
				System.out.println(">" + listeId.get(ind) + " \t" + best);
				listeId.remove(ind);
				listeValeurs.remove(ind);
				m--;
			}
		}
	
	}
	
	
	public static HashSet<String> compare(HashSet<String> phrase1, HashSet<String> phrase2) {
		HashSet<String> common = new HashSet<String>();
		for (String kmer : phrase1) {
			if (phrase2.contains(kmer)) {
				common.add(kmer);
			}
		}
		
		return common;
	}
	
}
