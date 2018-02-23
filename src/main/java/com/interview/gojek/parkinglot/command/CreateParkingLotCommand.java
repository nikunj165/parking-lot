
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.command.Command;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;

/**
 * @author nikunj-jain
 */
public class CreateParkingLotCommand extends Command {

  private Integer parkingLotSize;

  public CreateParkingLotCommand(Integer lotSize) {
    this();
    this.parkingLotSize = lotSize;
  }

  public CreateParkingLotCommand() {
    super();
    this.desc = "create_parking_lot";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    parkingLotService.createParkingLot(parkingLotSize);
    out.println("Created a Parking Slot with " + parkingLotSize + " slots");
  }

  @Override
  public Command makeCommand(String[] args) {
    if (args.length > 1 && args[1].isEmpty() == false)
      return new CreateParkingLotCommand(Integer.parseInt(args[1]));
    else
      return new InvalidCommand();
  }

}
