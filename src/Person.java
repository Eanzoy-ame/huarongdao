//    |—————————————————————————————————————————————————————————|
//    |    代码由idea编写，在eclipse中运行可能需要转换编码格式！   |
//    |—————————————————————————————————————————————————————————|
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Person extends JButton implements FocusListener{
    int number;
    Person(int number,String name){
        this.number=number;
        addFocusListener(this);
    }
    public void focusGained(FocusEvent e){
        //setBackground(Color.GREEN);
    }
    public void focusLost(FocusEvent e){
        //setBackground(Color.red);
    }

}
