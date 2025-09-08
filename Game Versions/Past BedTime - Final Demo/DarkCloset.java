import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class DarkCloset here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkCloset extends Room
{

    /**
     * Constructor for objects of class DarkCloset.
     * 
     */
    public DarkCloset(Player playerObj, Door door, Entity entity)
    {
        super(600, 200, 1, 3, playerObj, door, entity); 
        //entity = entity;
        if (door.id == -3) {
            addObject(playerObj,100,100);
        }
        prepare();
    }
    
    public void prepare() {
        Door door4d = new Door(-4);
        door4d.setRotation(270);
        addObject(door4d, 8,100);
        
        //wrench item spawn
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.wrench==false) {
                Wrench wrench = new Wrench();
                addObject(wrench,550,100);
            }
        }
        
        //showText("Its way to dark to see, but I swear I left something important here...", 300, 100);
        showText("Found the wrench, but I swear I left something else here...", 300, 150);
    }
}
