package org.project.search.dictionary.postagger;

import org.project.search.utils.StringUtils;

public class POSFactory {

	public PartOfSpeech getPartOfSpeech(final String name) {
		if (StringUtils.equals(name, ConstantValues.NOUN)) {
			return new Noun();
		} else if (StringUtils.equals(name, ConstantValues.ADVERB)) {
			return new Adverb();
		} else if (StringUtils.equals(name, ConstantValues.ADJECTIVE)) {
			return new Adjective();
		} else if (StringUtils.equals(name, ConstantValues.VERB)) {
			return new Verb();
		}
		return null;
	}
}
