import java.util.ArrayList;
import java.util.HashSet;


public class BestMatches {
	
	ArrayList<HashSet<String>> listesKmers;
	ArrayList<String> listeIDs;
	
	
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int graine = Integer.parseInt(args[1]);
		BestMatches fichier1 = new BestMatches(graine, args[2]);
		BestMatches fichier2 = new BestMatches(graine, args[3]);
		
		ArrayList<String> iD2 = fichier2.listeIDs;
		ArrayList<Integer> valeurs = new ArrayList<Integer>();
		
		//list(graine,phrase);
		
			System.out.println(fichier2.listesKmers.get(1).size());
		
		/*for (int i=0; i<fichier2.listesKmers.size(); i++) {
			// problemes avec le type de listesKmers, donc adapter les arguments en conséquence
			valeurs.add((compare(fichier1.listesKmers.get(0), fichier2.listesKmers.get(i))).size());
		}
		
		affichage(n, iD2, valeurs);*/
		
	}
	
	
	public BestMatches(int longueur, String path) {
		ReadFile fichier = new ReadFile(path);
		HashSet<String> temp = new HashSet<>();
		ArrayList<String> tableau = fichier.getTab().get(1);
		int nbPhrases = fichier.getTab().get(1).size();
		
		for (int i=0; i<nbPhrases; i++) {
			
			temp.addAll(list(longueur,tableau.get(i)));
			
		}
		
		listeIDs = fichier.getTab().get(0);
		listesKmers = new ArrayList<HashSet<String>>();
		listesKmers.add(temp);
		
	}
	
	
	public ArrayList<String> list(int longueur,String phrase){
		
		ArrayList<String> kmer = new ArrayList<>();
		for(int i =0;i<=(phrase.length()-longueur);i++){
			String tmp = phrase.substring(i, i+longueur);
				kmer.add(tmp);
		}
		return kmer;			
	}
	
	
	/* Trouver le type de ce que retournera cette fonction pour le main. */
	/* Elle va faire un max de chaque truc puis le second prend la place de l'autre.*/
	private static void affichage(int n, ArrayList<String> listeId, ArrayList<Integer> listeValeurs) {
		
		int best = listeValeurs.get(0);
		int ind = 0;
		
		for (int i=0; i<n; i++) {
			
			for (int j=0; j<listeId.size(); j++) {
				if (best < listeValeurs.get(j)) {
					best = listeValeurs.get(j);
					ind = j;
				}
			}
			
			System.out.println(listeId.get(ind) + "" + best);
			listeId.remove(ind);
			listeValeurs.remove(ind);
			best = listeValeurs.get(0);
			ind = 0;
		}
	
	}
	
	
	public static ArrayList<String> compare(HashSet<String> phrase1, HashSet<String> phrase2) {
		ArrayList<String> common=new ArrayList<>();
		for (String kmer : phrase1) {
			if(phrase2.contains(kmer)){
				common.add(kmer);
			}
		}
		
		return common;
	}
	
}
