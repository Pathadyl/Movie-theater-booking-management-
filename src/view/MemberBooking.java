package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.Movie;
import model.Showtime;
import model.Theater;
import service.MemberService;
import service.ShowtimeService;
import service.UserService;

public class MemberBooking extends javax.swing.JDialog {
    
    private MemberService memberService;
    private Movie movie;
    private Theater theater;
    private Showtime showtime;
    private ShowtimeService showtimeService;
    
    public MemberBooking(UserService userService, Movie movie, Theater theater, Showtime showtime) {
        initComponents();
        this.memberService = (MemberService) userService;
        this.movie = movie;
        this.theater = theater;
        this.showtime = showtime;
        showtimeService = new ShowtimeService(showtime);
        
        setTitle("Member Booking");
        setSize(560, 700);
        setLocationRelativeTo(null);
        
        movieTitleLabel.setText(movie.getTitle());
        durationLabel.setText(movie.getDuration() + " minutes");
        String location = theater.getName() + " " + theater.getLocation();
        locationLabel.setText(theater.getName());
        showtimeLabel.setText(convertTimestampToString(showtime.getShowTime()));
        pictureCover.setImage(new ImageIcon(getClass().getResource(movie.getCoverPath())));
        currentPointLabel.setText("Your reward point is " + String.valueOf(memberService.getMember().getRewardPoint()));
        
        jPanel1 = new CustomPanel();
        getContentPane().add(jPanel1);
        
    }
    
    private String convertTimestampToString(Timestamp timestamp) {
        // Create a SimpleDateFormat instance with the desired format
        SimpleDateFormat sdf = new SimpleDateFormat("dd'th' MMMM, yyyy, HH:mm", Locale.ENGLISH);
        
        // Convert the timestamp to a date string
        String formattedDate = sdf.format(timestamp);
        
        // Handling the suffix for the day (st, nd, rd, th)
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(timestamp));
        String daySuffix;
        
        switch (day % 10) {
            case 1:
                daySuffix = (day == 11) ? "th" : "st";
                break;
            case 2:
                daySuffix = (day == 12) ? "th" : "nd";
                break;
            case 3:
                daySuffix = (day == 13) ? "th" : "rd";
                break;
            default:
                daySuffix = "th";
        }
        
        // Replacing the placeholder suffix with the correct one
        formattedDate = formattedDate.replace("th", daySuffix);
        
        return formattedDate;
    }
    
//    @Override
//    public void paint(Graphics grphs) {
//        super.paint(grphs);
//        Graphics2D g2 = (Graphics2D) grphs;
//        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        g2.setColor(getBackground());
//        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
//    }
    
    private class CustomPanel extends javax.swing.JPanel {
        @Override
        protected void paintComponent(Graphics grphs) {
            super.paintComponent(grphs);
            Graphics2D g2 = (Graphics2D) grphs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        customJTextField2 = new view.customSwing.CustomJTextField();
        jLabel18 = new javax.swing.JLabel();
        currentPointLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel20 = new javax.swing.JLabel();
        rewardPoint = new view.customSwing.CustomJTextField();
        customButtonWithPressEffect1 = new view.customSwing.CustomButtonWithPressEffect();
        warningLabel = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        showtimeLabel = new javax.swing.JLabel();
        ticketQuantity = new view.customSwing.CustomJTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        movieTitleLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        pictureCover = new view.customSwing.PictureCover();

        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel16.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 255, 102));
        jLabel16.setText("Information");

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Reward Points:");

        customJTextField2.setBackground(new java.awt.Color(0, 0, 0));
        customJTextField2.setForeground(new java.awt.Color(102, 255, 102));
        customJTextField2.setEnabled(false);
        customJTextField2.setLabelText("Total Bill");
        customJTextField2.setLineColor(new java.awt.Color(102, 255, 102));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/rewards.png"))); // NOI18N

        currentPointLabel.setForeground(new java.awt.Color(102, 255, 102));
        currentPointLabel.setText("* Your current points is ");

        jLabel20.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(102, 255, 102));
        jLabel20.setText("Total:");

        rewardPoint.setBackground(new java.awt.Color(0, 0, 0));
        rewardPoint.setForeground(new java.awt.Color(102, 255, 102));
        rewardPoint.setLabelText("Your Point");
        rewardPoint.setLineColor(new java.awt.Color(102, 255, 102));

        customButtonWithPressEffect1.setText("Complete");
        customButtonWithPressEffect1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        customButtonWithPressEffect1.setPaintedColor(new java.awt.Color(102, 255, 102));
        customButtonWithPressEffect1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customButtonWithPressEffect1ActionPerformed(evt);
            }
        });

        warningLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        warningLabel.setForeground(new java.awt.Color(255, 51, 51));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/screen.png"))); // NOI18N

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/bigClock.png"))); // NOI18N

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/location.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Showtime:");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/calendar.png"))); // NOI18N

        showtimeLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        showtimeLabel.setForeground(new java.awt.Color(255, 255, 255));
        showtimeLabel.setText("Time table");

        ticketQuantity.setBackground(new java.awt.Color(0, 0, 0));
        ticketQuantity.setForeground(new java.awt.Color(102, 255, 102));
        ticketQuantity.setLabelText("Quantity");
        ticketQuantity.setLineColor(new java.awt.Color(102, 255, 102));

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Theater:");

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/ticket.png"))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 255, 102));
        jLabel1.setText("Finish Payment");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Movie:");

        movieTitleLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        movieTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        movieTitleLabel.setText("Movie title");

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Duration:");

        durationLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        durationLabel.setForeground(new java.awt.Color(255, 255, 255));
        durationLabel.setText("duration");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Enter number ticket:");

        locationLabel.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(255, 255, 255));
        locationLabel.setText("Theater Location");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureCover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel15))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel17))
                                .addGap(42, 42, 42)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentPointLabel)
                                    .addComponent(rewardPoint, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ticketQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(showtimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel14)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(locationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(movieTitleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(durationLabel)))
                        .addContainerGap(48, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customButtonWithPressEffect1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(30, 30, 30)
                                .addComponent(customJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 395, Short.MAX_VALUE)
                    .addComponent(warningLabel)
                    .addGap(0, 178, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pictureCover, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(movieTitleLabel)
                        .addComponent(jLabel4)
                        .addComponent(durationLabel))
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(locationLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(showtimeLabel)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel6))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ticketQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(rewardPoint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(currentPointLabel)
                        .addGap(25, 25, 25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(customJTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addComponent(customButtonWithPressEffect1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(warningLabel)
                    .addGap(0, 674, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 26, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void customButtonWithPressEffect1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customButtonWithPressEffect1ActionPerformed

        String inputQuantity = ticketQuantity.getText();
        String inputRewardPoint = rewardPoint.getText();
    
        if (inputQuantity == null || inputQuantity.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the quantity", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int quantity = 0;
        int rewardPoints = 0;

        try {
            quantity = Integer.parseInt(inputQuantity);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity input", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (inputRewardPoint != null && !inputRewardPoint.isEmpty()) {
            try {
                rewardPoints = Integer.parseInt(inputRewardPoint);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid reward points input", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

    if (rewardPoints > memberService.getMember().getRewardPoint()) {
        JOptionPane.showMessageDialog(this, "You do not have enough points!", "Error", JOptionPane.ERROR_MESSAGE);
    } else {
        double discount = rewardPoints;
            memberService.bookingMovie(
            memberService.getMember().getName(), 
            memberService.getMember().getPhone(), 
            memberService.getMember().getEmail(),
            movie, 
            theater, 
            quantity
        );
        JOptionPane.showMessageDialog(this, "Booking successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }
        
    }//GEN-LAST:event_customButtonWithPressEffect1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel currentPointLabel;
    private view.customSwing.CustomButtonWithPressEffect customButtonWithPressEffect1;
    private view.customSwing.CustomJTextField customJTextField2;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JLabel movieTitleLabel;
    private view.customSwing.PictureCover pictureCover;
    private view.customSwing.CustomJTextField rewardPoint;
    private javax.swing.JLabel showtimeLabel;
    private view.customSwing.CustomJTextField ticketQuantity;
    private javax.swing.JLabel warningLabel;
    // End of variables declaration//GEN-END:variables
}
