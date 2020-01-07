//    |—————————————————————————————————————————————————————————|
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式！   |
//    |—————————————————————————————————————————————————————————|
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class huarong extends JFrame implements MouseListener, KeyListener, ActionListener {

    private static final int ERROR_MESSAGE = 0;
    private static final int WARNING_MESSAGE = 0;
    int rod=0;

    Person person[]=new Person[10];
    //JLabel lblimg=new JLabel();
    JButton left,right,above,below;    //按钮绘为边界
    JButton restart=new JButton("重新开始");
    JButton about=new JButton("游戏简介");
    JButton help=new JButton("游戏帮助");
    JButton mouse=new JButton("鼠标操作");
    JButton key=new JButton("键盘操作");
    JButton message=new JButton("当前步数："+rod);
    JButton begin=new JButton("开始游戏");
    JButton star=new JButton();
    String name[]={"blue","red1","red2","red3","red4","red5","yel1","yel2","yel3","yel4"};

    public huarong(){
        //窗口
        JOptionPane.showMessageDialog(this, "开始游戏前，请先阅读下方的游戏帮助！");
        init();
        setBounds(200,200,640,800);
        setTitle("华容道");
        addWindowListener(new MyWin());
        setVisible(true);
        validate();
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setIconImage(new ImageIcon("imgs/welcome.png").getImage());
    }

    public void init(){

        setLayout(null);   //坐标布局
        message.setBackground(Color.ORANGE);
        add(restart);
        //设置按钮
        restart.setBounds(120, 650, 100, 40);
        restart.setFont(new Font("微软雅黑", Font.BOLD,12));
        restart.addActionListener(this);
        add(about);
        about.addActionListener(this);
        about.setBounds(250,650,100,40);
        about.setFont(new Font("微软雅黑", Font.BOLD,12));
        add(mouse);
        mouse.setBounds(280,40,100,40);
        mouse.setFont(new Font("微软雅黑", Font.BOLD,12));
        mouse.addActionListener(this);
        add(key);
        key.setBounds(400, 40, 100, 40);
        key.setFont(new Font("微软雅黑", Font.BOLD,12));
        key.addActionListener(this);
        add(help);
        help.setBounds(380, 650, 100, 40);
        help.setFont(new Font("微软雅黑", Font.BOLD,12));
        help.addActionListener(this);
        add(message);
        message.setBounds(110,40,160,40);
        message.setFont(new Font("微软雅黑", Font.BOLD,12));
        //ImageIcon starr=new ImageIcon("imgs/link.jpg");
        add(star);
        //star.setIcon(starr);
        star.setBounds(108,208,400,400);
        star.setBackground(Color.white);
        add(begin);
        begin.addActionListener(this);
        begin.setBounds(250,140,100,40);
        begin.setFont(new Font("微软雅黑", Font.BOLD,12));
        setVisible(true);
        left=new JButton();
        right=new JButton();
        above=new JButton();
        below=new JButton();
        add(left);
        add(right);
        add(above);
        add(below);
        //边界类
        left.setBounds(98, 98, 10, 520);
        right.setBounds(508,98,10,520);
        above.setBounds(98, 98, 420, 10);
        below.setBounds(98, 608, 420, 10);
        //去掉按钮边框
        left.setBorderPainted(false);right.setBorderPainted(false);
        above.setBorderPainted(false);below.setBorderPainted(false);
        validate();
    }

    //游戏布局
    public	void map()

    {
        for(int k=0;k<name.length;k++)
        {
            person[k]=new Person(k,name[k]);
            add(person[k]);
        }

        person[0].setBounds(208,108,200,200);
        ImageIcon blue=new ImageIcon("imgs/timg1.png");
        person[0].setIcon(blue);
        person[1].setBounds(208,308,200,100);
        ImageIcon red1=new ImageIcon("imgs/timg3.png");
        person[1].setIcon(red1);
        person[2].setBounds(108,308,100,200);
        ImageIcon red2=new ImageIcon("imgs/timg3.png");
        person[2].setIcon(red2);
        person[3].setBounds(408,308,100,200);
        ImageIcon red3=new ImageIcon("imgs/timg3.png");
        person[3].setIcon(red3);
        person[4].setBounds(108,108,100,200);
        ImageIcon red4=new ImageIcon("imgs/timg3.png");
        person[4].setIcon(red4);
        person[5].setBounds(408,108,100,200);
        ImageIcon red5=new ImageIcon("imgs/timg3.png");
        person[5].setIcon(red5);
        person[6].setBounds(108,508,100,100);
        ImageIcon yel1=new ImageIcon("imgs/timg2.png");
        person[6].setIcon(yel1);
        person[7].setBounds(408,508,100,100);
        ImageIcon yel2=new ImageIcon("imgs/timg2.png");
        person[7].setIcon(yel2);
        person[8].setBounds(208,408,100,100);
        ImageIcon yel3=new ImageIcon("imgs/timg2.png");
        person[8].setIcon(yel3);
        person[9].setBounds(308,408,100,100);
        ImageIcon yel4=new ImageIcon("imgs/timg2.png");
        person[9].setIcon(yel4);

    }

    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    public void keyPressed(KeyEvent e){  //键盘操作

        Person man=(Person)e.getSource();
        if(e.getKeyCode()==KeyEvent.VK_UP)  //上
            gok(man,above);
        if(e.getKeyCode()==KeyEvent.VK_DOWN)  //下
            gok(man,below);
        if(e.getKeyCode()==KeyEvent.VK_LEFT)  //左
            gok(man,left);
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)  //右
            gok(man,right);
    }

    //键盘模式下的移动
    public void gok(Person man,JButton direction){

        rod++;
        message.setText("当前步数："+rod);
        boolean move=true;  //可以移动
        Rectangle manRect=man.getBounds();
        int x=man.getBounds().x;
        int y=man.getBounds().y;
        if(direction==below)
            y=y+100;
        else if(direction==above)
            y=y-100;
        else if(direction==left)
            x=x-100;
        else if(direction==right)
            x=x+100;
        manRect.setLocation(x,y);
        Rectangle directionRect=direction.getBounds();
        for(int k=0;k<10;k++){
            Rectangle personRect=person[k].getBounds();
            if((manRect.intersects(personRect))&&(man.number!=k)){
                //intersects为矩形类的一个方法，可以判断是否相交
                for(Person man2:person){  //遍历数组
                    if(goc(man2,direction)==true){
                        return;
                    }
                }
                move=false;
            }
        }
        if(manRect.intersects(directionRect)){
            for(Person man2:person){
                if(goc(man2,direction)==true){
                    return;
                }
            }
            move=false;
        }
        if(move==true)
        {
            man.setLocation(x,y);
        }
        int bx,by;  //蓝色的位置
        bx=person[0].getBounds().x;
        by=person[0].getBounds().y;
        if(bx==208&&by==208)  //为了快速结束游戏，数字可设为208
        {
            win();
            return;

        }
    }

    public void win()

    {
        JOptionPane.showMessageDialog(this, "恭喜你，成功逃脱！\n"+"操作"+rod+"步！");
        JButton winn=new JButton();
        ImageIcon winner=new ImageIcon("timg1.png");
        winn.setIcon(winner);
        winn.setBounds(108,108,400,500);
        add(winn);
        setVisible(true);
        for(int k=0;k<name.length;k++)
            this.remove(person[k]);
    }

    //判断是否可以进行移动
    public boolean goc(Person man,JButton direction){
        boolean move=true;  //可以移动
        Rectangle manRect=man.getBounds();
        int x=man.getBounds().x;
        int y=man.getBounds().y;
        if(direction==below)
            y=y+100;
        else if(direction==above)
            y=y-100;
        else if(direction==left)
            x=x-100;
        else if(direction==right)
            x=x+100;
        manRect.setLocation(x,y);
        Rectangle directionRect=direction.getBounds();
        for(int k=0;k<10;k++){
            Rectangle personRect=person[k].getBounds();
            if((manRect.intersects(personRect))&&(man.number!=k))
                move=false;
        }
        if(manRect.intersects(directionRect))
            move=false;

        if(move==true)
            man.setLocation(x,y);

        return move;
    }

    public void gom(Person man,JButton direction){

        rod++;
        message.setText("当前步数："+rod);
        boolean move=true;  //可以移动
        Rectangle manRect=man.getBounds();
        int x=man.getBounds().x;
        int y=man.getBounds().y;
        if(direction==below)
            y=y+100;
        else if(direction==above)
            y=y-100;
        else if(direction==left)
            x=x-100;
        else if(direction==right)
            x=x+100;
        manRect.setLocation(x,y);
        Rectangle directionRect=direction.getBounds();
        for(int k=0;k<10;k++){
            Rectangle personRect=person[k].getBounds();
            if((manRect.intersects(personRect))&&(man.number!=k))
                move=false;
        }
        if(manRect.intersects(directionRect))
            move=false;
        if(move==true)
            man.setLocation(x,y);
        int bx,by;  //蓝色的位置
        bx=person[0].getBounds().x;
        by=person[0].getBounds().y;
        if(bx==208&&by==208)  //为了快速结束游戏，数字可设为208
        {
            win();
            return;
        }
    }

    @Override
    //重新开始新一局
    public void actionPerformed(ActionEvent e) {
        JButton b=(JButton)e.getSource();
        if(b==restart)
        {
            dispose();
            new huarong();
        }
        if(b==about)
        {
            JOptionPane.showMessageDialog(this, "华容道是古老的中国民间益智游戏，以其变化多端、百玩不厌的特点与魔方、\n"
                    +"独立钻石棋一起被国外智力专家并称为“智力游戏界的三个不可思议”。\n"+
                    "它与七巧板、九连环等中国传统益智玩具还有个代名词叫作“中国的难题”。\n"+
                    "据《资治通鉴》注释中说“从此道可至华容也”。\n"+"华容道原是中国古代的一个地名，相传当年曹操曾经败走此地。\n");
        }
        if(b==help)
        {
            JOptionPane.showMessageDialog(this, "胜利条件：蓝色方块到达地图中下方位置！\n"
                    + "    --点击开始游戏后，请先在上方选择操作方式！--\n\n"
                    + "键盘操作：使用小键盘的上下左右方向键控制方块的移动。\n"
                    + "精确操作：键盘操作模式下，先用鼠标点击某个方块，然后使用方向键进行移动。\n"
                    + "鼠标操作：玩家通过点击当前方块的不同位置进行相应移动。\n\n"
                    + "注意：不能往左下，右下，左上，右上进行移动。\n"
                    + "操作方式选择完毕后游戏中途尽量不要更换。", "游戏帮助",JOptionPane.QUESTION_MESSAGE);
        }
        if(b==key)
        {
            b.setBackground(Color.green);
            for(int k=0;k<name.length;k++)
            {
                person[k].addKeyListener(this);
            }
            person[9].requestFocus();  //获取焦点
        }
        if(b==mouse)
        {
            b.setBackground(Color.yellow);
            for(int k=0;k<name.length;k++)
                person[k].addMouseListener(this);
        }
        if(b==begin)
        {
            b.setBackground(Color.yellow);
            this.remove(begin);
            this.remove(star);
            map();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mousePressed(MouseEvent e) {
        Person man=(Person)e.getSource();
        int x=-1,y=-1;
        x=e.getX();
        y=e.getY();
        int w=man.getBounds().width;
        int h=man.getBounds().height;
        if(y<h/2&&x>w/3&&x<(w*2)/3)
        {
            gom(man,above);  //上
        }
        if(y>h/2&&x>w/3&&x<(w*2)/3)
        {
            gom(man,below);  //下
        }
        if(x<w/2&&y>h/3&&y<(h*2)/3)
        {
            gom(man,left);  //左
        }
        if(x>w/2&&y>h/3&&y<(h*2)/3)
        {
            gom(man,right);  //右
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    class MyWin implements WindowListener{

        @Override
        public void windowActivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosed(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowClosing(WindowEvent arg0) {
            // TODO Auto-generated method stub
            int i=JOptionPane.showConfirmDialog(null, "是否退出游戏？", "退出", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(i==JOptionPane.YES_OPTION){
                //关闭窗口,终止应用
                dispose(); System.exit(0);
            }

        }

        @Override
        public void windowDeactivated(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowDeiconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowIconified(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void windowOpened(WindowEvent arg0) {
            // TODO Auto-generated method stub

        }

    }

    public static void main(String[] args) {
        new huarong();
    }
}

