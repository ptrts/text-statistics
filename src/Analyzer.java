import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Analyzer {

	private Map<String, WordData> mapWords = new TreeMap<>();

	private List<WordData> listWords = new LinkedList<>();

	private StringBuilder wordBuilder = new StringBuilder();

	private int wordsCount = 0;

	private void processCharacter(int c) {
		if (Character.isLetterOrDigit(c)) {
			Character charC = Character.toChars(c)[0];
			wordBuilder.append(charC);
		} else if (wordBuilder.length() != 0) {

			wordsCount++;

			String word = wordBuilder.toString().toUpperCase();

			WordData wordData = mapWords.get(word);

			if (wordData == null) {
				wordData = new WordData(word);
				listWords.add(wordData);
				mapWords.put(wordData.getWord(), wordData);
			}

			wordData.incrementCount();

			wordBuilder.setLength(0);
		}
	}

	public void analyze(BufferedReader bufferedReader, PrintWriter printWriter) throws IOException {

		int intC = bufferedReader.read();

		while (intC != -1) {
			processCharacter(intC);
			intC = bufferedReader.read();
		}

		processCharacter(intC);

		Collections.sort(listWords);

		printWriter.println("Rating;Word;Count;Percent");

		int i = 0;

		for (WordData wordData : listWords) {
			double percent = ((double) wordData.getCount()) / wordsCount * 100;
			percent = ((double) Math.round(percent * 100)) / 100;
			printWriter.format("%d;%s;%d;%f%n", ++i, wordData.getWord(), wordData.getCount(), percent);
		}
	}
}
