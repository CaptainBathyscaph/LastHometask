
public class Main {
    public static void main(String[] args) throws IlluminanceTooMuchException, SpaceUsageTooMuchException {
        System.setProperty("log4j.configurationFile", "C:\\Users\\Home\\IdeaProjects\\HomeTaskOop\\src\\main\\resources\\log4j2.xml");
        Building building1 = new Building();

        building1.setBuildingName("Здание 1");
        building1.addRoom(new Room("Комната 1", 100.0, 3));
        building1.getRoom("Комната 1").addLightBulb(new LightBulb(150));
        building1.getRoom("Комната 1").addLightBulb(new LightBulb(250));
        building1.getRoom("Комната 1").addItem(new Item("Стол", 2.0));
        building1.getRoom("Комната 1").addItem(new Item("Кресло", 1.0));
        building1.addRoom(new Room("Комната 2", 20.0, 2));
        building1.describe();
    }


}

