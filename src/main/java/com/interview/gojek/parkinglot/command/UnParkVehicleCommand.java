
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.exceptions.SlotEmptyException;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;

/**
 * @author nikunj-jain
 */
public class UnParkVehicleCommand extends Command {

  private Integer slotId;

  public UnParkVehicleCommand(Integer slotId) {
    this();
    this.slotId = slotId;
  }

  public UnParkVehicleCommand() {
    super();
    this.desc = "leave";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    try {
      parkingLotService.leave(slotId);
      out.println("Slot number " + slotId + " is free");
    } catch (SlotEmptyException e) {
      out.print(e.getMessage());
    }
  }

  @Override
  public Command makeCommand(String[] args) {
    if (args.length > 1 && args[1].isEmpty() == false)
      return new UnParkVehicleCommand(Integer.parseInt(args[1]));
    else
      return new InvalidCommand();
  }
}
