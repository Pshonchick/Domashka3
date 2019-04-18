public class Car {
    private int releaseDate = (int) 09.2017;
    private String engineType;
    private int maxSpeed;
    private int runupTime;
    private int totalNumberOfPassengers;
    private int currentNumberOfPassengers;
    private int currentSpeed;
    private CarDoor[] cardoors = new CarDoor[MAX_DOORS];
    private CarWheel[] carwheels = new CarWheel[MAX_WHEELS];
    private int wheelCounter;
    private static final int MAX_DOORS = 4;
    private static final int MAX_WHEELS = 10;
    public Car(int releaseDate) {
        this.releaseDate = releaseDate;
        this.setCarDoors();
        this.setCarWheels();
    }

    public Car(int releaseDate, String engineType, int maxSpeed, int runupTime,
               int totalNumberOfPassengers, int currentNumberOfPassengers, int currentSpeed){
        this.releaseDate = releaseDate;
        this.engineType = engineType;
        this.maxSpeed = maxSpeed;
        this.runupTime = runupTime;
        this.totalNumberOfPassengers = totalNumberOfPassengers;
        this.currentNumberOfPassengers = currentNumberOfPassengers;
        this.currentSpeed = currentSpeed;
        this.setCarDoors();
        this.setCarWheels();
    }

    public Car() {

    }

    public void setCurrentSpeed(int currentSpeed){
        if ((currentSpeed <= maxSpeed) && (currentSpeed >= 0)) {
            this.currentSpeed = currentSpeed;
        } else {
            System.out.println("Невозмжно установить данную скорость. Она не входит в промежуток [0," + maxSpeed + "]");
        }
    }

    public int getCurrentSpeed(){
        return currentSpeed;
    }

    public void takeOnePassenger(){
        if (currentNumberOfPassengers >= totalNumberOfPassengers){
            System.out.println("Невозможно взять пасажиров. Машина заполнена.");
        } else {
            currentNumberOfPassengers++;
        }
    }
    public int getCurrentNumberOfPassengers(){
        return currentNumberOfPassengers;
    }
    private boolean checkPassengers(){
        return (currentNumberOfPassengers > 0);
    }

    public void getoffOnePassenger(){
        if (checkPassengers()) {
            currentNumberOfPassengers--;
        } else {
            System.out.println("Невозможно висадить пасажиров. Они отсутсвуют в машине");
        }
    }

    public void getoffAllPassengers(){
        if (checkPassengers()) {
            currentNumberOfPassengers = 0;
        } else {
            System.out.println("Невозможно висадить пасажиров. Они отсутсвуют в машине");
        }
    }

    public void setCarDoors(){
        for (int i = 0; i < MAX_DOORS; i++){
            cardoors[i] = new CarDoor();
        }
    }

    public void setCarWheels(){
        wheelCounter = 4;
        for (int i=0; i < wheelCounter; i++){
            carwheels[i] = new CarWheel();
        }
    }

    public CarDoor getCarDoor(int i){
        if ((i >= 0) && (i <= MAX_DOORS-1)){
            return cardoors[i];
        } else {
            System.out.println("Дверей з таким индексом не существует.");
            return null;
        }
    }

    public CarWheel getCarWheel(int i){
        if ((i >= 0) && (i <= wheelCounter-1)){
            return carwheels[i];
        } else {
            System.out.println("Колёс з таким индексом не существует.");
            return null;
        }
    }

    public void getOffAllCarWheels(){
        for (CarWheel carwheel: carwheels){
            carwheel = null;
        }
        wheelCounter = 0;
    }

    public void setNewWheels(int x){
        if (x + wheelCounter > MAX_WHEELS) {
            System.out.println("Невозможно добавить " + x + " колёс. Будет превышино максимальное количество " + MAX_WHEELS);
        } else {
            for (int i = 0; i < x; i++){
                carwheels[wheelCounter + i] = new CarWheel();
            }
            wheelCounter += x;
        }
    }

    public double getCurrentMaxSpeed(double minTWheel){
        if ((currentNumberOfPassengers == 0) || (wheelCounter == 0)){
            return 0;
        } else {
            return maxSpeed * minTWheel;
        }
    }
    public double getMinTireWheel(){
        double result = carwheels[0].getTireState();
        for (int i = 0; i < wheelCounter; i++){
            result = (carwheels[i].getTireState() < result)?carwheels[i].getTireState():result;
        }
        return result;
    }

    public int getCurrentNumberOfWheels(){
        return wheelCounter;
    }

    public void showInfo(){
        System.out.println("Дата производства новой машины: " + releaseDate);
        System.out.println("Тип двигателя: " + engineType);
        System.out.println("Максимальная скорость новой машины: " + maxSpeed);
        System.out.println("Время розгона до 100км/час: " + runupTime);
        System.out.println("Вместительность пасажиров: " + totalNumberOfPassengers);
        System.out.println("Количество пасажиров в данный момент: " + currentNumberOfPassengers);
        System.out.println("Количество колёс: " + wheelCounter);
        System.out.println("Текущая скорость: " + currentSpeed);
        System.out.println("Текущая возможная скорость: " + getCurrentMaxSpeed(getMinTireWheel()));
    }
}
