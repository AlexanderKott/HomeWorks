package homeworks.hw331;

public class Main {

    public static void main(String[] args) {
        Administrator admin   = new AdministratorImpl();
        Librarian librn    = new LibrarianImpl();
        Reader reader   = new ReaderImpl();
        Supplier supplier = new SupplierImpl();


        admin.searchForBookForReader("Война и мир", reader); //Админ ищет книгу для читателя
        librn.orderBooksFrom(supplier); //Библиотекарь заказал книгу
        supplier.bringBooksToLibrary(librn); //Поставщик дал ее библиотекарю
        reader.takeBooks(admin); //Читатель взял книгу у админа
        admin.overdueNotification(reader); //Админ уведомляет читателя что книга просрочена
        reader.giveBackBooks(admin); //читатель отдает книгу админу обратно


        Worker user2 = new Worker();  //Работник библиотеки
        user2.orderBooksFrom(supplier); //Может сам заказать книгу у поставщика
        user2.takeBooks(admin); // Может читать книгу, взяв ее у админа

        System.out.println("Done");
    }
}
