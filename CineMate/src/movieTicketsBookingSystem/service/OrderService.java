package movieTicketsBookingSystem.service;
import movieTicketsBookingSystem.dal.OrderDAO;
import movieTicketsBookingSystem.model.Orders;

public class OrderService {
    OrderDAO bookingDAO=new OrderDAO();

    public Orders booking(Orders booking){
       return bookingDAO.booking(booking);

    }

    public Orders bookingConfirmation(Orders booking){
        return bookingDAO.bookingConfirmation(booking);
    }
    
}
