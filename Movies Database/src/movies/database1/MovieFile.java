package movies.database1;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MovieFile {
	
	private String fileName;
	
	public String getName() {
		return fileName;
	}
	
	public List<Movie> loadFile(String fileName) throws FileNotFoundException, ParseException {

		File file = new File(fileName);
		if (file.exists()) System.out.println("Found file: " + fileName);
		else System.out.println("Cannot find file: " + fileName);
		
		//Loading file and creating list of objects. Every object contains informations about movie: name, category, rating, release date 
		List<Movie> movieList = new LinkedList<>();
		
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter(";");
			NumberFormat nf = NumberFormat.getInstance(); // This method allows to read commas as dots in double variables

			while (scanner.hasNext()) {
				Movie currentMovie = new Movie();
				currentMovie.setName(scanner.next().replace("\n", "").replace("\r", "")); // Removing "line breaks" from titles
				currentMovie.setCategory(scanner.next());
				currentMovie.setRate(nf.parse(scanner.next()).doubleValue()); 
				currentMovie.setReleaseDate(Integer.parseInt(scanner.next()));
				movieList.add(currentMovie);
			}
					
		}
		catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return movieList;
	}
	
}
