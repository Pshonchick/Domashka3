import java.util.Scanner;

public class CarDoorExp {
    private Scanner sc;
    private CarDoor cardoor;

    public CarDoorExp(CarDoor cardoor){
        sc = new Scanner(System.in);
        this.cardoor = cardoor;
        chooseCarDoorTask();
    }

    private void chooseCarDoorTask(){

        System.out.println();
        System.out.println("Меню \"Дверь\".");
        System.out.println("Какое задание выполняем? (1 - Открыть дверь, 2 - Закрить дверь, 3 - Описать состояние двери" +
                "4 - Открыть окно, 5 - Закрыть окно, 6 - Описать состояние окна стан вікна, " +
                "7 - Вывести информацию про об'ьект, друшлй символ - Выход в главное меню.)");
        System.out.print("Введіть символ: ");
        String n = sc.nextLine().trim();
        switch (n) {
            case "1":
                cardoor.openDoor();
                System.out.println("Открытая дверь.");
                break;
            case "2":
                cardoor.closeDoor();
                System.out.println("Закрытая  дверю.");
                break;
            case "3":
                System.out.println("Состояние двери перед проведением операции: " + ((cardoor.getDoor())?"открыты":"закрыты"));
                cardoor.setDoor();
                System.out.println("Состояние двери после проведения операции: " + ((cardoor.getDoor())?"открыты":"закрыты"));
                break;
            case "4":
                cardoor.openWindow();
                System.out.println("Открыли окно.");
                break;
            case "5":
                cardoor.closeWindow();
                System.out.println("Закрыли окно.");
                break;
            case "6":
                System.out.println("Состояние окна перед проведение операции: " + ((cardoor.getWindow())?"открыты":"закрыты"));
                cardoor.setWindow();
                System.out.println("Состояние окна после проведения операции: " + ((cardoor.getWindow())?"открыты":"закрыты"));
                break;
            case "7":
                cardoor.showInfo();
                break;
            default:
                return;
        }
        chooseCarDoorTask();
    }
}
