public class WordData implements Comparable<WordData> {
	public String word;
	public int count = 0;

	WordData(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return word+": "+count;
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
