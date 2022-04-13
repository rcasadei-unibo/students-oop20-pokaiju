package model.gameitem;

/**
 * Type of gameitem
 * 
 * @author Guo jiahao
 */
public enum GameItemTypes {
    /**
     * Restore Life point
     * 
     */
    HEAL("Heal", true, true),
    /**
     * it's used to evolve monster
     * 
     */
    EVOLUTIONTOOL("EvolutionTool", false, true),
    /**
     * it's used to catch monster
     * 
     */
    MONSTERBALL("MonsterBall", true, false);

    private final String name;
    private boolean useBattle;
    private boolean useBag;

    GameItemTypes(String name, boolean useBattle, boolean useBag) {
	this.name = name;
	this.useBattle = useBattle;
	this.useBag = useBag;
    }

    public String toString() {
	return this.name;
    }

    boolean isConsumableInBag() {
	return useBag;
    }

    boolean isConsumableInBattle() {
	return useBattle;
    }
}
