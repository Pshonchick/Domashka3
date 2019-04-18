import java.util.Scanner;

public class CarWheelExp {
    private Scanner sc;
    private CarWheel carWheel;

    public CarWheelExp(CarWheel carWheel){
        sc = new Scanner(System.in);
        this.carWheel = carWheel;
        chooseCarWheelTask();
    }

    private void chooseCarWheelTask(){

        System.out.println();
        System.out.println("Меню \"Колёса\".");
        System.out.println("Какое задание выполняем ? (1 - Поставить новую шину, 2 - Стереть шину на Х%, " +
                "3 - Вывести состояние шины, 4 - Вывести информацию про обьект, другой символ - Выход в главное меню.)");
        System.out.print("Введите символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                carWheel.setNewTire();
                System.out.println("Новую шину установлено");
                break;
            case "2":
                System.out.print("На скілько процентов стереть шину? Введить число от 0 до 100: ");
                double x = sc.nextDouble();
                sc.nextLine();
                carWheel.abradeTire(x);
                System.out.println("Шину стёрто на " + x + "%");
                carWheel.showInfo();
                break;
            case "3":
                System.out.println("Состояние шины - " + carWheel.getTireState() + " от новой.");
                break;
            case "4":
                carWheel.showInfo();
                break;
            default:
                return;
        }
        chooseCarWheelTask();
    }
}
