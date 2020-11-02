package homeworks.hw311;

final  public class FromArchievedStatusMover extends BookMover {

    @Override
    public void moveToStatus(Book book, Status requestedStatus) {
        System.out.println("Moving status... to "+ requestedStatus);
        if (book.status == Status.ARCHIVED){
            if (requestedStatus == Status.AVAILABLE){
                book.status = Status.AVAILABLE;
                System.out.println("Done");
                return;
            }
        }
        System.out.println("Перевод из статуса "+book.status+" в " +requestedStatus+ " невозможен");
    }
}
