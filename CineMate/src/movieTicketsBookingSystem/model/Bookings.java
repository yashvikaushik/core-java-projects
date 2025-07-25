package movieTicketsBookingSystem.model;

import java.util.ArrayList;
import java.util.Set;

import movieTicketsBookingSystem.dal.OrderDAO;

public class Bookings {
    private int id;
    private int orderID;
    
    public ArrayList<Integer> bookedSeats=new ArrayList<Integer>();

    Bookings(int orderID,ArrayList bookedSeats){
        this.orderID=orderID;
        this.bookedSeats=bookedSeats;
    }
    public Bookings(){

    }

    public int getOrderID(){
        return orderID;
    }
    public ArrayList<Integer> getBookedSeats(){
        return bookedSeats;
    }

    public int getID(){
        return id;
    }
    

    public void setOrderID(int order_id){
        this.orderID=orderID;
    }

    public void setBookedSeats(ArrayList<Integer> selectedSeats){
        this.bookedSeats=selectedSeats;
    }

    public void setID(int id){
        this.id=id;

    }


    

    @Override
public String toString() {
    return "Bookings{" +
            "order ID=" + orderID +
            ", Booked seats=" + bookedSeats +
            '}';
}
    
}
