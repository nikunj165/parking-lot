
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.command.Command;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;

/**
 * @author nikunj-jain
 */
public class InvalidCommand extends Command {

  public InvalidCommand() {
    this.desc = "Invalid Command";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    out.println(desc);
  }

  /*
   * (non-Javadoc)
   * 
   * @see com.interview.gojek.parkinglot.command.Command#makeCommand(java.lang.
   * String)
   */
  @Override
  public Command makeCommand(String[] arguments) {
    return new InvalidCommand();
  }

}
