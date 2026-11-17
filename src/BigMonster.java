import java.util.Random;

public class BigMonster extends Monster {

    BigMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC79");
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return super.taskMonster(1);
        }

        System.out.println("ПЕРЕД ТОБОЙ БОЛЬШОЙ МОНСТР! Решите задачу, чтобы победить:");

        Random random = new Random();
        int trueAnswer;
        String question;

        if (difficultGame == 2) {
            int x = 10 + random.nextInt(10);  // от 10 до 19
            int y = 10 + random.nextInt(10);  // от 10 до 19
            int z = random.nextInt(100);      // от 0 до 99

            trueAnswer = x * y - z;
            question = x + " × " + y + " - " + z;

        } else if (difficultGame == 3) {
            // деление с гарантированным целым ответом
            int divisor = 2 + random.nextInt(8);      // от 2 до 9
            int multiplier = 10 + random.nextInt(40); // от 10 до 49
            int dividend = divisor * multiplier;

            trueAnswer = multiplier;
            question = dividend + " ÷ " + divisor;

        } else if (difficultGame == 4) {
            // пример со скобками
            int a = 5 + random.nextInt(15);   // от 5 до 19
            int b = 5 + random.nextInt(15);   // от 5 до 19
            int c = 2 + random.nextInt(8);    // от 2 до 9
            int d = 10 + random.nextInt(40);  // от 10 до 49

            trueAnswer = (a + b) * c - d;
            question = "(" + a + " + " + b + ") × " + c + " - " + d;

        } else {
            // уровень 5: два умножения, первое всегда больше второго —
            // новый паттерн, не как на 2-м уровне
            int a = 20 + random.nextInt(30); // от 20 до 49
            int b = 10 + random.nextInt(10); // от 10 до 19
            int c = 2 + random.nextInt(9);   // от 2 до 10
            int d = random.nextInt(10);      // от 0 до 9

            trueAnswer = a * b - c * d;
            question = a + " × " + b + " - " + c + " × " + d;
        }

        return askExample(question, trueAnswer);
    }
}

