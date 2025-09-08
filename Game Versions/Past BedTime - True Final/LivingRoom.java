import lang.stride.*;
import java.util.*;
import greenfoot.*;

/**
 * 
 */
public class LivingRoom extends Room
{
    //int chaseTick=0;
    /**
     * Constructor for objects of class LivingRoom.
     */
    public LivingRoom(Player playerObj, Door door, Entity entity)
    {
        super(800, 600, 1, 9, playerObj, door, entity); 
        
        
        if (door.id == 7) {
            addObject(playerObj,700,500);
        }
        if (door.id == 10) {
            addObject(playerObj,700,200);
        }
        if (door.id == 14) {
            addObject(playerObj,100,100);
        }
        if (door.id == 12) {
            addObject(playerObj,500,100);
        }
        
        furniture();
        prepare();
        
        
    }
    public void act() {
        chasing();     
    }
    
    private void furniture() {
        Num2 n2 = new Num2();
        addObject(n2, 790,8);
    }
    private void prepare() {
        Door door8 = new Door(8);
        door8.setRotation(180);
        addObject(door8, 700,596);
        
        Door door13 = new Door(13);
        door13.setRotation(270);
        addObject(door13, 4,100);
        
        Door door11 = new Door(11);
        addObject(door11, 500,8);
        
        /*
        Door doort9 = new Door(9);
        doort9.setRotation(90);
        addObject(doort9, 792, 200);
        */
        
        //==============FIX===========================================================================!!!!!!!
        List<Player> players = getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            
            if (player.door9Key==false) {
                LockedDoor lockedDoor = new LockedDoor();
                lockedDoor.setRotation(90);
                addObject(lockedDoor, 792, 200);
                showText("This door is locked", 700, 200);
            }
            else {
                Door door9 = new Door(9);
                door9.setRotation(90);
                addObject(door9, 792, 200);
            }
        }
    }
    public void chasing() {
        chaseTick++;
        if (entity.chase==true && chaseTick==100) addObject(entity,100,100);
    }
}
