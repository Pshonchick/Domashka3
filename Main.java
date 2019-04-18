import java.util.Scanner;

public class Main {
        private Scanner sc = new Scanner(System.in);
        private Car car;
    private Object Car;

    public Main(){
            car = new Car(2017,"External",180,10,5,1,0);
            chooseMainTask();
        }

        public static void main(String[] args) {
            Main main = new Main();
        }

        public void chooseMainTask(){
            System.out.println();
            System.out.println("Главное меню.");
            System.out.println("Выбирите обьект ? (1 - Машина, 2 - Дверь, 3 - Колёса, другой символ - Выход из програмы)");
            System.out.print("Введите символ: ");
            String n = sc.nextLine().trim();
            switch (n) {
                case "1":
                    Car carExp = new Car ();
                    break;
                case "2":
                    System.out.print("Выбирите дверь? Введите индекс: ");
                    int i = sc.nextInt();
                    sc.nextLine();
                    CarDoor carDoor = car.getCarDoor(i);
                    CarDoor carDoorExp = new CarDoor();
                    break;
                case "3":
                    System.out.print("С каким колесом работаем ? Введите индекс: ");
                    int j = sc.nextInt();
                    sc.nextLine();
                    CarWheel carWheel = car.getCarWheel(j);
                   CarWheel carWheelExp = new CarWheel();
                    break;
                default:
                    System.out.println("Вы закончили выполнение программы.");
                    return;
            }
            chooseMainTask();
        }
    }
