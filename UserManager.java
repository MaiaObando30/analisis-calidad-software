import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private List<String> users;

    public UserManager() {
        users = new ArrayList<>();
    }

    public boolean addUser(String username) {
        if (username == null || username.trim().isEmpty()) {
            System.out.println("Error: El nombre de usuario no puede estar vacío.");
            return false;
        }

        users.add(username);
        System.out.println("Usuario agregado: " + username);
        return true;
    }

    public List<String> getUsers() {
        return new ArrayList<>(users);
    }

    public void printUsers() {
        if (users.isEmpty()) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println(" Lista de usuarios:");
            for (String user : users) {
                System.out.println("- " + user);
            }
        }
    }
}
