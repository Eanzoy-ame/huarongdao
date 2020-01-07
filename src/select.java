import line.com.xfu.tool.DBHelp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class select extends JFrame implements ActionListener {
    JLabel     lblname=new JLabel("请输入学号：");
    JLabel     lbl1name=new JLabel("请输入E-mail：");
    JTextField txtname=new JTextField(10);
    JTextField txt1name=new JTextField(10);
    JButton    btnfind=new JButton("查询");
    JTable table;    //表格控件
    Vector colname=new Vector();   //动态数组，存放列名
    Vector rowdata=new Vector();   //动态数组，存放每行数据

    //实现单击事件处理方法
    public void actionPerformed(ActionEvent e)
    {
        //获得事件源名字
        Object obj=e.getSource();
        if(obj.equals(btnfind))
        {
            String name=txtname.getText();
            try{
                Connection conn=new DBHelp().getConn();
                String sql="select * from dbo.tbhuarongdao where 学号 like ? and [E-mail] like ?";
                PreparedStatement ps=conn.prepareStatement(sql);
                ps.setString(1,"%"+name+"%");
                ps.setString(2,"%"+name+"%");
                ResultSet rs=ps.executeQuery();
                rowdata.clear();
                while(rs.next()){
                    Vector v=new Vector();
                    v.add(rs.getString("uid"));v.add(rs.getString("密码"));
                    v.add(rs.getString("学号"));v.add(rs.getString("E-mail"));
                    rowdata.add(v);
                }
                rs.close();ps.close();conn.close();
                table.repaint();   //刷新表格
                table.updateUI();
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }

    }

    //构造方法
    select()
    {
        setLayout(new FlowLayout());    //流式布局
        setSize(600,600);
        setLocationRelativeTo(null);
        setTitle("查询");
        setIconImage(new ImageIcon("imgs/welcome.png").getImage());
        add(lblname);lblname.setFont(new Font("微软雅黑", Font.BOLD,12));
        add(txtname);
        add(lbl1name);lbl1name.setFont(new Font("微软雅黑", Font.BOLD,12));
        add(txt1name);
        add(btnfind);btnfind.setFont(new Font("微软雅黑", Font.BOLD,12));
        colname.addElement("uid");colname.addElement("密码");
        colname.addElement("学号");colname.addElement("E-mail");
        table=new JTable(rowdata,colname);
        JScrollPane jsp=new JScrollPane(table);   //table加入滚动面板参数
        add(jsp);
        setVisible(true);
        btnfind.addActionListener(this);
    }

    public static void main(String args[])
    {
         new select();
    }

}

