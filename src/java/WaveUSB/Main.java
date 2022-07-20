package java.WaveUSB;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

class Main{
    static JFrame frame = new JFrame();
    static JPanel welcome = new JPanel();
    static JPanel macOS = new JPanel();
    static JPanel Linux = new JPanel();
    static JPanel Windows = new JPanel();
    static JPanel writeImageToUSB = new JPanel();
    static JPanel verifyUSB = new JPanel();
    static JPanel finishedScreen = new JPanel();//ending screen
    static JButton[] next = new JButton[5];
    static JButton[] previous = new JButton[5];

    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu viewMenu = new JMenu("View");
    JMenu downloadMenu = new JMenu("Download");
    JButton button = new JButton("");
    public static void main(String[] args) throws IOException {
        java.WaveUSB.Downloader downloader = new java.WaveUSB.Downloader();
        frame.setLayout(layout);
        frame.setSize(1920,1080);
        frame.setVisible(true);

    }


}