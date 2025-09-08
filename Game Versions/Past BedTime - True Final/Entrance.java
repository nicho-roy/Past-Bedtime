import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Entrance here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entrance extends Room
{
    
    /**
     * Constructor for objects of class Entrance.
     * 
     */
    public Entrance(Player playerObj, Door door, Entity entity)
    {
        super(400, 600, 1, 13, playerObj, door, entity); 
        
        if (door.id == 2000) {
            addObject(playerObj,200,100);
        }
        if (door.id == 11) {
            addObject(playerObj,200,500);
        }
        prepare();
    }
    
    public void prepare() {
        Door door12 = new Door(12);
        door12.setRotation(180);
        addObject(door12, 200, 592);
        
        Door exit = new Door(1000);
        exit.setImage("ExitDoor.png"); 
        addObject(exit, 200,18);
    }
    
    public void act() {
        chasing();    
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,200,592);
    }
}
