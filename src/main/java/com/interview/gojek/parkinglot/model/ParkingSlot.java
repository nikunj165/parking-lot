/**
 * 
 */

package com.interview.gojek.parkinglot.model;

/**
 * @author nikunj-jain
 */
public class ParkingSlot implements Comparable {
  private Integer slotId;
  Vehicle vehicle;
  boolean isOccupied;

  public ParkingSlot(Integer slotId) {
    this.slotId = slotId;
    vehicle = null;
    isOccupied = false;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public boolean isOccupied() {
    return isOccupied;
  }

  public void setOccupied() {
    isOccupied = true;
  }

  public void setUnOccupied() {
    isOccupied = false;
  }

  public Integer getSlotId() {
    return slotId;
  }

  public void setSlotId(Integer slotId) {
    this.slotId = slotId;
  }

  public void setVehicle(Vehicle vehicle) {
    this.vehicle = vehicle;
    this.setOccupied();
  }

  public int compareTo(Object o) {
    ParkingSlot obj = (ParkingSlot) o;
    return this.slotId - obj.getSlotId();
  }

  /**
   * 
   */
  public void clear() {
    vehicle = null;
    isOccupied = false;
  }

}