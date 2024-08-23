public class CoordinatePoint {
    private final int x;
    private final int y;
    private final int z;
    private final String pointColour;
    private final String pointCreationTime;

    private CoordinatePoint(CoordinatePointBuilder coordinatePointBuilder) {
        this.x = coordinatePointBuilder.x;
        this.y = coordinatePointBuilder.y;
        this.z = coordinatePointBuilder.z;
        this.pointColour = coordinatePointBuilder.pointColour;
        this.pointCreationTime = coordinatePointBuilder.pointCreationTime;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public String getPointColour() {
        return pointColour;
    }

    public String getPointCreationTime() {
        return pointCreationTime;
    }

    @Override
    public String toString() {
        return "CoordinatePoint{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", pointColour='" + pointColour + '\'' +
                ", pointCreationTime='" + pointCreationTime + '\'' +
                '}';
    }

    public static class CoordinatePointBuilder {
        private final int x;
        private int y;
        private int z;
        private String pointColour;
        private String pointCreationTime;

        public CoordinatePointBuilder(int x) {
            this.x = x;
        }

        public CoordinatePointBuilder setY(int y) {
            this.y = y;
            return this;
        }

        public CoordinatePointBuilder setZ(int z) {
            this.z = z;
            return this;
        }

        public CoordinatePointBuilder setPointColour(String pointColour) {
            this.pointColour = pointColour;
            return this;
        }

        public CoordinatePointBuilder setPointCreationTime(String pointCreationTime) {
            this.pointCreationTime = pointCreationTime;
            return this;
        }

        public CoordinatePoint build() {
            return new CoordinatePoint(this);
        }
    }
}

