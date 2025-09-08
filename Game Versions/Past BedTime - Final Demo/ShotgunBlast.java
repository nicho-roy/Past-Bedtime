import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class ShotgunBlast here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShotgunBlast extends Actor
{
    /**
     * Act - do whatever the ShotgunBlast wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveToEntity();
        killEntity();
    }
    public void moveToEntity() {
        List<Entity> entitys = getObjectsInRange(800, Entity.class);
        if (entitys.size() == 0) return;
        Entity entity = entitys.get(0);
        
        //Actor player = getOneIntersectingObject(Player.class);
        if (entity != null) {
            turnTowards(entity.getX(), entity.getY());
            move(80);
        }
    }
    public void killEntity() {
        List<Entity> entitys = getObjectsInRange(50, Entity.class);
        if (entitys.size() == 0) return;
        Entity entity = entitys.get(0);
        
        //Actor player = getOneIntersectingObject(Player.class);
        if (entity != null) {
            World world = getWorld();
            
            entity.dead=true;
            //world.removeObject(entity);
            world.removeObject(this);
        }
    }
}
