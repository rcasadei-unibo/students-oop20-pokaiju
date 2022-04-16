package model.npc;

import java.util.List;
import java.util.Optional;

import model.Pair;
import model.battle.Moves;
import model.monster.Monster;
import model.player.Player;

public class NpcHealerImpl extends NpcSimpleImpl {

	private Player player;

	public NpcHealerImpl(String name, List<String> sentences, Pair<Integer, Integer> position, Player player,
			boolean isVisible, boolean isEnabled) {
		super(name, TypeOfNpc.HEALER, sentences, position, isVisible, isEnabled);
		this.player = player;
	}

	private void heal() {
		for (Monster monster : this.player.getAllMonsters()) {
			monster.setHealth(monster.getMaxHealth());
			for (Moves move : monster.getAllMoves()) {
				monster.restoreMovePP(move);
			}
		}

	}

	@Override
	public Optional<String> interactWith(){
		Optional<String> result = super.interactWith();
		if (isEnabled()) {
			heal();
		}
		return result;

	}

}
