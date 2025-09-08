import greenfoot.*;
import java.util.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    
    private Vector2D velocity;
    private Vector2D acceleration;
    public void act()
    {
        kill();
        move(35);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
        }
        
    public void kill()
        {
            Actor bandit = getOneIntersectingObject(Bandit.class);
            if(bandit != null){
                World world = getWorld();
                world.removeObject(bandit);
            }
        }
        
    }