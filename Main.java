import java.util.Scanner;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        String mailCheck = "o.konek@bk.ru";
        String passCheck = "12345";
        String pass = "";
        String mail = "";
        Scanner reader = new Scanner(System.in);
        boolean Flag = true;

        while (Flag == true) {
                System.out.println("Введите почту");
                mail = reader.nextLine();
                validateEmail(mail);

                System.out.println("Введите пароль");
                pass = reader.nextLine();
                validatePassword(pass);

                if (mail.equals(mailCheck) && pass.equals(passCheck)) {
                    System.out.println("Вход успешно пройден");
                    Flag = false;
                } else if (mail.equals(mailCheck) == true && pass.equals(passCheck) == false) {
                    System.out.println("Пароль введён неверно");
                } else if (mail.equals(mailCheck) == false && pass.equals(passCheck) == true) {
                    System.out.println("Почта введена неверно");
                } else {
                    System.out.println("Логин и пароль введены неверно");
                }


        }
    }

    public static void validateEmail(String email)  {
        Pattern pattern = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}");
        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()) {
            throw new ValidationException("Почта введена некорректно: пример почты mail@bk.ru");
        }
    }

    public static void validatePassword(String password) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9/%!]*$");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            throw new ValidationException("В пароле разрешены только цифры, латинские буквы разных регистров и некоторые символы {/%!}");
        }
    }

    public static class ValidationException extends RuntimeException {
        public ValidationException(String message) {
            super(message);
        }
    }
}
