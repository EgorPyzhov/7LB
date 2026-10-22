
abstract class Figure {
    protected String name;

    public Figure() {
        this.name = "Геометрична фігура";
    }

    public Figure(String name) {
        this.name = name;
    }

    public abstract double area();

    public void showInfo() {
        System.out.println("Фігура: " + name);
    }

    public void showInfo(String message) {
        System.out.println(message + ": " + name);
    }
}

class Circle extends Figure {
    private double radius;

    public Circle() {
        super("Коло");
        this.radius = 1;
    }

    public Circle(double radius) {
        super("Коло");
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public void showInfo() {
        System.out.printf("Коло | Радіус: %.1f | Площа: %.2f%n",
                radius, area());
    }
}

class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Прямокутник");
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public void showInfo() {
        System.out.printf("Прямокутник | Сторони: %.1f x %.1f | Площа: %.2f%n",
                width, height, area());
    }
}

class Drawing {
    private Figure figure;

    public Drawing() {
        this.figure = new Figure() {
            @Override
            public double area() {
                return 0;
            }
        };
    }

    public Drawing(Figure figure) {
        this.figure = figure;
    }

    public void showInfo() {
        System.out.println("Малюнок містить фігуру:");
        figure.showInfo();
    }

    public void showInfo(String title) {
        System.out.println(title);
        figure.showInfo();
    }
}

public class Main {
    public static void main(String[] args) {
        Figure figure = new Circle(5);
        Circle circle = new Circle(5);
        Rectangle rectangle = new Rectangle(4, 6);

        System.out.println("       ГЕОМЕТРИЧНІ ФІГУРИ");

        figure.showInfo();
        figure.showInfo("Назва");
        System.out.printf("Площа фігури: %.2f%n", figure.area());

        circle.showInfo();
        System.out.printf("Площа кола: %.2f%n", circle.area());

        Figure anotherCircle = new Circle(3);
        anotherCircle.showInfo();

        rectangle.showInfo();

        Drawing drawing = new Drawing(circle);
        drawing.showInfo();
        drawing.showInfo("Інформація про малюнок");
    }
}
