import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class Hallway2 extends Room
{
    public int lightTick=0;
    //List<LightningFlash> lights;
    LightningFlash flash1;
    LightningFlash flash2;
    /**
     * Constructor for objects of class Hallway2.
     */
    public Hallway2(Player playerObj, Door door, Entity entity) // Player player
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 200, 1, 10, playerObj, door, entity); 
        //entity = entity;
        
        /*StairwayLight light = new StairwayLight();
        addObject(light, 1100, 33);
        */
        
        furniture();
        prepare();
        
        if (door.id == 13) {
            addObject(playerObj,1100,100);
        }
        if (door.id == 16) {
            addObject(playerObj,100,100);
        }
        
        //entity.chase=true;
    }
    
    public void act() {
        lightning();
        chasing();
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,2,100);
    }
    
    public void furniture() {
        Carpet carpet = new Carpet();
        addObject(carpet, getWidth() / 2, getHeight() / 2);
        
        Num6 num6 = new Num6();
        addObject(num6, (getWidth() / 2)-280, (getHeight() / 2)-55 );
    }
    public void prepare() {
        Door door14 = new Door(14);
        door14.setRotation(90);
        addObject(door14, 1196,100);
        
        Door door15 = new Door(15);
        door15.setRotation(270);
        addObject(door15, 8,100);
    }
    
    public void lightning() {
        lightTick++;
        if (lightTick==100) {
            LightningFlash newflash1 = new LightningFlash();
            flash1 = newflash1;
            addObject(newflash1, 200, 50);
            LightningFlash newflash2 = new LightningFlash();
            flash2 = newflash2;
            addObject(newflash2, 1000, 50);
        }
        if (lightTick==105) {
            if (flash1 != null) removeObject(flash1);
            if (flash2 != null) removeObject(flash2);
        }
        if (lightTick==110) {
            LightningFlash newflash1 = new LightningFlash();
            flash1 = newflash1;
            addObject(newflash1, 200, 50);
            LightningFlash newflash2 = new LightningFlash();
            flash2 = newflash2;
            addObject(newflash2, 1000, 50);
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
