package tryyy;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class FirstFrame extends JFrame{

    static JComboBox<ArrayList> mycombo;

    FirstFrame()
    {
        this.setSize(600,500);
        this.setTitle("My combo");
        this.setLayout(null);

        ArrayList<String> names=new ArrayList<String>();   
        names.add("jessy");
        names.add("albert");
        names.add("grace");
        mycombo=new JComboBox(names.toArray());
        mycombo.setBounds(60,32,200,50);
        this.add(mycombo);
        this.setVisible(true); // window visible
    }   

    public static void main(String[] args) {

        FirstFrame frame=new FirstFrame();  

    }

}