import myException.WrongLoginException;
import myException.WrongPasswordException;

public class Main {

    public static boolean latinNumeralsUnderlining(char ch) {
        if ( ((int)ch > 47 && (int)ch < 58) || ((int)ch > 64 && (int)ch < 91) || ((int)ch > 96 && (int)ch < 123) || (int)ch == 95 )
            return true;
        else
            return false;
    }

    public static boolean entrance(String login, String password, String confirmPassword) {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException("Введенный логин более 20ти символов. Введите меньшее колличество символов.");
            }
            for (int i = 0; i < password.length(); i++) {
                if (latinNumeralsUnderlining(login.charAt(i))) {
                    throw new WrongLoginException("Не допустимые символы. Можно вводить только латинские буквы, цифры и знак подчеркивания. \nНапример, java_skypro");
                }
            }

            if (password.length() >= 20) {
                throw new WrongPasswordException("Введенный пароль более 19ти символов. Введите меньшее колличество символов.");
            }
            for (int i = 0; i < password.length(); i++) {
                if (latinNumeralsUnderlining(login.charAt(i))) {
                    throw new WrongPasswordException("Не допустимые символы. Можно вводить только латинские буквы, цифры и знак подчеркивания. \nНапример, D_1hWiKjjP_9");
                }
            }

            if (!confirmPassword.equals(password)) {
                throw new WrongPasswordException("Пароли не совпадают.");
            }

            return true;

        } catch (WrongLoginException ex) {
            return false;
        } catch (WrongPasswordException ex) {
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            if (entrance("SkyPro", "qazXDE321", "qazXDE321"))
                System.out.println("Данные введены корректно.");
        } catch (WrongLoginException ex) {
            ex.getMessage();
        } catch (WrongPasswordException ex) {
            ex.getMessage();
        }


    }
}