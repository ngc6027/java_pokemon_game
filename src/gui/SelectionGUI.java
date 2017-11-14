package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lifeform.Player;
import lifeform.Pokemon;
import types.FireType;
import types.Type;

public class SelectionGUI extends JFrame {

JPanel array = new JPanel();

JPanel attackPanel;
JPanel namePanel, namePanel2;
JPanel imagePanel;
JPanel imagePanel2;
// imagePanel = new JPanel();
JPanel panelArray = new JPanel();
JButton image1;

Font font = new Font("Courier", Font.BOLD,12);

public SelectionGUI() {
Player PlayerOne = new Player(1);
Player PlayerTwo = new Player(2);
PlayerOne.setOpponent(PlayerTwo);
PlayerTwo.setOpponent(PlayerOne);


namePanel=new JPanel();
namePanel2=new JPanel();
attackPanel=new JPanel();
imagePanel=new JPanel();
imagePanel2=new JPanel();
setLayout(new BorderLayout());
setPreferredSize(new Dimension(350, 190));
panelArray.setLayout(new GridLayout(3,12, 5, 5));

Pokemon blastoise = new Pokemon(new types.WaterType(), 100 , "blastoise");
creatingList(blastoise);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon bulbasaur = new Pokemon(new types.GrassType(), 100 , "bulbasaur");
creatingList(bulbasaur);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon caterpie = new Pokemon(new types.GrassType(), 100 , "caterpie");
creatingList(caterpie);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon charizard = new Pokemon(new types.FireType(), 100 , "charizard");
creatingList(charizard);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon charmander = new Pokemon(new types.FireType(), 100 , "charmander");
creatingList(charmander);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon charmeleon = new Pokemon(new types.FireType(), 100 , "charmeleon");
creatingList(charmeleon);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);

add(panelArray);
Pokemon ditto = new Pokemon(new types.WaterType(), 100 , "ditto");
creatingList(ditto);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);

add(panelArray);
Pokemon ivysaur = new Pokemon(new types.GrassType(), 100 , "ivysaur");
creatingList(ivysaur);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);

add(panelArray);
Pokemon poliwag = new Pokemon(new types.WaterType(), 100 , "poliwag");
creatingList(poliwag);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon squirtle = new Pokemon(new types.WaterType(), 100 , "squirtle");
creatingList(squirtle);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon venusaur = new Pokemon(new types.GrassType(), 100 , "venusaur");
creatingList(venusaur);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon vulpix = new Pokemon(new types.FireType(), 100 , "vulpix");
creatingList(vulpix);
panelArray.add(imagePanel);
//image1.addActionListener(Pokemon);
panelArray.add(namePanel);

panelArray.add(attackPanel);


Pokemon wartortle = new Pokemon(new types.WaterType(), 100 , "wartortle");
creatingList(wartortle);







add(panelArray);



//while(iterator.hasNext()) {
//Pokemon Pokemon = iterator.next();
//creatingList(Pokemon);

//}

pack();
setVisible(true);
}

void creatingList(Pokemon Pokemon) {
ImageIcon start = new ImageIcon(getClass().getResource(Pokemon.getDescription()+".png"));
ImageIcon imageCharmander = new ImageIcon(getClass().getResource("charmander.png"));

imagePanel.setLayout(new GridLayout());
JButton image1 = new JButton(start);
imagePanel.add(image1);

namePanel.setLayout(new GridLayout(3, 1));
JButton name1 = new JButton(Pokemon.getDescription());
name1.setFont(font);
namePanel.add(name1);

JButton name2 = new JButton(Integer.toString(Pokemon.getCurrentHelath()));
name1.setFont(font);
namePanel.add(name2);

JButton name3 = new JButton("fire");
name1.setFont(font);
namePanel.add(name3);

attackPanel.setLayout(new GridLayout(2, 2));
JButton attack1 = new JButton("attack1");
attack1.setFont(font);
attackPanel.add(attack1);

JButton attack2 = new JButton("attack2");
attack2.setFont(font);
attackPanel.add(attack2);

JButton attack3 = new JButton("attack3");
attack3.setFont(font);
attackPanel.add(attack3);

JButton attack4 = new JButton("attack4");
attack4.setFont(font);
attackPanel.add(attack4);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource().equals(image1))
{


}
if(e.getSource().equals("blastoise"))
{
// do something
}
if(e.getSource().equals("cater"))
{
// do something
}
}

}

