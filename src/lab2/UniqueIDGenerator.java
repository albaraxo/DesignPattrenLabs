package lab2;

class UniqueIDGenerator {
    private static volatile UniqueIDGenerator instance;
    private int idCounter = 0;
    private UniqueIDGenerator() {
    }
    public static UniqueIDGenerator getInstance() {
        if (instance == null) {
            synchronized (UniqueIDGenerator.class) {
                if (instance == null) {
                    instance = new UniqueIDGenerator();
                }
            }
        }
        return instance;
    }
    public int getNextID() {
        idCounter++;
        return idCounter;
    }
}
class Main3
{
    public static void main(String[] args) {
        UniqueIDGenerator u1 = UniqueIDGenerator.getInstance();
        UniqueIDGenerator u2 = UniqueIDGenerator.getInstance();
        System.out.println(u1.getNextID());
        System.out.println(u1.getNextID());
        System.out.println(u2.getNextID());
    }
}
