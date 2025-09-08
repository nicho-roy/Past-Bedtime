import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Pantry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pantry extends Room
{

    /**
     * Constructor for objects of class Pantry.
     * 
     */
    public Pantry(Player playerObj, Door door, Entity entity)
    {
        super(600, 200, 1, 12, playerObj, door, entity);
        
        if (door.id == 17) {
            addObject(playerObj,500,100);
        }
        
        prepare();
    }
    
    public void act() {
        chasing();
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,500,8);
    }
    
    public void prepare() {
        Door door18 = new Door(18);
        addObject(door18, 500,8);
        
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.door9Key==false) {
                AtticKey atticKey = new AtticKey();
                addObject(atticKey,200,100);
            }
        }
        
        showText("This must be the key to the attic...", 300, 60);
    }
}
