// package movieTicketsBookingSystem.ui;

// import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ItemEvent;

// public class SeatSelectionFrame extends JFrame {

//     public SeatSelectionFrame(String movieName, int seatCount, JFrame previousFrame) {
//         setTitle("Select Seat - " + movieName);
//         setSize(600, 400);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setLocationRelativeTo(null);

//         JPanel seatPanel = new JPanel(new GridLayout(0, 5, 10, 10));
//         seatPanel.setBackground(Color.DARK_GRAY);

//         for (int i = 1; i <= seatCount; i++) {
//             JToggleButton seatBtn = new JToggleButton("Seat " + i);
//             seatBtn.setBackground(Color.BLACK);
//             seatBtn.setForeground(Color.BLACK);
//             seatBtn.setFocusPainted(false);

//             // Make it turn green when selected
//             seatBtn.addItemListener(e -> {
//                 if (e.getStateChange() == ItemEvent.SELECTED) {
//                     seatBtn.setBackground(Color.BLUE);
//                 } else {
//                     seatBtn.setBackground(Color.BLUE);
//                 }
//             });

//             seatPanel.add(seatBtn);
//         }

//         JScrollPane scrollPane = new JScrollPane(seatPanel);
//         scrollPane.getVerticalScrollBar().setUnitIncrement(16);

//         JButton backBtn = new JButton("Back");
//         backBtn.addActionListener(e -> {
//             this.dispose();
//             previousFrame.setVisible(true);
//         });

//         JButton bookBtn = new JButton("Book Now");
//         bookBtn.addActionListener(e -> {
//             JOptionPane.showMessageDialog(this, "Booking confirmed for " + movieName);
//         });

//         JPanel bottomPanel = new JPanel();
//         bottomPanel.setBackground(Color.DARK_GRAY);
//         bottomPanel.add(backBtn);
//         bottomPanel.add(bookBtn);

//         getContentPane().add(scrollPane, BorderLayout.CENTER);
//         getContentPane().add(bottomPanel, BorderLayout.SOUTH);
//     }
// }