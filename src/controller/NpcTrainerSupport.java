package controller;

import java.util.ArrayList;
import java.util.List;

import model.Pair;
import model.monster.Monster;
import model.npc.TypeOfNpc;

public class NpcTrainerSupport {

	private String name;
	private TypeOfNpc typeOfNpc;
	private List<String> sentences;
	private List<Integer> monstersOwned;
	private Pair<Integer, Integer> position;
	private boolean isVisible;
	private boolean isEnabled;
	private boolean isDefeated;

	public NpcTrainerSupport(String name, TypeOfNpc typeOfNpc, List<String> sentences, List<Integer> monstersOwned,
			boolean isVisible, boolean isEnabled, boolean isDefeated, Pair<Integer, Integer> position) {
		this.name = name;
		this.typeOfNpc = typeOfNpc;
		this.sentences = sentences;
		this.monstersOwned = monstersOwned;
		this.position = position;
		this.isVisible = isVisible;
		this.isDefeated = isDefeated;
		this.isEnabled = isEnabled;

	}

	public String getName() {
		return this.name;
	}

	public TypeOfNpc getTypeOfNpc() {
		return this.typeOfNpc;
	}

	public List<String> getSentences() {
		return this.sentences;
	}

	public Pair<Integer, Integer> getPosition() {
		return this.position;
	}
	
	public boolean getIsVisible() {
		return this.isVisible;
	}

	public boolean getIsEnabled() {
		return this.isEnabled;
	}

	public boolean getIsDefeated() {
		return this.isDefeated;
	}

	public List<Monster> getTranslatedMonsterList(List<Monster> list) {
		List<Monster> monster = new ArrayList<>();
		for (int id : this.monstersOwned) {
			for (Monster md : list) {
				if (md.getId() == id) {
					monster.add(md);
					break;
				}
			}
		}
		return monster;
	}
}
