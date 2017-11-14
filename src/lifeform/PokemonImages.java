package lifeform;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class PokemonImages {
	
	private static String[] pokemonNames = {"Squirtle", "Wartortle", "Blastoise", "Poliwag",
											 "Bulbasaur", "Ivysaur", "Venusaur", "Caterpie",
											 "Charmander", "Charmeleon", "Charizard", "Vulpix"};
	
	private static String[] fileLocations = {"squirtle.png", "wartortle.png", "blastoise.png", "poliwag.png",
											 "bulbasaur.png", "ivysaur.png", "venusaur.png", "caterpie.png",
											 "charmander.png", "charmeleon.png", "charizard.png", "vulpix.png"};
	
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
	
	/**
	 * Instantiates the HashMap for Pokemon Images.
	 * @throws IOException
	 */
	private void createHash() throws IOException
	{
		map = new HashMap<String, Image>();
		
		for(int i = 0; i < pokemonNames.length; i++)
		{
			map.put(pokemonNames[i], ImageIO.read(new File(fileLocations[i])));
		}
	}
}
