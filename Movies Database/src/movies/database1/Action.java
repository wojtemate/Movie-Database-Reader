package movies.database1;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Action {	
	public static final String help = "help";
	public static final String sortedByName = "sorted by name";
	public static final String categories = "categories";
	public static final String sortedByReleaseDate = "sorted by release date";
	public static final String sortedByRate = "sorted by rate"; 
	public static final String categoryFiltered = "category filtered";
	public static final String end = "end";
		
	public static void appLoop(List<Movie> movieList, HashSet<String> categorySet) {
		DataPrint.printHelp();
		String command = null;
		Scanner scanner = new Scanner(System.in);
		
		do {
			command = scanner.nextLine().toLowerCase();
			switch (command){
			case help:
				DataPrint.printHelp();
				break;
			case sortedByName:
				DataPrint.printSortedByName(movieList);
				break;
			case categories:
				DataPrint.printCategories(categorySet);
				break;
			case sortedByReleaseDate:
				DataPrint.printSortedByReleaseDate(movieList);
				break;
			case sortedByRate:
				DataPrint.printSortedByRate(movieList);
				break;
			case categoryFiltered:
				DataPrint.categoryFiltered(movieList, categorySet, scanner);
				break;
			case end:
				break; // This is the only way to quit
			default:
				System.out.println("System could not recognize the command '" + command + "'. Please, type it again.");
				System.out.println("Type '" + help + "' to see list of commands");
			}
		} while (!command.equals("end"));
		
		scanner.close();
	}
}
