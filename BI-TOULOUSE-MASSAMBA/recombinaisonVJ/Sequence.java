package recombinaisonVJ;

public class Sequence {
	private String id;
	private String phrase;
	
	public Sequence() {
		this.id = "";
		this.phrase = "";
	}
	
	public Sequence(String id , String phrase){
		this.id=id;
		this.phrase=phrase;
	}
	
	public String getId() {
		return id;
	}
	
	public String getPhrase() {
		return phrase;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
	
	@Override
	public String toString() {
		return "\n"+id+"\n\t"+phrase+"\n";
	}
}
