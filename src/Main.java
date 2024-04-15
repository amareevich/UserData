//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество дата_рождения номер_телефона пол");
        String input = scanner.nextLine();

        Pattern pattern = Pattern.compile("^([а-яА-Я]+) ([а-яА-Я]+) ([а-яА-Я]+) (\\d{2}\\.\\d{2}\\.\\d{4}) (\\d+) ([mf])$");
        Matcher matcher = pattern.matcher(input);

        if (!matcher.find()) {
            System.out.println("Данные введены в неверном формате");
            return;
        }

        String lastName = matcher.group(1);
        String firstName = matcher.group(2);
        String middleName = matcher.group(3);
        String birthDate = matcher.group(4);
        String phoneNumber = matcher.group(5);
        String gender = matcher.group(6);

        String fileName = lastName + ".txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String dataToWrite = String.format("%s %s %s %s %s %s%n", lastName, firstName, middleName, birthDate, phoneNumber, gender);
            writer.write(dataToWrite);
            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}