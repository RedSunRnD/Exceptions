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

    public void validateUser() {
        String login = getLogin();
        String password = getPassword();
        String confirmPassword = getConfirmPassword();

        if (login == null || login.length() > 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }
        if (password == null || password.length() > 20 || !password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов.");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
    }
}
