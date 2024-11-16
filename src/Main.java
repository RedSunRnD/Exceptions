import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "TheBestLogin";
        String password = "HardPassword_01";
        String confirmPassword = "HardPassword_01";

        try {
            validateUser(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println("Ошибка валидации: " + e.getMessage());
        } catch (RuntimeException e) {
        } finally {
            System.out.println("Процесс валидации завершен.");
        }
    }

    public static boolean checkLoginData(String loginData) {
        return loginData == null || loginData.length() > 20 || !loginData.matches("^[a-zA-Z0-9_]+$");
    }

    public static void validateUser(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {

        if (checkLoginData(login)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }

        if (checkLoginData(password)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают.");
        }
    }
}
