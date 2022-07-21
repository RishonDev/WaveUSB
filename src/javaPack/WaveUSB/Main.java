package javaPack.WaveUSB;

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
    static JButton[] next = new JButton[5];
    static JButton[] previous = new JButton[5];
    static JInternalFrame jInternalFrame = new JInternalFrame();
    static JProgressBar jProgressBar = new JProgressBar();
    JScrollPane jScrollPane = new JScrollPane();
    JScrollBar jScrollBar = new JScrollBar();
    JTextArea jTextArea = new JTextArea();
    static JPanel downloadImage = new JPanel();
    JLabel percentLabel = new JLabel();
    JLabel timeLefJLabel = new JLabel();
    static CardLayout layout = new CardLayout();
    static JFileChooser jFileChooser = new JFileChooser();
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenu viewMenu = new JMenu("View");
    JMenu downloadMenu = new JMenu("Download");
    static JButton button = new JButton("");
    static JLabel chooseOS = new JLabel("To start, choose your operating system installer you want to write to your USB:");
    static JLabel welcomeLabel = new JLabel("Welcome!");
    public static void main(String[] args){
        frame.setSize(new Dimension(800,800));
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        ApplicationPanel.setLayout(layout);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN,30));
        welcomeLabel.setBounds(100,100,500,100);
        chooseOS.setBounds(200,50,500,100);
        welcome.add(welcomeLabel);
        welcome.add(chooseOS);
        ApplicationPanel.add(welcome,"1");
        layout.show(ApplicationPanel ,"1");
        frame.add(ApplicationPanel);
        frame.pack();
        frame.setVisible(true);

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
}

