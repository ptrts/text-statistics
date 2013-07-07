public class WordData implements Comparable<WordData> {
	private String word;
	private int count = 0;

	WordData(String word) {
		this.word = word;
	}

	public String getWord() {
		return word;
	}

	public int getCount() {
		return count;
	}

	public void incrementCount() {
		count++;
	}

	@Override
	public String toString() {
		return word + ": " + count;
	}

	@Override
	public int compareTo(WordData wordData) {
		if (count < wordData.count) {
			return 1;
		} else if (count == wordData.count) {
			return word.compareTo(wordData.word);
		} else {
			return -1;
		}
	}
}
