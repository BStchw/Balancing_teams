/**
 * Class main.Individual represents a single person with name and rate
 */
public class Individual {
    String name;
    Integer rate;

    Individual(String name, Integer value)   {
        this.name = name;
        this.rate = value;
    }

    public String getName() {
        return name;
    }

    public Integer getRate() {
        return rate;
    }
}
