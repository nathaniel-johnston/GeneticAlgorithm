public class Item
{
    private int weight;
    private int survive;

    public Item(int weight, int survive)
    {
        this.weight = weight;
        this.survive = survive;
    }
    
    public int getWeight()
    {
        return weight;
    }
    
    public int getSurvive()
    {
        return survive;
    }
    
    public void setSurvive(int survive)
    {
        this.survive = survive;
    }
    
    public void getSurvive(int weight)
    {
        this.weight = weight;
    }
    
    public boolean equals(Item item)
    {
        if(this.weight == item.weight && this.survive == item.survive)
            return true;
        
        return false;
    }
}
