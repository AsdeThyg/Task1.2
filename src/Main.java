import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        getResult(getSquareSide());
    }

    private static float getSquareSide() {
        System.out.println("Длина стороны квадрата: ");
        return scanner.nextFloat();
    }

    private static float getFigurePartArea (float squareSide, int mode) {
        if (squareSide<=0)
            throw new IllegalStateException("Invalid side value");
        float squareArea = squareSide*squareSide;
        float circleArea = (float) ((Math.PI*squareSide*squareSide)/4);
        return switch (mode) {
            case 1 -> (squareArea - circleArea) / 2;
            case 2 -> (squareArea - circleArea) / 2 + circleArea;
            case 3 -> (squareArea - circleArea) / 4 + squareArea / 4;
            default -> throw new IllegalStateException("Count mode does not exist");
        };
    }

    private static void getResult(float squareSide) {
        try {
            for (int i=1; i<=3; i++) {
                float FigureArea = getFigurePartArea(squareSide, i);
                System.out.println(i + " Площадь части фигуры: " + FigureArea);
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}