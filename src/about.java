//    |—————————————————————————————————————————————————————————|
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式!    |
//    |—————————————————————————————————————————————————————————|
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class about extends JFrame implements ActionListener {
	JLabel lbl,lbl1,lbl2,lbl3,lbl4,lbl5,lblimg;
    JPanel jp = new JPanel();

    public about()
	{

        setTitle("关于");
	    setIconImage(new ImageIcon("imgs/welcome.png").getImage());
		setSize(600, 500);
		setLocationRelativeTo(null);
		jp.setLayout(null);
		add(jp);

		lblimg=new JLabel();
		lblimg.setIcon(new ImageIcon("imgs/about1.png"));
        lblimg.setBounds(0,0,600,200);

        lbl=new JLabel("Version:1.1.0");
        lbl.setBounds(40, 110, 400, 50);
        lbl.setFont(new Font("微软雅黑", Font.BOLD,13));

        lbl1=new JLabel("感谢王振辉老师本学期的辛勤指导！");
        lbl1.setBounds(40,160,400,50);
        lbl1.setFont(new Font("微软雅黑", Font.PLAIN,13));

        lbl2=new JLabel("声明：本程序为西安翻译学院2017级软件工程班期末课程设计作品。");
        lbl2.setBounds(40,210,400,50);
        lbl2.setFont(new Font("微软雅黑", Font.PLAIN,13));

        lbl3=new JLabel("仅供学习、交流用途，不具有参考性。请勿用于任何商业用途！");
        lbl3.setBounds(78,250,450,50);
        lbl3.setFont(new Font("微软雅黑", Font.PLAIN,13));

        lbl4=new JLabel("小组成员：张筱筱(17311070146)、田寰(17311070115)、杨瑞敏(17311070113)");
        lbl4.setBounds(40,310,490,50);
        lbl4.setFont(new Font("微软雅黑",Font.PLAIN, 13));

        lbl5=new JLabel("2018.12.24");
        lbl5.setBounds(420,360,400,50);
        lbl5.setFont(new Font("微软雅黑",Font.BOLD, 13));

        jp.add(lbl);jp.add(lbl1);jp.add(lbl2);
        jp.add(lbl3);jp.add(lbl4);jp.add(lblimg);jp.add(lbl5);
		setVisible(true);
        setResizable(false);

	}

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String args[]) {
        new about();

    }
}

