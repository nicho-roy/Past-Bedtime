import lang.stride.*;
import java.util.*;
import greenfoot.*;

public class Player extends Actor

{
    public int tick=0;
    //public int walkTick=0;
    public int runTick=0;
    public int x;
    public int y;
    public String face; 
    public int sprint=0;
    public int stam=50;
    public int health=3;
    
    //music code
    public static GreenfootSound creak = new GreenfootSound("DoorCreak.wav");
    public static GreenfootSound itemSound = new GreenfootSound("ItemPickup.mp3");
    
    public int door;
    
    //======ITEMS=======
    public boolean door7Key = false;
    public boolean wrench= false;
    public boolean door9Key = false;
    public boolean shotgun = false;
    public boolean shotgunShells = false;
    public boolean gunCooldown = true;
    
    
    public boolean gameOver=false;
    /**
     * Act - do whatever the player wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        //walk();
        //tick();
        //movement();
        if (stam>0) {
            sprint();
        } else {
            sprint=0;
        }
        getPosX();
        getPosY();
        moves();
        isMove();
        resetSprite();
        stamina();
        transitions();
        displayStatus();
        checkDeath();
        shoot();
        
        //ITEM PICKUPS
        pickupKey();
        pickupWrench();
        pickupAtticKey();
        pickupShotgun();
        pickupShells();
        
        //CHEAT CODES
    }
    
    public void transitions() {
        Room world = (Room) getWorld();
        Entity entity = world.entity;
        
        
        
        //Door door = (Door) getOneIntersectingObject(Door.class);
        List<Door> doors = getObjectsInRange(50, Door.class);
        if (doors.size() == 0) return;
        Door door = doors.get(0);
        
        //play doorcreak
        creak.setVolume(60);
        creak.play();
        
        if (door != null) {
            //PRE GAME DOORS
            if (door.id == -1) {
                Greenfoot.setWorld( new  DarkHallway1(this, door, entity));
            }
            if (door.id == -2) {
                Greenfoot.setWorld( new  DarkBasement(this, door, entity));
            }
            if (door.id == -3) {
                Greenfoot.setWorld( new  DarkCloset(this, door, entity));
            }
            if (door.id == -4) {
                Greenfoot.setWorld( new  DarkBasement(this, door, entity));
            }
            if (door.id == -5) {
                Greenfoot.setWorld( new  DarkGarage(this, door, entity));
            }
            if (door.id == -6) {
                Greenfoot.setWorld( new  DarkHallway1(this, door, entity));
            }
            if (door.id == 100 && wrench==true) {
                Greenfoot.setWorld( new  Garage(this, door, entity));
            }
            //MAIN GAME DOORS
            if (door.id == 1) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 2) {
                Greenfoot.setWorld( new  BasementSpawn(this, door, entity));
            }
            if (door.id == 3) {
                Greenfoot.setWorld( new  Closet(this, door, entity));
            }
            if (door.id == 4) {
                Greenfoot.setWorld( new  BasementSpawn(this, door, entity));
            }
            if (door.id == 5) {
                Greenfoot.setWorld( new  Garage(this, door, entity));
            }
            if (door.id == 6) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 7) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
            if (door.id == 8) {
                Greenfoot.setWorld( new  Hallway1(this, door, entity));
            }
            if (door.id == 9) {
                Greenfoot.setWorld( new  Attic(this, door, entity));
            }
            if (door.id == 10) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
            if (door.id == 11) {
                Greenfoot.setWorld( new  Entrance(this, door, entity));
            }
            if (door.id == 12) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
            if (door.id == 13) {
                Greenfoot.setWorld( new  Hallway2(this, door, entity));
            }
            if (door.id == 14) {
                Greenfoot.setWorld( new  LivingRoom(this, door, entity));
            }
            if (door.id == 15) {
                Greenfoot.setWorld( new  Kitchen(this, door, entity));
            }
            if (door.id == 16) {
                Greenfoot.setWorld( new  Hallway2(this, door, entity));
            }
            if (door.id == 17) {
                Greenfoot.setWorld( new  Pantry(this, door, entity));
            }
            if (door.id == 18) {
                Greenfoot.setWorld( new  Kitchen(this, door, entity));
            }
            if (door.id == 1000) {
                Greenfoot.setWorld( new  CodePanel(this, door, entity));
            }
        }
    }
    
    //ITEM PICKUPS
    public void pickupShells() {
        Actor ShotgunShells = getOneIntersectingObject(ShotgunShells.class);
        if (shotgun) {
            if (ShotgunShells != null) {
                World world = getWorld();
                world.removeObject(ShotgunShells);
                shotgunShells = true;
                itemSound.setVolume(35);
                itemSound.play();
            }
        }
    }
    public void pickupShotgun() {
        Actor Shotgun = getOneIntersectingObject(Shotgun.class);
        if (Shotgun != null) {
            World world = getWorld();
            world.removeObject(Shotgun);
            shotgun = true;
            itemSound.setVolume(35);
            itemSound.play();
        }
    }
    public void pickupKey() {
        Actor Key = getOneIntersectingObject(Key.class);
        if (Key != null) {
            World world = getWorld();
            world.removeObject(Key);
            door7Key = true;
            itemSound.setVolume(35);
            itemSound.play();
        }
    }
    public void pickupWrench() {
        Actor Wrench = getOneIntersectingObject(Wrench.class);
        if (Wrench != null) {
            World world = getWorld();
            world.removeObject(Wrench);
            wrench = true;
            itemSound.setVolume(35);
            itemSound.play();
        }
    }
    public void pickupAtticKey() {
        Actor AtticKey = getOneIntersectingObject(AtticKey.class);
        if (AtticKey != null) {
            World world = getWorld();
            world.removeObject(AtticKey);
            door9Key = true;
            itemSound.setVolume(35);
            itemSound.play();
        }
    }
    
    
    public void shoot() {
        List<Entity> entitys = getObjectsInRange(800, Entity.class);
        if (entitys.size() == 0) return;
        Entity entity = entitys.get(0);
        
        World world = getWorld();
        Room room = (Room) getWorld();
        //Actor player = getOneIntersectingObject(Player.class);
        if ((entity != null) && (Greenfoot.isKeyDown("space")) && (gunCooldown) && /*(room.roomID==8) &&*/ (shotgunShells)) {
            Greenfoot.playSound("lmg_fire01.mp3");
            world.addObject( new ShotgunBlast(), x, y);
            gunCooldown=false;
            shotgunShells=false;
        }
    }
    
   
    private void sprint() {
        if (Greenfoot.isKeyDown("shift")) {
            sprint=3;  //sprint multiplier
            stam--;    //stamina loss
        }
        else {
            sprint=0;
        }
        
        //CHEAT CODE
        /*
        if (Greenfoot.isKeyDown("space")) {
            sprint=20;  //sprint multiplier
            //Greenfoot.setWorld( new  PlayerDeathEnding());
        }
        */
    }
    
    
    public void displayStatus() {
        World world = getWorld();
        world.showText("Health: "+health, 100,20);
        world.showText("Stamina: "+stam, 100,40);
    }
    public void checkDeath() {
        if (health<=0) {
            Room world = (Room) getWorld();
            world.chaseTheme.stop();
            world.music.stop();
            
            Greenfoot.setWorld( new  PlayerDeathEnding());
            
        }
    }
    public void stamina() {
        if (stam<800 && runTick>200) {
            stam+=50;
            runTick=0;
        }
        runTick++;
    }
    public void moves() {
        if (Greenfoot.isKeyDown("w")) {
            tick++;
            face="up";
            setLocation(x, y-3-sprint);
            if (tick>0 && tick<20) {
                setImage("PlayerBackWalk1.png"); 
            }
            if (tick>20) {
                setImage("PlayerBackWalk2.png"); 
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("a")) {
            tick++;
            face="left";
            setLocation(x-3-sprint, y);
            if (tick>0 && tick<20) {
                setImage("PlayerLeftWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerLeftWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("s")) {
            tick++;
            face="down";
            setLocation(x, y+3+sprint);
            if (tick>0 && tick<20) {
                setImage("PlayerWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
        if (Greenfoot.isKeyDown("d")) {
            tick++;
            face="right";
            setLocation(x+3+sprint, y);
            if (tick>0 && tick<20) {
                setImage("PlayerRightWalk1.png");
            }
            if (tick>20) {
                setImage("PlayerRightWalk2.png");
            }
            if (tick>40) {
                tick=1;
            }
        }
    }
    public void isMove() {
        if (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("s") || Greenfoot.isKeyDown("d")) {
            moves();
        }
        else {
            tick=0;
        }
    }
    public void resetSprite() {
        if (tick==0 && face=="up") {
            setImage("playerBackIdle.png");
        }
        if (tick==0 && face=="left") {
            setImage("PlayerLeftIdle.png");
        }
        if (tick==0 && face=="down") {
            setImage("PlayerIdleV5.png");
        }
        if (tick==0 && face=="right") {
            setImage("PlayerRightIdle.png");
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
    
    
    /*
     * public void getPos() {
        x = getX();
        y = getY();
    }
     */
    
    
    
    
    /*
    public void walk() {
    if (walkTick==0) {
        setImage("PlayerIdleV5.png");
    }
    if (walkTick>0 && walkTick<20) {
        setImage("PlayerWalk1.png");
    }
    if (walkTick==20) {
        setImage("PlayerWalk2.png");
    }
    if (walkTick==40) {
        walkTick=0;
    }
    }
    public void tick() {
        tick++;
    }
    public void movement() {
        if (Greenfoot.isKeyDown("w")) {
            setLocation(x, y-3);
            walkTick++;
        } else if  (Greenfoot.isKeyDown("a")) {
            setLocation(x-3, y);
            walkTick++;
        } else if (Greenfoot.isKeyDown("s")) {
            setLocation(x, y+3);
            walkTick++;
        } else if (Greenfoot.isKeyDown("d")) {
            setLocation(x+3, y);
            walkTick++;
        }
        else {
            walkTick=0;
        }
    }
    */
    
    
}
