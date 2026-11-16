import java.util.Random;

public class Monster {
    private String image = "\uD83E\uDDDF";
    private final int x, y;

    Monster(int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard); // от 1 до sizeBoard — по всей ширине поля
        y = 1 + random.nextInt(sizeBoard); // от 1 до sizeBoard — по всей высоте поля
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean conflictPerson(int personX, int personY) {
        return personX == x && personY == y;
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");

        if (difficultGame == 1) {
            Random random = new Random();
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            int trueAnswer = a + b;

            System.out.println("Реши пример: " + a + " + " + b + " = ?");
            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 2) {
            Random random = new Random();
            int a = random.nextInt(80) + 20;
            int b = random.nextInt(a);
            int trueAnswer = a - b;

            System.out.println("Реши пример: " + a + " - " + b + " = ?");
            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 3) {
            Random random = new Random();
            int a = random.nextInt(12) + 1;
            int b = random.nextInt(10) + 1;
            int trueAnswer = a * b;

            System.out.println("Реши пример: " + a + " × " + b + " = ?");
            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 4) {
            Random random = new Random();
            int a = random.nextInt(20) + 5;
            int b = random.nextInt(15) + 5;
            int trueAnswer = a * b;

            System.out.println("Реши пример: " + a + " × " + b + " = ?");
            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else if (difficultGame == 5) {
            Random random = new Random();
            int a = random.nextInt(40) + 10;
            int b = random.nextInt(10) + 1;
            int c = random.nextInt(5) + 1;
            int trueAnswer = a - (b * c);

            System.out.println("Реши пример: " + a + " - (" + b + " × " + c + ") = ?");
            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        } else {
            System.out.println("неизвестный уровень сложности.");
            return false;
        }
    }
}