import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kitchen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kitchen extends Room
{

    /**
     * Constructor for objects of class Kitchen.
     * 
     */
    public Kitchen(Player playerObj, Door door, Entity entity)
    {
        super(700, 600, 1, 11, playerObj, door, entity);
        
        if (door.id == 15) {
            addObject(playerObj,600,300);
        }
        if (door.id == 18) {
            addObject(playerObj,200,500);
        }
        
        //furniture();
        prepare();
    }
    
    public void act() {
        super.act();
        chasing();
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,780,300);
    }
    
    public void furniture() {
        
    }
    public void prepare() {
        if (entity.location==1) {
            addObject(entity,20,250);
            entity.chase=true;
        }
        
        Door door16 = new Door(16);
        door16.setRotation(90);
        addObject(door16, 692 ,300);
        
        Door door17 = new Door(17);
        door17.setRotation(180);
        addObject(door17, 200 ,592);
    }
}
