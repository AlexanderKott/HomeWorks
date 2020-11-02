package homeworks.hw331;

public interface Administrator {
    void overdueNotification(Reader reader);
    void searchForBookForReader(String name, Reader reader);
    void giveBook(Reader reader);
}
