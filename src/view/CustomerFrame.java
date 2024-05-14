package view;

import java.awt.CardLayout;
import java.awt.Color;
import java.util.List;
import javax.swing.ImageIcon;
import model.Guest;
import model.Movie;
import model.Role;
import service.GuestService;
import service.UserService;
import view.component.Form_Movie;
import view.customSwing.PicturePoster;

public class CustomerFrame extends javax.swing.JFrame {
    
    private CardLayout cardLayout;
    private UserService userService;
    private boolean movieAvailable = true;
    private List<Movie> movies;
    
    
    public CustomerFrame() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        setSize(1280, 700);
        setLocationRelativeTo(null);
        
        userService = new GuestService(new Guest());
        cardLayout = (CardLayout) cardLayoutCustomerPanel.getLayout();
        
        homeButton.setShowBorder(false);
        theaterButton.setShowBorder(false);
        storeButton.setShowBorder(false);
        personalButton.setShowBorder(false);
        binButton.setShowBorder(false);
        
        init();
    }
    
    private void init() {
        movies = userService.getAllMovie();
        for(Movie movie : movies){
            movieList.addFormMovie(new Form_Movie(movie));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBorder2 = new view.customSwing.CustomBorderPanel();
        menuBar = new view.component.MenuBar();
        theaterButton = new view.component.MenuButton();
        storeButton = new view.component.MenuButton();
        personalButton = new view.component.MenuButton();
        homeButton = new view.component.MenuButton();
        cardLayoutCustomerPanel = new view.Panel.CardLayoutPanel();
        homePanel = new view.Panel.HomePanel();
        headerHomePanel = new view.customSwing.CustomHeader();
        movieList = new view.component.MovieList();
        storePanel = new view.Panel.StorePanel();
        loginPanel = new view.Panel.LoginPanel();
        customHeader1 = new view.customSwing.CustomHeader();
        headerLabel = new javax.swing.JLabel();
        userNameJTextField = new view.customSwing.CustomJTextField();
        passwordJPasswordField = new view.customSwing.CustomJPasswordField();
        userNameCationLabel = new javax.swing.JLabel();
        passwordCautionLabel = new javax.swing.JLabel();
        registerButton = new view.customSwing.CustomButtonWithPressEffect();
        loginButton = new view.customSwing.CustomButtonWithPressEffect();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        memberPanel = new view.Panel.MemberPanel();
        customHeader2 = new view.customSwing.CustomHeader();
        headerLabel1 = new javax.swing.JLabel();
        binButton = new view.customSwing.CustomButtonWithPressEffect();
        background1 = new view.component.Background();
        detailButton = new view.component.personalMenuButton();
        updateButton = new view.component.personalMenuButton();
        changePassButton = new view.component.personalMenuButton();
        paymentHistoryButton = new view.component.personalMenuButton();
        logOutButton = new view.component.personalMenuButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        panelBorder2.setBackground(new java.awt.Color(255, 255, 255));

        theaterButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/theater.png"))); // NOI18N
        theaterButton.setText("THEATER");
        theaterButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        theaterButton.setSizeSpeed(8.0F);
        theaterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                theaterButtonActionPerformed(evt);
            }
        });

        storeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/store.png"))); // NOI18N
        storeButton.setText("STORE");
        storeButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        storeButton.setSizeSpeed(8.0F);
        storeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                storeButtonActionPerformed(evt);
            }
        });

        personalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/personal.png"))); // NOI18N
        personalButton.setText("PERSONAL");
        personalButton.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        personalButton.setSizeSpeed(8.0F);
        personalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                personalButtonActionPerformed(evt);
            }
        });

        homeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/home.png"))); // NOI18N
        homeButton.setText("HOME");
        homeButton.setFont(new java.awt.Font("Sherif", 1, 14)); // NOI18N
        homeButton.setSizeSpeed(10.0F);
        homeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuBarLayout = new javax.swing.GroupLayout(menuBar);
        menuBar.setLayout(menuBarLayout);
        menuBarLayout.setHorizontalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuBarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(theaterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(storeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(personalButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuBarLayout.setVerticalGroup(
            menuBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(theaterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addComponent(personalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(storeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(homeButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        headerHomePanel.setColorPaint(new java.awt.Color(91, 115, 79));

        javax.swing.GroupLayout headerHomePanelLayout = new javax.swing.GroupLayout(headerHomePanel);
        headerHomePanel.setLayout(headerHomePanelLayout);
        headerHomePanelLayout.setHorizontalGroup(
            headerHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        headerHomePanelLayout.setVerticalGroup(
            headerHomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 90, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout homePanelLayout = new javax.swing.GroupLayout(homePanel);
        homePanel.setLayout(homePanelLayout);
        homePanelLayout.setHorizontalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(movieList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        homePanelLayout.setVerticalGroup(
            homePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homePanelLayout.createSequentialGroup()
                .addComponent(headerHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(movieList, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        cardLayoutCustomerPanel.add(homePanel, "homePagePanel");

        javax.swing.GroupLayout storePanelLayout = new javax.swing.GroupLayout(storePanel);
        storePanel.setLayout(storePanelLayout);
        storePanelLayout.setHorizontalGroup(
            storePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1280, Short.MAX_VALUE)
        );
        storePanelLayout.setVerticalGroup(
            storePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        cardLayoutCustomerPanel.add(storePanel, "storePagePanel");

        customHeader1.setColorPaint(new java.awt.Color(91, 115, 79));
        customHeader1.setPreferredSize(new java.awt.Dimension(1280, 520));

        headerLabel.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel.setText("Account Information");

        javax.swing.GroupLayout customHeader1Layout = new javax.swing.GroupLayout(customHeader1);
        customHeader1.setLayout(customHeader1Layout);
        customHeader1Layout.setHorizontalGroup(
            customHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customHeader1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        customHeader1Layout.setVerticalGroup(
            customHeader1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
        );

        userNameJTextField.setBackground(new java.awt.Color(0, 0, 0));
        userNameJTextField.setForeground(new java.awt.Color(255, 255, 255));
        userNameJTextField.setLabelText("Username");
        userNameJTextField.setLineColor(new java.awt.Color(102, 255, 102));
        userNameJTextField.setSelectionColor(new java.awt.Color(0, 204, 51));

        passwordJPasswordField.setBackground(new java.awt.Color(0, 0, 0));
        passwordJPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        passwordJPasswordField.setLabelText("Password");
        passwordJPasswordField.setLineColor(new java.awt.Color(102, 255, 102));
        passwordJPasswordField.setSelectionColor(new java.awt.Color(0, 204, 51));
        passwordJPasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordJPasswordFieldActionPerformed(evt);
            }
        });

        userNameCationLabel.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        userNameCationLabel.setForeground(new java.awt.Color(255, 0, 0));

        passwordCautionLabel.setFont(new java.awt.Font("SansSerif", 0, 10)); // NOI18N
        passwordCautionLabel.setForeground(new java.awt.Color(255, 0, 0));

        registerButton.setText("Register");
        registerButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        registerButton.setPaintedColor(new java.awt.Color(0, 0, 0));
        registerButton.setSizeSpeed(10.0F);

        loginButton.setText("Login");
        loginButton.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        loginButton.setPaintedColor(new java.awt.Color(58, 181, 75));
        loginButton.setShowBorder(false);
        loginButton.setSizeSpeed(10.0F);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Don't Have an Account?");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(58, 151, 75));
        jLabel4.setText("Forgot Password ?");

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customHeader1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(387, 387, 387)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(loginPanelLayout.createSequentialGroup()
                                .addComponent(passwordCautionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addComponent(passwordJPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(registerButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(userNameCationLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(563, 563, 563)
                        .addComponent(jLabel3)))
                .addContainerGap(408, Short.MAX_VALUE))
            .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addGap(386, 386, 386)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(409, Short.MAX_VALUE)))
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addComponent(customHeader1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112)
                .addComponent(userNameCationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordJPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(passwordCautionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(registerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(loginPanelLayout.createSequentialGroup()
                    .addGap(149, 149, 149)
                    .addComponent(userNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(405, Short.MAX_VALUE)))
        );

        cardLayoutCustomerPanel.add(loginPanel, "loginPagePanel");

        customHeader2.setColorPaint(new java.awt.Color(91, 115, 79));

        headerLabel1.setFont(new java.awt.Font("SansSerif", 1, 28)); // NOI18N
        headerLabel1.setForeground(new java.awt.Color(255, 255, 255));
        headerLabel1.setText("Account Information");

        binButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/bin.png"))); // NOI18N
        binButton.setPaintedColor(new java.awt.Color(91, 115, 79));
        binButton.setSizeSpeed(8.0F);

        javax.swing.GroupLayout customHeader2Layout = new javax.swing.GroupLayout(customHeader2);
        customHeader2.setLayout(customHeader2Layout);
        customHeader2Layout.setHorizontalGroup(
            customHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(customHeader2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(binButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        customHeader2Layout.setVerticalGroup(
            customHeader2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(binButton, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
            .addComponent(headerLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        detailButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/details.png"))); // NOI18N
        detailButton.setText("Details");
        detailButton.setIconTextGap(10);
        detailButton.setSizeSpeed(10.0F);
        detailButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailButtonActionPerformed(evt);
            }
        });

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/update.png"))); // NOI18N
        updateButton.setText("Update");
        updateButton.setIconTextGap(10);
        updateButton.setSizeSpeed(10.0F);

        changePassButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/change password.png"))); // NOI18N
        changePassButton.setText("Change Password");
        changePassButton.setIconTextGap(10);
        changePassButton.setSizeSpeed(10.0F);

        paymentHistoryButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/payment history.png"))); // NOI18N
        paymentHistoryButton.setText("Payment History");
        paymentHistoryButton.setIconTextGap(10);
        paymentHistoryButton.setSizeSpeed(10.0F);

        logOutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icon/log out.png"))); // NOI18N
        logOutButton.setText("Log Out");
        logOutButton.setIconTextGap(10);
        logOutButton.setSizeSpeed(10.0F);

        javax.swing.GroupLayout memberPanelLayout = new javax.swing.GroupLayout(memberPanel);
        memberPanel.setLayout(memberPanelLayout);
        memberPanelLayout.setHorizontalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(customHeader2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(paymentHistoryButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(detailButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logOutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(changePassButton, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)))
        );
        memberPanelLayout.setVerticalGroup(
            memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(memberPanelLayout.createSequentialGroup()
                .addComponent(customHeader2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(memberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(detailButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(changePassButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(paymentHistoryButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(memberPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(background1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))))
        );

        cardLayoutCustomerPanel.add(memberPanel, "memberPagePanel");

        javax.swing.GroupLayout panelBorder2Layout = new javax.swing.GroupLayout(panelBorder2);
        panelBorder2.setLayout(panelBorder2Layout);
        panelBorder2Layout.setHorizontalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(cardLayoutCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelBorder2Layout.setVerticalGroup(
            panelBorder2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBorder2Layout.createSequentialGroup()
                .addComponent(cardLayoutCustomerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(menuBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelBorder2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeButtonActionPerformed
        cardLayout.show(cardLayoutCustomerPanel, "homePagePanel");
    }//GEN-LAST:event_homeButtonActionPerformed

    private void theaterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_theaterButtonActionPerformed
        cardLayout.show(cardLayoutCustomerPanel, "theaterPagePanel");
    }//GEN-LAST:event_theaterButtonActionPerformed

    private void personalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_personalButtonActionPerformed
        if(userService.getUser().getRole() == Role.GUEST){
            cardLayout.show(cardLayoutCustomerPanel, "loginPagePanel");
        } else {
            cardLayout.show(cardLayoutCustomerPanel, "memberPagePanel");
        }
    }//GEN-LAST:event_personalButtonActionPerformed

    private void storeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_storeButtonActionPerformed
        
    }//GEN-LAST:event_storeButtonActionPerformed

    private void detailButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_detailButtonActionPerformed

    private void passwordJPasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordJPasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordJPasswordFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
    }//GEN-LAST:event_loginButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private view.component.Background background1;
    private view.customSwing.CustomButtonWithPressEffect binButton;
    private view.Panel.CardLayoutPanel cardLayoutCustomerPanel;
    private view.component.personalMenuButton changePassButton;
    private view.customSwing.CustomHeader customHeader1;
    private view.customSwing.CustomHeader customHeader2;
    private view.component.personalMenuButton detailButton;
    private view.customSwing.CustomHeader headerHomePanel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JLabel headerLabel1;
    private view.component.MenuButton homeButton;
    private view.Panel.HomePanel homePanel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private view.component.personalMenuButton logOutButton;
    private view.customSwing.CustomButtonWithPressEffect loginButton;
    private view.Panel.LoginPanel loginPanel;
    private view.Panel.MemberPanel memberPanel;
    private view.component.MenuBar menuBar;
    private view.component.MovieList movieList;
    private view.customSwing.CustomBorderPanel panelBorder2;
    private javax.swing.JLabel passwordCautionLabel;
    private view.customSwing.CustomJPasswordField passwordJPasswordField;
    private view.component.personalMenuButton paymentHistoryButton;
    private view.component.MenuButton personalButton;
    private view.customSwing.CustomButtonWithPressEffect registerButton;
    private view.component.MenuButton storeButton;
    private view.Panel.StorePanel storePanel;
    private view.component.MenuButton theaterButton;
    private view.component.personalMenuButton updateButton;
    private javax.swing.JLabel userNameCationLabel;
    private view.customSwing.CustomJTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
