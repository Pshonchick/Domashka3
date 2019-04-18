public class CarWheel {
    private double tirestate;    // [0,1]; 0 - out-of-date, 1 - new
    private static final double TIRESTATE_NEW = 1;
    private static final double TIRESTATE_OLD = 0;

    public CarWheel(){
        tirestate = 1;
    }
    public CarWheel(double tirestate){
        if (checkTirestate(tirestate)){
            this.tirestate = tirestate;
        } else {
            System.out.println("Невозможно создать обьект класса CarWheel");
        }
    }

    private boolean checkTirestate(double tirestate){
        boolean result = ((tirestate >= TIRESTATE_OLD) && (tirestate <= TIRESTATE_NEW));
        if (!result) System.out.println("Неправильное значение изношености шины. \n" +
                "Это значение должно быть в пределах между 0 та 1 включительно.");
        return result;
    }

    public void setNewTire(){
        tirestate = TIRESTATE_NEW;
    }

    public void abradeTire(double x){
        if ((x >= 0) && (x <= 100)){
            tirestate *= (1 - (x / 100));
        } else {
            System.out.println("Невозможно виполнить действие. Введённое число должноо состоять в промежутке [0,100]");
        }
    }

    public double getTireState(){
        return tirestate;
    }

    public void showInfo(){
        System.out.println("Состояние шины - " + getTireState() + " от новой.");
    }
}
