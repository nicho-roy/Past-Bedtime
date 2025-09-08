import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkBasement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkBasement extends Room
{

    /**
     * Constructor for objects of class DarkBasement.
     * 
     */
    public DarkBasement(Player playerObj, Door door, Entity entity)
    {
        super(1000, 600, 1, 1, playerObj, door, entity);
        
        furniture();
        if (door.id == 0) {
            addObject(playerObj,200,390);
        }
        if (door.id == -2) {
            addObject(playerObj,900,100);
        }
        if (door.id == -4) {
            addObject(playerObj,900,500);
        }
        prepare();
    }
    private void furniture() {
        TV tv = new TV();
        tv.setImage("TVoff.png");
        addObject(tv,152,408);
        Couch couch = new Couch();
        addObject(couch,270,400);
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Door door1d = new Door(-1);
        door1d.setRotation(90);
        addObject(door1d, 990,100);
        Door door3d = new Door(-3);
        door3d.setRotation(90);
        addObject(door3d, 990,500);
        
        showText("Power outage again?!?", getWidth() / 2, 80);
        showText("Now I can barely see past my own nose... guess I should fix the breaker.", getWidth() / 2, 100);
    }
}

