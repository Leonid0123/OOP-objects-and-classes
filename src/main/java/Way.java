public class Way {
    private final City city;
    private final int cost;

    public Way(City city, int cost) {
        this.city = city;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return city.getName() + ": " + cost;
    }

    public City getCity() {
        return city;
    }
}
