package cmsc256;
/**
 *   CMSC 256
 *   Computer Science Department
 *   College of Engineering
 *   Virginia Commonwealth University
 */
// Import Bridges and relevant data source
import bridges.connect.Bridges;
import bridges.data_src_dependent.*;
import bridges.base.*;

import java.util.List;
import java.util.Map;


public class Project6 {

	// Splits string into an array of words
	// Tutorial on regular expressions: 
	// https://www.vogella.com/tutorials/JavaRegularExpressions/article.html
	public static String[] splitText(String text) {      
		// remove '.' from all sentences by replacing with empty space
		text = text.replaceAll("[.]", "");  

		// remove non-printing white-space beginning and end of text
		text = text.trim();

		// separate each word based on spaces and add to word array
		String[] words = text.split("\\s+");

		// remove special characters from before/after words in the array
		for (int i = 0; i < words.length; i++) {        
			// \W+ is to find any non-word character 
			words[i] = words[i].replaceAll("\\W+$", "");  	// $ looks at end of the word
			words[i] = words[i].replaceAll("^\\W+", "");	// ^ looks at the beginning
			words[i] = words[i].trim();
		}

		return words;
	}


	public static void main(String[] args){

		// Initialize a Bridges connection with your credentials
		Bridges bridges = new Bridges(8, "DebMDuke", "1043584906762");

		// Set an assignment title
		bridges.setTitle("Project6");
		bridges.setDescription("MinHeap represented as a Binary Tree.");

		try {
			List<Shakespeare> shakespeare_list = bridges.getDataSource().getShakespeareData("poems");
			// Look at the first literary work, a poem
			Shakespeare po1 = shakespeare_list.get(1);

			// Display text as written
			System.out.println(po1.getText());

			// Separate into individual words
			String[] wordlist = splitText(po1.getText());

			// Display word array, one word per line
			for (int i=0; i<wordlist.length; ++i)
				System.out.println(wordlist[i]);


			StandardDictionary<String,Integer> my_dictionary = new StandardDictionary<String, Integer>();
			//HashTableDictionary<String,Integer> my_map = new HashTableDictionary<String, Integer>();
			//SearchTreeDictionary<String, Integer> my_tree = new SearchTreeDictionary<String, Integer>();


			//TODO: 2.Use StandardDictionary to compute the number of occurrences of each word.
			for (String word : wordlist) {

			}

			//TODO: uncomment after completing step 2 
			//my_dictionary.visualize(bridges);  

			for (Map.Entry<String,Integer> e : my_dictionary) 
				System.out.println(e.getKey() + " " + e.getValue());
		}
		catch(Exception ex) {
			System.out.println("Unable to access BRIDGES");
		}


	}
}