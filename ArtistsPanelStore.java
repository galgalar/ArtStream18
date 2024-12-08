import javax.swing.*;
import java.util.*;

public interface ArtistsPanelStore {

    // ArrayList<JPanel> digitalPanel = new ArrayList<>();
    // ArrayList<JPanel> charcoalPanel = new ArrayList<>();
    // ArrayList<JPanel> landscapesPanel = new ArrayList<>();
    // ArrayList<JPanel> portraitPanel = new ArrayList<>();

    // JPanel panel = new JPanel();

    JPanel addDigitalPanel(JPanel panel);
    JPanel addCharcoalPanel(JPanel panel);
    JPanel addLandscapePanel(JPanel panel);
    JPanel addPortraitPanel(JPanel panel);

}
