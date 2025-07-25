package movieTicketsBookingSystem.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import movieTicketsBookingSystem.dal.DBConnection;
import movieTicketsBookingSystem.model.Orders;
import movieTicketsBookingSystem.model.Bookings;

public class OrderDAO {

    public Orders booking(Orders order) {
        Connection conn = DBConnection.getConnection();
        String template = "INSERT INTO orders(user_id,movie_id)  VALUES (?,?);";
        try (PreparedStatement psmt = conn.prepareStatement(template, Statement.RETURN_GENERATED_KEYS)) {
            psmt.setInt(1, order.getUserID());
            psmt.setInt(2, order.getMovieID());
            int rowsInserted = psmt.executeUpdate();

            if (rowsInserted != 1)
                return null;
            try (ResultSet generatedKeys = psmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int ID = generatedKeys.getInt(1);
                    order.setID(ID);
                    order.getBooking().setOrderID(ID);
                } else {
                    System.out.println("Failed to retrieve order ID.");
                    return null;
                }
            }

            String insertBookingSql = "INSERT INTO bookings(order_id,seat_number) VALUES(?,?)";

            for (Integer seat : order.getBooking().getBookedSeats()) {
                try {
                    PreparedStatement pst = conn.prepareStatement(insertBookingSql);
                    pst.setInt(1, order.getBooking().getOrderID());
                    pst.setInt(2, seat);
                    pst.executeUpdate();
                } catch (SQLException se) {
                    System.out.println(se);
                }

                return order;

            }
        } catch (SQLException se) {
            System.out.println(se);
        }

        return null;
    }

    public Orders bookingConfirmation(Orders order) {
        Connection conn = DBConnection.getConnection();
        String template = "SELECT booking_id FROM bookings";
        try (PreparedStatement psmt = conn.prepareStatement(template)) {
            ResultSet rs = psmt.executeQuery();
            if (rs.next()) {
                return order;
            }
        } catch (SQLException se) {
            System.out.println(se);
        }

        return null;
    }

}
