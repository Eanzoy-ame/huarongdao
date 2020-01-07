//    |—————————————————————————————————————————————————————————|
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式！   |
//    |—————————————————————————————————————————————————————————|
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;


public class welcome extends Thread{
    JWindow     window=new JWindow();
    ImageIcon   img=new ImageIcon("imgs/welcome.png");
    JLabel      lblimg=new JLabel();

    public void run(){
        try {
            sleep(2000);
            new mk();
            window.dispose();
        }
        catch (InterruptedException e) {

            e.printStackTrace();
        }
    }
    welcome(){

        window.setSize(300,300);
        window.setLocationRelativeTo(null);
        window.add(lblimg);
        this.lblimg.setIcon(img);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        new welcome().start(); //定义一个匿名线程对象
    }
}
