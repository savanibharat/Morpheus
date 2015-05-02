package org.project.search.create.index;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface ElementFileName {

	List<File> elementInFiles(String str);

	boolean elementExists(String str);

	Map<String, List<File>> returnElementFileNamesPair();
}
