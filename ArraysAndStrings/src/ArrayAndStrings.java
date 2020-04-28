import java.util.ArrayList;

public class ArrayAndStrings {

	public ArrayList<String> merge(String[] words, String[] more){
		ArrayList<String> sentence = new ArrayList<String>();
		for (String w : words) sentence.add(w);
		for (String w : more) sentence.add(w);
		return sentence;
	}
	
	public String joinWords(String[] words) {
		String sentence = "";
		for (String w : words) {
			sentence = sentence + w;
		}
		return sentence;
	}
	
	public String joinWordsWithStringBuilder(String[] words) {
		StringBuilder sentence = new StringBuilder();
		for (String w : words) {
			sentence.append(w);
		}
		return sentence.toString();
	}
}
