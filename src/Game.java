import java.util.Random;
import java.util.Scanner;

public class Game {
    static final Scanner scanner = new Scanner(System.in); // единственный сканнер в игре

    public static void main(String[] args) {
        String castle = "\uD83C\uDFF0"; // 🏰

        int sizeBoard = 5;
        int step = 0;
        Person person = new Person(sizeBoard);

        Random random = new Random();
        int castleX = 1 + random.nextInt(sizeBoard);
        int castleY = 1;

        String[][] board = new String[sizeBoard][sizeBoard];
        for (int y = 1; y <= sizeBoard; y++) {
            for (int x = 1; x <= sizeBoard; x++) {
                board[y - 1][x - 1] = "  ";
            }
        }

        // Замок ставим ПЕРВЫМ, чтобы монстр не мог заспавниться под ним
        board[castleY - 1][castleX - 1] = castle;

        int countMonster = sizeBoard * sizeBoard - sizeBoard - 1;
        Monster[] monsters = new Monster[countMonster];
        int count = 0;

        while (count < countMonster) {
            Monster monster;
            int remainder = count % 3; // типы монстров идут по кругу

            if (remainder == 0) {
                monster = new Monster(sizeBoard);
            } else if (remainder == 1) {
                monster = new BigMonster(sizeBoard);
            } else {
                monster = new RiddleMonster(sizeBoard);
            }

            int row = monster.getY() - 1;
            int column = monster.getX() - 1;

            if (board[row][column].equals("  ")) {
                board[row][column] = monster.getImage();
                monsters[count] = monster;
                count++;
            }
        }

        System.out.println("Привет! Ты готов начать играть в игру? (Напиши: ДА или НЕТ)");
        String answer = scanner.nextLine().trim().toUpperCase();
        System.out.println("Ваш ответ:\t" + answer);

        switch (answer) {
            case "ДА":
                System.out.println("Выбери сложность игры (от 1 до 5):");
                int difficultGame = scanner.nextInt();
                scanner.nextLine(); // съедаем Enter после nextInt
                System.out.println("Выбранная сложность:\t" + difficultGame);

                while (true) {
                    board[person.getY() - 1][person.getX() - 1] = person.getImage();
                    outputBoard(board, person.getLive());

                    System.out.println("Введите, куда будет ходить персонаж "
                            + "(ход возможен только по вертикали или горизонтали на одну клетку)"
                            + "\nКоординаты персонажа — (x: " + person.getX()
                            + ", y: " + person.getY() + ")");

                    int x = scanner.nextInt();
                    int y = scanner.nextInt();
                    scanner.nextLine(); // съедаем Enter — важно для задач с текстовым ответом
                    System.out.println(x + ", " + y);

                    // Проверка границ поля
                    if (x < 1 || x > sizeBoard || y < 1 || y > sizeBoard) {
                        System.out.println("Некорректный ход: координаты вне поля!");
                        continue;
                    }

                    // Проверка, что ход на одну клетку
                    if (!person.isMoveCorrect(x, y)) {
                        System.out.println("Некорректный ход");
                        continue;
                    }

                    String cell = board[y - 1][x - 1];

                    if (cell.equals("  ")) {
                        // Пустая клетка — просто идём
                        board[person.getY() - 1][person.getX() - 1] = "  ";
                        person.move(x, y);
                        step++;
                        System.out.println("Ход корректный; новые координаты: "
                                + person.getX() + ", " + person.getY()
                                + "\nХод номер: " + step);
                    } else if (cell.equals(castle)) {
                        System.out.println("Вы прошли игру!");
                        break;
                    } else {
                        // Клетка занята монстром — бой
                        System.out.println("На пути монстр! Начинается битва...");

                        for (Monster monster : monsters) {
                            if (monster.getX() == x && monster.getY() == y) {
                                if (monster.taskMonster(difficultGame)) {
                                    System.out.println("Монстр повержен!");
                                    board[person.getY() - 1][person.getX() - 1] = "  ";
                                    board[y - 1][x - 1] = "  "; // монстр исчезает с поля
                                    person.move(x, y);
                                    step++;
                                } else {
                                    person.downLive();
                                    System.out.println("Жизней осталось: " + person.getLive());
                                }
                                break;
                            }
                        }
                    }

                    if (person.getLive() <= 0) {
                        System.out.println("Закончились жизни. Итог: пройдено ходов — " + step);
                        break;
                    }
                }
                break;

            case "НЕТ":
                System.out.println("Жаль, приходи ещё!");
                break;

            default:
                System.out.println("Данные введены некорректно");
                break;
        }
    }

    static void outputBoard(String[][] board, int live) {
        String leftBlock = "| ";
        String rightBlock = "|";
        String wall = "+ —— + —— + —— + —— + —— +";

        for (String[] row : board) {
            System.out.println(wall);
            for (String col : row) {
                System.out.print(leftBlock + col + " ");
            }
            System.out.println(rightBlock);
        }
        System.out.println(wall);

        System.out.println("Количество жизней:\t" + live + "\n");
    }
}


