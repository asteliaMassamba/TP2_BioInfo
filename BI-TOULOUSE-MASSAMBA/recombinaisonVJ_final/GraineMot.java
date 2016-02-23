import java.util.HashSet;

public class GraineMot extends Graine{

	int longueur;
	String graine;
	
	public GraineMot(String graine) {
		this.graine = graine;
		this.longueur = graine.length();
	}
	
	public HashSet<String> liste(Sequence sequence){
		
		HashSet<String> kmer = new HashSet<String>();
		for(int i =0; i<(sequence.getPhrase().length() - this.longueur); i++){
			String tmp = sequence.getPhrase().substring(i, i+this.longueur).toLowerCase();
				kmer.add(tmp);
		}
		
		HashSet<String> result = new HashSet<>();
		char graine[] = this.graine.toCharArray();
		for (String string : kmer) {
			char[] tmp = string.toCharArray();
			for (int i=0;i<graine.length;i++){
				if (graine[i]=='-'){
					tmp[i]=' ';
				}
			}
			
			String st = new String(tmp);
			st=st.replaceAll(" ", "");
			result.add(st);
		}
		return result;		
	}
	
}
