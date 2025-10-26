package lab3;

// Prototype interface
interface CloneableLevel extends Cloneable {
    CloneableLevel clone();
    void customize();
}

// Concrete Prototype
class GameLevel implements CloneableLevel {
    private String terrain;
    private String obstacles;
    private String enemies;

    public GameLevel(String terrain, String obstacles, String enemies) {
        this.terrain = terrain;
        this.obstacles = obstacles;
        this.enemies = enemies;
    }

    @Override
    public CloneableLevel clone() {
        return new GameLevel(terrain, obstacles, enemies);
    }

    @Override
    public void customize() {
        System.out.println("Customizing Level with:");
        System.out.println("Terrain: " + terrain);
        System.out.println("Obstacles: " + obstacles);
        System.out.println("Enemies: " + enemies);
        System.out.println("----------------------------");
    }

    // Setters allow customization after cloning
    public void setTerrain(String terrain) { this.terrain = terrain; }
    public void setObstacles(String obstacles) { this.obstacles = obstacles; }
    public void setEnemies(String enemies) { this.enemies = enemies; }
}

// Client
public class LevelDesignTool {
    public static void main(String[] args) {
        // Base Prototype
        GameLevel baseLevel = new GameLevel("Ice land", "poison", "Snakes");

        // Clone 1
        GameLevel level1 = (GameLevel) baseLevel.clone();
        level1.setEnemies("Monstors");
        level1.customize();

        // Clone 2
        GameLevel level2 = (GameLevel) baseLevel.clone();
        level2.setTerrain("Forest");
        level2.setObstacles("Rocks and fire");
        level2.setEnemies("Dragons");
        level2.customize();
    }
}
