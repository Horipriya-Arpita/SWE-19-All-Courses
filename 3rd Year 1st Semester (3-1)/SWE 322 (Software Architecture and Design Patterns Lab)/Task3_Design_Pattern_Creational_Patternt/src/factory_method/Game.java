
package factory_method;


public class Game {

    public static void main(String[] args) {
        int t = 10;
        int score = 0;
        while(t>0){
            t--;
            score++;
            
            int level;
            if(score<5) level = 1;
            else level = 2;
            
            System.out.println("........................\n\n"+"level : " + level + "\tscore : " + score +".... \t");
            if(level==1){
                Level1ObstacleFactory lev1obstacleFactory = new Level1ObstacleFactory() {};
                Asteroids asteroids = (Asteroids) lev1obstacleFactory.createAsteroid(score);
                asteroids.show();
                DebrisField debrisfield = (DebrisField) lev1obstacleFactory.createDebrisField(score);
                debrisfield.show();
                BlackHoles blackHoles = (BlackHoles) lev1obstacleFactory.createBlackHole(score);
                blackHoles.show();
                EnemyShips enemyShips = (EnemyShips) lev1obstacleFactory.createEnemyShip(score);
                enemyShips.show();
                SolarFlares solarFlares = (SolarFlares) lev1obstacleFactory.createSolarFlare(score);
                solarFlares.show();
                
            }
            
            else {
                Level2ObstacleFactory lev2obstacleFactory = new Level2ObstacleFactory() {};
                Asteroids asteroids = (Asteroids) lev2obstacleFactory.createAsteroid(score);
                asteroids.show();
                DebrisField debrisfield = (DebrisField) lev2obstacleFactory.createDebrisField(score);
                debrisfield.show();
                BlackHoles blackHoles = (BlackHoles) lev2obstacleFactory.createBlackHole(score);
                blackHoles.show();
                EnemyShips enemyShips = (EnemyShips) lev2obstacleFactory.createEnemyShip(score);
                enemyShips.show();
                SolarFlares solarFlares = (SolarFlares) lev2obstacleFactory.createSolarFlare(score);
                solarFlares.show();
                
            }
            
            
            
        }
    }
    
}
