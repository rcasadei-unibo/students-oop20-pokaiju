package model.npc;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Pair;
import model.monster.Monster;

public class NpcTrainerImpl extends NpcSimpleImpl implements NpcTrainer{

	List<Monster> monstersOwned;
	boolean isDefated = false;
	
	public NpcTrainerImpl(String name, TypeOfNpc typeOfNpc, ArrayList<String> sentences, ArrayList<Monster> monstersOwned, Pair<Integer,Integer> position) {
		super(name, typeOfNpc, sentences,position);
		this.monstersOwned = monstersOwned;
	}

	@Override
	public List<Monster> getMonstersOwned() {
		return this.monstersOwned;
	}

	@Override
	public boolean isDefeated() {
		return this.isDefated;
	}

	@Override
	public void setDefeated() {
		this.isDefated = true;
	}
	
	int battle() {										//----- DA IMPLEMENTARE -----
		return 0;
	}
	
	public Optional<String> interactWith() {
		if(!this.isDefated){
			int battleResult = battle();
			if(battleResult == 1) {					//----- FIXARE battleResult -----, Restituisce a prescidere cose
				setDefeated();	
			}
			return Optional.of("Bel combattimento");
		}
		else {
			Optional<String> result = Optional.of(this.sentences.get(0));
			return result;
		}
	}

}
