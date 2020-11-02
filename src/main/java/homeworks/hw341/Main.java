package homeworks.hw341;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersDB db = new UsersDB();
        System.out.println("Введите логин и пароль юзера (через пробел). Или end для завершения");
        run(db.getUsers());
    }


    public static void run(User[] users) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        String input;

        while (true) {
            System.out.println("\n > ");
            try {
                input = scanner.nextLine();
                if ("end".equals(input)) {
                    break;
                }

                ParseInput info = parse(input);
                displayUser(checkUser(info, users));

            } catch (IllegalArgumentException | InputMismatchException | ParseException e) {
                System.out.println("Ошибка ввода. Нажмите Enter");
                scanner.nextLine();
                continue;
            } catch (AccessDeniedException e) {
                System.out.println("Доступ запрещен");
            } catch (UserNotFoundException e) {
                System.out.println("Пользователь не найден");
            }

        }
        scanner.close();
    }

    public static ParseInput parse(String input) throws ParseException {
        String[] in = input.split(" ");
        if (in.length != 2) throw  new ParseException("parse exception", 0);
        return new ParseInput(in[0], in[1]);
    }

    public static void displayUser(String str){
        System.out.println(str);
    }

    public static String checkUser(ParseInput info, User[] users) throws AccessDeniedException, UserNotFoundException {
        for (int i = 0; i < users.length; i++) {
            if (info.getLogin().equals(users[i].getLogin())) {
                if (info.getPassword().equals(users[i].getPassword())) {
                    if (users[i].getAge() >= 18) {
                        return "Пользователь с ником " + info.getLogin() + " найден. Доступ разрешен";
                    } else {
                        throw new AccessDeniedException("Access Denied");
                    }

                }
            }
        }
        throw new UserNotFoundException("User Not Found");
    }

}


