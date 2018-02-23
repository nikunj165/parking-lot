
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.model.Vehicle;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;
import java.util.List;

/**
 * @author nikunj-jain
 */
public class GetRegistrationByColorCommand extends Command {

  private String colour;

  public GetRegistrationByColorCommand() {
    this.desc = "registration_numbers_for_cars_with_colour";
  }

  public GetRegistrationByColorCommand(String colour) {
    this();
    this.colour = colour;
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    List<? extends Vehicle> list = parkingLotService.getVehiclesByColor(colour);
    for (Vehicle v : list)
      out.print(v.getRegistrationNumber() + ", ");
    out.println();
  }

  @Override
  public Command makeCommand(String[] arguments) {
    if (arguments.length > 1 && arguments[1].isEmpty() == false)
      return new GetRegistrationByColorCommand(arguments[1]);
    else
      return new InvalidCommand();
  }

}
