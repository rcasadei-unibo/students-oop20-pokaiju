package model.map;

import java.util.Map;
import java.util.Optional;

import model.Pair;
import model.npc.Npc;

public class GameMapDataImpl implements GameMapData {
    private final String name;
    private final Map<Pair<Integer, Integer>, MapBlockType> blocks;
    private final Map<Pair<Integer, Integer>, Npc> npcs;
    private final Map<Pair<Integer, Integer>, GameMapData> linkedMaps;

    public GameMapDataImpl(String name, Map<Pair<Integer, Integer>, MapBlockType> blocks,
	    Map<Pair<Integer, Integer>, Npc> npcs, Map<Pair<Integer, Integer>, GameMapData> linkedMaps) {
	this.name = name;
	this.blocks = blocks;
	this.npcs = npcs;
	this.linkedMaps = linkedMaps;
    }

    @Override
    public MapBlockType getBlockType(Pair<Integer, Integer> block) {
	return blocks.containsKey(block) ? blocks.get(block) : MapBlockType.BORDER;
    }

    @Override
    public Optional<Npc> getNPC(Pair<Integer, Integer> block) {
	return npcs.containsKey(block) ? Optional.of(npcs.get(block)) : Optional.empty();
    }

    @Override
    public Optional<GameMapData> getNextMap(Pair<Integer, Integer> playerPosition) {
	return linkedMaps.containsKey(playerPosition) ? Optional.of(linkedMaps.get(playerPosition)) : Optional.empty();
    }

    @Override
    public String getName() {
	return this.name;
    }

}