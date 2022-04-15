package model.player;

import java.util.List;

import model.monster.Monster;

public interface MonsterStorage {

    /**
     * 
     * this function adds a monster in storage if current box isn't full
     * 
     * @param monster to add in storage
     */
    public void addMonster(Monster monster);

    /**
     * this function tries to deposit a monster in the current monster box and to
     * remove the monster form player team
     * 
     * @param monster to deposit
     * @return true if is deposited, false otherwise
     */
    public boolean depositMonster(Monster monster);

    /**
     * this function tries to remove a monster from the current box and to add it in
     * player team
     * 
     * @param monsterID
     * @return true if monster has been added in player team and removed from box,
     *         false otherwise
     */
    public boolean withdrawMonster(int monsterID);

    /**
     * this function tries to exchange two monsters from player team to current box
     * 
     * @param monster   to add in storage
     * @param monsterID to add in player team
     * @return true if the exchange was completed
     */
    public boolean exchange(Monster monster, int monsterID);

    /**
     * 
     * this function changes current box with the next one
     */
    public void nextBox();

    /**
     *
     * this function changes current box with the previous one
     */
    public void previousBox();

    /**
     * 
     * @return current box name
     */
    public String getCurrentBoxName();

<<<<<<< HEAD
	/**
	 * 
	 * @return current box monsters list
	 */
	public List<Monster> getCurrentBoxMonsters();
	public int getMaxSizeOfBox();
	public int getMaxNumberOfBox();
	public int currentBoxSize();
=======
    /**
     * 
     * @return current box monsters list
     */
    public List<Monster> getCurrentBoxMonsters();

    /**
     * 
     * @return maximum number of box
     */
    int getMaxSizeOfBox();

    /**
     * 
     * @return maximum number of monster in each box
     */
    int getMaxNumberOfBox();
>>>>>>> cb2a10a1d50782eeac516ac08b02f601552d39d8
}
