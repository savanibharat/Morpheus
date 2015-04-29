package org.project.search.collect.files;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to collect all files from folder. 
 * We are sorting the collected files based on filename.
 * */
public class FilesCollector {

	
	/** The path. */
	String path;
	
	/**
	 * Instantiates a new files collector.
	 *
	 * @param path the path
	 */
	public FilesCollector(String path) {
		this.path = path;
	}

	/**
	 * Gets the files from path.
	 *
	 * @param path the path
	 * @return the files from path
	 */
	private List<File> getFilesFromPath(String path) {

		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();
		List<File> fileList = new ArrayList<File>();
		
		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				fileList.add(listOfFiles[i]);
			} 
			else if (listOfFiles[i].isDirectory()) {
				return getFilesFromPath(listOfFiles[i].getAbsolutePath());
			}
		}
		return fileList;
	}

	/**
	 * Gets the files.
	 *
	 * @return the files
	 */
	public List<File> getFiles() {
		List<File> fileList = getFilesFromPath(path);
		sortFiles(fileList);
		return fileList;
	}

	/**
	 * Sort files.
	 *
	 * @param fileList the file list
	 * @return the list
	 */
	private List<File> sortFiles(List<File> fileList) {
		Collections.sort(fileList);
		return fileList;
	}
}
