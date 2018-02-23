
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;
import java.lang.reflect.Constructor;

/**
 * @author nikunj-jain
 */
public class GetSlotByRegistrationCommand extends Command {
  private String registrationNumber;

  /**
   * @param arguments
   */
  public GetSlotByRegistrationCommand(String arguments) {
    this();
    this.registrationNumber = arguments;
  }

  /**
   * 
   */
  public GetSlotByRegistrationCommand() {
    super();
    this.desc = "slot_number_for_registration_number";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    Integer index = parkingLotService.getSlotByRegistration(registrationNumber);
    if (index != null)
      out.println(index);
    else
      out.println("Not Found");
  }

  @Override
  public Command makeCommand(String[] args) {
    if (args.length > 1 && false == args[1].isEmpty())
      return new GetSlotByRegistrationCommand(args[1]);
    else
      return new InvalidCommand();
  }

}
