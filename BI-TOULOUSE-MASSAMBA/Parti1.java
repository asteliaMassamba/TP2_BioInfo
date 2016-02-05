import java.util.ArrayList;


public class Parti1 {

	public static void main(String[] args) {
		int l = Integer.parseInt(args[0]);
		int s = Integer.parseInt(args[1]);
		ReadFile rf = new ReadFile(args[2]);
		ArrayList<ArrayList<String>> fileParse= rf.getTab();
		afficheWindows(windows(l,s,fileParse.get(1).get(0)), s);
		
		

	}
	
	public static void afficheWindows(ArrayList<String> windows,int shift){
		int idx = 1;
		for (String string : windows) {
			System.out.println(idx+"\t"+string+"\t"+(idx+string.length()-1));
			idx+=shift;
			
		}
	}
	
	
	public static ArrayList<String> windows (int longueur, int shift, String sequence) {
		ArrayList<String> mapper= new ArrayList<>();
		int nbF=1;
		String tmp=sequence;
		String buff="";
		while(tmp.length()>longueur){
			nbF++;
			buff=tmp.substring(0,longueur);
			tmp=tmp.substring(shift);
			mapper.add(buff);
		}
		mapper.add(tmp);
		System.out.println(tmp);
		
		
		return mapper;
	}
	
	public Object mapperWindowsKmers(int lw,int sw,int lk,double sk,String f1,String f2){
		
		return null;
	}

}
