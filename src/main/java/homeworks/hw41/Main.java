package homeworks.hw41;

public class Main {

    public static void main(String[] args) {
        Box<String> sample1 = new Box<>("НетологиЯ");
        System.out.println(sample1);
        Box<Integer> sample2 = new Box<>(1); //Ошибка была здесь
        /*
        Было написанно String а я заменил на Integer. Алмазный синтаксис начинает работать
        когда правильно указан тип генерика. Джава понимает какой экземпляр Box нам нужен
        по генерику. Поэтому оно не работало. Java не может угадть тип Box самостоятельно.
        Решение: использовать правильный генерик, в данном случае Integer
         */


        System.out.println(sample2);
        Box<Boolean> sample3 = new Box<>(Boolean.TRUE);
        System.out.println(sample3);
    }
}
