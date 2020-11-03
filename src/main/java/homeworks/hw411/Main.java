package homeworks.hw411;

public class Main {
    public static void main(String[] args) {
        System.out.println("1. Добавить задачу\n" +
                           "2. Вывести список задач\n" +
                           "3. Удалить задачу\n" +
                           "0. Выход");


        TaskKeeper taskKeeper = new TaskKeeper();
        taskKeeper.run();
        System.out.println("Выход");
    }


}
