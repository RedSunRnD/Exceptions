import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        UserValidation[] Users = new UserValidation[]{
                new UserValidation("TheBestLogin", "HardPassword_01", "HardPassword_01"),
                new UserValidation("1111111", "22222222", "22222222")
        };
        try {
            Users[1].validateUser();
        } catch (Exception e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } finally {
            System.out.println("Процесс валидации завершен.");
        }
    }
}