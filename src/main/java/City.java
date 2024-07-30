import java.util.ArrayList;
import java.util.List;

public class City {
    private final String name;
    List<Way> ways = new ArrayList<>();

    public City(String name) {
        this.name = name;
    }

    public City(String name, List<Way> ways) {
        this.name = name;
        this.ways = ways;
    }

    @Override
    public String toString() {
        return "Название города: " + name + '\'' +
                " Список связанных городов: " + '\''
                + ways;
    }

    public String getName() {
        return name;
    }

    public void addWay(Way way) {
        boolean flag = true;
        for (Way current : this.ways) {
            if (current.getCity() == way.getCity()) {
                flag = false;
                System.out.println("Путь " + current + " уже существует! Добавить указанный путь невозможно.");
            }
        }
        if (flag)
            this.ways.add(way);
    }

    public void addWay(City city, int cost) {
        Way way = new Way(city, cost);
        addWay(way);
    }

    public City travelBy(int n) {
        City destCity = this;
        if (n <= 0) {
            System.out.println("Значение n должно быть больше нуля!");
            return null;
        } else {
            for (int i = 0; i < n; i++) {
                if (!destCity.ways.isEmpty())
                    destCity = destCity.ways.get(0).getCity();
                else {
                    System.out.println("При путешествии из города " + this.getName() + " вы попали в тупик после посещения города " + destCity.name + ". Количество успешно осуществленных переходов: " + i);
                    return null;
                }
            }
            return destCity;
        }
    }
}
