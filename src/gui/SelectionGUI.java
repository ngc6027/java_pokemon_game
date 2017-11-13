package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectionGUI extends JFrame {

public SelectionGUI()
{
setLayout(new BorderLayout());
 
JPanel array = new JPanel();
getContentPane().add(array);
JPanel attackPanel;
JPanel namePanel;
namePanel = new JPanel();
attackPanel = new JPanel();
 
 
Font font = new Font("Courier", Font.BOLD,40);
 
 
 
// Image Pokemon1 = new ImageIcon(this.getClass().getResource("/character.png")).getImage();
 
ImageIcon start = new ImageIcon(getClass().getResource("ditto.png"));
//textButton = new JButton (start);
//add(new JPanel());
// JPanel panel = new JPanel();
// add(new JPanel());
// JLabel jlabel = new JLabel("Name : type  LIfe: 100/100");
//
// panel.add(jlabel);
 
// JLabel[][] grid = new JLabel[3][11];
 
// for(int i = 0; i<3; i++)
// {
// for(int w=0; w<11;i++)
// {
 
namePanel.setLayout(new GridLayout(3,1));
JButton name1 = new JButton("Ditto");
name1.setFont(font);
namePanel.add(name1);
 
JButton name2 = new JButton("Life Points 100/100");
name1.setFont(font);
namePanel.add(name2);

JButton name3 = new JButton("Type: its fucking jelly");
name1.setFont(font);
namePanel.add(name3);
 
 
 
 
 
attackPanel.setLayout(new GridLayout(2,2));
JButton attack1 = new JButton("attack 1");
attack1.setFont(font);
attackPanel.add(attack1);
 
JButton attack2 = new JButton("attack 2");
attack2.setFont(font);
attackPanel.add(attack2);
 
JButton attack3 = new JButton("attack 3");
attack3.setFont(font);
attackPanel.add(attack3);
 
JButton attack4 = new JButton("attack 4");
attack4.setFont(font);
attackPanel.add(attack4);
 
//array.add(grid[i][w]);
add("Center",namePanel);
add("East",attackPanel);
add ("West",new JButton(start));
// }
// }
//         add(new JButton("Button 3"));
//         add(new JButton("Button 4"));
//         add(new JButton("Button 4"));
//         add(new JButton("Button 5"));
//         
// for(int i=0; i<11;i++)
// {
//
//
// for(int w=0;w<3;w++)
// {
// array[i][w] =  (JPanel) new JPanel();
// array[i][w].add("Center",namePanel);
// array[i][w].add("East",attackPanel);
// array[i][w].add ("West",new JButton(start));
// }
// }
 
// for(int i = 0;i<3;i++)
// {
// for(int w = 0;w<11;w++)
// {
// array[i][w] = new JPanel();
// array[i][w].add(namePanel);
// array[i][w].add(attackPanel);
// array[i][w].add (new JButton(start));
// }
// }
 
 
 

//
// array[2][1].add("Center",namePanel);
// array[2][2].add("East",attackPanel);
// array[2][0].add ("West",new JButton(start));
//
// array[3][1].add("Center",namePanel);
// array[3][2].add("East",attackPanel);
// array[3][0].add ("West",new JButton(start));


pack();
setVisible(true);
}
 
void creatingList()
{
 
}
 

 

 

}
