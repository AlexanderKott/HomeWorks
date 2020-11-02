package homeworks.hw341;

public class UsersDB {

    private User[] users = {
       new User("login1","pass1","mail1@mail1.ru", 18),
       new User("login2","pass2","mail2@mail1.ru", 10),
       new User("login3","pass3","mail3@mail1.ru", 70),
       new User("login4","pass4","mail4@mail1.ru", 30),
       new User("login5","pass5","mail5@mail1.ru", 15),
       new User("login6","pass6","mail6@mail1.ru", 25),

    };


    public User[] getUsers() {
        return users;
    }
}
