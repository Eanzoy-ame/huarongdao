//    |—————————————————————————————————————————————————————————|
//    |                                                         |
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式！   |
//    |                                                         |
//    |—————————————————————————————————————————————————————————|
import line.com.xfu.tool.DBHelp;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.font.TextAttribute;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mk extends JFrame{

    JLabel lblimg = new JLabel();
    JLabel lbluid=new JLabel("uid:");
    JLabel lblpwd=new JLabel("password:");
    JButton lbl1=new JButton("注册账号");
    JButton lbl2=new JButton("忘记密码");
    JTextField txtuid=new JTextField();
    JPasswordField txtpwd=new JPasswordField();
    JButton btnok=new JButton("YES");
    JButton btnexit=new JButton("CANCEL");
    JMenuBar mainmenu=new JMenuBar();
    JMenu menufind= new JMenu("查看V");
    JMenu menuedit= new JMenu("编辑E");
    JMenu menuhelp= new JMenu("帮助H");
    JMenuItem item1=new JMenuItem("一");
    JMenuItem item2=new JMenuItem("二");
    JMenuItem item3=new JMenuItem("三");
    JMenuItem item4=new JMenuItem("复制 C");
    JMenuItem item5=new JMenuItem("粘贴 P");
    JMenuItem item6=new JMenuItem("帮助主题");
    JMenuItem item7=new JMenuItem("关于...");
    JCheckBox b1=new JCheckBox("记住密码");
    JCheckBox b2=new JCheckBox("自动登录");

    void drawmenu(){
        b1.setBounds(480,230,80,30);
        b2.setBounds(580,230,80,30);
        b1.setFont(new Font("微软雅黑", Font.BOLD,12));b2.setFont(new Font("微软雅黑", Font.BOLD,12));
        add(b1);add(b2);setResizable(false);
        menufind.setMnemonic('V');
        menufind.add(item1);menufind.addSeparator();menufind.add(item2);menufind.addSeparator();menufind.add(item3);
        menuedit.setMnemonic('E');
        menuedit.add(item4);menuedit.addSeparator();menuedit.add(item5);
        menuhelp.setMnemonic('H');
        menuhelp.add(item6);menuhelp.addSeparator();menuhelp.add(item7);
        mainmenu.add(menufind);mainmenu.add(menuedit);mainmenu.add(menuhelp);
        setJMenuBar(mainmenu);
        setIconImage(new ImageIcon("imgs/welcome.png").getImage());
    }

    mk(){
        setTitle("登录");
        setSize(780,440);
        setLocationRelativeTo(null);
        setLayout(null);
        drawmenu();

        lblimg.setIcon(new ImageIcon("imgs/link1.gif"));
        lblimg.setBounds(0,0,400,400);
        lbluid.setBounds(420,90,50,30);
        lblpwd.setBounds(420,170,65,30);
        lbl1.setBounds(630,95,90,20);lbl1.setFont(new Font("微软雅黑", Font.BOLD,12));
        lbl1.setForeground(new Color(37, 105, 255));
        lbl1.setText("<html><a href=''>注册帐号</a></html>");
        lbl2.setBounds(630,175,90,20);lbl2.setFont(new Font("微软雅黑", Font.BOLD,12));
        lbl2.setForeground(new Color(37, 105, 255));
        lbl2.setText("<html><a href=''>忘记密码</a></html>");
        lbl1.setBorderPainted(false);lbl2.setBorderPainted(false);
        lbl1.setContentAreaFilled(false);lbl2.setContentAreaFilled(false);
        lbl1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));lbl2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        add(lblimg);add(lbl1);
        add(lbluid);add(lblpwd);add(lbl2);
        txtuid.setBounds(490,90,150,30); add(txtuid);
        txtpwd.setBounds(490,170,150,30); add(txtpwd);
        btnok.setBounds(480,290,60,30); add(btnok);
        btnexit.setBounds(580,290,85,30); add(btnexit);
        setVisible(true);

        btnok.addActionListener(new MyClick());
        btnexit.addActionListener(new MyClick());
        lbl1.addActionListener(new MyClick());
        addWindowListener(new Mywin());
        item7.addActionListener(new MyClick());
        lbl2.addActionListener(new MyClick());


    }

    public static void main(String[] args) {
        new mk();
    }

    class MyClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object obj =e.getSource();

            if (obj == btnok) {
                //登陆验证
                //String uid=txtuid.getText();
                //String pwd=txtpwd.getText();
                //和正确的账号密码比较
                //if(uid.equals("admin")&&pwd.equals("123456")){
                //   frame.dispose();
                //   new huarong();
                //}
                try {
                    //1获得用户输入
                    String xh = txtuid.getText();
                    String xm = txtpwd.getText();
                    //2获得数据库连接
                    Connection conn = new DBHelp().getConn();
                    //3执行SQL
                    String sql = "select * from tbhuarongdao where uid=? and 密码=?";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, xh);
                    ps.setString(2, xm);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        //打开主界面
                        new huarong();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "uid或密码错误，请重新填写！", "提示", JOptionPane.ERROR_MESSAGE);
                        txtuid.setText("");
                        txtpwd.setText("");
                        txtuid.requestFocus();
                    }
                }
                catch (Exception ex) {
                    System.out.print(ex);
                }
                //else if (obj==lbl1){ }
            }
            else if(obj==item7){    //关于
                new about();
            }
            else if(obj==lbl1){    //注册
                new Register();
            }
            else if(obj==lbl2){    //查询密码
                new select();
            }
            else {
                dispose();
                System.exit(0);   //关闭
            }
        }
    }
    class Mywin implements WindowListener{

        @Override
        public void windowOpened(WindowEvent e) {

        }

        @Override
        public void windowClosing(WindowEvent e) {
                //关闭窗口,终止应用
                dispose(); System.exit(0);
            }


        @Override
        public void windowClosed(WindowEvent e) {

        }

        @Override
        public void windowIconified(WindowEvent e) {

        }

        @Override
        public void windowDeiconified(WindowEvent e) {

        }

        @Override
        public void windowActivated(WindowEvent e) {

        }

        @Override
        public void windowDeactivated(WindowEvent e) {

        }
    }
}

