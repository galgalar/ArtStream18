

import javax.swing.*;
import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.*;

public class SetupAccountArtist extends SetupAccountClient implements ActionListener
{
    private JLabel typeOfArtistLabel = new JLabel("Type of artist");
    private String[] artists = 
    {
        "Select",
        "Digital Artist",
        "Charcoal Artist",
        "Landscape Artist",
        "Portrait Artist"
    };

    private JComboBox<String> typeOfArtist = new JComboBox<>(artists);
    
    private String type;

    public SetupAccountArtist() 
    {
        setupLabel.setText("Setup your account as an Artist");
    
            typeOfArtistLabel.setFont(new Font("Monospaced", Font.PLAIN, 16));
            typeOfArtistLabel.setForeground(Color.BLACK);
            
            typeOfArtist.setMaximumSize(new Dimension(600, 40));
            typeOfArtist.setFont(new Font("Monospaced", Font.PLAIN, 14));     

            typeOfArtistLabel.setAlignmentX(LEFT_ALIGNMENT);
            typeOfArtist.setAlignmentX(LEFT_ALIGNMENT);
         
            pane2.add(usernameLabelRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(usernameFieldRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            // pane2.add(emailLabelRegister);
            // pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            // pane2.add(emailFieldRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(passwordLabelRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(passwordFieldRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(confirmPasswordLabelRegiste);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(confirmPasswordFieldRegister);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(typeOfArtistLabel);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(typeOfArtist);
            pane2.add(Box.createRigidArea(new Dimension(0, 10)));
            pane2.add(registerButton);

            typeOfArtist.addActionListener(this);

            type = (String) typeOfArtist.getSelectedItem();
            System.out.println(type);


        

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Object source = e.getSource();
        String command = e.getActionCommand();      

        if(command.equals("signin"))
        {
            card.show(secondMain,command);
        }else if(command.equals("register"))
        {
            card.show(secondMain,command);  

        }else if(e.getSource() == typeOfArtist)
        {
            type = (String)typeOfArtist.getSelectedItem();
            System.out.println(type);
        }
        
        
        else if(source == registerButton)
       {
           String username = usernameFieldRegister.getText();
           char[] pass = passwordFieldRegister.getPassword();
           char[] confirmPass = confirmPasswordFieldRegister.getPassword();
           Artists artists = new Artists();
           String password = "",confirmPassword = "";
           
           for(int i = 0;i < pass.length; ++i)
           {
               password += pass[i];
           }
           for(int i = 0;i < confirmPass.length; ++i)
           {
               confirmPassword += confirmPass[i];
           }
           
           if(password.isEmpty() || username.isEmpty() || typeOfArtist.getSelectedItem().equals("Select") || typeOfArtist.getSelectedItem() == null)
           {
               JOptionPane.showMessageDialog(null,"Fill in the empty fields");
           }
           else if(password.equals(confirmPassword))
           {
                if(artists.validateRegister(username, password))
                {
                    JOptionPane.showMessageDialog(null,"Account already existed");
                    usernameFieldRegister.setText("");
                    passwordFieldRegister.setText("");
                    // emailFieldRegister.setText("");
                    confirmPasswordFieldRegister.setText("");
                    typeOfArtist.setSelectedItem("Select");
                }else
                {
                    Artists lol = new Artists();
                    System.out.println(lol.noOfClient);
                    new Artists(username,password,type);                  
                    JOptionPane.showMessageDialog(null,"Account created successfully!");

                    if(type.equals("Digital Artist"))
                    {
                        JPanel digital = new JPanel();
                        digital.setLayout(new BorderLayout());

                        ImageIcon profileArtist = new ImageIcon("src\\portrait.jpg");
                        Image getProfileImage = profileArtist.getImage();
                        Image setSizeProfile = getProfileImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                        profileArtist = new ImageIcon(setSizeProfile);
                        JLabel artistImageAndName = new JLabel(profileArtist);
                        artistImageAndName.setText(usernameFieldRegister.getText());
                        artistImageAndName.setVerticalTextPosition(SwingConstants.BOTTOM);
                        artistImageAndName.setHorizontalTextPosition(SwingConstants.CENTER);
                        artistImageAndName.setForeground(Color.WHITE);
                        artistImageAndName.setFont(new Font("Monospaced",Font.BOLD,20));
                        JButton sendCommission = new JButton("Request Commission");
                        digital.add(artistImageAndName,BorderLayout.CENTER);
                        sendCommission.setMaximumSize(new Dimension(300,300));
                        sendCommission.addActionListener(this);
                        sendCommission.setForeground(Color.WHITE);
                        digital.add(sendCommission,BorderLayout.SOUTH);
                        digital.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
                        // new DigitalArtists(digital);
                       
                        new DigitalArtists(digital);
                        


                    }else if(type.equals("Charcoal Artist"))
                    {
                        
                    }else if(type.equals("Landscape Artist"))
                    {
                        
                    }else
                    {
                    
                    }

                    
                    usernameFieldRegister.setText("");
                    passwordFieldRegister.setText("");
                    confirmPasswordFieldRegister.setText("");
     
                    card.show(secondMain,"signin");    
                }
             
           }         
           else
           {
               passwordFieldRegister.setText(""); 
               confirmPasswordFieldRegister.setText(""); 
               JOptionPane.showMessageDialog(null,"The password should be match");
           }
       
       }else if(source == goBack)
       {
           new FirstFrame();
           dispose();
           
       }else if(source == signinButton)
       {     
            Artists testCredentials = new Artists();
            char [] c = passwordFieldSignin.getPassword();
            String passwordSignin = "";
            for(int i = 0; i < c.length; ++i)
            passwordSignin += c[i];
     
           if(testCredentials.validateLogin(usernameFieldSignin.getText(), passwordSignin))
           {
                JOptionPane.showMessageDialog(null,"Login Successfully!");
                testCredentials.displayDashboard(type);

                
                // new DashboardClient((String)usernameFieldSignin.getText());
                dispose();
           }else if(usernameFieldSignin.getText().isEmpty() || passwordSignin.isEmpty())
           {
               JOptionPane.showMessageDialog(null,"Fill in the empty fields");
           }
           else{
                JOptionPane.showMessageDialog(null,"Invalid Credentials");
                // usernameFieldSignin.setText("");
                // passwordFieldSignin.setText("");
           }
                    
       }

    }  



    // @Override
    // public void itemStateChanged(ItemEvent e)
    // {
    //     Object source = e.getItem();

    //     if(source == typeOfArtist)
    //     {
    //         int select = e.getStateChange();

    //         if(select == ItemEvent.SELECTED)
    //         {
    //             String getType = (String)typeOfArtist.getSelectedItem();
    //             type = getType;


    //                 // switch (getType) 
    //                 // {
    //                 //         case "Digital Artist":
    //                 //         type = "Digital Artist";
    //                 //         break;
    //                 //         case "Charcoal Artist":
    //                 //         type = "Charcoal Artist";
    //                 //         break;
    //                 //         case "Landscape Artist":
    //                 //         type = "Landscape Artist";
    //                 //         break;
    //                 //         case "Portrait Artist":
    //                 //         type = "Portrait Artist";
    //                 //         break;
    //                 //         default:
    //                 //         break;
    //                 // }
    //         }else
    //         {

    //         }
                   

    //     }


    // }






    
}
    
    
    
    
    


    
        
  
    
        
