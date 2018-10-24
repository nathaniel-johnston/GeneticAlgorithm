
public class Population
{
    private int popSize;
    private Individual[] individuals;
    int fittest = 0;

    public Population(int size)
    {
        this.popSize = popSize;
        individuals = new Individual[popSize];
    }
    
    public int getPopsize()
    {
        return popSize;
    }
    
    public Individual getIndividual(int index)
    {
        return individuals[index];
    }
    
    /*
     * This needs to run a linear search, also needs a compare method
     */
    public int getIndex(Individual ind)
    {
        //return individuals.indexOf(item);
        for(int i = 0; i < individuals.length; i++)
        {
            if(individuals[i] == ind)
            return i;
        }
        
        return -1;
    }
    
    public void setIndividual(int index, Individual val)
    {
        if(index >= popSize) return;
        
        individuals[index] = val;
    }

    public Individual getFittest()
    {
        int mostFit = 0;
        int mostFitIndex = 0;

        for(int i = 0; i < popSize; i++)
        {
            if(mostFit <= individuals[i].getFitness())
            {
                mostFit = individuals[i].getFitness();
                mostFitIndex = i;
            }
        }

        fittest = individuals[mostFitIndex].getFitness();
        return individuals[mostFitIndex];
    }

    public Individual getSecondFittest()
    {
        int mostFit1 = 0;
        int mostFit2 = 0;

        for(int i = 0; i < popSize; i++)
        {
            if (individuals[i].getFitness() > individuals[mostFit1].getFitness())
            {
                mostFit2 = mostFit1;
                mostFit1 = i;
            } else if (individuals[i].getFitness() > individuals[mostFit2].getFitness())
            {
                mostFit2 = i;
            }
        }

        return individuals[mostFit2];
    }

    public int getLeastFitIndex()
    {
        int minFitVal = Integer.MAX_VALUE;
        int minFitIndex = 0;

        for(int i = 0; i < popSize; i++)
        {
            if(minFitVal >= individuals[i].getFitness())
            {
                minFitVal = individuals[i].getFitness();
                minFitIndex = i;
            }
        }

        return minFitIndex;
    }

    public void findFitness()
    {
        for(int i = 0; i < popSize; i++)
        {
            individuals[i].calculateFitness();
        }

        getFittest();
    }
}
