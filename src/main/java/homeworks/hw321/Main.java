package homeworks.hw321;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Player player = new Player();

        System.out.format("У игрока %d слотов с оружием,"
                        + " введите номер, чтобы выстрелить,"
                        + " -1 чтобы выйти%n",
                player.getSlotsCount()
        );


        run(player); //Цикл игры

        System.out.println("Game over!");
    }

    public static void run(Player player) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        int input;

        while (true) {
            System.out.println("\n Введите слот ");
            try {
                input = scanner.nextInt();
                if (input == -1) {
                    break;
                }
                player.shotWithWeapon(input);

            } catch (IllegalArgumentException | InputMismatchException e) {
                System.out.println("Ошибка ввода.");
                scanner.nextLine();
                continue;
            }
        }
        scanner.close();
    }


}
