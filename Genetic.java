import java.util.*;

public class Genetic
{
    Population pop;
    Individual fittest;
    Individual secondFittest;
    int generationCount;

    public Genetic()
    {
        pop = new Population(10);
        fittest = new Individual();
        secondFittest = new Individual();
        generationCount = 0;
    }

    void selection()
    {
        fittest = pop.getFittest();
        secondFittest = pop.getSecondFittest();
    }

    //NOT GOING TO WORK, THE GENES AREN'T THE SAME LENGTH
    void crossover(int index)
    {	
        Random rand = new Random();

        int crossoverPoint = rand.nextInt(pop.getIndividual(index).getGeneLength());

        for(int i = 0; i < crossoverPoint; i++)
        {
            Item temp = fittest.getGene(i);
            fittest.setGene(i, secondFittest.getGene(i));
            secondFittest.setGene(i, temp);
        }
    }

    public void mutation(int firstIndex, int secondIndex)
    {	
        Random rand = new Random();

        int mutationPoint = rand.nextInt(pop.getIndividual(firstIndex).getGeneLength());
        
        

        

    }

    //PROBABLY USELESS
    /*
    public Individual getFittestChild()
    {
        //Individual indPtr = &secondFittest;

        if(fittest.getFitness() > secondFittest.getFitness())
        {
            indPtr = &fittest;
            return fittest;
        }
        //return fittest;
        return indPtr;
    }
    */

    public void addFittestChild()
    {
        fittest.calculateFitness();
        secondFittest.calculateFitness();

        int leastFitIndex = pop.getLeastFitIndex();

        //pop.setItem(leastFitIndex, getFittestChild());
        pop.setItem(leastFitIndex, fittest);
    }
}
