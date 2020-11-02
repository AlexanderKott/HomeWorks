package homeworks.hw311;

final public class FromAvailableStatusMover extends BookMover {
    @Override
    public void moveToStatus(Book book, Status requestedStatus) {
        System.out.println("Moving status... to "+ requestedStatus);
        if (book.status == Status.AVAILABLE) {
            switch (requestedStatus) {
                case BORROWED:
                case ARCHIVED:
                    book.status = requestedStatus;
                    System.out.println("Done");
                    return;

            }
        }

        System.out.println("Перевод из статуса "+book.status+" в " +requestedStatus+ " невозможен");
    }
}
