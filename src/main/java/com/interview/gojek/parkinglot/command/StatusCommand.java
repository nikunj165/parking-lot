
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.model.ParkingSlot;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;
import java.util.List;

/**
 * @author nikunj-jain
 */
public class StatusCommand extends Command {

  public StatusCommand() {
    this.desc = "status";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    List<ParkingSlot> list = parkingLotService.getStatus();
    out.println("Slot No.\tRegistration No.\t\tColour");
    for (ParkingSlot slot : list)
      out.println(slot.getSlotId() + "\t" + slot.getVehicle().getRegistrationNumber() + "\t"
          + slot.getVehicle().getColor());
  }

  @Override
  public Command makeCommand(String[] args) {
    return new StatusCommand();
  }

}
