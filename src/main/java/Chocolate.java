import java.util.Comparator;

public class Chocolate
{
    double price ;
    double weight;
    public void setWeight(double weight) {
        this.weight=weight;

    }

    public void setPrice(double price) {
        this.price=price;

    }
    public double getPrice() {
        return price;
    }



    public double getWeight() {
        return weight;
    }
}
class Amulm extends Chocolate
{
    public Amulm()
    {
        super.setWeight(150);
        super.setPrice(370);
    }
}
class Cadburym extends Chocolate
{
    public Cadburym()
    {
        super.setWeight(250);
        super.setPrice(470);
    }
}
class Hersheysm extends Chocolate
{
    public Hersheysm()
    {
        super.setWeight(250);
        super.setPrice(570);
    }

}
class Sortbyprice implements Comparator<Chocolate>
{
    public int compare(Chocolate a, Chocolate b)
    {
        return (int) (a.getPrice()-b.getPrice());
    }

}