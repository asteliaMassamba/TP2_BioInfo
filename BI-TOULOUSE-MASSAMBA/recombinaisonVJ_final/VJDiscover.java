import java.util.ArrayList;
import java.util.HashSet;

public class VJDiscover {

	public static void main(String[] args) {
		if (args[0].contains("#")) {
			realiserCalculMot(args[0], args[1], args[2], args[3]);
		}
		else {
			realiserCalculEntier(Integer.parseInt(args[0]), args[1], args[2], args[3]);
		}
	}
	
	
	private static void realiserCalculEntier(int args0, String args1, String args2, String args3) {
		Graine graine = new GraineEntier(args0);
		IDsKmers fichier1 = new IDsKmers(graine, args1);
		IDsKmers fichierV = new IDsKmers(graine, args2);
		IDsKmers fichierJ = new IDsKmers(graine, args3);
	
		ArrayList<Sequence> iD1 = fichier1.listeID_phrases;
		ArrayList<Sequence> iDV = fichierV.listeID_phrases;
		ArrayList<Sequence> iDJ = fichierJ.listeID_phrases;
		ArrayList<ArrayList<Integer>> valeursV = new ArrayList<>();
		ArrayList<ArrayList<Integer>> valeursJ = new ArrayList<>();
	
		for (HashSet<String> f1 : fichier1.listesKmers) {
			ArrayList<Integer> tempV = new ArrayList<>();
			ArrayList<Integer> tempJ = new ArrayList<>();
			for (HashSet<String> fV : fichierV.listesKmers) {
				tempV.add((IDsKmers.compare(f1, fV)).size());
			}
			for (HashSet<String> fJ : fichierJ.listesKmers) {
				tempJ.add((IDsKmers.compare(f1, fJ)).size());
			}
			valeursV.add(tempV);
			valeursJ.add(tempJ);
		}

		affichage(iD1, IDsKmers.listePlusieursSequences(iD1, iDV, valeursV), IDsKmers.listePlusieursSequences(iD1, iDJ, valeursJ));
	}
	
	
	private static void realiserCalculMot(String args0, String args1, String args2, String args3) {
		Graine graine = new GraineMot(args0);
		IDsKmers fichier1 = new IDsKmers(graine, args1);
		IDsKmers fichierV = new IDsKmers(graine, args2);
		IDsKmers fichierJ = new IDsKmers(graine, args3);
	
		ArrayList<Sequence> iD1 = fichier1.listeID_phrases;
		ArrayList<Sequence> iDV = fichierV.listeID_phrases;
		ArrayList<Sequence> iDJ = fichierJ.listeID_phrases;
		ArrayList<ArrayList<Integer>> valeursV = new ArrayList<>();
		ArrayList<ArrayList<Integer>> valeursJ = new ArrayList<>();
	
		for (HashSet<String> f1 : fichier1.listesKmers) {
			ArrayList<Integer> tempV = new ArrayList<>();
			ArrayList<Integer> tempJ = new ArrayList<>();
			for (HashSet<String> fV : fichierV.listesKmers) {
				tempV.add((IDsKmers.compare(f1, fV)).size());
			}
			for (HashSet<String> fJ : fichierJ.listesKmers) {
				tempJ.add((IDsKmers.compare(f1, fJ)).size());
			}
			valeursV.add(tempV);
			valeursJ.add(tempJ);
		}

		affichage(iD1, IDsKmers.listePlusieursSequences(iD1, iDV, valeursV), IDsKmers.listePlusieursSequences(iD1, iDJ, valeursJ));
	}
	
	
	private static void affichage(ArrayList<Sequence> listeiD1, ArrayList<Sequence> listeiDV, ArrayList<Sequence> listeiDJ) {
		for (int i=0; i<listeiD1.size(); i++) {
			System.out.println(listeiD1.get(i).getId() +"\t"+ listeiDV.get(i).getId() +"\t"+ listeiDJ.get(i).getId());
		}
		
	}
	
}
