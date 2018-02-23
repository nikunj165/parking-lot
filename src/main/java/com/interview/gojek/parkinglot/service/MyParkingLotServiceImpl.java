/**
 * 
 */

package com.interview.gojek.parkinglot.service;

import com.interview.gojek.parkinglot.exceptions.SlotEmptyException;
import com.interview.gojek.parkinglot.exceptions.SlotNotFoundException;
import com.interview.gojek.parkinglot.model.Car;
import com.interview.gojek.parkinglot.model.ParkingSlot;
import com.interview.gojek.parkinglot.model.Vehicle;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author nikunj-jain
 */
public class MyParkingLotServiceImpl implements IParkingLotService {

  private final String notFound = "Not Found";
  private int parkingSize;
  private int filledSlots;
  List<ParkingSlot> slotList;
  Map<String, Integer> registrationNumberIndex;
  Map<String, Set<Integer>> colorIndex;
  Map<Integer, ParkingSlot> parkingIndex;

  public void createParkingLot(int size) {
    this.parkingSize = size;
    filledSlots = 0;
    this.slotList = new LinkedList<ParkingSlot>();
    registrationNumberIndex = new HashMap<String, Integer>();
    colorIndex = new HashMap<String, Set<Integer>>();
    parkingIndex = new TreeMap<Integer, ParkingSlot>();
    initialize();
  }

  private void initialize() {
    for (int i = 1; i <= parkingSize; i++) {
      slotList.add(new ParkingSlot(i));
    }

  }
  //
  // public void processCommand(String nextCommand) {
  // if (nextCommand.startsWith("park")) {
  // park(nextCommand);
  // } else if (nextCommand.startsWith("leave")) {
  // leave(nextCommand);
  // } else if (nextCommand.startsWith("status")) {
  // showStatus();
  // } else if
  // (nextCommand.startsWith("registration_numbers_for_cars_with_colour")) {
  // getVehiclesByColor(nextCommand.split(" ")[1]);
  // } else if (nextCommand.startsWith("slot_numbers_for_cars_with_colour")) {
  // getSlotsByColor(nextCommand.split(" ")[1]);
  // } else if (nextCommand.startsWith("slot_number_for_registration_number")) {
  // getSlotByRegistration(nextCommand.split(" ")[1]);
  // }
  // }

  public Integer park(Vehicle vehicle) throws SlotNotFoundException, Exception {
    return parkNextCar(vehicle);
  }

  public void leave(Integer id) throws SlotEmptyException {
    try {
      if (parkingIndex.containsKey(id)) {
        filledSlots--;

        ParkingSlot slot = parkingIndex.get(id);
        parkingIndex.remove(id);
        if (slot.isOccupied()) {
          Vehicle vehicle = slot.getVehicle();
          slot.clear();
          slotList.add(slot);
          Collections.sort(slotList);
          registrationNumberIndex.remove(vehicle.getRegistrationNumber());
          colorIndex.get(vehicle.getColor()).remove(slot.getSlotId());
        }
      } else
        throw new SlotEmptyException("Slot is already unoccupied by any car");
    } catch (SlotEmptyException e) {
    }
  }

  private Integer parkNextCar(Vehicle vehicle) throws SlotNotFoundException, Exception {
    ParkingSlot slot = findNextParkingSlot();
    if (slot != null) {
      parkingIndex.put(slot.getSlotId(), slot);
      slot.setVehicle(vehicle);
      registrationNumberIndex.put(vehicle.getRegistrationNumber(), slot.getSlotId());
      if (colorIndex.containsKey(vehicle.getColor())) {
        colorIndex.get(vehicle.getColor()).add(slot.getSlotId());
      } else {
        Set<Integer> set = new HashSet<Integer>();
        set.add(slot.getSlotId());
        colorIndex.put(vehicle.getColor(), set);
      }
      filledSlots++;
      return slot.getSlotId();
    } else {
      throw new SlotNotFoundException("Sorry, Parking Lot is full");
    }
  }

  private ParkingSlot findNextParkingSlot() {
    ParkingSlot slot;
    if (filledSlots < parkingSize) {
      synchronized (slotList) {
        slot = slotList.remove(0);
      }
      return slot;
    }
    return null;
  }

  public Integer getSlotByRegistration(String s) {
    Integer index = registrationNumberIndex.get(s);
    return index;
  }

  public Set<Integer> getSlotsByColor(String s) {
    return colorIndex.get(s.toLowerCase());

  }

  public List<Vehicle> getVehiclesByColor(String s) {
    Set<Integer> slotIndex = colorIndex.get(s.toLowerCase());
    List<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
    for (Integer i : slotIndex) {
      listOfVehicles.add(parkingIndex.get(i).getVehicle());
    }
    return listOfVehicles;
  }

  public List<ParkingSlot> getStatus() {
    List<ParkingSlot> listSlots = new ArrayList<ParkingSlot>();

    for (ParkingSlot slot : this.parkingIndex.values()) {
      if (slot.isOccupied())
        listSlots.add(slot);
    }
    return listSlots;
  }

}
