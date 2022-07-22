package javaPack.waveUSB;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

class Main {
   //Components of the Application
    static JFrame frame = new JFrame();
    static JPanel ApplicationPanel = new JPanel();
    static JPanel welcome = new JPanel();
    static JPanel macOS = new JPanel();
    static JPanel Linux = new JPanel();
    static JPanel Windows = new JPanel();
    static JPanel writeImageToUSB = new JPanel();
    static JPanel verifyUSB = new JPanel();
    static JPanel finishedScreen = new JPanel();//ending screen
    static JButton macOS_11 = new JButton("macOS 11 (Codenamed Big Sur)");
    static JButton macOS_12 = new JButton("macOS 12(Codenamed Monterey)");
    static JLabel macOSChoose = new JLabel("Choose your macOS Version:");
    static JButton[] previous = new JButton[5];
    static JInternalFrame jInternalFrame = new JInternalFrame();
    static JProgressBar jProgressBar = new JProgressBar();
    static JScrollPane jScrollPane = new JScrollPane();
    static JScrollBar jScrollBar = new JScrollBar();
    static JTextArea jTextArea = new JTextArea();
    static JPanel downloadImage = new JPanel();
    static JLabel percentLabel = new JLabel();
    static JLabel timeLeftLabel = new JLabel();
    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    static JMenuBar menuBar = new JMenuBar();
    static JButton otherButton = new JButton("Other..");
    static JLabel chooseOS = new JLabel("To start, choose your operating system installer you want to write to your USB:");
    static JLabel welcomeLabel = new JLabel("Welcome!");
    JMenu fileMenu = new JMenu("File");
    JMenu viewMenu = new JMenu("View");
    JMenu downloadMenu = new JMenu("Download");
    //Buttons
    static JButton macOSButton = new JButton("macOS");
    static JButton windowsButton = new JButton("Windows");
    static JButton linuxButton = new JButton("Linux");
    static JButton ubuntu = new JButton("Ubuntu 22.04(Codenamed Jammy Jellyfish)");
    static JButton debian = new JButton("Debian 11-32 bit(Codenamed Bullseye)");
    static JButton debian64 = new JButton("Debian 11 64-bit (Codenamed Bullseye)");
    static JButton debianNet64 = new JButton("Debian 11 64-bit Network Installer(Codenamed Bullseye)");
    static JButton debianNet = new JButton("Debian 11 32-bit Network Installer(Codenamed Bullseye)");
    static JButton ubuntuServer = new JButton("Ubuntu Server 22.04(Codenamed Jammy Jellyfish)");
    static JButton Arch = new JButton("Arch 2022.07.01 64-bit");
    static JButton fedoraWorkspace = new JButton("Fedora Workstation 36 32-bit");
    static JButton fedoraWorkspace64 = new JButton("Fedora Workstation 36 64-bit");
    static JButton fedoraServer = new JButton("Fedora Server 36 32-bit");
    static JButton fedoraServer64 = new JButton("Fedora Server 36 64-bit");

    public static void main(String[] args){
        frame.setSize(new Dimension(500,400));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN,30));
        welcomeLabel.setBounds(100,100,500,100);
        chooseOS.setBounds(200,50,500,100);
        macOSButton.setSize(100,30);
        macOSButton.setLocation(250,200);
        windowsButton.setSize(100,30);
        windowsButton.setLocation(250,300);
        linuxButton.setSize(100,30);
        linuxButton.setLocation(100,370);
        otherButton.setSize(100,30);
        macOS_12.setSize(100,30);
        macOS_11.setSize(100,30);
        macOSChoose.setFont(new Font("SansSerif", Font.PLAIN, 30));
        welcome.add(welcomeLabel);
        welcome.add(chooseOS);
        welcome.add(macOSButton);
        welcome.add(windowsButton);
        welcome.add(linuxButton);
        welcome.add(otherButton);
        welcome.add(otherButton);
        macOS.add(macOSChoose);
        macOS.add(macOS_12);
        macOS.add(macOS_11);
        ApplicationPanel.setLayout(layout);
        ApplicationPanel.add(welcome,"1");
        ApplicationPanel.add(macOS,"2");
        ApplicationPanel.add(Linux,"3");
        ApplicationPanel.add(Windows,"4");
        ApplicationPanel.add(writeImageToUSB,"5");
        ApplicationPanel.add(verifyUSB,"6");
        ApplicationPanel.add(finishedScreen,"7");
        layout.show(ApplicationPanel ,"3");
        frame.add(menuBar);
        frame.add(ApplicationPanel);
        //frame.pack();
        frame.setVisible(true);

    }

 private static int getFileSize(URL url) {
  URLConnection conn = null;
  try {
   conn = url.openConnection();
   if(conn instanceof HttpURLConnection) {
    ((HttpURLConnection)conn).setRequestMethod("HEAD");
   }
   conn.getInputStream();
   return conn.getContentLength();
  } catch (IOException e) {
   throw new RuntimeException(e);
  } finally {
   if(conn instanceof HttpURLConnection) {
    ((HttpURLConnection)conn).disconnect();
   }
  }
 }

    public void download(String URL, String fileName){
     Runnable updateThread = new Runnable() {
      public void run() {
       try {

        HttpsURLConnection httpsConnection = (HttpsURLConnection) (new URL(URL).openConnection());
        long completeFileSize = httpsConnection.getContentLength();
        java.io.BufferedInputStream in = new java.io.BufferedInputStream(httpsConnection.getInputStream());
        java.io.FileOutputStream fos = new java.io.FileOutputStream(fileName);
        java.io.BufferedOutputStream bout = new BufferedOutputStream(fos, 1024);
        byte[] data = new byte[1024];
        long downloadedFileSize = 0;
        int x = 0;
        while ((x = in.read(data, 0, 1024)) >= 0) {
         downloadedFileSize += x;
         final int currentProgress = (int) ((((double)downloadedFileSize) / ((double)completeFileSize)) * 100000d);
         SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
           jProgressBar.setValue(currentProgress);
          }
         });
         bout.write(data, 0, x);
        }
        bout.close();
        in.close();
       } catch (FileNotFoundException e) {
       } catch (IOException e) {
       }
      }
     };
     new Thread(updateThread).start();
    }
}

