import java.util.*;

public class Individual
{
    private ArrayList<Item> genes;
    private int fitness;
    Item defaults[];
    
    public Individual()
    {
        genes = new ArrayList<Item>();
        fitness = 0;
        
        defaults = new Item[6];
        
        defaults[0] = new Item(15, 15);
        defaults[1] = new Item(3, 7);
        defaults[2] = new Item(2, 10);
        defaults[3] = new Item(5, 5);
        defaults[4] = new Item(9, 8);
        defaults[5] = new Item(20, 17);
    }
    
    public void initialize()
    {
        Item shuffled[] = shuffle();
        int weightSum = 0;
        int i = 0;
        
        while(weightSum < 30)
        {
            genes.add(shuffled[i]);
            weightSum = shuffled[i].getWeight();
            i++;
        }
    }
    
    public Item[] shuffle()
    {
        Random rand = new Random();
        
        Item shuffled[];
        
        shuffled = new Item[6];
        
        for(int i = 0; i < 6; i++)
        {
            shuffled[i] = defaults[i];
        }
        
        for(int i = 0; i < 3; i++)
        {
            int randomInd = rand.nextInt(3);
            Item temp = shuffled[randomInd];
            shuffled[randomInd] = shuffled[6-i-1];
            shuffled[6-i-1] = temp;
        }
        
        return shuffled;
    }
    
    public int getFitness()
    {
        return fitness;
    }
    
    public Item getGene(int index)
    {
        return genes.get(index);
    }
    
    public int getGeneLength()
    {
        return genes.size();
    }
    
    public void setGene(int index, Item item)
    {
        if(index >= genes.size())
            return;
        genes.set(index, item);
    }
    
    public void calculateFitness()
    {
        fitness = 0;
        
        for(int i = 0; i < genes.size(); i++)
        {
            fitness += genes.get(i).getSurvive();
        }
    }
}
