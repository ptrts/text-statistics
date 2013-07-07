import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {

		InputStream inputStream = null;
		PrintWriter printWriter = null;

		try {

			inputStream = new FileInputStream(args[0]);
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			printWriter = new PrintWriter(args[1]);

			Analyzer analyzer = new Analyzer();
			analyzer.analyze(bufferedReader, printWriter);

		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (printWriter != null) {
				printWriter.close();
			}
		}
	}
}
