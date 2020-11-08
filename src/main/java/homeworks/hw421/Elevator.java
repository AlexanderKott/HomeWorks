package homeworks.hw421;


import java.util.*;

public class Elevator {
    private PriorityQueue<Integer> floors; //Очередь
    private HouseInt house; //Дом

    public Elevator(HouseInt house) {
        this.house = house;
        this.floors = new PriorityQueue<>(house.getMaxFloor());
    }

    private static int parse(int input, HouseInt house) {
        if ((input >= house.getMinFloor() && (input <= house.getMaxFloor())))
            return input;
        throw new InputMismatchException();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int input;

        while (true) {
            System.out.println("\nОжидаю ввода этажа: (для завершения введите 0)");
            try {
                input = scanner.nextInt();
                if (input == 0) {
                    displayElevatorPath();
                    break;
                }

                int variant = parse(input, house);
                makePath(variant);


            } catch (IllegalArgumentException | InputMismatchException
                    | IndexOutOfBoundsException e) {
                System.out.println("Такого этажа нет в доме");
                scanner.nextLine();
                continue;
            }
        }
        scanner.close();
    }

    private void makePath(int variant) {
        floors.offer(variant);
    }

    private void displayElevatorPath() {
        System.out.println("Лифт проследовал по следующим этажам:");

        if (floors.size() == 0) {
            System.out.println("Лифт никуда не ехал");
            return;
        }

        Iterator<Integer> iterator = floors.iterator();
        while (iterator.hasNext()) {
            int floor = iterator.next();
            System.out.print(" этаж " + floor + " ->");
        }

        System.out.println(" этаж 0");


    }
}
