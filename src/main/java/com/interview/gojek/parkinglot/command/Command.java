
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;

/**
 * @author nikunj-jain
 */
public abstract class Command {
  protected String desc;

  public abstract void execute(IParkingLotService parkingLotService, PrintStream out);

  /**
   * @return
   */
  public String getDescription() {
    return desc;
  }

  public abstract Command makeCommand(String[] arguments);
}
