package movies.database1;

import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Start {

	static String fileName = "Movies.txt"; // Name of file with movies database
	
	public static void main(String[] args) throws FileNotFoundException, ParseException {

		System.out.println("This is a movie database application.");
		MovieFile movieFile = new MovieFile();
		
		List<Movie> listOfMovies = new LinkedList<>();
		listOfMovies = movieFile.loadFile(fileName);
		
		HashSet<String> categorySet = new HashSet<>();
		categorySet = CategorySet.createCategorySet(listOfMovies);
		Action.appLoop(listOfMovies, categorySet);
	}
	
}
