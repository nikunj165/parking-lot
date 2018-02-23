/**
 * @author nikunj-jain
 */

package com.interview.gojek.parkinglot;

import com.interview.gojek.parkinglot.command.Command;
import com.interview.gojek.parkinglot.command.CreateParkingLotCommand;
import com.interview.gojek.parkinglot.command.GetRegistrationByColorCommand;
import com.interview.gojek.parkinglot.command.GetSlotByRegistrationCommand;
import com.interview.gojek.parkinglot.command.GetSlotsByColorCommand;
import com.interview.gojek.parkinglot.command.InvalidCommand;
import com.interview.gojek.parkinglot.command.ParkVehicleCommand;
import com.interview.gojek.parkinglot.command.StatusCommand;
import com.interview.gojek.parkinglot.command.UnParkVehicleCommand;
import com.interview.gojek.parkinglot.service.CommandParser;
import com.interview.gojek.parkinglot.service.IParkingLotService;
import com.interview.gojek.parkinglot.service.MyParkingLotServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class App {
  private CommandParser commandParser;
  private IParkingLotService parkingLotService;
  private PrintStream out;
  private Command[] commands;

  public App(String[] args) {
    commands = getAvailableCommands();
    if (args != null && args.length > 0)
      commandParser = new CommandParser(args[0]);
    else
      commandParser = new CommandParser(null);
    if (args.length > 1)
      try {
        out = (new PrintStream(new File(args[1])));
      } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    else
      out = (System.out);
    parkingLotService = new MyParkingLotServiceImpl();
  }

  public static void main(String[] args) {
    App app = new App(args);
    app.start();
  }

  public void start() {
    Command command;
    while ((command = commandParser.parseCommand(commands)) != null) {
      command.execute(parkingLotService, out);
    }
  }

  private Command[] getAvailableCommands() {
    return new Command[] { new CreateParkingLotCommand(), new ParkVehicleCommand(),
        new UnParkVehicleCommand(), new StatusCommand(), new GetSlotsByColorCommand(),
        new GetSlotByRegistrationCommand(), new GetRegistrationByColorCommand(),
        new InvalidCommand() };
  }

  public PrintStream getOut() {
    return out;
  }

}
