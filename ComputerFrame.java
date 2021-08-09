
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.event.KeyListener;
public class ComputerFrame extends JFrame implements ActionListener, KeyListener {
    JButton back, rock, paper, scissor;
    JPanel p1, up, left, center;
    JLabel l1, You, Computer, userclick, labelroundcnt;
    JLabel ustar1, ustar2, ustar3, cstar1, cstar2, cstar3, labelforuser, labelforcomputer;
    ImageIcon stoneleft, stoneright, paperleft, paperright, scissorleft, scissorright, blank1, blank2;
    ImageIcon userstar1, userstar2, userstar3, computerstar1, computerstar2, computerstar3, r, p, s;
    Random rand;
    public static int number;
    public static int computer, user;
    public static int usercount = 0, computercount = 0, roundcnt = 1;
    public static int tie;
    Scoreboard scoreboard;
    public ComputerFrame() {
        setTitle("Play with Computer");
        scoreboard = new Scoreboard();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icongame.png")));
        Font fontlabel = new Font("Century", Font.BOLD, 24);
        Font fontuc = new Font("Century", Font.PLAIN, 17);
        Font fontbutton = new Font("Century", Font.PLAIN, 16);
        p1 = new JPanel();
        p1.setBounds(0, 0, 750, 500);
        up = new JPanel();
        up.setBounds(0, 0, 850, 150);
        Border blackline1 = BorderFactory.createLineBorder(Color.black);
        up.setBackground(new Color(255,100,0));
        up.setBorder(blackline1);
        add(up);
        left = new JPanel();
        left.setBounds(0, 150, 210, 400);
        Border blackline2 = BorderFactory.createLineBorder(Color.black);
        left.setBackground(new Color(255,100,0));
        left.setBorder(blackline2);
        add(left);
        center = new JPanel();
        center.setBounds(210, 150, 633, 400);
        Border blackline3 = BorderFactory.createLineBorder(Color.black);
        center.setBackground(Color.white);
        center.setBorder(blackline3);
        add(center);
        l1 = new JLabel("ROUND");
        l1.setBounds(355, 20, 100, 50);
        l1.setFont(fontlabel);
        l1.setForeground(Color.white);
        labelroundcnt = new JLabel("1");
        labelroundcnt.setBounds(465, 20, 100, 50);
        labelroundcnt.setFont(fontlabel);
        labelroundcnt.setForeground(Color.white);
        up.add(labelroundcnt);
        You = new JLabel("Your Score");
        You.setBounds(50, 50, 100, 30);
        You.setFont(fontuc);
        You.setForeground(Color.white);
        ustar1 = new JLabel("");
        ustar1.setBounds(30, 85, 51, 47);
        up.add(ustar1);
        ustar2 = new JLabel("");
        ustar2.setBounds(100, 85, 51, 47);
        up.add(ustar2);
        ustar3 = new JLabel("");
        ustar3.setBounds(170, 85, 51, 47);
        up.add(ustar3);
        Computer = new JLabel("Computer Score");
        Computer.setBounds(660, 50, 130, 30);
        Computer.setFont(fontuc);
        Computer.setForeground(Color.white);
        cstar1 = new JLabel("");
        cstar1.setBounds(620, 85, 51, 47);
        up.add(cstar1);
        cstar2 = new JLabel("");
        cstar2.setBounds(690, 85, 51, 47);
        up.add(cstar2);
        cstar3 = new JLabel("");
        cstar3.setBounds(760, 85, 51, 47);
        up.add(cstar3);
        userclick = new JLabel("Click Your Choice");
        userclick.setBounds(30, 10, 180, 30);
        userclick.setFont(fontuc);
        userclick.setForeground(Color.white);
        left.add(userclick);
        r = new ImageIcon("stone_leftnew.png");
        p = new ImageIcon("paper_leftnew.png");
        s = new ImageIcon("scissor_leftnew.png");
        rock = new JButton("Rock");
        rock.setBounds(30, 50, 140, 80);
        Border rockborder = BorderFactory.createLineBorder(Color.white);
        rock.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rock.setIcon(r);
        rock.setBackground(Color.white);
        rock.setForeground(Color.black);
        rock.setToolTipText("Rock (R)");
        rock.setBorder(rockborder);
        rock.setFont(fontbutton);
        rock.addActionListener(this);
        rock.addKeyListener(this);
        paper = new JButton("Paper");
        paper.setBounds(30, 150, 140, 80);
        Border paperborder = BorderFactory.createLineBorder(Color.white);
        paper.setCursor(new Cursor(Cursor.HAND_CURSOR));
        paper.setIcon(p);
        paper.setBackground(Color.white);
        paper.setForeground(Color.black);
        paper.setToolTipText("Paper (P)");
        paper.setBorder(paperborder);
        paper.setFont(fontbutton);
        paper.addActionListener(this);
        scissor = new JButton("Scissor");
        scissor.setBounds(30, 250, 140, 80);
        Border scissorborder = BorderFactory.createLineBorder(Color.white);
        scissor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scissor.setIcon(s);
        scissor.setBackground(Color.white);
        scissor.setForeground(Color.black);
        scissor.setToolTipText("Scissor (S)");
        scissor.setBorder(scissorborder);
        scissor.setFont(fontbutton);
        scissor.addActionListener(this);
        left.add(rock);
        left.add(paper);
        left.add(scissor);
        ImageIcon i1 = new ImageIcon("back2.png");
        back = new JButton();
        back.setBounds(20, 345, 70, 40);
        Border backbtn = BorderFactory.createLineBorder(Color.black);
        back.setIcon(i1);
        back.setBorder(backbtn);
        back.setBackground(new Color(255,100,0));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setToolTipText("Back (Backspace)");
        back.addActionListener(this);
        back.addKeyListener(this);
        left.add(back);
        up.add(l1);
        up.add(You);
        up.add(Computer);
        userstar1 = new ImageIcon("s.png");
        ustar1.setIcon(userstar1);
        userstar2 = new ImageIcon("s.png");
        ustar2.setIcon(userstar2);
        userstar3 = new ImageIcon("s.png");
        ustar3.setIcon(userstar3);
        computerstar1 = new ImageIcon("s.png");
        cstar1.setIcon(computerstar1);
        computerstar2 = new ImageIcon("s.png");
        cstar2.setIcon(computerstar2);
        computerstar3 = new ImageIcon("s.png");
        cstar3.setIcon(computerstar3);
        userstar1 = new ImageIcon("starnew1.png");
        userstar2 = new ImageIcon("starnew1.png");
        userstar3 = new ImageIcon("starnew1.png");
        computerstar1 = new ImageIcon("starnew1.png");
        computerstar2 = new ImageIcon("starnew1.png");
        computerstar3 = new ImageIcon("starnew1.png");
        labelforuser = new JLabel("");
        labelforuser.setBounds(250, 250, 252, 216);
        labelforcomputer = new JLabel("");
        labelforcomputer.setBounds(550, 250, 252, 216);
        center.add(labelforuser);
        center.add(labelforcomputer);
        stoneleft = new ImageIcon("stone_left.png");
        stoneright = new ImageIcon("stone_right.png");
        paperleft = new ImageIcon("paper_left.png");
        paperright = new ImageIcon("paper_right.png");
        scissorleft = new ImageIcon("scissor_left.png");
        scissorright = new ImageIcon("scissor_right.png");
        blank1 = new ImageIcon("");
        blank2 = new ImageIcon("");
        setLocation(250, 80);
        setSize(850, 580);
        up.setLayout(null);
        left.setLayout(null);
        center.setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            new ComputerFrame().setVisible(false);
            dispose();
            new HomePage().setVisible(true);
        }
        if (e.getKeyCode() == KeyEvent.VK_R) {
            randomfunction();
            ForRock();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            randomfunction();
            ForPaper();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            randomfunction();
            ForScissor();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        }
    }
    public void keyReleased(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new ComputerFrame().setVisible(false);
            dispose();
            new HomePage().setVisible(true);
        } else if (e.getSource() == rock) {
            randomfunction();
            ForRock();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        } else if (e.getSource() == paper) {
            randomfunction();
            ForPaper();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        } else if (e.getSource() == scissor) {
            randomfunction();
            ForScissor();
            labelforuser.setIcon(blank1);
            labelforcomputer.setIcon(blank2);
            stars();
            score();
        }
    }
    public void randomfunction() {
        rand = new Random();
        number = 3;
        computer = rand.nextInt(number);
    }
    public void ForRock() {
        switch (computer) {
            case 1:
                computercount = computercount + 1;
                labelforuser.setIcon(stoneleft);
                labelforcomputer.setIcon(paperright);
                JOptionPane.showMessageDialog(this, "Computer Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 0:
                labelforuser.setIcon(stoneleft);
                labelforcomputer.setIcon(stoneright);
                JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 2:
                usercount = usercount + 1;
                labelforuser.setIcon(stoneleft);
                labelforcomputer.setIcon(scissorright);
                JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            default:
                break;
        }
        labelroundcnt.setText(Integer.toString(roundcnt));
    }
    public void ForPaper() {
        switch (computer) {
            case 1:
                labelforuser.setIcon(paperleft);
                labelforcomputer.setIcon(paperright);
                JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 0:
                usercount = usercount + 1;
                labelforuser.setIcon(paperleft);
                labelforcomputer.setIcon(stoneright);
                JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 2:
                computercount = computercount + 1;
                labelforuser.setIcon(paperleft);
                labelforcomputer.setIcon(scissorright);
                JOptionPane.showMessageDialog(this, "Computer Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            default:
                break;
        }
        labelroundcnt.setText(Integer.toString(roundcnt));
    }
    public void ForScissor() {
        switch (computer) {
            case 1:
                usercount = usercount + 1;
                labelforuser.setIcon(scissorleft);
                labelforcomputer.setIcon(paperright);
                JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 0:
                computercount = computercount + 1;
                labelforuser.setIcon(scissorleft);
                labelforcomputer.setIcon(stoneright);
                JOptionPane.showMessageDialog(this, "Computer Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            case 2:
                labelforuser.setIcon(scissorleft);
                labelforcomputer.setIcon(scissorright);
                JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                roundcnt = roundcnt + 1;
                break;
            default:
                break;
        }
        labelroundcnt.setText(Integer.toString(roundcnt));
    }
    public void stars() {
        switch (usercount) {
            case 1:
                ustar1.setIcon(userstar1);
                break;
            case 2:
                ustar2.setIcon(userstar2);
                break;
            case 3:
                ustar3.setIcon(userstar3);
                break;
            default:
                break;
        }
        switch (computercount) {
            case 1:
                cstar1.setIcon(computerstar1);
                break;
            case 2:
                cstar2.setIcon(computerstar2);
                break;
            case 3:
                cstar3.setIcon(computerstar3);
                break;
            default:
                break;
        }
    }
    public void score() {
        if (usercount == 3) {
            dispose();
            scoreboard.Scoreboardmethod();
        } else if (computercount == 3) {
            dispose();
            scoreboard.Scoreboardmethod();
        }
    }
    public static void main(String args[]) {
        ComputerFrame cf = new ComputerFrame();
    }
}
