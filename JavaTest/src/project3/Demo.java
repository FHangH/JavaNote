package project3;

import project3.appliance.Computer;
import project3.appliance.Light;
import project3.appliance.TelePhone;
import project3.appliance.WashMachine;

public class Demo
{
    public static void main(String[] args)
    {
        // Light
        Light light = new Light("Light");
        light.runStart();
        light.startCharge();
        light.overCharge();
        light.runOver();

        // WashMachine
        WashMachine washMachine = new WashMachine("WashMachine");
        washMachine.runStart();
        washMachine.startCharge();
        washMachine.runOver();

        // TelePhone
        TelePhone telePhone = new TelePhone("TelePhone");
        telePhone.runStart();
        telePhone.startCall();
        telePhone.overCall();
        telePhone.runOver();

        // Computer
        Computer computer = new Computer("Computer");
        computer.runStart();
        computer.playGames();
        computer.overGames();
        computer.runOver();
    }
}