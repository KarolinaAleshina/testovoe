import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int bestAttempts = Integer.MAX_VALUE;
        boolean play = true;

        while (play) {
            int chosenNumber = random.nextInt(100) + 1;
            int attempts = 0;
            boolean mystery = false;

            System.out.println("Я загадал число от 1 до 100. Попробуй угадать!");
            System.out.println("(Введи RESULT, чтобы увидеть статистику)");

            while (!mystery) {
                System.out.print("Введи число: ");
                String input = scanner.nextLine();

                if (input.equalsIgnoreCase("RESULT")) {
                    System.out.println("Текущие попытки: " + attempts);
                    if (bestAttempts == Integer.MAX_VALUE) {
                        System.out.println("Лучший результат: пока нет");
                    } else {
                        System.out.println("Лучший результат: " + bestAttempts);
                    }
                    continue;
                }

                int userNumber;
                try {
                    userNumber = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Это не число и не команда RESULT. Попробуй снова.");
                    continue;
                }

                if (userNumber < 1 || userNumber > 100) {
                    System.out.println("Число должно быть от 1 до 100.");
                    continue;
                }

                attempts++;

                if (userNumber == chosenNumber) {
                    System.out.println("Поздравляю! Ты угадал!");
                    System.out.println("Количество попыток: " + attempts);
                    System.out.println("Загаданное число: " + chosenNumber);

                    if (attempts < bestAttempts) {
                        bestAttempts = attempts;
                        System.out.println("Это новый лучший результат!");
                    } else {
                        System.out.println("Лучший результат: " + bestAttempts);
                    }

                    mystery = true;
                } else if (userNumber < chosenNumber) {
                    System.out.println("Я сам в шоке, но, загаданное число больше, брат");
                } else {
                    System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
                }
            }
        }
        System.out.println("Спасибо за игру! Лучший результат: " + bestAttempts + " попыток.");
    }
}