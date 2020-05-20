import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private String buildingName;
    protected List<Room> rooms = new ArrayList();
    Logger logger = LogManager.getLogger();

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Room getRoom(String name) {
        for (Room room : rooms) {
            if (room.getName().equals(name))
                return room;
        }
        return null;
    }

    public void describe() {
        logger.info(getBuildingName());
        for (Room room : rooms) {
            logger.info( room.getName() + " Освещенность = " + room.calculateTotalRoomBrightness() + " лк ("
                    + room.getNumberOfWindows() + " окна по 700 лк, Лампочки: " + room.lightBulbList + ")" + "\n" +  " Площадь = "
                    + room.getArea() + " м^2 (занято " + room.calculateOccupiedArea() + " м^2, свободно "
                    + room.calculateFreeArea() + " м^2, или " + room.calculatePercentage() + " Мебель: " + room.itemList + ") ");
        }
    }

}
