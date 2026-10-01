import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        // Объявление и инициализация переменных
        int step = 0;                  // номер текущего хода
        int personLive = 3;          // количество жизней персонажа
        int sizeBoard = 5;          // размер игрового поля (5x5)
        int personX, personY;       // координаты персонажа

        // Обозначения персонажей
        String person = "Г";
        String monster = "Мм";

        // Располагаем персонажа в центре поля
        personX = 1 + sizeBoard / 2;
        personY = 1 + sizeBoard / 2;

        // Создаём сканер для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Приветственное сообщение
        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");

        // Считываем ответ пользователя
        String answer = scanner.nextLine();

        // Выводим ответ пользователя обратно в консоль
        System.out.println("Ваш ответ:\t" + answer);

        // Обработка ввода пользователя с использованием логических операций (из Встречи 3)
        if (answer.equalsIgnoreCase("ДА")) {
            System.out.println("Отлично! Начинаем игру.");


            // Считываем ответ пользователя
        String answer = scanner.nextLine();

        // Выводим ответ пользователя обратно в консоль
        System.out.println("Ваш ответ:\t" + answer);

        // Проверяем готовность начать игру
        if (answer.equalsIgnoreCase("ДА")) {
            System.out.println("Отлично! Начинаем игру.");

            // Выводим информацию о состоянии игры
            System.out.println("Номер хода: " + step);
            System.out.println("Количество жизней: " + personLive);
            System.out.println("Положение персонажа: X = " + personX + ", Y = " + personY);
            System.out.println("Размер поля: " + sizeBoard + "x" + sizeBoard);

            // Создаём игровое поле с помощью конкатенации строк
            String gamingField = "+ —— + —— + —— + —— + —— +\n"
                    + "| | | | | |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "| | | " + monster + " | | |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "| | | | | |\n"
                    + "+ —— + —— + —— + —— + —— +\n"
                    + "| " + person + " | | | | |\n"
                    + "+ —— + —— + —— + —— + —— +";

            // Выводим игровое поле в консоль
            System.out.println("Игровое поле:");
            System.out.println(gamingField);

            // Увеличиваем номер хода
            step += 1;
            System.out.println("Ход выполнен. Текущий ход: " + step);
        } else {
            System.out.println("Жаль, что ты не хочешь играть. До новых встреч!");
        }

        // Закрываем сканер
        scanner.close();
    }
}
