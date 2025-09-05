package controller;

import model.GameBoard;
import model.Pair;
import model.Snake;
import strategy.MovementStrategy;
import strategy.movement.Human;

import java.util.Deque;

public class SnakeFoodGame {
    private GameBoard board;
    private Snake snake;
    private int[][] food;
    private int foodIndex;
    private MovementStrategy movementStrategy;

    public SnakeFoodGame(int width, int height, int[][] food) {
        this.board = GameBoard.getInstance(width, height);
        this.food = food;
        this.foodIndex = 0;
        this.snake = new Snake();
        this.movementStrategy = new Human();
    }

    public int move(String direction) {
        // Curr position
        Pair currHead = snake.getBody().peekFirst();

        // Next Position
        Pair newHead = movementStrategy.getNextPosition(currHead, direction);
        int newHeadRow = newHead.getRow();
        int newHeadCol = newHead.getCol();

        // Check Boundary
        boolean crossBoundary = newHeadRow < 0 || newHeadCol < 0 ||
                newHeadRow >= board.getHeight() || newHeadCol >= board.getWidth();


        // Collision check
        Pair currTail = snake.getBody().peekLast();
        boolean biteItself = snake.getPositionMap().containsKey(newHead) &&
                !(newHead.getRow() == currTail.getRow() && newHead.getCol() == currTail.getCol());

        // Game over condition
        if (crossBoundary || biteItself) return -1;

        // Check if snake eats food
        boolean ateFood = (foodIndex < food.length) &&
                (food[foodIndex][0] == newHeadRow) &&
                (food[foodIndex][1] == newHeadCol);

        if (ateFood) {
            foodIndex++;
        } else {
            snake.getBody().pollLast();
            snake.getPositionMap().remove(currTail);
        }

        snake.getBody().addFirst(newHead);
        snake.getPositionMap().put(newHead, true);

        int score = snake.getBody().size() - 1;
        return score;
    }

    public Deque<Pair> getSnake() {
        return snake.getBody();
    }
}
