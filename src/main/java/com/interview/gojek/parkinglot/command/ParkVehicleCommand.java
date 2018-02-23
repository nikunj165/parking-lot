
package com.interview.gojek.parkinglot.command;

import com.interview.gojek.parkinglot.exceptions.SlotNotFoundException;
import com.interview.gojek.parkinglot.model.Car;
import com.interview.gojek.parkinglot.model.Vehicle;
import com.interview.gojek.parkinglot.service.IParkingLotService;

import java.io.PrintStream;

/**
 * @author nikunj-jain
 */
public class ParkVehicleCommand extends Command {

  private Vehicle vehicle;

  public ParkVehicleCommand(Vehicle vehicle) {
    this();
    this.vehicle = vehicle;
  }

  /**
   * 
   */
  public ParkVehicleCommand() {
    super();
    this.desc = "park";
  }

  @Override
  public void execute(IParkingLotService parkingLotService, PrintStream out) {
    try {
      Integer slotId = parkingLotService.park(vehicle);
      out.println("Allocated Slot No. " + slotId);
    } catch (SlotNotFoundException e) {
      out.println("Sorry, Parking Lot is full");
    } catch (Exception e) {
      out.println("Error: " + e.getMessage());
    }
  }

  @Override
  public Command makeCommand(String[] arguments) {
    Vehicle v = null;
    if (arguments.length > 2)
      v = new Car(arguments[1], arguments[2]);
    return new ParkVehicleCommand(v);

  }

}
