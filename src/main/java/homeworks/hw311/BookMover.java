package homeworks.hw311;

public abstract class BookMover implements IBookMover {

    public abstract void moveToStatus(Book book, Status requestedStatus);
}
