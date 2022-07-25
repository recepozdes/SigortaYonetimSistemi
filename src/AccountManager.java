import java.util.TreeSet;

public class AccountManager {

    TreeSet<Account> users = new TreeSet<>();

    public void addUsers() throws ClassCastException {
        Address address = new HomeAddress("Ankara", "Alsancak", "Leylak Sokak", "Ata 2 sitesi leylak sokak Alsancak Ankara");
        User user1 = new User("Recep", "Özdeş", "recep@recep.com", "123", "developer", 33, address, "Individual");
        Account account = new Individual(user1);

        Address address2 = new HomeAddress("İzmir", "Bornova", "Gül Sokak", "Gül sokak no 46 Merkez İzmir");
        User user2 = new User("Esra", "Özdeş", "esra@esra.com", "456", "mühendis", 30, address2, "Enterprise");
        Account account2 = new Enterprise(user2);
        users.add(account);
        users.add(account2);
    }

    public Account login(String email, String password) {
        addUsers();
        try {
            for (Account acc : users) {
                if (acc.getUser().getEmail().equals(email) && acc.getUser().getPassword().equals(password)) {
                    acc.login(email, password, acc);
                    return acc;
                }
            }
            throw new InvalidAuthenticationException("Şifre veya email yanlış girildi!");

        } catch (InvalidAuthenticationException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}