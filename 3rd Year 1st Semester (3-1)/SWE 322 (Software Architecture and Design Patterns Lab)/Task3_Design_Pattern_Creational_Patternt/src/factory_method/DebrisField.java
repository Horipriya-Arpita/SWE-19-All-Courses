
package factory_method;

public abstract class DebrisField implements Obstacle {
    
    @Override
    public void show(){
        System.out.println("DebrisFeild");
    }
}

class Small_Metal_DebrisFeild extends DebrisField{
    
    @Override
    public void show(){
        System.out.println("Small_Metal_DebrisFeild popped up");
    }
}

class Large_Metal_DebrisFeild extends DebrisField{
    
    @Override
    public void show(){
        System.out.println("Large_Metal_DebrisFeild popped up");
    }
}

class Small_Crystal_DebrisFeild extends DebrisField{
    
    @Override
    public void show(){
        System.out.println("Small_Crystal_DebrisFeild popped up");
    }
}

class Large_Crystal_DebrisFeild extends DebrisField{
    
    @Override
    public void show(){
        System.out.println("Large_Crystal_DebrisFeild popped up");
    }
}
