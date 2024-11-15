import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "TheBestLogin";
        String password = "HardPassword_03";
        String confirmPassword = "HardPassword_01";

        try {
            validateUser(login, password, confirmPassword);
        } catch (RuntimeException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } finally {
            System.out.println("Процесс валидации завершен.");
        }
    }

    public static void validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (login == null || login.length() > 20 || !login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }

        if (password == null || password.length() > 20 || !password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}
