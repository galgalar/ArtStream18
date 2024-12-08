

import java.util.ArrayList;
import javax.swing.*;


public class Artists extends Informations implements Validation{
    
    private static ArrayList <String> names = new ArrayList<>();
    private static ArrayList <String> pass = new ArrayList<>();
    private static ArrayList<DashboardArtist> dashboardDigital = new ArrayList<>();
    private static ArrayList<DashboardArtist> dashboardCharcoal = new ArrayList<>();
    private static ArrayList<DashboardArtist> dashboardLandscape = new ArrayList<>();
    private static ArrayList<DashboardArtist> dashboardPortrait= new ArrayList<>();
    private String type;
    public static int noOfClient = 0;
    private int index;
    

    public Artists(String username,String password, String type)
    {
        super(username,password);
        this.type =  type;

        try
        {           
            names.add(username);
            pass.add(password);
            
            // // dashboardClients.add(new DashboardClient(username));
 
             System.out.println(names.get(noOfClient));
             System.out.println(pass.get(noOfClient));  
             

             ++noOfClient;      

            if(type.equals("Digital Artist"))
            {
                dashboardDigital.add(new DashboardArtist(username));
                
            }else if(type.equals("Charcoal Artist"))
            {
                dashboardCharcoal.add(new DashboardArtist(username));
            }else if(type.equals("Landscape Artist"))
            {
                dashboardLandscape.add(new DashboardArtist(username));
            }else
            {
                dashboardPortrait.add(new DashboardArtist(username));
            }

            
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }



    }

    public Artists()
    {
        super("Unknown","LOL");
    }
    @Override
    public boolean validateLogin(String name, String password) {

        for (int i = 0; i < names.size(); ++i) {
            if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
                index = i;       
                System.out.print(index);       
                return true; 
            }
        }
        return false; 
    }
    @Override
    public boolean validateRegister(String name, String password) {

        for (int i = 0; i < names.size(); ++i) {
            if (name.equals(names.get(i)) && password.equals(pass.get(i))) {
                return true; 
            }
        }
        return false; 
    }
    
    public void displayDashboard(String type)
    {       
            if(type.equals("Digital Artist"))
            {
                 dashboardDigital.get(index).setVisible(true);
            }else if(type.equals("Charcoal Artist"))
            {
                 dashboardCharcoal.get(index).setVisible(true);
            }else if(type.equals("Landscape Artist"))
            {
                dashboardLandscape.get(index).setVisible(true);
            }else
            {
                dashboardPortrait.get(index).setVisible(true);
            }

    }
    


}
