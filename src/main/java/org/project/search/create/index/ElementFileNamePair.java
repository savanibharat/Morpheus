package org.project.search.create.index;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.project.search.corpus.Word;
import org.project.staticfactory.StaticFactory;

/**
 * The Class ElementFileNamePair.
 */
public class ElementFileNamePair implements ElementFileName {

	/** The files. */
	private List<File> files;

	/** The map. */
	private HashMap<String, List<File>> map = StaticFactory.newMapInstance();

	/**
	 * Indexing.
	 *
	 * @param word
	 *            the word
	 * @param file
	 *            the file
	 * @return the map
	 */
	private Map<String, List<File>> indexing(List<String> word, File file) {

		for (int i = 0; i < word.size(); i++) {
			if (map.containsKey(word.get(i))) {
				files=map.get(word.get(i));
				if (!files.contains(file)) {
					files.add(file);
					map.put(word.get(i), files);
				}
			} else {
				List<File> list = new ArrayList<File>(Arrays.asList(file));
				map.put(word.get(i), list);
			}
		}
		return map;
	}

	/**
	 * Generate index.
	 *
	 * @param word
	 *            the word
	 * @param file
	 *            the file
	 * @return the map
	 */
	public Map<String, List<File>> generateIndex(List<String> word, File file) {

		return indexing(word, file);
	}

   /**
	 * 
	 * @see
	 * org.project.search.create.index.ElementFileName#elementInFiles(java.lang
	 * .String)
	 */
	public List<File> elementInFiles(String str) {

		if (map.isEmpty()) {
			return null;
		}

		return map.get(str);
	}

	/**
	 * 
	 * @see
	 * org.project.search.create.index.ElementFileName#elementExists(java.lang
	 * .String)
	 */
	public boolean elementExists(String str) {
		return map.containsKey(str);
	}

	/**
	 * 
	 * @see
	 * org.project.search.create.index.ElementFileName#returnElementFileNamesPair
	 * (java.lang.String)
	 */
	public Map<String, List<File>> returnElementFileNamesPair() {
		if (!map.isEmpty()) {
			return map;
		}
		return null;
	}

	/**
	 * Size.
	 *
	 * @return the int
	 */
	public int size() {
		return map.size();

	}

}