import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFile {
	private BufferedReader br;
	private ArrayList<Sequence> tab = new ArrayList<>();
	
	public ReadFile(String path) {
		try{
			File file = new File(path);
			FileReader fr = new FileReader(file);
			this.br = new BufferedReader(fr);
			System.out.println(path);
			split();
		}catch (IOException e){
			System.out.println("file not found");
		}
	}

	private void split() throws IOException{
		String tmp = new String();
		
		int i = 0;	
		
		while((tmp = br.readLine())!=null){	
			if (tmp.length()>0){
				if (tmp.charAt(0)=='>') {
					
					//incrémentation de i si le tableau contien déja au moins une sequence
					if (tab.size()>0)
						i++;
	
					// dans tous les cas on ajoute la nouvelle sequence
					tab.add(new Sequence(tmp,""));	
								
				}				
				else{
					// dans le cas ou le fichier ne contiens pas d'id de sequence
					if (tab.isEmpty()){
						throw new IOException("bad file content : file must begin with a sequence id");
					}
					tab.get(i).setPhrase(tab.get(i).getPhrase().concat(tmp));
				}
			}
		}
		
	}
	
	public ArrayList<Sequence> getTab(){
		return tab;
	}
	
	
	
}
