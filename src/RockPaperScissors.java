import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private User user;
    private Computer computer;
    private int userScore;
    private int computerScore;
    private int numberOfGames;

    private enum Move {
        ROCK, PAPER, SCISSORS;

        /**
         * Сравнивает текущий ход с переданным в параметре otherMove и определяет
         * победу, поражение или ничью.
         *
         * @param otherMove
         *            ход, с которым сравнивается текущий
         * @return 1 если текущий ход бьет другой, -1 если другой ход бьет текущий,
         *         0 в случае ничьей
         */
        public int compareMoves(Move otherMove) {
            // Ничья
            if (this == otherMove)
                return 0;

            switch (this) {
                case ROCK:
                    return (otherMove == SCISSORS ? 1 : -1);
                case PAPER:
                    return (otherMove == ROCK ? 1 : -1);
                case SCISSORS:
                    return (otherMove == PAPER ? 1 : -1);
            }

            // Этот код не должен выполняться никогда

            return 0;
        }
    }

    private class User {
        private Scanner inputScanner;

        public User() {
            inputScanner = new Scanner(System.in);
        }

        public Move getMove() {
            // Выведем запрос на ввод
            System.out.print("Камень, ножницы или бумага? ");

            // Прочитаем ввод пользователя
            String userInput = inputScanner.nextLine();
            userInput = userInput.toUpperCase();
            char firstLetter = userInput.charAt(0);
            if (firstLetter == 'К' || firstLetter == 'Н' || firstLetter == 'Б') {
                // Ввод корректный
                switch (firstLetter) {
                    case 'К':
                        return Move.ROCK;
                    case 'Н':
                        return Move.PAPER;
                    case 'Б':
                        return Move.SCISSORS;
                }
            }

            // Ввод некорректный. Выведем запрос на ввод снова.
            return getMove();
        }

        public boolean playAgain() {
            System.out.print("Хотите сыграть еще раз? ");
            String userInput = inputScanner.nextLine();
            userInput = userInput.toUpperCase();
            return userInput.charAt(0) == 'Y';
        }
    }

    private class Computer {
        public Move getMove() {
            Move[] moves = Move.values();
            Random random = new Random();
            int index = random.nextInt(moves.length);
            return moves[index];
        }
    }

    public RockPaperScissors() {
        user = new User();
        computer = new Computer();
        userScore = 0;
        computerScore = 0;
        numberOfGames = 0;
    }

    public void startGame() {
        System.out.println("КАМЕНЬ, НОЖНИЦЫ, БУМАГА!");

        // Получение ходов
        Move userMove = user.getMove();
        Move computerMove = computer.getMove();
        System.out.println("\nВаш ход " + userMove + ".");
        System.out.println("Ход компьютера " + computerMove + ".\n");

        // Сравнение ходов и определение победителя
        int compareMoves = userMove.compareMoves(computerMove);
        switch (compareMoves) {
            case 0: // Ничья
                System.out.println("Tie!");
                break;
            case 1: // Победил игрок
                System.out.println(userMove + " beats " + computerMove + ". Вы победили!");
                userScore++;
                break;
            case -1: // Победил компьютер
                System.out.println(computerMove + " beats " + userMove + ". Вы проиграли.");
                computerScore++;
                break;
        }
        numberOfGames++;

        // Предложим пользователю сыграть еще раз
        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            printGameStats();
        }
    }

    /**
     * Вывод статистики. Ничьи учитываются как полпобеды
     * при подсчете процента побед.
     */
    private void printGameStats() {
        int wins = userScore;
        int losses = computerScore;
        int ties = numberOfGames - userScore - computerScore;
        double percentageWon = (wins + ((double) ties) / 2) / numberOfGames;

        // Вывод линии
        System.out.print("+");
        printDashes(68);
        System.out.println("+");

        // Вывод заголовков таблицы
        System.out.printf("|  %6s  |  %6s  |  %6s  |  %12s  |  %14s  |\n",
                "WINS", "LOSSES", "TIES", "GAMES PLAYED", "PERCENTAGE WON");

        // Вывод линии
        System.out.print("|");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(10);
        System.out.print("+");
        printDashes(16);
        System.out.print("+");
        printDashes(18);
        System.out.println("|");

        // Вывод значений
        System.out.printf("|  %6d  |  %6d  |  %6d  |  %12d  |  %13.2f%%  |\n",
                wins, losses, ties, numberOfGames, percentageWon * 100);

        // Вывод линии
        System.out.print("+");
        printDashes(68);
        System.out.println("+");
    }

    private void printDashes(int numberOfDashes) {
        for (int i = 0; i < numberOfDashes; i++) {
            System.out.print("-");
        }
    }

//    public static void main(String[] args) {
//        RockPaperScissors game = new RockPaperScissors();
//        game.startGame();
//    }
}
