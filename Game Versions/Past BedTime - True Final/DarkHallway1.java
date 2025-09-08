import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DarkHallway1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DarkHallway1 extends Room
{
    public int lightTick=0;
    //List<LightningFlash> lights;
    LightningFlash flash1;
    LightningFlash flash2;
    /**
     * Constructor for objects of class DarkHallway1.
     * 
     */
    public DarkHallway1(Player playerObj, Door door, Entity entity)
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 200, 1, 2, playerObj, door, entity); 
        
        if (door.id == -1) {
            addObject(playerObj,100,100);
        }
        if (door.id == -6) {
            addObject(playerObj,1100,100);
        }
        if (door.id == -8) {
            addObject(playerObj,1100,100);
        }
        
        
        prepare();
    }
    private void prepare()
    {
        Door door2d = new Door(-2);
        door2d.setRotation(270);
        addObject(door2d, 4,100);
        Door door5d = new Door(-5);
        door5d.setRotation(90);
        addObject(door5d, 1196,100);
    }
    
    public void act() {
        lightning();     
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
