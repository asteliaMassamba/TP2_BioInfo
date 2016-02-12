import java.util.ArrayList;

public class KmersOperation {
	private ArrayList<ArrayList<String>> tab1;
	private ArrayList<ArrayList<String>> tab2;
	private ArrayList<String> kmer1;
	private ArrayList<String> kmer2;
	private ArrayList<String> common;
	
	
	public KmersOperation(String[] args) {
		int longueur= Integer.parseInt(args[0]);
		ReadFile f1 = new ReadFile(args[1]);
		ReadFile f2 = new ReadFile(args[2]);
		tab1=f1.getTab();
		tab2=f2.getTab();
		

		
		//dans le tp1 les fichier n'ont qu'une seul sequence, le reste du traitement est basé sur ce fait
		ListKmer l=new ListKmer();
		kmer1=l.listNoDoub(longueur,tab1.get(1).get(0));
		
		kmer2=l.listNoDoub(longueur,tab2.get(1).get(0));
				
		compare();
		
	}
	
	

	public double ratio() {
		double nbCommon=0;
		nbCommon=(double)common.size()/kmer2.size();
		return nbCommon;
	}



	public void compare() {
		common=new ArrayList<>();
			for (String kmer : kmer1) {
				if(kmer2.contains(kmer)){
					common.add(kmer);
				}
			}
	}
	
	public ArrayList<String> getCommon() {
		return common;
	}

	

}
