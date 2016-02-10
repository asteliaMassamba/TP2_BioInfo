import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;

public class ListSpacedKmers {
	private ArrayList<ArrayList<String>> tab1;
	private static ArrayList<String> kmer1;
	
	public ListSpacedKmers() {
		
	}
	
	
	public ListSpacedKmers(String[] args){
		int longueur= args[0].length();
		ReadFile f1 = new ReadFile(args[1]);
		tab1=f1.getTab();
		kmer1=list(longueur,tab1.get(1).get(0));
		
		kmer1=interpret(kmer1, args[0]);
		
	}
	
	
	public ArrayList<String> listNoDoub(int longueur,String phrase){
		
			ArrayList<String> kmer = list(longueur, phrase);
			Set<String> s = new HashSet<>();
			s.addAll(kmer);
			kmer=new ArrayList<>(s);
			return kmer;			
	}
	
	private ArrayList<String> list(int longueur,String phrase){
		
		ArrayList<String> kmer = new ArrayList<>();
		for(int i =0;i<=(phrase.length()-longueur);i++){
			String tmp = phrase.substring(i, i+longueur);
			kmer.add(tmp);
		}
		return kmer;			
	}
	
	public ArrayList<String>interpret(ArrayList<String>kmer ,String Graine){
		ArrayList<String> result = new ArrayList<>();
		char graine2[] = Graine.toCharArray();
		for (String string : kmer) {
			char[] tmp = string.toCharArray();
			for (int i=0;i<graine2.length;i++){
				if (graine2[i]=='-'){
					tmp[i]=' ';
				}
			}
			
			String st = new String(tmp);
			
			st=st.replaceAll(" ", "");
			
			result.add(st);
		}
		return result;		
	}
	
	public void afficherKmer(ArrayList<String> kmer){
		for (String string : kmer) {
			System.out.println(string);
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ListSpacedKmers k = new ListSpacedKmers(args);
		for (String string : kmer1) {
			System.out.println(string);
		}
	}
}


