package Snake;

import javafx.geometry.Pos;

import java.util.*;

public class App extends Thread{

    private Snake snake;
    private Fruit fruit;
    private int[][] matrix;
    private int height;
    private int widht;
    private Map<Directions, Position> directions = new HashMap<>();
    private boolean eaten;


    {
        eaten = false;
        height = 20;
        widht = 20;
        snake = new Snake(createChains(), Directions.RIGHT);
        matrix = new int[height][widht];
        fruit = new Fruit(new Position(10, 15));

        directions.put(Directions.RIGHT, new Position(0, 1));
        directions.put(Directions.LEFT, new Position(0, -1));
        directions.put(Directions.UP, new Position(1, 0));
        directions.put(Directions.LEFT, new Position(-1, 0));
    }

    private List<Position> createChains() {

        List<Position> list = new ArrayList<>();
        list.add(new Position(10,10));
        list.add(new Position(10,9));
        list.add(new Position(10,8));
        list.add(new Position(10,7));
        list.add(new Position(10,6));
        return list;
    }

    public void render(){
        String[] str = {".", "*", "@"};
        for (int y = 0; y != height; ++y) {
            for (int x = 0; x != widht; ++x) {
                matrix[y][x] = 0;
            }
        }
        if (eaten){
            snake.getChains().add(new Position());
            eaten = false;
        }
        for (int i = 0; i != snake.getChains().size(); ++i) {
            Position position = snake.getChains().get(i);
            matrix[position.getY()][position.getX()] = 1;
        }

        Position position = fruit.getPosition();
        matrix[position.getY()][position.getX()] = 2;

        for (int y = 0; y != height; ++y) {
            for (int x = 0; x != widht; ++x) {
                System.out.print(str[matrix[y][x]]);
            }
            System.out.println();
        }
        System.out.println("\n\n");
        }


    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

    @Override
    public void run() {
        while (true)
        {
            render();
            move();
            checkIfEaten();
            try{
                Thread.sleep(1000);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void checkIfEaten() {
        Position head = snake.getChains().get(0);
        Position fruitPosition = fruit.getPosition();
        if (head.equals(fruitPosition)){
            eaten = true;
            fruit.setPosition(generateNewPosition());
        }
    }

    private Position generateNewPosition() {
        List<Position> empty = getEmpry();
        return empty.get(new Random().nextInt(empty.size() - 1));
    }

    private List<Position> getEmpry() {
        List<Position> list = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < widht; x++) {
                Position position = new Position(y, x);
                if (!snake.getChains().contains(position))
                    list.add(position);
            }

        }
        return list;
    }

    private void move() {
        List<Position> chais = snake.getChains();
        for (int i = snake.getChains().size() - 1; i != 0; --i) {
            Position position = snake.getChains().get(i);
            Position previous = snake.getChains().get(i - 1);
            position.setY(previous.getY());
            position.setX(previous.getX());
        }

        Position head = chais.get(0);
        Directions direction = snake.getDirections();
        head.setY(head.getY() + directions.get(direction).getY());
        head.setX(head.getX() + directions.get(direction).getX());
    }
}
