package model.monster;

import java.util.Map;

public interface MonsterStats {
    
    /**
     * This function returns monster health
     * 
     * @return monster health
     */
    int getHealth();

    /**
     * This function set monster health
     * 
     * @param health
     */
    void setHealth(int health);

    /**
     * This function returns monster attack
     * 
     * @return monster attack
     */
    int getAttack();

    /**
     * This function set monster attack
     * 
     * @param monster attack
     */
    void setAttack(int attack);

    /**
     * This function returns monster defense
     * 
     * @return monster defense
     */
    int getDefense();

    /**
     * This function set monster defense
     * 
     * @param monster defense
     */
    void setDefense(int defense);

    /**
     * This function returns monster speed
     * 
     * @return monster speed
     */
    int getSpeed();

    /**
     * This function set monster speed
     * 
     * @param monster speed
     */
    void setSpeed(int speed);

    /**
     * This function returns monster stats as map
     * 
     * @return stats map
     */
    Map<String, Integer> getStatsAsMap();
}
