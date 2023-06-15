import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
public class Sheep extends Actor
{
    
    int age=(int)(Math.random()*100);
    int babyCD=0;    
    int babyAmount=0; 
    int eatCD=50;
    public Sheep(){
        super();
        getImage().scale(40,30);
    }
    
    
    public void act()
    {
        
        if (age>200)
          getImage().scale(60,60);
          
        
        move(3);
        if(isAtEdge()){
            int r=(int)(Math.random()*360);
            setRotation(r);
        }
        int num=(int)(Math.random()*130);
        if(num==0){
            int angle=(int)(Math.random()*180);
            turn(angle);
        }
        if( num==2){
            
            List<Grass> nearGrass=getObjectsInRange(2000, Grass.class); //check if no grass
            this.turnTowards(nearGrass.get(0).getX(), nearGrass.get(0).getY());
        }
        
        age++;
        
        if(age>=800){
            World w=getWorld();
            w.removeObject(this);
            return;
        }
        
        
        babyCD--;
        
        if(age>300){
            Actor a=getOneIntersectingObject(Sheep.class);
            if (a!=null) {

                if (  a.getWorld()!=null && ((Sheep)a).age>=300 && ((Sheep)a).babyCD<0 && babyCD<0){
                babyAmount=(int)(Math.random()*5)+2;
                for(int k=0;k<babyAmount;k++){
                    getWorld().addObject(new Sheep(),getX(),getY());
                    ((Sheep)a).babyCD=100;
                    this.babyCD=100;
                }
            }
            }
        }
        
        eatCD--;
        if(age>200 && eatCD<0){
            Actor a=getOneIntersectingObject(Grass.class);
            if(a!=null){
                getWorld().removeObject(a);
                this.eatCD=75;
                age=age-80;
            }
        }
    }
    
    
}
