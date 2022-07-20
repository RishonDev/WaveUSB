package WaveUSB;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

class Main{
    static JFrame frame = new JFrame();
    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    public static void main(String[] args) throws IOException {
        Downloader downloader = new Downloader();
        frame.setLayout(layout);
        frame.setSize(1920,1080);
        frame.setVisible(true);

    }


}