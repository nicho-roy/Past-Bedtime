import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Garage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garage extends Room
{
    
    /**
     * Constructor for objects of class Garage.
     * 
     */
    public Garage(Player playerObj, Door door, Entity entity)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1, 8, playerObj, door, entity); 
        
        furniture();
        if (door.id == 5) {
            addObject(playerObj,100,100);
        }
        if (door.id == 100) {
            addObject(playerObj,600,30);
        }
        
        prepare();
        
        //testing
        //entity.chase=true;
    }
    
    
    public void act() {
        super.act();
        chasing();
        entityRush();
    }
    
    
    public void prepare() {
        if (entity.location==2) {
            addObject(entity,600,600);
            entity.chase=true;
        }
        
        
        Door door6 = new Door(6);
        door6.setRotation(270);
        addObject(door6, 4,100);
        
        
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.shotgunShells==false) {
                ShotgunShells shells = new ShotgunShells();
                addObject(shells,750,550);
            }
            if (player.shotgun==false) {
                showText("I have no use for these right now...", 600, 500);    
            }
            if (player.shotgun) {
                showText("Press SPACE to shoot", 650, 500);    
            }
        }    
    }
    public void furniture() {
        Breaker breaker = new Breaker();
        addObject(breaker, 600,22);
        
        Num8 num8 = new Num8();
        addObject(num8, 600,28);
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,100,100);
    }
    public void entityRush() {
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.shotgunShells) {
                addObject(entity,8,100);
                entity.chase=true;
            }
        }    
    }
}
