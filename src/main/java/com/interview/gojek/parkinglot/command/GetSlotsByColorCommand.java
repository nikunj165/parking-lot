
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;
import java.util.Set;

/**
 * @author nikunj-jain
 */
public class GetSlotsByColorCommand extends Command {
  private String colour;

  public GetSlotsByColorCommand(String colour) {
    this();
    this.colour = colour;
  }

  public GetSlotsByColorCommand() {
    super();
    this.desc = "slot_numbers_for_cars_with_colour";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    Set<Integer> slotIndex = parkingLotService.getSlotsByColor(colour);
    if (slotIndex == null || slotIndex.isEmpty()) {
      out.println("No Cars found");
      return;
    }
    for (Integer i : slotIndex) {
      out.print(i + ", ");
    }
    out.println();
  }

  @Override
  public Command makeCommand(String[] colour) {
    if (colour.length > 1)
      return new GetSlotsByColorCommand(colour[1]);
    else
      return new InvalidCommand();
  }

}
