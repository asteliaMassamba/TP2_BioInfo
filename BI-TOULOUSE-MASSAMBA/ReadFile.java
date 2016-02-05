
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	private BufferedReader br;
	private ArrayList<ArrayList<String>> tab = new ArrayList<>();
	
	public ReadFile(String path) {
		try{
			File file = new File(path);
			FileReader fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			split();
		}catch (IOException e){
			System.out.println("file not found");
		}
	}

	private void split() throws IOException{
		tab.add(new ArrayList<String>());
		tab.add(new ArrayList<String>());
		tab.get(1).add("");
		String tmp = new String();
		int i = 0;
		while((tmp = br.readLine())!=null){
			
			if (tmp.length()>0){
				if (tmp.charAt(0)=='>') {
					tab.get(0).add(tmp.substring(1));
					if(!tab.get(1).get(i).equals("")){
						i++;
						tab.get(1).add("");
					}
				}
				else{					
					tab.get(1).set(i,tab.get(1).get(i).concat(tmp));
				}
			}
		}
		
	}
	
	public ArrayList<ArrayList<String>> getTab(){
		return tab;
	}
	
	
	
}
