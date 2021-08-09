
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.*;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JTextField;
public class anotherfriendframe extends JFrame implements ActionListener, KeyListener {
    static JButton back, rock, paper, scissor, playbutton;
    static JPanel p1, up, left, center;
    static JLabel l1, You, opponent, userclick, labelroundcnt, waitinglabel;
    static JLabel ustar1, ustar2, ustar3, ostar1, ostar2, ostar3, labelforuser, labelforopponent;
    static ImageIcon stoneleft, stoneright, paperleft, paperright, scissorleft, scissorright, blank1, blank2;
    static ImageIcon userstar1, userstar2, userstar3, opponentstar1, opponentstar2, opponentstar3, r, p, s;
    static Random rand;
    static int number;
    static int computer, user;
    static int usercount = 0, computercount = 0, roundcnt = 1;
    static int tie;
    static String str1;
    static Socket socket;
    static DataInputStream din;
    static DataOutputStream dout;
    public static JTextField t1;
    static String value = "pass";
    static int port = 4005;
    anotherfriendframe() {
        setTitle("Play with Another Friend");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icongame.png")));
        Font fontlabel = new Font("Century", Font.BOLD, 24);
        Font fontuc = new Font("Century", Font.PLAIN, 17);
        Font fontbutton = new Font("Century", Font.PLAIN, 16);
        p1 = new JPanel();
        p1.setBounds(0, 0, 850, 580);
        Border blackforpanel = BorderFactory.createLineBorder(Color.black);
        p1.setBackground(new Color(255,100,0));
        p1.setBorder(blackforpanel);
        add(p1);
        up = new JPanel();
        up.setBounds(0, 0, 850, 150);
        Border blackline1 = BorderFactory.createLineBorder(Color.black);
        up.setBounds(0, 0, 850, 150);
        up.setBackground(new Color(255,100,0));
        up.setBorder(blackline1);
        p1.add(up);
        left = new JPanel();
        left.setBounds(0, 150, 210, 345);
        Border blackline2 = BorderFactory.createLineBorder(Color.black);
        left.setBackground(new Color(255,100,0));
        left.setBorder(blackline2);
        p1.add(left);
        center = new JPanel();
        center.setBounds(210, 150, 633, 400);
        Border blackline3 = BorderFactory.createLineBorder(Color.black);
        center.setBackground(Color.white);
        center.setBorder(blackline3);
        p1.add(center);
        Font ft = new Font("Centuary", Font.PLAIN, 30);
        waitinglabel = new JLabel("Waiting for an opponent connection...");
        waitinglabel.setBounds(80, 80, 500, 50);
        waitinglabel.setFont(ft);
        waitinglabel.setForeground(Color.white);
        p1.add(waitinglabel);
        l1 = new JLabel("ROUND");
        l1.setBounds(355, 20, 100, 50);
        l1.setFont(fontlabel);
        l1.setForeground(Color.white);
        labelroundcnt = new JLabel("1");
        labelroundcnt.setBounds(465, 20, 100, 50);
        labelroundcnt.setFont(fontlabel);
        labelroundcnt.setForeground(Color.white);
        up.add(labelroundcnt);
        t1 = new JTextField();
        t1.setBounds(20, 30, 80, 20);
        t1.setVisible(false);
        up.add(t1);
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
        opponent = new JLabel("Opponent's Score");
        opponent.setBounds(650, 50, 150, 30);
        opponent.setFont(fontuc);
        opponent.setForeground(Color.white);
        ostar1 = new JLabel("");
        ostar1.setBounds(620, 85, 51, 47);
        up.add(ostar1);
        ostar2 = new JLabel("");
        ostar2.setBounds(690, 85, 51, 47);
        up.add(ostar2);
        ostar3 = new JLabel("");
        ostar3.setBounds(760, 85, 51, 47);
        up.add(ostar3);
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
        paper.addKeyListener(this);
        scissor = new JButton("Scissor");
        scissor.setBounds(30, 250, 140, 80);
        Border scissorborder = BorderFactory.createLineBorder(Color.white);
        scissor.setCursor(new Cursor(Cursor.HAND_CURSOR));
        scissor.setIcon(s);
        scissor.setBackground(Color.white);
        scissor.setForeground(Color.black);
        scissor.setBorder(scissorborder);
        scissor.setToolTipText("Scissor (S)");
        scissor.setFont(fontbutton);
        scissor.addActionListener(this);
        scissor.addKeyListener(this);
        left.add(rock);
        left.add(paper);
        left.add(scissor);
        ImageIcon i1 = new ImageIcon("back2.png");
        back = new JButton();
        back.setBounds(10, 502, 70, 40);
        Border backbtn = BorderFactory.createLineBorder(Color.black);
        back.setIcon(i1);
        back.setBorder(backbtn);
        back.setBackground(new Color(255,100,0));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.setToolTipText("Back (Backspace)");
        back.addActionListener(this);
        ImageIcon i2 = new ImageIcon("play.png");
        playbutton = new JButton("Play");
        playbutton.setBounds(110, 502, 90, 40);
        playbutton.setBorder(backbtn);
        playbutton.setBackground(Color.white);
        playbutton.setForeground(Color.black);
        playbutton.setIcon(i2);
        playbutton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        playbutton.setFont(fontbutton);
        playbutton.setToolTipText("Play (ENTER)");
        p1.add(playbutton);
        playbutton.addActionListener(this);
        playbutton.setEnabled(false);
        up.add(l1);
        up.add(You);
        up.add(opponent);
        userstar1 = new ImageIcon("s.png");
        ustar1.setIcon(userstar1);
        userstar2 = new ImageIcon("s.png");
        ustar2.setIcon(userstar2);
        userstar3 = new ImageIcon("s.png");
        ustar3.setIcon(userstar3);
        opponentstar1 = new ImageIcon("s.png");
        ostar1.setIcon(opponentstar1);
        opponentstar2 = new ImageIcon("s.png");
        ostar2.setIcon(opponentstar2);
        opponentstar3 = new ImageIcon("s.png");
        ostar3.setIcon(opponentstar3);
        userstar1 = new ImageIcon("starnew1.png");
        userstar2 = new ImageIcon("starnew1.png");
        userstar3 = new ImageIcon("starnew1.png");
        opponentstar1 = new ImageIcon("starnew1.png");
        opponentstar2 = new ImageIcon("starnew1.png");
        opponentstar3 = new ImageIcon("starnew1.png");
        labelforuser = new JLabel("");
        labelforuser.setBounds(50, 80, 252, 216);
        labelforopponent = new JLabel("");
        labelforopponent.setBounds(350, 80, 252, 216);
        center.add(labelforuser);
        center.add(labelforopponent);
        stoneleft = new ImageIcon("stone_left.png");
        stoneright = new ImageIcon("stone_right.png");
        paperleft = new ImageIcon("paper_left.png");
        paperright = new ImageIcon("paper_right.png");
        scissorleft = new ImageIcon("scissor_left.png");
        scissorright = new ImageIcon("scissor_right.png");
        blank1 = new ImageIcon("");
        blank2 = new ImageIcon("");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(250, 80);
        setSize(850, 580);
        p1.setLayout(null);
        up.setLayout(null);
        left.setLayout(null);
        center.setLayout(null);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            new anotherfriendframe().setVisible(false);
            dispose();
            new HomePage().setVisible(true);
        } else if (e.getSource() == rock) {
            labelforuser.setIcon(stoneleft);
            t1.setText("0");
            playbutton.setEnabled(true);
        } else if (e.getSource() == paper) {
            labelforuser.setIcon(paperleft);
            t1.setText("1");
            playbutton.setEnabled(true);
        } else if (e.getSource() == scissor) {
            labelforuser.setIcon(scissorleft);
            t1.setText("2");
            playbutton.setEnabled(true);
        } else if (e.getSource() == playbutton) {
            try {
                mainlogic();
                playbutton.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void mainlogic() throws IOException {
        if (value == "failed") {
            socket.close();
            din.close();
        } else {
            try {
                String doutmsg = t1.getText();
                dout.writeUTF(doutmsg);
                dout.flush();
                str1 = din.readUTF();
                // user choice 0 means Stone
                if ("0".equals(t1.getText()) && "0".equals(str1)) {
                    labelforopponent.setIcon(stoneright);
                    JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("0".equals(t1.getText()) && "1".equals(str1)) {
                    computercount = computercount + 1;
                    labelforopponent.setIcon(paperright);
                    JOptionPane.showMessageDialog(this, "You Lose!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("0".equals(t1.getText()) && "2".equals(str1)) {
                    usercount = usercount + 1;
                    labelforopponent.setIcon(scissorright);
                    JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } // user choice 1 means Paper
                else if ("1".equals(t1.getText()) && "0".equals(str1)) {
                    usercount = usercount + 1;
                    labelforopponent.setIcon(stoneright);
                    JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("1".equals(t1.getText()) && "1".equals(str1)) {
                    labelforopponent.setIcon(paperright);
                    JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("1".equals(t1.getText()) && "2".equals(str1)) {
                    computercount = computercount + 1;
                    labelforopponent.setIcon(scissorright);
                    JOptionPane.showMessageDialog(this, "You Lose!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } // user choice 2 means Paper
                else if ("2".equals(t1.getText()) && "0".equals(str1)) {
                    computercount = computercount + 1;
                    labelforopponent.setIcon(stoneright);
                    JOptionPane.showMessageDialog(this, "You Lose!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("2".equals(t1.getText()) && "1".equals(str1)) {
                    usercount = usercount + 1;
                    labelforopponent.setIcon(paperright);
                    JOptionPane.showMessageDialog(this, "You Win!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                } else if ("2".equals(t1.getText()) && "2".equals(str1)) {
                    labelforopponent.setIcon(scissorright);
                    JOptionPane.showMessageDialog(this, "Tie!", "Rock Paper Scissor", JOptionPane.INFORMATION_MESSAGE);
                    roundcnt = roundcnt + 1;
                }
            } catch (IOException e1) {
                System.err.println("error");
            }
            labelforuser.setIcon(blank1);
            labelforopponent.setIcon(blank2);
            labelroundcnt.setText(Integer.toString(roundcnt));
            stars();
            countstars();
        }
    }
    public void stars() throws IOException {
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
                ostar1.setIcon(opponentstar1);
                break;
            case 2:
                ostar2.setIcon(opponentstar2);
                break;
            case 3:
                ostar3.setIcon(opponentstar3);
                break;
            default:
                break;
        }
    }
    public void countstars() throws IOException {
        if (usercount == 3) {
            value = "failed";
            this.dispose();
            userdialog();
        } else if (computercount == 3) {
            value = "failed";
            this.dispose();
            userdialog();
        }
    }
    public void keyPressed(KeyEvent e1) {
        if (e1.getKeyCode() == KeyEvent.VK_R) {
            labelforuser.setIcon(stoneleft);
            t1.setText("0");
            playbutton.setEnabled(true);
        } else if (e1.getKeyCode() == KeyEvent.VK_P) {
            labelforuser.setIcon(paperleft);
            t1.setText("1");
            playbutton.setEnabled(true);
        } else if (e1.getKeyCode() == KeyEvent.VK_S) {
            labelforuser.setIcon(scissorleft);
            t1.setText("2");
            playbutton.setEnabled(true);
        } else if (e1.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                mainlogic();
                playbutton.setEnabled(false);
            } catch (IOException ex) {
                Logger.getLogger(ServerFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e1.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            new ServerFrame().setVisible(false);
            dispose();
            new HomePage().setVisible(true);
        }
    }
    public void keyReleased(KeyEvent e1) {   
    }
    public void keyTyped(KeyEvent e1) {
    }
    public void userdialog() {
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
        playagain.setToolTipText("Press Enter key or Click to Play again...");
        JLabel homepage = new JLabel("HOMEPAGE");
        homepage.setBounds(330, 450, 200, 50);
        homepage.setForeground(Color.white);
        homepage.setCursor(new Cursor(Cursor.HAND_CURSOR));
        homepage.setFont(fontbtn);
        if (usercount == 3) {
            youwin.setText("You Win...");
        } else {
            cmwin.setText("Opponent Win...");
        }
        userscore.setText(Integer.toString(usercount));
        computerscore.setText(Integer.toString(computercount));
        MouseListener m1 = new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                d.setVisible(false);
                d.dispose();
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
                new anotherfriendframe().setVisible(true);
            }
        };
        playagain.addActionListener(al);
        KeyListener kl = new KeyListener() {
            public void keyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    d.setVisible(false);
                    d.dispose();
                    new anotherfriendframe().setVisible(true);
                }
            }
            public void keyReleased(KeyEvent evt) {
            }
            public void keyTyped(KeyEvent evt) {
            }
        };
        playagain.addKeyListener(kl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p2.setLayout(null);
        d.setLocation(250, 80);
        d.setSize(850, 580);
        d.setResizable(false);
        d.setVisible(true);
    }
    public void clientmethod() {
        try {
            socket = new Socket("localhost", port);
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());

        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public static void main(String args[]) {
        anotherfriendframe a1 = new anotherfriendframe();
        a1.clientmethod();
    }
}
