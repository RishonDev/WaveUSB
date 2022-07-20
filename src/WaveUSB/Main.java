package WaveUSB;

import javax.swing.*;
import java.awt.*;

class Main implements Constants{
    static JFrame frame = new JFrame();
    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    public static void main(String[] args){
        frame.setLayout(layout);
        frame.setSize(1920,1080);
        frame.setVisible(true);
        
    }

}