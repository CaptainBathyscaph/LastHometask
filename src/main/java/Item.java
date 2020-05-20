public class Item {
    private String name;
    private Double area;

    public Item(String name, Double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return name + " (" + area + " м^2" + ") ";
    }
}
