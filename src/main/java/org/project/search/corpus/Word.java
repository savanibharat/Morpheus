package org.project.search.corpus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.project.search.dictionary.postagger.Adjective;
import org.project.search.dictionary.postagger.Adverb;
import org.project.search.dictionary.postagger.Noun;
import org.project.search.dictionary.postagger.Verb;

public class Word {

	private String word;
	private Word[] words;
	private Collection<Word> wordCollection;
	private List<Noun> nouns = new ArrayList<Noun>();
	private List<Adverb> adverbs = new ArrayList<Adverb>();
	private List<Adjective> adjectives = new ArrayList<Adjective>();
	private List<Verb> verbs = new ArrayList<Verb>();

	public Word(String word) {
		this.word = word;
	}

	public Word(Word[] words) {
		this.words = words;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public Word[] getWords() {
		return words;
	}

	public void setWords(Word[] words) {
		this.words = words;
	}

	public void setWordCollection(Collection<Word> wordCollection) {
		this.wordCollection = wordCollection;
	}

	public Collection<Word> getWordCollection() {
		return wordCollection;
	}

	public void setNounList(Noun noun) {
		nouns.add(noun);
	}

	public List<Noun> getNouns() {
		return nouns;
	}

	public void setAdjectiveList(Adjective adj) {
		adjectives.add(adj);
	}

	public List<Adjective> getAdjectives() {
		return adjectives;
	}

	public void setAdverbList(Adverb adv) {
		adverbs.add(adv);
	}

	public List<Adverb> getAdverbs() {
		return adverbs;
	}

	public void setVerbList(Verb verb) {
		verbs.add(verb);
	}

	public List<Verb> getVerbs() {
		return verbs;
	}

	@Override
	public String toString() {
		return "\"nouns\":" + nouns + ", " + "\"adjectives\":" + adjectives
				+ ", " + "\"adverb\":" + adverbs + ", " + "\"Verb\": " + verbs
				+ " ";
	}
}
