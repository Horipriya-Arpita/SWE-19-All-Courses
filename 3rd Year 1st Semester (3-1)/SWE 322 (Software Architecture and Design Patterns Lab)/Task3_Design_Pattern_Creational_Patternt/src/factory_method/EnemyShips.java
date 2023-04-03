/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factory_method;

public abstract class EnemyShips implements Obstacle{
    
    @Override
    public void show() {
        System.out.println("EnemyShips popped up");
    }
    
}

class Gray_EnemyShips extends EnemyShips{
    @Override
    public void show(){
        System.out.println("Gray_EnemyShips popped up");
    }
}

class Black_EnemyShips extends EnemyShips{
    @Override
    public void show(){
        System.out.println("Black_EnemyShips popped up");
    }
}

class Blue_EnemyShips extends EnemyShips{
    @Override
    public void show(){
        System.out.println("Blue_EnemyShips popped up");
    }
}

class Red_EnemyShips extends EnemyShips{
    @Override
    public void show(){
        System.out.println("Red_EnemyShips popped up");
    }
}