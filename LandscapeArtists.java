
import javax.swing.*;
import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.*;

public class LandscapeArtists extends JPanel {
    //  protected JButton[] commissionLandscape= new JButton[4];
    
    // public LandscapeArtists()
    // {
    //     label.setText("Charcoal Artists");
    //     String[] landscapeArtists = 
    //     {
    //         "Norman Lee",
    //         "Aristotle Mosiax",
    //         "Josh Montage",
    //         "Sarah Monday"
    //     };   
        
    //     contents.removeAll();
    //     for (int i = 0; i < grids.length; ++i) 
    //     {
            
    //         profileLabels[i].setText(landscapeArtists[i]);            
    //         profileLabels[i].setVerticalTextPosition(SwingConstants.BOTTOM);
    //         profileLabels[i].setHorizontalTextPosition(SwingConstants.CENTER);

    //         // Update each grid
    //         grids[i] = new JPanel();
    //         grids[i].setLayout(new BorderLayout());
    //         grids[i].setBackground(Color.decode("#303765"));
    //         grids[i].add(profileLabels[i], BorderLayout.CENTER);

    //         // Create a new "View Profile" button
    //         commissionLandscape[i] = new JButton("REQUEST COMMISSION");
    //         commissionLandscape[i].addActionListener(this);
    //         commissionLandscape[i].setBackground(Color.decode("#17224d"));
    //         commissionLandscape[i].setForeground(Color.WHITE);
    //         commissionLandscape[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    //         grids[i].setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    //         grids[i].add(commissionLandscape[i], BorderLayout.SOUTH);

    //         // Add the grid to the contents panel
    //         contents.add(grids[i]);
    //     }

    //     // Refresh the UI to display changes
    //     contents.revalidate();
    //     contents.repaint();
        
        
        
    //     setVisible(true);
    
    // }
    
    // @Override 
    // public void actionPerformed(ActionEvent e)
    // {
    //    Object source = e.getSource();
       
    //    if(source == acceptedButton)
    //    {
    //        new AcceptedCommissions();
    //        setVisible(false);
    //    }else if(source == pendingButton)
    //    {
    //        new PendingCommissions();
    //        setVisible(false);
    //    }else if(source == profileButton)
    //    {
    //        int choice = JOptionPane.showConfirmDialog(null,"Are you sure you want to log out?", "Confirm Log-Out",JOptionPane.YES_NO_OPTION);
           
    //        if(choice == JOptionPane.YES_OPTION)
    //        {
    //            new FirstFrame();           
    //            setVisible(false);
    //        }   
    //    }else if(source == commissionLandscape[0] || source == commissionLandscape[1] || source == commissionLandscape[2] ||source == commissionLandscape[3])
    //    {
    //        new CommissionLandscape();
        
    //    }else
    //    {
    //        new DashboardClient();
    //        setVisible(false);
    //    }
           
       
       
    // }
    
    
    public LandscapeArtists()
    {
        setBackground(Color.decode("#17224d"));
        setLayout(new BorderLayout());
        JPanel[] panels = new JPanel[2];

        for(int i = 0; i < panels.length; ++i)
        {
            if(i == 0)
            {
                JLabel labelHeader = new JLabel();
                labelHeader.setText("Landscape Artists");
                labelHeader.setFont(new Font("Monospace",Font.BOLD,30));
                labelHeader.setForeground(Color.WHITE);
                
                panels[i] = new JPanel();
                panels[i].setLayout(new FlowLayout(FlowLayout.LEFT));
                panels[i].setBackground(Color.decode("#17224d"));
                panels[i].add(labelHeader);

                add(panels[i],BorderLayout.NORTH);
            }else
            {
                panels[i] = new JPanel();
                panels[i].setBackground(Color.decode("#17224d"));
                add(panels[i],BorderLayout.CENTER);
            }
            
        }
      





        setVisible(true);

    }
    
}