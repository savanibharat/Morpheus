package org.project.search.processfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.project.search.collect.files.FilesCollector;
import org.project.search.corpus.Line;
import org.project.search.create.index.ElementFileNamePair;

/**
 * The Class ParseFile.
 */
public class ParseFile {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {
		/**
		 * Get a line 
		 * Remove punctuation's 
		 * Pass the string to Line.java 
		 * Break line to words and return words[] to Word.java 
		 * Change this section in FUTURE
		 * */

		FilesCollector files = new FilesCollector("Files");
		List<File> list = files.getFiles();
		System.out.println(list);
		ElementFileNamePair pairs = new ElementFileNamePair();
		double start = System.currentTimeMillis();
		for (int i = 0; i < list.size(); i++) {
			File currentFile = list.get(i);
			BufferedReader br = new BufferedReader(new FileReader(currentFile));
			String str = "";
			try {
				while ((str = br.readLine()) != null) {
					Line line = new Line(str.replaceAll("\\p{Punct}+", " "));
					List<String> words = line.processLine();
					pairs.generateIndex(words, currentFile);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				br.close();
				br = null;
			}

		}
		/*Set<Entry<String, List<File>>> set = pairs.returnElementFileNamesPair().entrySet();
		for (Entry<String, List<File>> entry : set) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}*/
		double end = System.currentTimeMillis();
		double seconds = (end - start) / 1000.0d;
		System.out.println("Time to index in milliseconds -> " + seconds);
		System.out.println("Word to File Name pairs -> " + pairs.size());
	}

}