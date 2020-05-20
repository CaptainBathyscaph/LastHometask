import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Room extends Building {
    private String name;
    private Double area;
    private int numberOfWindows;
    private Logger logger = LogManager.getLogger();
    protected List<LightBulb> lightBulbList = new ArrayList();
    protected List<Item> itemList = new ArrayList();

    protected Room(String name, Double area, int numberOfWindows) {
        this.name = name;
        this.area = area;
        this.numberOfWindows = numberOfWindows;
    }

    public void addLightBulb(LightBulb lightBulb) throws IlluminanceTooMuchException {
        int totalBrightness = 0;
        lightBulbList.add(lightBulb);
        totalBrightness = totalBrightness + calculateTotalRoomBrightness();
        if (totalBrightness > 4000) {
            logger.error("Превышена максимальная освещённость в 4000 лк");
            throw new IlluminanceTooMuchException();
        }
    }

    public int calculateLightBulbBrightness() {
        int illuminaceLevel = 0;
        for (int i = 0; i < lightBulbList.size(); i++) {
            illuminaceLevel = illuminaceLevel + lightBulbList.get(i).getBrightness();
        }
        return illuminaceLevel;
    }

    public int calculateWindowBrightness() {
        return numberOfWindows * 700;
    }

    public int calculateTotalRoomBrightness() {
        return calculateWindowBrightness() + calculateLightBulbBrightness();
    }

    public void addItem(Item item) throws SpaceUsageTooMuchException {
        double areaLevel = 0.0;
        itemList.add(item);
        areaLevel = areaLevel + calculateOccupiedArea();
        if (areaLevel > 70.0) {
            logger.error("Превышено 70% площади ");
            throw new SpaceUsageTooMuchException();
        }
    }

    public double calculateOccupiedArea() {
        double areaLevel = 0.0;
        for (int i = 0; i < itemList.size(); i++) {
            areaLevel = areaLevel + itemList.get(i).getArea();
        }
        return areaLevel;
    }

    public double calculateFreeArea() {
        return area - calculateOccupiedArea();
    }

    public double calculatePercentage() {
        return calculateFreeArea() * 100 / getArea();
    }

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", illumination=" + numberOfWindows + '}';
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

    public Integer getNumberOfWindows() {
        return numberOfWindows;
    }

    public void setNumberOfWindows(Integer numberOfWindows) {
        this.numberOfWindows = numberOfWindows;
    }
}
