import java.util.*;

/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer {   
    private int customerID;
    public int serveTime;
    private String currentStall;
    
    private final int BAKERYMEAN    = 37;
    private final int BAKERYSTDV    = 17;
    
    private final int BEVERAGEMEAN  = 43;
    private final int BEVERAGESTDV  = 11;
    
    private final int DAIRYMEAN     = 59;
    private final int DAIRYSTDV     = 19;
    
    private final int FRUITMEAN     = 47;
    private final int FRUITSTDV     = 13;
    
    private final int MEATMEAN      = 53;
    private final int MEATSTDV      = 13;
    
    private final int VEGETABLEMEAN = 71;
    private final int VEGETABLESTDV = 29;
    
    RandomGaussian needGen          = new RandomGaussian();
    ArrayList shoppingList          = new ArrayList();
    ArrayList fullNeeds             = new ArrayList();
    ArrayList<Stall> stallsToVisit  = new ArrayList<Stall>();
    
    public Customer(int ID)
    {
        customerID = ID;
    }
    
    public void listGen(LinkedList<Stall> s){
        if(needGen.getGaussian(BAKERYMEAN, BAKERYSTDV) > 50){
            shoppingList.add("Bakery");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "bakery"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
        
        if(needGen.getGaussian(BEVERAGEMEAN, BEVERAGESTDV) > 50){
            shoppingList.add("Beverage");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "beverage"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
        
        if(needGen.getGaussian(DAIRYMEAN, DAIRYSTDV) > 50){
            shoppingList.add("Dairy");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "dairy"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
        
        if(needGen.getGaussian(FRUITMEAN, FRUITSTDV) > 50){
            shoppingList.add("Fruit");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "fruit"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
        
        if(needGen.getGaussian(MEATMEAN, MEATSTDV) > 50){
            shoppingList.add("Meat");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "meat"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
        
        if(needGen.getGaussian(VEGETABLEMEAN, VEGETABLESTDV) > 50){
            shoppingList.add("Vegetables");
            fullNeeds.add(true);
            
            for(int i = 0; i < s.size(); i++){
                if(s.get(i).type == "vegetables"){
                    stallsToVisit.add(s.get(i));
                }
            }
        } else {
            fullNeeds.add(false);
        }
    }
    
    public Line nextShortest()
    {
        Line shortestLine = stallsToVisit.get(0).findShortest();
        for(int i = 1; i < stallsToVisit.size(); i++){
            if(stallsToVisit.get(i).findShortest().size() < shortestLine.size()){
                shortestLine = stallsToVisit.get(i).findShortest();
            }
        }
        return shortestLine;
    }
    
    public void moveLines(Line l)
    {
        l.add(this);
        l.remove(this);
    }
    
    public void fulfillNeed(String n)
    {
        if(n == "bakery"){
            shoppingList.remove("Bakery");
            fullNeeds.set(0, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "bakery"){
                    stallsToVisit.remove(i);
                }
            }
        } else if( n == "beverage"){
            shoppingList.remove("Beverage");
            fullNeeds.set(1, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "beverage"){
                    stallsToVisit.remove(i);
                }
            }
        } else if( n == "dairy"){
            shoppingList.remove("Dairy");
            fullNeeds.set(2, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "dairy"){
                    stallsToVisit.remove(i);
                }
            }
        } else if( n == "fruit"){
            shoppingList.remove("Fruit");
            fullNeeds.set(3, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "fruit"){
                    stallsToVisit.remove(i);
                }
            }
        } else if( n == "meat"){
            shoppingList.remove("Meat");
            fullNeeds.set(4, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "meat"){
                    stallsToVisit.remove(i);
                }
            }
        } else if( n == "vegetables"){
            shoppingList.remove("Vegetables");
            fullNeeds.set(5, false);
            for(int i = 0; i < stallsToVisit.size(); i++){
                if(stallsToVisit.get(i).type == "vegetables"){
                    stallsToVisit.remove(i);
                }
            }
        }
    }
    
    public void setServeTime(int t)
    {
        serveTime = t;
    }
    
    public int getServeTime()
    {
        return serveTime;
    }
    
    public String moveStall(String stall)
    {
        currentStall = stall;
        return currentStall;
    }
    
    public String info()
    {
        String info =  "Customer: "           + customerID              + "\n";
               info += "    Specific Needs: " + shoppingList.toString() + "\n";
               info += "    Overall  Needs: " + fullNeeds.toString();
               
        System.out.println(info);
        
        return info;
    }
}