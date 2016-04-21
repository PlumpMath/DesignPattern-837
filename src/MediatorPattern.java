/**
 * Created by mike on 4/19/16.
 */

interface ThingsWaitingToPass {
    public void Pass();
}

class Car implements ThingsWaitingToPass{
    private String number;
    private Mediator trafficPolice;

    public Car(String number) {
        this.number = number;
        System.out.println("Car " + number + " is arrived.");
    }

    public void setTrafficPolice(Mediator trafficPolice) {
        this.trafficPolice = trafficPolice;
    }

    public void Pass() {
        if (trafficPolice.getPassStatus()) {
            trafficPolice.somethingPassed();
            System.out.println("Car " + number + " was pass.");
        }
        else {
            System.out.println("Car " + number + " is waiting to pass.");
        }
    }
}

class People implements ThingsWaitingToPass {
    private String name;
    private Mediator trafficPolice;

    public People(String name) {
        this.name = name;
        System.out.println(name + "is arrived.");
    }

    public void setTrafficPolice(Mediator trafficPolice) {
        this.trafficPolice = trafficPolice;
    }

    public void Pass() {
        if (trafficPolice.getPassStatus()) {
            trafficPolice.somethingPassed();
            System.out.println(name + " was pass.");
        }
        else {
            System.out.println(name + " is waiting to pass.");
        }
    }
}

interface Mediator {
    public void registerPeople(People people);
    public void registerCar(Car car);
    public void somethingPassed();
    public boolean getPassStatus();
    public void setPassStatus(boolean passStatus);
}

class TrafficPolice implements Mediator {
    private People people;
    private Car car;
    private boolean canPass;

    public TrafficPolice() {
        canPass = true;
    }

    public void registerPeople(People people) {
        this.people = people;
    }

    public void registerCar(Car car) {
        this.car = car;
    }

    public void somethingPassed() {
        canPass = true;
    }

    public boolean getPassStatus() {
        return canPass;
    }

    public void setPassStatus(boolean passStatus) {
        this.canPass = passStatus;
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        TrafficPolice trafficPolice = new TrafficPolice();
        trafficPolice.setPassStatus(false);
        Car car = new Car("A8888");
        car.setTrafficPolice(trafficPolice);
        People people = new People("Mary");
        people.setTrafficPolice(trafficPolice);
        car.Pass();
        trafficPolice.setPassStatus(true);
        people.Pass();
        car.Pass();
    }
}
