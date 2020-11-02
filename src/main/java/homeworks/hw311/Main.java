package homeworks.hw311;

public class Main {

    public static void main(String[] args) {

       //Тесты

        //Available -> Borrowed
        testAB();
        //Available -> Archived
        testAA();

        //Borrowed -> Archived
        testABA();
        //Borrowed -> Overdued
        testABO();

        //Overdued -> Archived
        testABOA();

        //Archived -> Available
        testAAA();

        //-----------------------------------------------------------

    }

    public static void testAB(){
        System.out.println("Test  Available -> Borrowed");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
                fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.BORROWED);
        display(testbook);
    }


    public static void testAA(){
        System.out.println("Test Available -> Archived");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
        fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.ARCHIVED);
        display(testbook);
    }


    public static void testABO(){
        System.out.println("Test Available -> Borrowed  -> Overdued");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
        fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.BORROWED);
        fromAvailableStatusMover = new FromBorrowedStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.OVERDUED);
        display(testbook);
    }



    public static void testABA(){
        System.out.println("test Available -> borrowed  -> Archived");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
                fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.BORROWED);
        fromAvailableStatusMover = new FromBorrowedStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.ARCHIVED);
        display(testbook);
    }


    public static void testABOA(){
        System.out.println("test Available -> Borrowed -> Overdued  -> Archived");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
        fromAvailableStatusMover = new FromAvailableStatusMover();

        fromAvailableStatusMover.moveToStatus(testbook, Status.BORROWED);

        fromAvailableStatusMover = new FromBorrowedStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.OVERDUED);

        fromAvailableStatusMover = new FromOverduedStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.ARCHIVED);

        display(testbook);
    }




    //Archived -> Available
    public static void testAAA(){
        System.out.println("test Available -> Archived  -> Available");
        Book testbook = new Book("The Lord of the Rings ");
        BookMover
        fromAvailableStatusMover = new FromAvailableStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.ARCHIVED);

        fromAvailableStatusMover = new FromArchievedStatusMover();
        fromAvailableStatusMover.moveToStatus(testbook, Status.AVAILABLE);
        display(testbook);
    }


    //------------------------------------------------------------------------
    public static void display(Book book){
        System.out.println("[Рузультат] Книга теперь в статусе "+ book.getStatus());
        System.out.println();
    }
}
