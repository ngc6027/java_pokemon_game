package lifeform;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class PokemonImages {
	
	private static String[] pokemonNames = {"Charmander"};
	private static String[] fileLocations = {"charmander.png"};
	
	private static HashMap<String, Image> map = null;
	
	public Image getImage(String key) throws IOException
	{
		/* For lazy-loading the list */
		if(map == null)
		{
			createHash();
		}
		
		return(map.get(key));
	}
	
	private void createHash() throws IOException
	{
		map = new HashMap<String, Image>();
		
		for(int i = 0; i < pokemonNames.length; i++)
		{
			map.put(pokemonNames[i], ImageIO.read(new File(fileLocations[i])));
		}
	}
}
