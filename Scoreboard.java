
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
public class Scoreboard {
    public void Scoreboardmethod() {
        JFrame d = new JFrame("Rock Paper Scissor");
        d.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icongame.png")));
        JPanel p2 = new JPanel();
        p2.setBounds(0, 0, 850, 580);
        d.add(p2);
        p2.setBackground(new Color(255,100,0));
        Font fontwin = new Font("Century", Font.BOLD, 35);
        Font fontbtn = new Font("Century", Font.BOLD, 25);
        Font font1 = new Font("Century", Font.BOLD, 50);
        Font font2 = new Font("Century", Font.BOLD, 45);
        JLabel cmwin = new JLabel("");
        cmwin.setBounds(260, 70, 350, 50);
        cmwin.setFont(fontwin);
        cmwin.setForeground(Color.white);
        p2.add(cmwin);
        JLabel youwin = new JLabel();
        youwin.setBounds(330, 70, 350, 50);
        youwin.setFont(fontwin);
        youwin.setForeground(Color.white);
        p2.add(youwin);
        JLabel userscore = new JLabel("0");
        userscore.setBounds(350, 120, 50, 50);
        userscore.setForeground(Color.white);
        userscore.setFont(font1);
        p2.add(userscore);
        JLabel line = new JLabel(":");
        line.setBounds(397, 130, 50, 50);
        line.setForeground(Color.white);
        line.setFont(font2);
        p2.add(line);
        JLabel computerscore = new JLabel("0");
        computerscore.setBounds(430, 120, 50, 50);
        computerscore.setForeground(Color.white);
        computerscore.setFont(font1);
        p2.add(computerscore);
        JButton playagain = new JButton("Play Again");
        playagain.setBounds(300, 200, 200, 70);
        Border blbutton = new LineBorder(Color.black, 2, true);
        playagain.setForeground(Color.black);
        playagain.setBackground(Color.white);
        playagain.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playagain.setFont(fontbtn);
        playagain.setBorder(blbutton);
        playagain.setToolTipText("PlayAgain (ENTER)");
        p2.add(playagain);
        JLabel homepage = new JLabel("HOMEPAGE");
        homepage.setBounds(330, 450, 200, 50);
        homepage.setForeground(Color.white);
        homepage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homepage.setFont(fontbtn);
        p2.add(homepage);
        if (ComputerFrame.usercount == 3) {
            youwin.setText("You Win...");
        } else {
            cmwin.setText("Computer Win...");
        }
        userscore.setText(Integer.toString(ComputerFrame.usercount));
        computerscore.setText(Integer.toString(ComputerFrame.computercount));
        MouseListener m1 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                d.setVisible(false);
                d.dispose();
                ComputerFrame.roundcnt=1;
                ComputerFrame.usercount=0;
                ComputerFrame.computercount=0;
                new HomePage().setVisible(true);
            }
            public void mousePressed(MouseEvent e) {
            }
            public void mouseReleased(MouseEvent e) {
            }
            public void mouseExited(MouseEvent e) {
            }
            public void mouseEntered(MouseEvent e) {
            }
        };
        homepage.addMouseListener(m1);
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
                d.dispose();
                ComputerFrame.roundcnt = 1;
                ComputerFrame.usercount = 0;
                ComputerFrame.computercount = 0;
                new ComputerFrame().setVisible(true);
            }
        };
        playagain.addActionListener(al);
        KeyListener kl = new KeyListener() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    d.setVisible(false);
                    d.dispose();
                    ComputerFrame.roundcnt = 1;
                    ComputerFrame.usercount = 0;
                    ComputerFrame.computercount = 0;
                    new ComputerFrame().setVisible(true);
                }

            }
            public void keyReleased(KeyEvent evt) {
            }
            public void keyTyped(KeyEvent evt) {
            }
        };
        playagain.addKeyListener(kl);
        p2.setLayout(null);
        d.setLocation(250, 80);
        d.setSize(850, 580);
        d.setResizable(false);
        d.setVisible(true);
    }
}
