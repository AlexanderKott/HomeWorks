package homeworks.hw421;

public class Main {
    public static void main(String[] args) {

        House25 house = new House25();

        System.out.println("Введите номер этажа в диапазоне " +
                           "от " + house.getMinFloor() + " до " + house.getMaxFloor() + "\n" +
                           "0 - посмотреть результат и выход");

        Elevator elevator = new Elevator(house);
        elevator.run();
        System.out.println("Выход");
    }


}
