import greenfoot.*;
import java.util.List;

//import java.util.Vector;
/**
 * Write a description of class Cowboy here. @author (your name) @version (a version number or a date)
 */
public class Cowboy extends Actor
{
    private Vector2D velocity;
    private Point2D position;
    private Vector2D acceleration;
    private GreenfootSound gameMusic;
    private static double GRAVITY = 10;
    /* (World, Actor, GreenfootImage, Greenfoot and MouseInfo)*/
    public int tick;
    public int halfHeight = 20;
    public boolean boo = true;
    //private double timeStepDuration = 1.0/60;
    
    /**
     * Act - do whatever the Cowboy wants to do. This method is called whenever the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    
    {
        isMove();
        jump();
        resetSprite();
        shoot();
        updatePhysics();
        groundRespawn(getX(), getY());
        collision();
        transition();
        //transition2();
    }
        
    public void shoot()
    {
    if(Greenfoot.mouseClicked(null))
    {
        Actor bullet = new Bullet();
        MouseInfo mouse = Greenfoot.getMouseInfo();
        getWorld().addObject(bullet, getX(), getY());
        bullet.turnTowards(mouse.getX(), mouse.getY());
        Greenfoot.playSound("lmg_fire01.mp3");
    }
    }
    
    public Cowboy()
    {
        position = null;
        velocity = new Vector2D(0.0, 0.0);
        acceleration = new Vector2D(0.0, GRAVITY);
    }
    
    public void jump()
    {
        if (Greenfoot.isKeyDown("space") && (boo==true)) {
            boo = false; 
            velocity = new Vector2D(0,-45);
        }
    }
    
    public void updatePhysics()
    {
        position = new Point2D(getX(), getY());

            SimulationWorld world = (SimulationWorld) getWorld();
            if (world != null)
           {
            double dt = world.getTimeStepDuration();
 
            Vector2D velocityVariation = Vector2D.multiply(acceleration, dt);
            velocity = Vector2D.add(velocity, velocityVariation);
        
            Vector2D positionVariation = Vector2D.multiply(velocity, dt);
            position.add(positionVariation);
        
            setLocation((int)position.getX(), (int)position.getY());
            
            
            
        }
    }   
    
        public  void transition(){
        //transition1 = isAtEdge(Cowboy.class);
     {
            if(isAtEdge() && (getX()>=780)){
            
            if (getWorld() instanceof PonchoGunSlingers1)
            {   
                //PonchoGunSlingers1 world1 = (PonchoGunSlingers1)  getWorld();
                //world1.gameMusic.stop();
                //PonchoGunSlingers2 world2 = new PonchoGunSlingers2();
                //world2.started();
                //Greenfoot.setWorld(world2);  
                Greenfoot.setWorld( new PonchoGunSlingers2());
            }
            
            if (getWorld() instanceof PonchoGunSlingers2)
            {   
                //PonchoGunSlingers2 world2 = (PonchoGunSlingers2)  getWorld();
                //world2.gameMusic.stop();
                //PonchoGunSlingers3 world3 = new PonchoGunSlingers3();
                //world3.started();
                //Greenfoot.setWorld(world3);  
                Greenfoot.setWorld( new PonchoGunSlingers3());
            }  
            
            if (getWorld() instanceof PonchoGunSlingers3)
            {   
                //PonchoGunSlingers3 world3 = (PonchoGunSlingers3)  getWorld();
                //world3.gameMusic.stop();
                Greenfoot.setWorld( new JumpScare());
                }
        }
     }
    }
     
    public void collision(){
        List<Platform> csl= getIntersectingObjects(Platform.class);
        if (csl.size() > 0){
             Platform platform = csl.get(0);
            float yOverlap = (platform.getY()- platform.getImage().getHeight()/2) - (this.getY() +this.getImage().getHeight()/2);
            Vector2D overlap = new Vector2D(0,yOverlap); 
            position = new Point2D(getX(), getY());
            position.add(overlap);
            setLocation((int)position.getX(), (int)position.getY());
            boo = true;
        }
    
    }
    public void groundRespawn(int x, int y){
        if (y>=575){
            setLocation(38, 465);
            velocity = new Vector2D(0,0);
        }
    }
    
    public void  isMove() {
        if (Greenfoot.isKeyDown("a") || Greenfoot.isKeyDown("d")) {
            moves();
        }else{
            tick=0;
        }
    }
    
    public void resetSprite() {
         if (tick == 0) {
            setImage("CowboyIdleV2.png");
            }
        }
        
    public void moves() {
        if (Greenfoot.isKeyDown("d")){
            tick++;
            move(5);
            if (tick > 0 && tick < 20) {
                setImage("CowboyWalkV2.png");
            }
            if (tick > 20) {
                 setImage("CowboyIdleV2.png");
            }
            if (tick > 40) {
                  tick =1;
            }
        }
        if (Greenfoot.isKeyDown("a")){
            tick++;
            move(-5);
            if (tick > 0 && tick < 20) {
                setImage("CowboyWalkV2.png");
            }
            if (tick > 20) {
                setImage("CowboyIdleV2.png");
            }
            if (tick >40) {
                tick =1;
            }
        }
        }
    }

