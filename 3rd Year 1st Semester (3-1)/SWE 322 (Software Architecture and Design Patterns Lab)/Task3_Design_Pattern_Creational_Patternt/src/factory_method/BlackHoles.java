
package factory_method;

public abstract class BlackHoles implements Obstacle {
    @Override
    public void show(){
        System.out.println("BlackHoles popped up");
    }
    
}

class Small_BlackHoles extends BlackHoles {
    @Override
    public void show(){
        System.out.println("Small_BlackHoles popped up");
    }
}

class Large_BlackHoles extends BlackHoles {
    @Override
    public void show(){
        System.out.println("Large_BlackHoles popped up");
    }
}