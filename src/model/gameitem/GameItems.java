package model.gameitem;

import model.monster.Monster;

public interface GameItems {
    /**
     * This function returns the name of GameItem
     * 
     * @return GameItem's name
     */
    String getNameItem();

    /**
     * This function returns the type of GameItem
     *
     * @return GameItem's type
     */
    GameItemTypes getType();

    /**
     * This function returns if GameItem is used
     * 
     * @param monster
     * @return if GameItem is used
     */
    boolean use(Monster m);

    /**
     * This function returns the quantity of GameItem
     * 
     * @return GameItem's quantity
     */
    int getNumber();

    /**
     * This function updates Item's quantity
     * 
     * @param new quantity
     */
    void setNumber(int i);
}