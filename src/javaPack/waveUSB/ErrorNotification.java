package javaPack.waveUSB;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//File copied from JUIT Libraray project. it is an incomplete library and is very buggy, so please do not use it for production. Still curious? visit https://github.com/RishonDev/JUIT
@SuppressWarnings("ALL")
public class ErrorNotification {

	private short x = 600;
	private short y = 175;
	final private int IMAGE_SIZEY =  92;
	final private int IMAGE_SIZEX =  84;

	private JLabel IconImage = new JLabel("");
	private JFrame frame;
	private JButton ok = new JButton("Ok");
	private String temp = ok.getText();
	private JButton cancel = new JButton();
	private String temp2 = cancel.getText();

	public short getX() {
		return x;
	}

	public void setX(short x) {
		this.x = x;
	}

	public short getY() {
		return y;
	}

	public void setY(short y) {
		this.y = y;
	}

	public int getIMAGE_SIZEY() {
		return IMAGE_SIZEY;
	}

	public int getIMAGE_SIZEX() {
		return IMAGE_SIZEX;
	}

	public JLabel getIconImage() {
		return IconImage;
	}

	public void setIconImage(JLabel iconImage) {
		IconImage = iconImage;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JButton getOk() {
		return ok;
	}

	public void setOk(JButton ok) {
		this.ok = ok;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public JButton getCancel() {
		return cancel;
	}

	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

	public String getTemp2() {
		return temp2;
	}

	public void setTemp2(String temp2) {
		this.temp2 = temp2;
	}

	public JLabel getErrorText() {
		return ErrorText;
	}

	public void setErrorText(JLabel errorText) {
		ErrorText = errorText;
	}

	private JLabel ErrorText;
	public ErrorNotification(String Title,int x,int y)
	{
		frame =  new JFrame(Title);
		frame.setSize(x,y);
	}
	public void SetErrorText(String displayText)
	{
		var ErrorText = new JLabel(displayText);
		ErrorText.setBounds(102, 17, 492, 113);
		frame.getContentPane().add(ErrorText);
	}
	public void SetIcon(String filePathWithName) {
		IconImage.setIcon(new ImageIcon(ErrorNotification.class.getResource(filePathWithName)));
	}
	public void setSizeOfText(short x,short y) {
		ErrorText.setSize(y, x);
	}
	public void setTitle(String Title)
	{
		ErrorText.setName(Title);
	}
	public void setDefaults()
	{
		String pathOfFile = "juit/img/error.png";
		frame.setBounds(100, 100, 600, 175);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Image icon = Toolkit.getDefaultToolkit().getImage(pathOfFile);
		frame.setIconImage(icon);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		IconImage.setIcon(new ImageIcon(Objects.requireNonNull(ErrorNotification.class.getResource(pathOfFile))));
		IconImage.setBounds(6, 23, 84, 92);
		frame.getContentPane().add(IconImage);
		ok.setBounds(0,0,580,165);
		frame.getContentPane().add(ok);
	}
	public void setBackgroundColor(Color color)
	{
		frame.setBackground(color);
	}
	public void setFont(String FontName,String FontType,short size)
	{
		if(FontType.equals("Plain"))ErrorText.setFont(new Font(FontName, Font.PLAIN, size));
		if(FontType.equals("Bold"))ErrorText.setFont(new Font(FontName, Font.BOLD, size));
		if(FontType.equals("Italic"))ErrorText.setFont(new Font(FontName, Font.ITALIC, size));

	}
	public void setTitleIcon(String pathOfFile)
	{
		Image icon = Toolkit.getDefaultToolkit().getImage(pathOfFile);
		frame.setIconImage(icon);
	}
	public void setButtonMessage(String buttonMessage)
	{
		ok.setText(buttonMessage);
	}
	public void setButtonSize(Dimension dim)
	{
		ok.setPreferredSize(dim);
	}
	public void setPositionOfOkButton(short x,short y)
	{
		ok.setLocation(x,y);
	}
	public void setPositionOfCancelButton(short x,short y)
	{
		cancel.setLocation(x,y);
	}
	public void setSizeOfWindow(short x, short y)
	{
		this.x = x;
		this.y = y;
		frame.setSize(this.x,this.y);
	}
	public short getXOfWindow()
	{
		return x;
	}
	public short getYOfWindow()
	{
		return y;
	}
	public short getYOfOkButton()
	{
		short buttony = 175;
		return buttony;
	}
	public short getXOfOkButton()
	{
		short buttonx = 600;
		return buttonx;
	}
	public short getYOfCancelkButton()
	{
		short cancelButtony = 175;
		return cancelButtony;
	}
	public short getXOfCancelButton()
	{
		short cancelButtonx = 600;
		return cancelButtonx;
	}
	public void AddCancelButton()
	{
		cancel.setBounds(100, 100, 590, 175);
		frame.add(cancel);

	}
	public void setButtonOkFont(String FontName,String FontType,short size)
	{
		if(FontType.equals("Plain"))ok.setFont(new Font(FontName, Font.PLAIN, size));
		if(FontType.equals("Bold"))ok.setFont(new Font(FontName, Font.BOLD, size));
		if(FontType.equals("Italic"))ok.setFont(new Font(FontName, Font.ITALIC, size));
	}
	public void setButtonCancelFont(String FontName,String FontType,short size)
	{
		if(FontType.equals("Plain"))cancel.setFont(new Font(FontName, Font.PLAIN, size));
		if(FontType.equals("Bold"))cancel.setFont(new Font(FontName, Font.BOLD, size));
		if(FontType.equals("Italic"))cancel.setFont(new Font(FontName, Font.ITALIC, size));
	}

	public void trimTextOfCancelButton()
	{
		String temp =cancel.getText().trim();
		cancel.setText(temp);
	}
	public void trimTextOfOkButton()
	{
		String temp =ok.getText().trim();
		ok.setText(temp);
	}
}
