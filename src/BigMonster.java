import java.util.Random;

public class BigMonster extends Monster {
    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC79"); // 👹
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return super.taskMonster(1);
        } else {
            System.out.println("ПЕРЕД ТОБОЙ БОЛЬШОЙ МОНСТР! Решите задачу, чтобы победить:");

            Random random = new Random();
            int trueAnswer = 0;
            String question = "";

            if (difficultGame == 2) {
                int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
                int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
                int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);

                trueAnswer = x * y - z;
                question = x + " * " + y + " - " + z;

            } else if (difficultGame == 3) {
                // деление с гарантированным целым ответом
                int divisor = random.nextInt(2, 10);
                int multiplier = random.nextInt(10, 50);
                int dividend = divisor * multiplier;

                trueAnswer = multiplier;
                question = dividend + " / " + divisor;

            } else if (difficultGame == 4) {
                // пример со скобками
                int a = random.nextInt(5, 20);
                int b = random.nextInt(5, 20);
                int c = random.nextInt(2, 10);
                int d = random.nextInt(10, 50);

                trueAnswer = (a + b) * c - d;
                question = "(" + a + " + " + b + ") * " + c + " - " + d;

            } else {
                // уровень 5 и выше — как уровень 2
                int x = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
                int y = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
                int z = random.nextInt(100 * (difficultGame - 1), 100 * difficultGame);

                trueAnswer = x * y - z;
                question = x + " * " + y + " - " + z;
            }

            System.out.println("Реши пример: " + question + " = ?");

            int answer = Game.scanner.nextInt();

            if (trueAnswer == answer) {
                System.out.println("Верно! Ты победил монстра");
                return true;
            } else {
                System.out.println("Ты проиграл эту битву!");
                return false;
            }
        }
    }

    public boolean taskMonster() {
        return super.taskMonster(1);
    }
}
