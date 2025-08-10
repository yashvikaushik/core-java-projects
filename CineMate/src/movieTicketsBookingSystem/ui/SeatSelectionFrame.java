package movieTicketsBookingSystem.ui;

import movieTicketsBookingSystem.model.Bookings;
import movieTicketsBookingSystem.model.Orders;
import movieTicketsBookingSystem.service.OrderService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class SeatSelectionFrame extends JFrame {

    private static final int TOTAL_SEATS = 10;
    private ArrayList<Integer> selectedSeats = new ArrayList<>();

    public SeatSelectionFrame(int userID, int movieID) {
        setTitle("Cinemate - Select Seats");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel seatPanel = new JPanel(new GridLayout(2, 5, 10, 10));

        JButton[] seatButtons = new JButton[TOTAL_SEATS];

        for (int i = 0; i < TOTAL_SEATS; i++) {
            int seatNum = i + 1;
            seatButtons[i] = new JButton("Seat " + seatNum);
            seatButtons[i].setBackground(Color.LIGHT_GRAY);

            seatButtons[i].addActionListener(e -> {
                if (selectedSeats.contains(seatNum)) {
                    selectedSeats.remove(seatNum);
                    seatButtons[seatNum - 1].setBackground(Color.LIGHT_GRAY);
                } else {
                    selectedSeats.add(seatNum);
                    seatButtons[seatNum - 1].setBackground(Color.GREEN);
                }
            });

            seatPanel.add(seatButtons[i]);
        }

        JButton confirmButton = new JButton("Confirm Booking");
        confirmButton.setFont(new Font("Arial", Font.BOLD, 16));

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedSeats.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please select at least one seat.");
                    return;
                }

                Orders order = new Orders();
                order.setUserID(userID);
                order.setMovieID(movieID);

                Bookings booking = new Bookings();
                booking.setBookedSeats(selectedSeats);
                order.setBooking(booking);

                Orders confirmedOrder = new OrderService().booking(order);

                if (confirmedOrder != null) {
                    JOptionPane.showMessageDialog(null, "Booking successful! Order ID: " + confirmedOrder.getID());
                    dispose(); // Close seat frame
                } else {
                    JOptionPane.showMessageDialog(null, "Booking failed. Please try again.");
                }
            }
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(confirmButton);

        add(seatPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}