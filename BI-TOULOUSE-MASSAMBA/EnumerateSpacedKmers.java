import java.util.ArrayList;
import java.util.HashSet;

public class EnumerateSpacedKmers {

	HashSet<String> listeGraines;
	
	public static void main(String[] args) {
		int poids = Integer.parseInt(args[0]);
		int longueur = Integer.parseInt(args[1]);
		ArrayList<String> resultat1 = traitsCont(poids,longueur);
		ArrayList<String> resultat2 = traitsCent(poids,longueur);
		ArrayList<String> resultat3 = alterne(poids, longueur);
		ArrayList<String> resultat4 = traitsCroi(poids, longueur);
		HashSet<String> reponse = new HashSet<>();
		reponse.addAll(resultat1);
		reponse.addAll(resultat2);
		reponse.addAll(resultat3);
		reponse.addAll(resultat4);
		for (String string : reponse)
			System.out.println(string);
	}
	
	
	public EnumerateSpacedKmers(int poids, int longueur) {
		ArrayList<String> resultat1 = traitsCont(poids,longueur);
		ArrayList<String> resultat2 = traitsCent(poids,longueur);
		ArrayList<String> resultat3 = alterne(poids, longueur);
		ArrayList<String> resultat4 = traitsCroi(poids, longueur);
		HashSet<String> reponse = new HashSet<>();
		reponse.addAll(resultat1);
		reponse.addAll(resultat2);
		reponse.addAll(resultat3);
		reponse.addAll(resultat4);
		listeGraines = reponse;
	}
	
	
	public static ArrayList<String> traitsCont(int poids, int longueur) {
		ArrayList<String> resultat1 = new ArrayList<String>();
		for (int i=poids; i<longueur+1; i++) {
			char[] tab = new char[i];
			for (int k=0; k<i; k++) {
				tab[k] = '#';
			}
			
			char[] temp = tab.clone();
			
			for (int n=0; n<poids; n++) {
				for (int j=1; j<i-poids+1; j++) {
					temp[j+n] = '-';
				}
				if (temp[i-1] != '-') {
					resultat1.add(String.valueOf(temp));
					resultat1.add(reverse(String.valueOf(temp)));
				}
				temp = tab.clone();
			}
		}
		
		/*char[] tab1 = new char[poids];
		for (int k=0; k<poids; k++) {
			tab1[k] = '#';
		}
		resultat2.add(String.valueOf(tab1));*/
		
		for (int i=poids+1; i<longueur+1; i++) {
			char[] tab = new char[i];
			for (int k=0; k<i; k++) {
				tab[k] = '#';
			}
			tab[1] = '-';
			
			char[] temp = tab.clone();
			
			for (int n=0; n<poids-1; n++) {
				for (int j=2; j<i-poids+1; j++) {
					temp[j+n] = '-';
				}
				resultat1.add(String.valueOf(temp));
				resultat1.add(reverse(String.valueOf(temp)));
				temp = tab.clone();
			}
			
			
		}
		return resultat1;
	}
	
	public static ArrayList<String> traitsCent(int poids, int longueur) {
		ArrayList<String> resultat2 = new ArrayList<String>();
		
		for (int i=poids+1; i<longueur+1; i++) {
			char[] tab = new char[i];
			for (int k=0; k<i; k++) {
				tab[k] = '#';
			}
			
			int cpt = i;
			char[] temp = tab.clone();
			int a = 1;
			while (cpt > poids) {
				
				if (cpt > poids) {
					temp[a] = '-';
					cpt--;
				}
				
				if (cpt > poids) {
					temp[i-a-1] = '-';
					cpt--;
				}
				a++;
			}
			resultat2.add(String.valueOf(temp));
			resultat2.add(reverse(String.valueOf(temp)));
			temp = tab.clone();
		}
		return resultat2;
	}
	
	
	public static ArrayList<String> alterne(int poids, int longueur) {
		ArrayList<String> resultat3 = new ArrayList<String>();
		for (int i=poids+1; i<2*poids; i++) {
			char[] tab = new char[i];
			for (int k=0; k<i; k++) {
				tab[k] = '#';
			}
			
			char[] temp = tab.clone();
			int j = 0;
			int cpt = i;
			while ((j*2+1<i-1) && (cpt>poids)) {
				temp[j*2+1] = '-';
				cpt--;
				j++;
			}
			if (temp.length <= longueur) {
				resultat3.add(String.valueOf(temp));
				resultat3.add(reverse(String.valueOf(temp)));
			}
		}
		
		return resultat3;
	}
	
	
	public static ArrayList<String> traitsCroi(int poids, int longueur) {
		ArrayList<String> resultat4 = new ArrayList<String>();
		
		for (int i=2; i<poids; i++) {
			for (int j=1; j<poids-1; j++) {
				ArrayList<String> base1 = traitsCont(poids-j,longueur-i);
				ArrayList<String> base2 = traitsCent(poids-j,longueur-i);
				ArrayList<String> base3 = alterne(poids-j, longueur-i);
				for (String string : base1) {
					String temp ="";
					for (int k=1; k<j+1; k++)
						temp = temp.concat("#-");
					temp = temp.concat(string);
					if (temp.length() <= longueur) {
						resultat4.add(temp);
						resultat4.add(reverse(temp));
					}
				}
				
				for (String string : base2) {
					String temp2 ="";
					for (int k=1; k<j+1; k++)
						temp2 = temp2.concat("#-");
					temp2 = temp2.concat(string);
					if (temp2.length() <= longueur) {
						resultat4.add(temp2);
						resultat4.add(reverse(temp2));
					}
				}
				
				for (String string : base3) {
					String temp3 ="";
					for (int k=1; k<j+1; k++)
						temp3 = temp3.concat("#-");
					temp3 = temp3.concat(string);
					if (temp3.length() <= longueur) {
						resultat4.add(temp3);
						resultat4.add(reverse(temp3));
					}
				}
				
			}
		}
		return resultat4;
	}
	
	
	public static String reverse(String mot) {
		char[] temp = new char[mot.length()];
		for (int i=0; i<mot.length(); i++) {
			temp[i] = mot.charAt(mot.length()-1-i);
		}
		
		return String.valueOf(temp);
	}
	
}
