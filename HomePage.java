
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public class HomePage extends JFrame implements ActionListener {

    JRadioButton computer;
    JRadioButton friend;
    JPanel p1;
    JButton b1;
    JLabel l1;
    String value;
    ServerFrame serverFrame;

    public HomePage() {
        setTitle("Home");
        serverFrame = new ServerFrame();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icongame.png")));
        Font fontlabel = new Font("Century", Font.BOLD, 30);
        l1 = new JLabel("Welcome to Rock Paper Scissor Game");
        l1.setBounds(135, 50, 650, 50);
        l1.setForeground(Color.white);
        l1.setFont(fontlabel);
        p1 = new JPanel();
        p1.setBounds(0, 0, 750, 500);
        p1.setBackground(Color.white);
        Font font1 = new Font("Arial", Font.PLAIN, 20);
        ImageIcon i1 = new ImageIcon("letsplay.png");
        b1 = new JButton("Let's Play");
        b1.setBounds(530, 320, 120, 53);
        Border blbutton = BorderFactory.createLineBorder(Color.white);
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBorder(blbutton);
        b1.setIcon(i1);
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        ButtonGroup bg = new ButtonGroup();
        computer = new JRadioButton("Play with Computer", true);
        computer.setBounds(180, 180, 200, 20);
        computer.setBackground(new Color(255, 100, 0));
        computer.setForeground(Color.white);
        computer.setCursor(new Cursor(Cursor.HAND_CURSOR));
        computer.setFont(font1);
        friend = new JRadioButton("Play with Friend");
        friend.setBounds(180, 250, 200, 20);
        friend.setBackground(new Color(255, 100, 0));
        friend.setForeground(Color.white);
        friend.setCursor(new Cursor(Cursor.HAND_CURSOR));
        friend.setFont(font1);
        add(p1);
        p1.setBackground(new Color(255, 100, 0));
        p1.add(l1);
        p1.add(b1);
        bg.add(computer);
        bg.add(friend);
        p1.add(computer);
        p1.add(friend);
        setLocation(250, 80);
        setSize(850, 580);
        p1.setLayout(null);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            radiobutton();
        }
    }

    public void radiobutton() {
        if (computer.isSelected()) {
            new HomePage().setVisible(false);
            dispose();
            new ComputerFrame().setVisible(true);
        } else if (friend.isSelected()) {
            new HomePage().setVisible(false);
            dispose();
            serverFrame.ServerFrameMethod();
            try {
                serverFrame.servermethod();
            } catch (Exception e) {
            }
        }
    }

    public static void main(String args[]) {

        HomePage h1 = new HomePage();
    }
}
