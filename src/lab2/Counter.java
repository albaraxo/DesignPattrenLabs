package lab2;

public class Counter{

    //private
    private static Counter instance;
    private int count = 0;

    private Counter(){

    }
    public static Counter getCounter(){
        if(instance == null){
            instance = new Counter();
        }
        return instance;
    }

    public int getCount(){
        return count;
    }

    public void incrementCoun(){
        count++;
    }

}

class Main {
    public static void main(String[] args) {
        Counter obj1 = Counter.getCounter();
        Counter obj2 = Counter.getCounter();

        //check if they are same references
        System.out.println(obj1 == obj2);
        // increment count of instance
        obj1.incrementCoun();
        System.out.println(  obj1.getCount());
        // if we increment the second instance and the result is ture then we succses to build singlton desgin pattren
        obj2.incrementCoun();
        System.out.println(obj2.getCount());

    }
}

