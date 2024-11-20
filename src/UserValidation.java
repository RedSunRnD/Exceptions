import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class UserValidation extends User {
    private String confirmPassword;

    public UserValidation(String login, String password, String confirmPassword) {
        super(login, password);
        this.confirmPassword = confirmPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public static boolean checkLoginData(String loginData) {
        return loginData == null || loginData.length() > 20 || !loginData.matches("^[a-zA-Z0-9_]+$");
    }

    public void validateUser() {
        String login = getLogin();
        String password = getPassword();
        String confirmPassword = getConfirmPassword();

        if (checkLoginData(login)) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }
        if (checkLoginData(password)) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
