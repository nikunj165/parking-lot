/**
 * 
 */

package com.interview.gojek.parkinglot.service;

import com.interview.gojek.parkinglot.exceptions.SlotEmptyException;
import com.interview.gojek.parkinglot.exceptions.SlotNotFoundException;
import com.interview.gojek.parkinglot.model.ParkingSlot;
import com.interview.gojek.parkinglot.model.Vehicle;

import java.util.List;
import java.util.Set;

/**
 * @author nikunj-jain
 */
public interface IParkingLotService {

  /**
   * @param command
   */

  public void createParkingLot(int size);

  public Integer park(Vehicle vehicle) throws SlotNotFoundException, Exception;

  public void leave(Integer slotId) throws SlotEmptyException;

  public Integer getSlotByRegistration(String s);

  public Set<Integer> getSlotsByColor(String s);

  public List<Vehicle> getVehiclesByColor(String s);

  public List<ParkingSlot> getStatus();
}
