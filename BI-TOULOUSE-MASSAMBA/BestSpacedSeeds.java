import java.util.ArrayList;

public class BestSpacedSeeds {

	public static void main(String[] args) {
		int poids = Integer.parseInt(args[0]);
		int longueur = Integer.parseInt(args[1]);
		
		EnumerateSpacedKmers liste = new EnumerateSpacedKmers(poids, longueur);
		
		ArrayList<Double> ratio = new ArrayList<Double>();
		ArrayList<String> graine = new ArrayList<String>();
		
		for (String string : liste.listeGraines) {
			String[] temp = {string,args[2],args[3]};
			KmersSpacedOperation k = new KmersSpacedOperation(temp);
			ratio.add(k.ratio());
			graine.add(string);
		}
		
		int top1=0; int top2=0; int top3=0;
		for (int i=1; i<ratio.size(); i++) {
			if (ratio.get(top1) > ratio.get(i)) {
				top3 = top2;
				top2 = top1;
				top1 = i;
			}
		}
		
		System.out.println("1 : ratio -> " + String.valueOf(ratio.get(top3)) + ", graine -> " + graine.get(top3));
		System.out.println("2 : ratio -> " + String.valueOf(ratio.get(top2)) + ", graine -> " + graine.get(top2));
		System.out.println("3 : ratio -> " + String.valueOf(ratio.get(top1)) + ", graine -> " + graine.get(top1));
		
	}
	
	
}
