import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Closet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Closet extends Room
{

    /**
     * Constructor for objects of class Closet.
     * 
     */
    public Closet(Player playerObj, Door door, Entity entity)
    {
        super(600, 200, 1, 7, playerObj, door, entity); 
        //entity = entity;
        if (door.id == 3) {
            addObject(playerObj,100,100);
        }
        prepare();
        
        //change entity location after a chase
        if (entity.chase==true) {
            entity.location=2;
        }
        
        entity.chase=false;
    }
      
    public void prepare() {
        Door door4 = new Door(4);
        door4.setRotation(270);
        addObject(door4, 8,100);
        
        //FIX=====
        
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.door7Key==false) {
                Key breakerKey = new Key();
                addObject(breakerKey,550,100);
            }
        }
        
        showText("I feel safe here", 300, 50);
    }
}
