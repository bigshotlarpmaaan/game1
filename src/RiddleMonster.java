import java.util.Random;

public class RiddleMonster extends Monster {

    RiddleMonster(int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83E\uDDDE");
    }

    @Override
    public boolean taskMonster(int difficultGame) {
        System.out.println("ПЕРЕД ТОБОЙ ДЖИНН-ЗАГАДОЧНИК! Отгадай загадку, чтобы пройти:");

        String[][] riddles = {
                {"Висит груша — нельзя скушать.", "лампа"},
                {"Зимой и летом одним цветом.", "ель"},
                {"Не лает, не кусает, а в дом не пускает.", "замок"},
                {"Сидит дед, во сто шуб одет, кто его раздевает, тот слёзы проливает.", "лук"},
                {"Что вверх корнем растёт?", "сосулька"}
        };

        int index = new Random().nextInt(riddles.length);

        if (difficultGame >= 4) {
            System.out.println("Загадка: " + riddles[index][0]);
        } else {
            String firstLetter = riddles[index][1].substring(0, 1);
            System.out.println("Загадка: " + riddles[index][0]
                    + " (первая буква ответа: " + firstLetter + ")");
        }

        String answer = Game.scanner.next().trim().toLowerCase();

        if (riddles[index][1].equals(answer)) {
            System.out.println("Верно! Ты победил монстра");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву! Правильный ответ: " + riddles[index][1]);
            return false;
        }
    }
}

