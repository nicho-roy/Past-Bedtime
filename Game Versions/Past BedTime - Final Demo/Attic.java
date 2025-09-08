import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Attic here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Attic extends Room
{

    /**
     * Constructor for objects of class Attic.
     * 
     */
    public Attic(Player playerObj, Door door, Entity entity)
    {
        super(700, 300, 1, 14, playerObj, door, entity);
        
        if (door.id == 9) {
            addObject(playerObj,100,100);
        }
        
        
        furniture();
        prepare();
        
        showText("A perfect distraction...", 550, 180);
    }
    public void prepare() {
        Door door10 = new Door(10);
        door10.setRotation(270);
        addObject(door10, 8, 100);
        
        if (entity.location==3) {
            addObject(entity,650,100);
        }
        
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.shotgun==false) {
                Shotgun shotgun = new Shotgun();
                addObject(shotgun,600,250);
            }
        }    
    }
    public void furniture() {
        Alarm alarm = new Alarm();
        addObject(alarm, 650, 100);
        
        Num1 num1 = new Num1();
        addObject(num1, 650, 33);
    }
    
    public void act() {
        super.act();
        chasing();
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,2,100);
    }
}
