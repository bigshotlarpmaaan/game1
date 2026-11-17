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

    // Общий метод: показывает пример, читает ответ и сравнивает его с правильным.
    // trueAnswer вычисляется В МОМЕНТ генерации чисел — поэтому всегда совпадает с примером.
    protected boolean askExample(String question, int trueAnswer) {
        System.out.println("Реши пример: " + question + " = ?");
        int answer = Game.scanner.nextInt();

        if (answer == trueAnswer) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву! Правильный ответ: " + trueAnswer);
            return false;
        }
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");

        Random random = new Random();
        int trueAnswer;
        String question;

        if (difficultGame == 1) {
            int a = random.nextInt(100);
            int b = random.nextInt(100);
            trueAnswer = a + b;
            question = a + " + " + b;
        } else if (difficultGame == 2) {
            int a = random.nextInt(80) + 20;
            int b = random.nextInt(a);
            trueAnswer = a - b;
            question = a + " - " + b;
        } else if (difficultGame == 3) {
            int a = random.nextInt(12) + 1;
            int b = random.nextInt(10) + 1;
            trueAnswer = a * b;
            question = a + " × " + b;
        } else if (difficultGame == 4) {
            // деление с гарантированным целым ответом
            int b = random.nextInt(9) + 2;       // делитель: от 2 до 10
            int result = random.nextInt(15) + 5; // частное: от 5 до 19
            int a = b * result;                  // делимое — всегда делится нацело
            trueAnswer = result;
            question = a + " ÷ " + b;
        } else if (difficultGame == 5) {
            int a = random.nextInt(40) + 10;
            int b = random.nextInt(10) + 1;
            int c = random.nextInt(5) + 1;
            trueAnswer = a - (b * c);
            question = a + " - (" + b + " × " + c + ")";
        } else {
            System.out.println("Неизвестный уровень сложности.");
            return false;
        }

        return askExample(question, trueAnswer);
    }
}
