import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class BasementSpawn extends Room
{

    /**
     * Constructor for objects of class livingRoom.
     */
    public BasementSpawn(Player playerObj, Door door, Entity entity)
    {
        super(1000, 600, 1, 5, playerObj, door, entity);
        
        furniture();
        if (door.id == 0) {
            addObject(playerObj,250,400);
        }
        if (door.id == 2) {
            addObject(playerObj,900,100);
        }
        if (door.id == 4) {
            addObject(playerObj,900,500);
        }
        prepare();
    }
    public void act() {
        chasing();
    }
    
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,950,100);
    }
    
    
    private void furniture() {
        TV tV = new TV();
        addObject(tV,152,408);
        Couch couch = new Couch();
        addObject(couch,270,400);
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        //furniture first
        
        
        /*
        Player hero = new Player();
        addObject(hero,510,363);
        */
        Door door1 = new Door(1);
        door1.setRotation(90);
        addObject(door1, 990,100);
        Door door3 = new Door(3);
        door3.setRotation(90);
        addObject(door3, 990,500);
    }
}
