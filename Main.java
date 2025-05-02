public class Main {
    public static void main(String[] args) {
        UserManager manager = new UserManager();

        // Agregar usuarios
        manager.addUser("Ana");
        manager.addUser("Luis");
        manager.addUser("maia");
        manager.addUser("");// Intento inválido

        // Imprimir la lista de usuarios
        manager.printUsers();
    }
}
