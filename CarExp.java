import java.util.Scanner;

public class CarExp {
    private Scanner sc;
    private Car car;

    public CarExp(Car car){
        this.car = car;
        sc = new Scanner(System.in);
        chooseCarTask();
    }

    private void chooseCarTask(){
        System.out.println();
        System.out.println("Меню \"Машина\".");
        System.out.println("Какое задание выполняем ? (1 - Изменить текущую скорость, 2 - Посадить 1 пасажира, 3 - Висадить 1 пасажира, 4 - Висадить всех пасажиров, ");
        System.out.println("                        5 - Получить дверь по индексу, 6 - Получить колесо по индексу, 7 - Снять все колёса з машины, 8 - Установить на машину новые колёса, ");
        System.out.println("                        9 - Посчитать текущую возможную максимальную скорость, 10 - Вывести информацию об обьекте , другой символ - Виход в главное меню.)");
        System.out.print("Введите символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                System.out.print("Какую текущую скорость установить? Введите целое число: ");
                int x = sc.nextInt();
                sc.nextLine();
                car.setCurrentSpeed(x);
                System.out.println("Текущая скорость: " + car.getCurrentSpeed());
                break;
            case "2":
                car.takeOnePassenger();
                System.out.println("Количество пасажиров в машине: " + car.getCurrentNumberOfPassengers());
                break;
            case "3":
                System.out.println("Количество пасажиров в машине: " + car.getCurrentNumberOfPassengers());
                break;
            case "5":
                System.out.print("Какую дверь получить ? введите индекс: ");
                int i = sc.nextInt();
                sc.nextLine();
                CarDoor cd = car.getCarDoor(i);
                if (cd != null){
                    System.out.println("Получить дверь по индексу " + i + " : " + car.getCarDoor(i));
                    cd.showInfo();
                }
                break;
            case "6":
                System.out.print("Какое колесо получить? введите индекс: ");
                int j = sc.nextInt();
                sc.nextLine();
                CarWheel cw = car.getCarWheel(j);
                if (cw != null) {
                    System.out.println("Получить колесо по индексу " + j + " : " + cw);
                    cw.showInfo();
                }
                break;
            case "7":
                car.getOffAllCarWheels();
                System.out.println("Все колёса зняты.");
                System.out.println("Количество колёс на машине: " + car.getCurrentNumberOfWheels());
                break;
            case "8":
                System.out.print("Сколько колёс вы хотели бы установить? введите целое число: ");
                int k = sc.nextInt();
                sc.nextLine();
                System.out.println("Количество колёс до установки новых: " + car.getCurrentNumberOfWheels());
                car.setNewWheels(k);
                System.out.println("Текущее количество колёс на машине: " + car.getCurrentNumberOfWheels());
                break;
            case "9":
                System.out.println("Максимальная возможная скорость: " + car.getCurrentMaxSpeed(car.getMinTireWheel()));
                break;
            case "10":
                car.showInfo();
                break;
            default:
                return;
        }
        chooseCarTask();
    }
}
