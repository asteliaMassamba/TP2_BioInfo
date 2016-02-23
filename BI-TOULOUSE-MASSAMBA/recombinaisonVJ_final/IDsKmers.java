import java.util.ArrayList;
import java.util.HashSet;

public class IDsKmers {
	
	ArrayList<HashSet<String>> listesKmers;
	ArrayList<Sequence> listeID_phrases;

	public IDsKmers(Graine graine, String path) {
		ReadFile fichier = new ReadFile(path);
		ArrayList<HashSet<String>> temp = new ArrayList<HashSet<String>>();
		ArrayList<Sequence> tableau = fichier.getTab();
		int nbSequences = fichier.getTab().size();
		
		for (int i=0; i<nbSequences; i++) {
			temp.add(graine.liste(tableau.get(i)));
		}
		
		listeID_phrases = tableau;
		listesKmers = new ArrayList<HashSet<String>>();
		listesKmers.addAll(temp);
		
	}
	
	
	/*public static HashSet<String> listeUneSequence(int longueur,String phrase){
		HashSet<String> kmer = new HashSet<String>();
		for(int i =0; i<(phrase.length()-longueur); i++){
			String tmp = phrase.substring(i, i+longueur).toLowerCase();
				kmer.add(tmp);
		}
		return kmer;			
	}*/
	
	
	public static ArrayList<Sequence> listePlusieursSequences(ArrayList<Sequence> listeId1, ArrayList<Sequence> listeId2, ArrayList<ArrayList<Integer>> listeValeurs) {
		int n = listeId1.size();
		int m = listeId2.size();
		ArrayList<Sequence> res = new ArrayList<Sequence>();
		
		for (int i=0; i<n; i++) {
			int best = listeValeurs.get(i).get(0);
			int ind = 0;
			for (int j=0; j<m; j++) {
				if (best < listeValeurs.get(i).get(j)) {
					best = listeValeurs.get(i).get(j);
					ind = j;
				}
			}
			res.add(listeId2.get(ind));
		}
		
		return res;
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
