package view.component;

import dao.ShowtimeDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;
import model.Movie;
import model.Showtime;
import model.Theater;
import service.UserService;
import view.MemberBooking;
import view.customSwing.CustomButtonWithPressEffect;

public class Form_TheaterShowtimeByMovie extends javax.swing.JPanel { 

    private Movie movie;
    private Theater theater;
    private DateChooserModel dateChooserModel;
    private ShowtimeDao showtimeDao;
    private UserService userService;

    public Form_TheaterShowtimeByMovie(UserService userservice, Movie movie, Theater theater, DateChooserModel dateChooserModel) {
        initComponents();
        this.movie = movie;
        this.theater = theater;
        this.userService = userservice;
        this.dateChooserModel = dateChooserModel;
        showtimeDao = new ShowtimeDao();
        setOpaque(false);
        setData();
    }
    
    
    public void setData(){
        List<Showtime> showtimes = userService.getShowTimeListByMovieAndTheater(movie, theater);
        theaterNameLabel.setText(theater.getName());
        for(Showtime showtime : showtimes){
            for(Timestamp dateShowtime : dateChooserModel.getDateShowTimes()){
                if(showtime.getShowTime().equals(dateShowtime)){
                    CustomButtonWithPressEffect button = new CustomButtonWithPressEffect();
                    button.setPreferredSize(new Dimension(115, 50));
                    button.setFont(new Font("SansSerif", Font.PLAIN, 12));
                    button.setText(getTimeOfDay(showtime.getShowTime()));
                    button.setPaintedColor(Color.DARK_GRAY);
                    button.setBorderPainted(false);
                    panel.add(button);
                    button.addActionListener(new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            MemberBooking memberBookingDialog = new MemberBooking(userService, movie, theater, showtime);
                            memberBookingDialog.setVisible(true);
                        }
                            
                    });
                    break;
                }
            }
            
        }
        panel.revalidate();
        panel.repaint();
    }
    
   
    
    private String getTimeOfDay(Timestamp t) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        return timeFormat.format(t);
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topBottomBorderPanel1 = new view.component.TopBottomBorderPanel();
        theaterNameLabel = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        scrollBar1 = new view.customSwing.ScrollBar();

        setBackground(new java.awt.Color(0, 0, 0));

        topBottomBorderPanel1.setBackground(new java.awt.Color(0, 0, 0));

        theaterNameLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        theaterNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        theaterNameLabel.setText("Theater name");

        javax.swing.GroupLayout topBottomBorderPanel1Layout = new javax.swing.GroupLayout(topBottomBorderPanel1);
        topBottomBorderPanel1.setLayout(topBottomBorderPanel1Layout);
        topBottomBorderPanel1Layout.setHorizontalGroup(
            topBottomBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBottomBorderPanel1Layout.createSequentialGroup()
                .addComponent(theaterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        topBottomBorderPanel1Layout.setVerticalGroup(
            topBottomBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBottomBorderPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(theaterNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        sp.setBorder(null);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sp.setHorizontalScrollBar(scrollBar1);

        panel.setBackground(new java.awt.Color(0, 0, 0));
        panel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));
        sp.setViewportView(panel);

        scrollBar1.setBackground(new java.awt.Color(58, 181, 75));
        scrollBar1.setOrientation(javax.swing.JScrollBar.HORIZONTAL);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topBottomBorderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sp)
            .addGroup(layout.createSequentialGroup()
                .addGap(565, 565, 565)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(575, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(topBottomBorderPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    private view.customSwing.ScrollBar scrollBar1;
    private javax.swing.JScrollPane sp;
    private javax.swing.JLabel theaterNameLabel;
    private view.component.TopBottomBorderPanel topBottomBorderPanel1;
    // End of variables declaration//GEN-END:variables
}
