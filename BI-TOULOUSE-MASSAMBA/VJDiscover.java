import java.util.ArrayList;
import java.util.HashSet;

public class VJDiscover {

	public static void main(String[] args) {
		int graine = Integer.parseInt(args[0]);
		BestMatches fichier1 = new BestMatches(graine, args[1]);
		BestMatches fichierV = new BestMatches(graine, args[2]);
		BestMatches fichierJ = new BestMatches(graine, args[3]);
		
		ArrayList<String> iD1 = fichier1.listeIDs;
		ArrayList<String> iDV = fichierV.listeIDs;
		ArrayList<String> iDJ = fichierJ.listeIDs;
		ArrayList<ArrayList<Integer>> valeursV = new ArrayList<>();
		ArrayList<ArrayList<Integer>> valeursJ = new ArrayList<>();
		
		for (HashSet<String> f1 : fichier1.listesKmers) {
			ArrayList<Integer> tempV = new ArrayList<>();
			ArrayList<Integer> tempJ = new ArrayList<>();
			for (HashSet<String> fV : fichierV.listesKmers) {
				tempV.add((BestMatches.compare(f1, fV)).size());
			}
			for (HashSet<String> fJ : fichierJ.listesKmers) {
				tempJ.add((BestMatches.compare(f1, fJ)).size());
			}
			valeursV.add(tempV);
			valeursJ.add(tempJ);
		}

		affichage(iD1, liste(iD1, iDV, valeursV), liste(iD1, iDJ, valeursJ));
		
	}
	
	
	private static ArrayList<String> liste(ArrayList<String> listeId1, ArrayList<String> listeId2, ArrayList<ArrayList<Integer>> listeValeurs) {
		int n = listeId1.size();
		int m = listeId2.size();
		ArrayList<String> res = new ArrayList<String>();
		
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
	
	
	private static void affichage(ArrayList<String> listeiD1, ArrayList<String> listeiDV, ArrayList<String> listeiDJ) {
		for (int i=0; i<listeiD1.size(); i++) {
			System.out.println(">"+ listeiD1.get(i) +"\t"+ listeiDV.get(i) +"\t"+ listeiDJ.get(i));
		}
		
	}
	
}
