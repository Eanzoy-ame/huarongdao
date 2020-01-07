//    |—————————————————————————————————————————————————————————|
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式！   |
//    |—————————————————————————————————————————————————————————|
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;

import line.com.xfu.tool.DBHelp;

public class Register extends javax.swing.JFrame
	implements java.awt.event.ActionListener
{

	private static final int E = 0;
	private javax.swing.JPanel jp;
	private javax.swing.JLabel lb7;
	private javax.swing.JLabel lb5;
	private javax.swing.JLabel lb1;
	private javax.swing.JLabel lb2;
	private javax.swing.JLabel lb3;
	private javax.swing.JLabel lb4;
	private javax.swing.JLabel lb6;
	private javax.swing.ImageIcon img;
	private javax.swing.JTextField jtf1;
	private javax.swing.JPasswordField jtf2;
	private javax.swing.JTextField jtf3;
	private javax.swing.JTextField jtf4;
	private javax.swing.JButton jb1;
	private javax.swing.JButton jb2;

	public Register()
	{
		JLabel lblimg;
		jp = new JPanel();
		lb1 = new JLabel("uid：");
        lb2 = new JLabel("密 码：");
        lb3 = new JLabel("学 号：");
        lb4 = new JLabel("E-mail：");
		lb5 = new JLabel("用户注册");
		lb6 = new JLabel();
		lb7 = new JLabel();
		img = new ImageIcon("imgs/welcome.png");
		jtf1 = new JTextField();
		jtf2 = new JPasswordField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jb1 = new JButton("确认");
		jb1.setFont(new Font("微软雅黑", Font.BOLD,12));
		jb2 = new JButton("取消");
		jb2.setFont(new Font("微软雅黑", Font.BOLD,12));
		jp.setLayout(null);
		add(jp);
		lb1.setFont(new Font("微软雅黑", Font.BOLD,15));
        lb2.setFont(new Font("微软雅黑", Font.BOLD,15));
        lb3.setFont(new Font("微软雅黑", Font.BOLD,15));
        lb4.setFont(new Font("微软雅黑", Font.BOLD,15));
        lb5.setFont(new Font("宋体", Font.BOLD,20));
        lb1.setBounds(95, 120, 50, 25);
        lb2.setBounds(90, 170, 50, 25);
        lb3.setBounds(90, 220, 50, 25);
        lb4.setBounds(80, 270, 65, 25);
		lb5.setBounds(140, 50, 130, 30);
		lb6.setBounds(70, 390, 280, 25);
		lb7.setBounds(20, 40, 64, 64);
        lb7.setIcon(new ImageIcon("Image/welcome.png"));
		jp.add(lb5);
		jp.add(lb1);
		jp.add(lb2);
		jp.add(lb3);
		jp.add(lb4);
		jp.add(lb6);
		jp.add(lb7);
		jtf1.setBounds(140, 120, 125, 20);
		jtf2.setBounds(140, 170, 125, 20);
		jtf3.setBounds(140, 220, 125, 20);
		jtf4.setBounds(140, 270, 125, 20);
		jp.add(jtf1);
		jp.add(jtf2);
		jp.add(jtf3);
		jp.add(jtf4);
		jb1.setBounds(100, 340, 60, 30);
		jb2.setBounds(200, 340, 60, 30);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		jp.add(jb1);
		jp.add(jb2);
		lblimg=new JLabel();
		lblimg.setIcon(new ImageIcon("imgs/about1.png"));
		lblimg.setBounds(0,0,600,200);
		jp.add(lblimg);
		setTitle("用户注册");
		setVisible(true);
		setSize(380, 460);
		setLocationRelativeTo(null);
		setResizable(false);
		setIconImage(new ImageIcon("imgs/welcome.png").getImage());
	}
    public boolean checkXH(String uid){
    	try{
    		Connection conn=new DBHelp().getConn();
    		String sql="select * from tbhuarongdao where uid=?";
    		PreparedStatement ps=conn.prepareStatement(sql);
	  		ps.setString(1,uid);
	  		ResultSet rs=ps.executeQuery();
	  		if(rs.next()){
	  		  return true;		
	  		}
	  		rs.close();ps.close();conn.close();
    	}
    	catch(Exception ex){
    	    System.out.println(ex);
    	}
		return false;
    }
	public void actionPerformed(java.awt.event.ActionEvent e)
	{
		Object obj=e.getSource();
		if(obj==jb1) {
			new mk();
			dispose();
		}
		else {
			dispose();
		}
		
	  	if(obj==jb1){//注册
	  	  //1.检查数据是否填全
	  	  String uid=jtf1.getText();String password=jtf2.getText();
	  	  String email=jtf3.getText(); String xh=jtf4.getText();
	  	  if(uid.equals("") || password.equals("") || xh.equals("") || email.equals("")){
	  		JOptionPane.showMessageDialog(null,"请检查数据是否填完整！");	  
	  	  }
	  	  else{
	  	     //2.账号是不是已经存在
	  	     if(checkXH(xh)){JOptionPane.showMessageDialog(null,"该uid已存在！");}
	  	     else{
	  	    	//3.保存操作	
	  	    	try{
	  	    		Connection conn=new DBHelp().getConn();
	  	    		String sql="insert into dbo.tbhuarongdao values(?,?,?,?)";
	  	    		PreparedStatement ps=conn.prepareStatement(sql);
					ps.setString(1,uid);
					ps.setString(2,password);
					ps.setString(3,email);
					ps.setString(4,xh);
	  		  		int i=ps.executeUpdate();
	  		  		if(i==1){
	  		  		  JOptionPane.showMessageDialog(null,"该用户注册成功！");	  		
	  		  		}
	  		  		else{JOptionPane.showMessageDialog(null,"该用户注册失败！");	 }
	  		  		ps.close();conn.close();
	  	    	}
	  	    	catch(Exception ex){
	  	    		System.out.println(ex);
	  	    	}
	  	     }
	  	  }   
	  	}
	  	else{
	  		
	  	}
	}
	public static void main(String[] args) {
	  new Register();
	}
}
