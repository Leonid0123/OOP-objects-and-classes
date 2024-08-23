public class Main {
    public static void main(String[] args) {
        CoordinatePoint point1 = new CoordinatePoint.CoordinatePointBuilder(3).setPointColour("red").build();
        CoordinatePoint point2 = new CoordinatePoint.CoordinatePointBuilder(4).setY(2).setZ(5).setPointCreationTime("11:00").build();
        CoordinatePoint point3 = new CoordinatePoint.CoordinatePointBuilder(7).setY(7).setPointCreationTime("15:35").setPointColour("yellow").build();

        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}