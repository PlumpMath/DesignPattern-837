/**
 * Created by mike on 4/19/16.
 */

interface machine {
    public void turnOn();
    public void turnOff();
}

class Computer implements machine{
    public void turnOn() {
        System.out.println("The computer is turned on.");
    }
    public void playGames() {
        System.out.println("Playing computer games.");
    }
    public void turnOff() {
        System.out.println("The computer is turned off.");
    }
}

class TV implements machine{
    private int telegram = 1;

    public void turnOn() {
        System.out.println("The TV is turned on.");
        playTelegram();
    }

    public void setTelegram(int telegram) {
        this.telegram = telegram;
    }

    public void playTelegram() {
        System.out.println("Telegram No." + telegram + " is playing.");
    }

    public void turnOff() {
        System.out.println("The TV is turned off.");
    }
}

class HouseMachineFacade {
    private TV myTV;
    private Computer myComputer;

    public HouseMachineFacade() {
        myTV = new TV();
        myComputer = new Computer();
    }

    public void turnOnComputer() {
        myComputer.turnOn();
    }

    public void playComputerGames() {
        myComputer.playGames();
    }

    public void turnOffComputer() {
        myComputer.turnOff();
    }

    public void turnOnTV() {
        myTV.turnOn();
    }

    public void setTVTelegram(int telegram) {
        myTV.setTelegram(telegram);
    }

    public void playTVTelegram() {
        myTV.playTelegram();
    }

    public void turnOffTV() {
        myTV.turnOff();
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        HouseMachineFacade myFacade = new HouseMachineFacade();
        myFacade.turnOnComputer();
        myFacade.playComputerGames();
        myFacade.turnOnTV();
        myFacade.turnOffTV();
        myFacade.turnOffComputer();
    }
}
