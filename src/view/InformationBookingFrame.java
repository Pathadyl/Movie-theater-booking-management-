package view;

import dao.ShowtimeDao;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import model.Bill;
import model.Movie;
import model.Showtime;
import model.Theater;
import service.UserService;
import view.component.DateChooserModel;
import view.component.Form_TheaterShowtimeByMovie;
import view.customSwing.TestButtonAlignText;

public class InformationBookingFrame extends javax.swing.JFrame {
    
    private Movie movie;
    private List<DateChooserModel> listShowTimeDateChooser;
    private DateChooserModel isSelectedDateChooserdModel;
    private UserService userService;
    
    
    public InformationBookingFrame(Movie movie, UserService userService) {
        initComponents();
        this.userService = userService;
        this.movie = movie;
        setBackground(new Color(0, 0, 0, 0));
        setSize(1280, 700);
        setLocationRelativeTo(null);
        titleMovieLabel.setText(movie.getTitle());
        durationLabel.setText(movie.getTitle());
        pictureCover.setImage(new ImageIcon(getClass().getResource(movie.getCoverPath())));
        
        filterShowtimesByDayOfMonth();
        setDataForShowTimeDateChooserList();
        
        isSelectedDateChooserdModel = listShowTimeDateChooser.get(0);
        setDataForTheaterShowTimeByMovieList();
    }
    
    
    private void setDataForShowTimeDateChooserList(){
        for(DateChooserModel dateModel : listShowTimeDateChooser){
            TestButtonAlignText button = dateModel.getButton();
            showTimeDateChooserList.addDateChooser(button);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dateModel.setIsSelected(true);
                    isSelectedDateChooserdModel.setIsSelected(false);
                    isSelectedDateChooserdModel = dateModel;
                    theaterShowTimeByMovieList.resetAllForm();
                    setDataForTheaterShowTimeByMovieList();
                }
               
            });
        } 
    }
    
    private void setDataForTheaterShowTimeByMovieList(){
        List<Theater> theaters = userService.getTheaterListByMovie(movie);
        for(Theater theater : theaters){
            Form_TheaterShowtimeByMovie ft = new Form_TheaterShowtimeByMovie(userService, movie, theater, isSelectedDateChooserdModel);
            theaterShowTimeByMovieList.addForm_TheaterShowTimeByMovie(ft);
        }
    }
        
    
    private void filterShowtimesByDayOfMonth() {
        listShowTimeDateChooser = new ArrayList<>();
        
        List<Showtime> showtimes = userService.getShowTimeListByMovie(movie);

        for (Showtime showtime : showtimes) {
            DateChooserModel dateChooserModel = findOrCreateDateChooserModel(showtime.getShowTime());
            dateChooserModel.getDateShowTimes().add(showtime.getShowTime());
        }

    }
    
    private DateChooserModel findOrCreateDateChooserModel(Timestamp date){
        
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd:MM:yyyy");
        String dayOfMonth = dayFormat.format(date);
        
        for (DateChooserModel model : listShowTimeDateChooser) {
            if(model.getDay().equals(dayOfMonth)) {
                return model;
            }
        }
        
        DateChooserModel newModel = new DateChooserModel();
        newModel.setDay(dayOfMonth);
        newModel.setDayOfWeek(getDayOfWeek(date));
        newModel.setDayOfMonth(getDayOfMonth(date));
        newModel.getButton().setText(newModel.getDayOfWeek() + "\n" + newModel.getDayOfMonth());
        listShowTimeDateChooser.add(newModel);
        return newModel;
    } 
    
    private void getSelectedDateChooserModel() {
        for(DateChooserModel model : listShowTimeDateChooser){
            if(model.isIsSelected()){
                isSelectedDateChooserdModel = model;
            }
        }
    }
    
    
    private String getDayOfWeek(Timestamp t) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEE");
        return dayFormat.format(t);
    }

    
    private String getDayOfMonth(Timestamp t) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
        return dayFormat.format(t);
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        customBorderPanel1 = new view.customSwing.CustomBorderPanel();
        pictureCover = new view.customSwing.PictureCover();
        showTimeDateChooserList = new view.component.ShowTimeDateChooserList();
        titleMovieLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        durationLabel = new javax.swing.JLabel();
        theaterShowTimeByMovieList = new view.component.TheaterShowTimeByMovieList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        customBorderPanel1.setBackground(new java.awt.Color(0, 0, 0));

        titleMovieLabel.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        titleMovieLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleMovieLabel.setText("TITLE MOVIE");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/clock.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        durationLabel.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        durationLabel.setForeground(new java.awt.Color(255, 255, 255));
        durationLabel.setText("Duration");

        javax.swing.GroupLayout customBorderPanel1Layout = new javax.swing.GroupLayout(customBorderPanel1);
        customBorderPanel1.setLayout(customBorderPanel1Layout);
        customBorderPanel1Layout.setHorizontalGroup(
            customBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(customBorderPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(customBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showTimeDateChooserList, javax.swing.GroupLayout.DEFAULT_SIZE, 1280, Short.MAX_VALUE)
                    .addGroup(customBorderPanel1Layout.createSequentialGroup()
                        .addGroup(customBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleMovieLabel)
                            .addGroup(customBorderPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(durationLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(customBorderPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(theaterShowTimeByMovieList, javax.swing.GroupLayout.PREFERRED_SIZE, 1260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customBorderPanel1Layout.setVerticalGroup(
            customBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customBorderPanel1Layout.createSequentialGroup()
                .addComponent(pictureCover, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleMovieLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(customBorderPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(durationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(showTimeDateChooserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(theaterShowTimeByMovieList, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customBorderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customBorderPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(InformationBookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(InformationBookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(InformationBookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(InformationBookingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new InformationBookingFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.customSwing.CustomBorderPanel customBorderPanel1;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel jLabel2;
    private view.customSwing.PictureCover pictureCover;
    private view.component.ShowTimeDateChooserList showTimeDateChooserList;
    private view.component.TheaterShowTimeByMovieList theaterShowTimeByMovieList;
    private javax.swing.JLabel titleMovieLabel;
    // End of variables declaration//GEN-END:variables
}
