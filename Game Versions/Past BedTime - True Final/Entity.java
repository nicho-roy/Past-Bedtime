import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
import java.util.Vector;


/**
 * Write a description of class Entity here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Entity extends Actor
{
    public final static double MOVESPEED = 4.5;
    public int moveTick;
    public int deathTick=0;
    public int playerX,playerY;
    public int x,y;
    
    private Vector2D move;
    
    //Entity location id
    public int location=1;
    
    //CHASE MODE (Temporarily true)
    public boolean chase = false;
    public boolean dead = false;
    //public static GreenfootSound chaseTheme = new GreenfootSound("Entity Sounds.mp3");
    
    
    public void act()
    {
        playerPos();
        getPosX();
        getPosY();
        
                
        Room world = (Room) getWorld();
        if (world.roomID == 14 ) {
            alarmTriggered();
        }
        else {
            if (dead==false) {
                move();
            }
        }
        
        if (dead==false) {
            sprite();
        }
        else {
            deathSequence();
        }
        
        distracted();
        death();
        kill();
    }
    
    public void move() {
        if (Player.class != null) {
            
            //set vector
            double difX = (playerX - getX());
            double difY = (playerY - getY());
            
            double magnitude = Math.sqrt( Math.pow(difX, 2) + Math.pow(difY, 2) );
            
            //Syntax
            /*
            double data = 52.6345
            Double newData = new Double(data);
            int value = newData.intValue();
            */
            
            double tempX = ( (1/magnitude) * difX );
            double tempY = ( (1/magnitude) * difY );
            
            
            //setup class
            Double newDataX = new Double(tempX) * MOVESPEED;
            int moveX = newDataX.intValue();
            
            Double newDataY = new Double(tempY) * MOVESPEED;
            int moveY = newDataY.intValue();
            
            
            //int moveX = ( (1/magnitude) * difX ); //move formula
            
            
            
            
            //moving
            setLocation(x + (moveX), y + (moveY ));
            
            
            /*
            //set vector
            Vector2D move = new Vector2D(playerX - getX(), playerY - getY());
            
            move.normalize();
            */
            
            /*
            move = Vector2D.multiply(move, MOVESPEED);
            Entity entity = new Entity();
            
            
            moving to player
            move = Vector.multiply(move, MOVESPEED);
            */
            
        }
    }
    public void alarmTriggered() {
        setLocation(x + 4, y);
    }
    
    public void death() {
        List<ShotgunBlast> blasts = getObjectsInRange(110, ShotgunBlast.class);
        if (blasts.size() == 0) return;
        ShotgunBlast blast = blasts.get(0);
        
        //Actor player = getOneIntersectingObject(Player.class);
        if (blast != null) {
            //SWITCH SPRITE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            setImage("EntityDead.png");
            dead=true;
            chase=false;
        }
    }
    public void deathSequence() {
        //DEATH SOUND???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????
        if (deathTick==180) {
            World world = getWorld();
            Greenfoot.setWorld( new  KillEntityEnding());
        }
        deathTick++;
    }
    
    public void distracted() {  
        Room room = (Room) getWorld();
        if ((room.roomID == 14 )) {
            location=3;
            chase=false;
        }
        
        /*
        List<Alarm> alarms = getObjectsInRange(800, Alarm.class);
            if (alarms.size() == 0) return;
            Alarm alarm = alarms.get(0);
            
            //Actor player = getOneIntersectingObject(Player.class);
            if ((alarm != null)) {
                //playsound
                location=3;
                chase=false;
            } 
        
         */
    }
    public void kill() {
        List<Player> players = getObjectsInRange(110, Player.class);
        if (players.size() == 0) return;
        Player player = players.get(0);
        
        //Actor player = getOneIntersectingObject(Player.class);
        if (player != null) {
            //transition to kill yourself =]
            World world = getWorld();
            HitMarker hit = new HitMarker();
            world.addObject(hit, 600, 600);
            world.removeObject(this);
            player.health--;
        }
    }
    public int getPosX() {
        x =getX();
        return x;
    }
    public int getPosY() {
        y =getY();
        return y;
    } 
    
    public void playerPos() {
        List<Player> players = getWorld().getObjects(Player.class);
        if (players.size() != 0) {
            Player player = players.get(0);
            //playerX = ((Player)getWorld().getObjects(Player.class).get(0)).getPosX();
            //playerY = ((Player)getWorld().getObjects(Player.class).get(0)).getPosY();
            playerX = (player.getPosX());
            playerY = (player.getPosY());
            
            //setLocation(playerX+200, playerY);
        }
    }
    public void sprite() {
        if (x > playerX) {
            if (moveTick==30) {
                setImage("EntityWalk1V2.png");
            }
            if (moveTick==60) {
                setImage("EntityWalk2V3.png");
                moveTick=0;
            }
        }
        else {
            if (moveTick==30) {
                setImage("EntityWalk1V2Right.png"); //////////////right sprite
            }
            if (moveTick==60) {
                setImage("EntityWalk2V3Right.png"); //////////////right sprite
                moveTick=0;
            }
        }
        moveTick++;
    }
}