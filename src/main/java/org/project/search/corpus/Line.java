package org.project.search.corpus;

import java.util.ArrayList;
import java.util.List;

/**
 * Line class.
 * This class is used to process the lines from file.
 * Need to modify code in future.
 */
public class Line {

	/** The str. */
	String str;

	/**
	 * Instantiates a new line.
	 *
	 * @param str the str
	 */
	public Line(String str) {
		this.str = str;
	}

	/**
	 * Process line.
	 * New instantiated line is broken into an array by splitting on space.
	 * Add the words in List<String>
	 * return the array of the list 
	 * @return the List<String>
	 */
	public List<String> processLine() {

		String[] words = str.split(" ");
		List<String> wordList = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > 0) {
				wordList.add(words[i].toLowerCase());
			}
		}
		return wordList;
	}

}
