import java.util.*;

/**
 * Write a description of class Market here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Market
{
    LinkedList marketStalls = new LinkedList();
    LinkedList marketCustomers = new LinkedList();
    ProcessedCustomers satisfied = new ProcessedCustomers();
    
    private final int ARRTIMEMEAN       = 61;
    private final int ARRTIMESTDV       = 31;
    
    private final int BAKERYTIME        = 29;
    private final int BAKERYTIMESTDV    = 13;
    
    private final int BEVERAGETIME      = 19;
    private final int BEVERAGTETIMESTDV = 7;
    
    private final int DAIRYTIME         = 59;
    private final int DAIRYTIMESTDV     = 23;
    
    private final int FRUITTIME         = 83;
    private final int FRUITTIMESTDV     = 31;
    
    private final int MEATTIME          = 101;
    private final int MEATTIMESTDV      = 41;
    
    private final int VEGETABLETIME     = 119;
    private final int VEGETABLETIMESTDV = 29;
    
    public int space = 750;
    RandomGaussian arrivalTime = new RandomGaussian();
    
    public static void main(String args[]){
        
    }
    
    public List FatherTime()
    {
        int currentID = 0;
        int lastArrival = 0;
        int nextArrival = 0;
        int currentIndex = 0;
        nextArrival += arrivalTime.getGaussian(61, 31);
        for(int time = 0; time < 1000; time++){
            if(time == nextArrival){
                marketCustomers.add(addCustomer(currentID, nextArrival));
                currentID++;
                nextArrival += arrivalTime.getGaussian(61, 31);
            }
        }
        
        return marketCustomers;
    }
    
    public List addAll(int bake, int bev, int dairy, int fruit, int meat, int vegi)
    {
        int stallCount = 1;
        for( int i = 0; i < bake; i++){
            marketStalls.add(addStall("bakery", BAKERYTIME, BAKERYTIMESTDV, stallCount));
            stallCount++;
        }
        
        for( int i = 0; i < bev; i++){
            marketStalls.add(addStall("beverage", BEVERAGETIME, BEVERAGTETIMESTDV, stallCount));
            stallCount++;
        }
        
        for( int i = 0; i < bake; i++){
            marketStalls.add(addStall("dairy", DAIRYTIME, DAIRYTIMESTDV, stallCount));
            stallCount++;
        }
        
        for( int i = 0; i < bake; i++){
            marketStalls.add(addStall("fruit", FRUITTIME, FRUITTIMESTDV, stallCount));
            stallCount++;
        }
        
        for( int i = 0; i < bake; i++){
            marketStalls.add(addStall("meat", MEATTIME, MEATTIMESTDV, stallCount));
            stallCount++;
        }
        
        for( int i = 0; i < bake; i++){
            marketStalls.add(addStall("vegetables", VEGETABLETIME, VEGETABLETIMESTDV, stallCount));
            stallCount++;
        }
        
        return marketStalls;
    }
    
    public Customer addCustomer(int ID, int t)
    {
        Customer customer = new Customer(ID, t);
        customer.listGen();
        
        customer.info();
        return customer;
    }
    
    /**
     * Constructor for objects of class Market
     */
    public Stall addStall(String type, int s, int d, int i)
    {
        Stall stall = new Stall(type, s, d, i);
        return stall;
    }
}
