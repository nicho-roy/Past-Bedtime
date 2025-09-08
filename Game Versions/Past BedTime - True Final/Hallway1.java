import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class livingRoom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hallway1 extends Room
{
    public int lightTick=0;
    //List<LightningFlash> lights;
    LightningFlash flash1;
    LightningFlash flash2;
    
    ////public Entity entity;
    /**
     * Constructor for objects of class livingRoom.
     * 
     */
    public Hallway1(Player playerObj, Door door, Entity entity) // Player player
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 200, 1, 6, playerObj, door, entity); 
        //entity = entity;
        
        /*StairwayLight light = new StairwayLight();
        addObject(light, 1100, 33);
        */
        if (door.id == 1) {
            addObject(playerObj,100,100);
        }
        if (door.id == 6) {
            addObject(playerObj,1100,100);
        }
        if (door.id == 8) {
            addObject(playerObj,1100,100);
        }
        
        
        prepare();
        /*(if (playerObj.door == 1) {
            addObject(playerObj,100,0);
        }*/
        
    }
    private void prepare()
    {
        Door door2 = new Door(2);
        door2.setRotation(270);
        addObject(door2, 4,100);
        Door door5 = new Door(5);
        door5.setRotation(90);
        addObject(door5, 1196,100);
        
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.door7Key==false) {
                LockedDoor lockedDoor = new LockedDoor();
                addObject(lockedDoor, 1100, 6);
                showText("This door is locked", 1100, 12);
            }
            else {
                Door door7 = new Door(7);
                addObject(door7, 1100, 6);
            }
        }
        
        
        
        
        
        /*
        if (lightTick==200) {
            LightningFlash flash1 = new LightningFlash();
            removeObject(flash1);
        }
        */
    }
    
    public void act() {
        chasing();
        lightning();     
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,1100,100);
    }
    
    
    public void lightning() {
        lightTick++;
        if (lightTick==100) {
            LightningFlash newflash1 = new LightningFlash();
            flash1 = newflash1;
            addObject(newflash1, 400, 50);
            LightningFlash newflash2 = new LightningFlash();
            flash2 = newflash2;
            addObject(newflash2, 800, 50);
        }
        if (lightTick==105) {
            if (flash1 != null) removeObject(flash1);
            if (flash2 != null) removeObject(flash2);
        }
        if (lightTick==110) {
            LightningFlash newflash1 = new LightningFlash();
            flash1 = newflash1;
            addObject(newflash1, 400, 50);
            LightningFlash newflash2 = new LightningFlash();
            flash2 = newflash2;
            addObject(newflash2, 800, 50);
        }
        if (lightTick==125) {
            if (flash1 != null) removeObject(flash1);
            if (flash2 != null) removeObject(flash2);
        }
        if (lightTick==200) {
            lightTick=0;
        }
    }
}
