
package view.form;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import model.Admin;
import model.Movie;
import service.AdminService;
import view.swing.WindowEventHandler;

public class movieDetail extends javax.swing.JFrame {
    private int movieID;
    private AdminService adminServices;
    public movieDetail() {
        initComponents();
        addWindowListener(new WindowEventHandler());
        
    }
    public movieDetail(int id){
        initComponents();
        initDetail(id);
        movieID = id;
        Movie m = adminServices.getMovieById(id);
        addWindowListener(new WindowEventHandler());
        
        updateTitle.setText(titleLabel.getText());
        updateGenre.setText(genre.getText());
        
        updateDescription.setText(m.getDescription());
        updateDescription.setLineWrap(true);
        updateDescription.setWrapStyleWord(true);
        updateDescription.setEditable(true);
        
        updateDirector.setText(director.getText());
        updateDuration.setText(duration.getText());
        updatePrice.setText(price.getText());
        posterPathUpdate.setText(m.getPosterPath());
        coverPathUpdate.setText(m.getCoverPath());
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Gọi phương thức xử lý sự kiện khi nút được nhấp
                adminServices = new AdminService(new Admin());
                if(adminServices.editMovieInDB(id, updateTitle.getText(), updateDescription.getText(),
                        updateDirector.getText(), updateGenre.getText(), updateDuration.getText(),
                        Double.valueOf(updatePrice.getText()), posterPathUpdate.getText(), coverPathUpdate.getText(), 
                        Boolean.valueOf(updateVisibility.getSelectedItem().toString()), 
                        Boolean.valueOf(updateAvailability.getSelectedItem().toString()))){
                    initDetail(id);
                    JOptionPane.showMessageDialog(null, "Update movie successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    //
                }
                CardLayout cl = (CardLayout) jPanel2.getLayout();
                cl.show(jPanel2, "cardPanel1");
            }
        });
    }
    public void initDetail(int id){
        adminServices = new AdminService(new Admin());
        Movie m = adminServices.getMovieById(id);
        titleLabel.setText(m.getTitle());
        descriptionLabel.setPreferredSize(new Dimension(275, 0));
        descriptionLabel.setText("<html>"+m.getDescription()+"</html>");
        
        Border border = BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY);
        descriptionLabel.setBorder(border);
        director.setText(m.getDirector());
        genre.setText(m.getGenre());
        duration.setText(m.getDuration());
        price.setText(String.valueOf(m.getPrice()));
        visibility.setText("");
        availability.setText("");
        if(m.isVisibility()){
            visibility.setIcon(new ImageIcon(getClass().getResource("/view/icon/true.png")));
            updateVisibility.setSelectedIndex(0);
        }
        else{
            visibility.setIcon(new ImageIcon(getClass().getResource("/view/icon/false.png")));
            updateVisibility.setSelectedIndex(1);
        }
        
        if(m.isAvailability()){
            availability.setIcon(new ImageIcon(getClass().getResource("/view/icon/true.png")));
            updateAvailability.setSelectedIndex(0);
        }
        else{
            availability.setIcon(new ImageIcon(getClass().getResource("/view/icon/false.png")));
            updateAvailability.setSelectedIndex(1);
        }
        moviePoster.setForeground(Color.WHITE);
        try{
            if(getClass().getResource(m.getCoverPath())!=null){
                moviePoster.setIcon(new ImageIcon(getClass().getResource(m.getCoverPath())));
                // Tạm thời để cover path là ảnh của movie detail.
                System.out.println("m.getCoverPath()");
                moviePoster.setText("");
            }
            else {
                moviePoster.setIcon(null); // Xóa icon nếu có
                moviePoster.setText("Can not find image!");
            }
        } catch (Exception e) {
            moviePoster.setIcon(null); // Xóa icon nếu có
            moviePoster.setText("Can not find image!");
        }
        moviePicture.setIcon(moviePoster.getIcon());
        moviePicture.setText(moviePoster.getText());
        moviePicture.setForeground(Color.WHITE);
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        moviePoster = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();
        directorLabel = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        titleLabel = new javax.swing.JLabel();
        director = new javax.swing.JLabel();
        genre = new javax.swing.JLabel();
        duration = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        visibilityLabel = new javax.swing.JLabel();
        availabilityLabel = new javax.swing.JLabel();
        availability = new javax.swing.JLabel();
        visibility = new javax.swing.JLabel();
        panelBorder2 = new view.swing.PanelBorder();
        exitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        panelBorder3 = new view.swing.PanelBorder();
        moveToUpdate = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        updateTitle = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        directorLabel1 = new javax.swing.JLabel();
        genreLabel1 = new javax.swing.JLabel();
        priceLabel1 = new javax.swing.JLabel();
        visibilityLabel1 = new javax.swing.JLabel();
        availabilityLabel1 = new javax.swing.JLabel();
        updateGenre = new javax.swing.JTextField();
        updateDirector = new javax.swing.JTextField();
        updateDuration = new javax.swing.JTextField();
        updatePrice = new javax.swing.JTextField();
        updateVisibility = new javax.swing.JComboBox<>();
        updateAvailability = new javax.swing.JComboBox<>();
        panelBorder1 = new view.swing.PanelBorder();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        coverPathUpdate = new javax.swing.JTextField();
        panelBorder4 = new view.swing.PanelBorder();
        updateButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        updateDescription = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        moviePicture = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        posterPathUpdate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setMaximumSize(new java.awt.Dimension(500, 735));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 735));

        moviePoster.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/furiosa.png"))); // NOI18N

        genreLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        genreLabel.setForeground(new java.awt.Color(255, 255, 255));
        genreLabel.setText("Duration");

        directorLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        directorLabel.setForeground(new java.awt.Color(255, 255, 255));
        directorLabel.setText("Director");

        descriptionLabel.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        descriptionLabel.setForeground(new java.awt.Color(204, 204, 204));
        descriptionLabel.setText("description");

        titleLabel.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setText("Movie title");

        director.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        director.setForeground(new java.awt.Color(204, 204, 204));
        director.setText("director");

        genre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        genre.setForeground(new java.awt.Color(204, 204, 204));
        genre.setText("genre");

        duration.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        duration.setForeground(new java.awt.Color(204, 204, 204));
        duration.setText("duration");

        priceLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel.setText("Price");

        price.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        price.setForeground(new java.awt.Color(204, 204, 204));
        price.setText("price");

        visibilityLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        visibilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        visibilityLabel.setText("Visibility");

        availabilityLabel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        availabilityLabel.setForeground(new java.awt.Color(255, 255, 255));
        availabilityLabel.setText("Availability");

        availability.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        availability.setForeground(new java.awt.Color(204, 204, 204));
        availability.setText("availability");

        visibility.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        visibility.setForeground(new java.awt.Color(204, 204, 204));
        visibility.setText("visibility");

        panelBorder2.setBackground(new java.awt.Color(0, 204, 0));

        exitButton.setBackground(new java.awt.Color(0, 0, 0));
        exitButton.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        exitButton.setForeground(new java.awt.Color(255, 255, 255));
        exitButton.setText("Exit");
        exitButton.setBorder(null);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Description");

        panelBorder3.setBackground(new java.awt.Color(0, 204, 0));

        moveToUpdate.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        moveToUpdate.setForeground(new java.awt.Color(255, 255, 255));
        moveToUpdate.setText("Update");
        moveToUpdate.setBorderPainted(false);
        moveToUpdate.setContentAreaFilled(false);
        moveToUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveToUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder3Layout = new javax.swing.GroupLayout(panelBorder3);
        panelBorder3.setLayout(panelBorder3Layout);
        panelBorder3Layout.setHorizontalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(moveToUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBorder3Layout.setVerticalGroup(
            panelBorder3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moveToUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(28, 28, 28)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
                        .addComponent(genre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(moviePoster)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(26, 26, 26)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(directorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(45, 45, 45)
                            .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(visibilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(availabilityLabel)
                                .addComponent(genreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(27, 27, 27)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(visibility, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(duration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(availability, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)))
                        .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(panelBorder3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(moviePoster, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(genre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descriptionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(directorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(director, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(genreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visibilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(visibility, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availabilityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(availability, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelBorder2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelBorder3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(33, 33, 33))
        );

        jPanel2.add(jPanel1, "cardPanel1");

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));

        updateTitle.setBackground(new java.awt.Color(0, 0, 0));
        updateTitle.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        updateTitle.setForeground(new java.awt.Color(255, 255, 255));
        updateTitle.setText("Title");
        updateTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateTitleActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Description");

        directorLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        directorLabel1.setForeground(new java.awt.Color(255, 255, 255));
        directorLabel1.setText("Director");

        genreLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        genreLabel1.setForeground(new java.awt.Color(255, 255, 255));
        genreLabel1.setText("Duration");

        priceLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        priceLabel1.setForeground(new java.awt.Color(255, 255, 255));
        priceLabel1.setText("Price");

        visibilityLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        visibilityLabel1.setForeground(new java.awt.Color(255, 255, 255));
        visibilityLabel1.setText("Visibility");

        availabilityLabel1.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        availabilityLabel1.setForeground(new java.awt.Color(255, 255, 255));
        availabilityLabel1.setText("Availability");

        updateGenre.setBackground(new java.awt.Color(0, 0, 0));
        updateGenre.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateGenre.setForeground(new java.awt.Color(204, 204, 204));
        updateGenre.setText("genre");

        updateDirector.setBackground(new java.awt.Color(0, 0, 0));
        updateDirector.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateDirector.setForeground(new java.awt.Color(204, 204, 204));
        updateDirector.setText("director");

        updateDuration.setBackground(new java.awt.Color(0, 0, 0));
        updateDuration.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateDuration.setForeground(new java.awt.Color(204, 204, 204));
        updateDuration.setText("duration");

        updatePrice.setBackground(new java.awt.Color(0, 0, 0));
        updatePrice.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updatePrice.setForeground(new java.awt.Color(204, 204, 204));
        updatePrice.setText("price");

        updateVisibility.setBackground(new java.awt.Color(204, 204, 204));
        updateVisibility.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateVisibility.setForeground(new java.awt.Color(255, 255, 255));
        updateVisibility.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false", " " }));

        updateAvailability.setBackground(new java.awt.Color(204, 204, 204));
        updateAvailability.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateAvailability.setForeground(new java.awt.Color(255, 255, 255));
        updateAvailability.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "true", "false", " " }));

        panelBorder1.setBackground(new java.awt.Color(0, 204, 0));

        jButton2.setBackground(new java.awt.Color(0, 204, 51));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Exit");
        jButton2.setToolTipText("");
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder1Layout = new javax.swing.GroupLayout(panelBorder1);
        panelBorder1.setLayout(panelBorder1Layout);
        panelBorder1Layout.setHorizontalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder1Layout.setVerticalGroup(
            panelBorder1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cover path");

        coverPathUpdate.setBackground(new java.awt.Color(0, 0, 0));
        coverPathUpdate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        coverPathUpdate.setForeground(new java.awt.Color(204, 204, 204));
        coverPathUpdate.setText("path");

        panelBorder4.setBackground(new java.awt.Color(0, 204, 0));

        updateButton.setBackground(new java.awt.Color(0, 204, 51));
        updateButton.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.setToolTipText("");
        updateButton.setBorderPainted(false);
        updateButton.setContentAreaFilled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBorder4Layout = new javax.swing.GroupLayout(panelBorder4);
        panelBorder4.setLayout(panelBorder4Layout);
        panelBorder4Layout.setHorizontalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBorder4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelBorder4Layout.setVerticalGroup(
            panelBorder4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(updateButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        updateDescription.setBackground(new java.awt.Color(0, 0, 0));
        updateDescription.setColumns(20);
        updateDescription.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        updateDescription.setForeground(new java.awt.Color(204, 204, 204));
        updateDescription.setRows(5);
        jScrollPane1.setViewportView(updateDescription);

        jPanel4.setOpaque(false);

        moviePicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/images/furiosa.png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moviePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(moviePicture, javax.swing.GroupLayout.PREFERRED_SIZE, 188, Short.MAX_VALUE)
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Poster path");

        posterPathUpdate.setBackground(new java.awt.Color(0, 0, 0));
        posterPathUpdate.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        posterPathUpdate.setForeground(new java.awt.Color(204, 204, 204));
        posterPathUpdate.setText("path");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(updateAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(updateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(directorLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genreLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(visibilityLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(updateVisibility, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updatePrice, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateDuration, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(updateDirector, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(availabilityLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(coverPathUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(posterPathUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateGenre, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(directorLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genreLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateDuration, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(priceLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updatePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(visibilityLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(updateVisibility, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(availabilityLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(updateAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posterPathUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(coverPathUpdate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(panelBorder1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(panelBorder4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, "cardPanel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_exitButtonActionPerformed

    private void updateTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateTitleActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private void moveToUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveToUpdateActionPerformed
        CardLayout cl = (CardLayout) jPanel2.getLayout();
        cl.show(jPanel2, "cardPanel3");
    }//GEN-LAST:event_moveToUpdateActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CardLayout cl = (CardLayout) jPanel2.getLayout();
        cl.show(jPanel2, "cardPanel1");
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(movieDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(movieDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(movieDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(movieDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new movieDetail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel availability;
    private javax.swing.JLabel availabilityLabel;
    private javax.swing.JLabel availabilityLabel1;
    private javax.swing.JTextField coverPathUpdate;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JLabel director;
    private javax.swing.JLabel directorLabel;
    private javax.swing.JLabel directorLabel1;
    private javax.swing.JLabel duration;
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel genre;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JLabel genreLabel1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moveToUpdate;
    private javax.swing.JLabel moviePicture;
    private javax.swing.JLabel moviePoster;
    private view.swing.PanelBorder panelBorder1;
    private view.swing.PanelBorder panelBorder2;
    private view.swing.PanelBorder panelBorder3;
    private view.swing.PanelBorder panelBorder4;
    private javax.swing.JTextField posterPathUpdate;
    private javax.swing.JLabel price;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel priceLabel1;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JComboBox<String> updateAvailability;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextArea updateDescription;
    private javax.swing.JTextField updateDirector;
    private javax.swing.JTextField updateDuration;
    private javax.swing.JTextField updateGenre;
    private javax.swing.JTextField updatePrice;
    private javax.swing.JTextField updateTitle;
    private javax.swing.JComboBox<String> updateVisibility;
    private javax.swing.JLabel visibility;
    private javax.swing.JLabel visibilityLabel;
    private javax.swing.JLabel visibilityLabel1;
    // End of variables declaration//GEN-END:variables
}
