package org.project.staticfactory;

import java.util.HashMap;

public class StaticFactory {

	public static <K, V> HashMap<K, V> newMapInstance() {
		return new HashMap<K,V>();
	}

}
