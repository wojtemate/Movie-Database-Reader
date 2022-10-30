package movies.database1;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class DataPrint {
	
	public static void printHelp() {		
		System.out.println("\nType the command to do an action: ");
		System.out.println("'" + Action.help + "' to print all possible commands with explanations,");
		System.out.println("'" + Action.categories + "' to print categories of movies in base,");
		System.out.println("'" + Action.sortedByName + "' to print all movies titles sorted alphabetically,");
		System.out.println("'" + Action.sortedByReleaseDate + "' to print list of movies sorted by release date,");
		System.out.println("'" + Action.sortedByRate + "' to print list of movies sorted by rate,");
		System.out.println("'" + Action.categoryFiltered + "' to see list of movies in chosen category,");
		System.out.println("'" + Action.end + "' to quit.");
	}
	
	public static void printAll(List<Movie> movieList) {		
		String line;
		int i = 1; // it will be used to show numeric order of printed lines
		for (Movie movie : movieList) {
			line = String.format("Movie: '%s', Category: %s, Rate: %s, Release date: %s", movie.getName(), movie.getCategory(),
				movie.getRate(), movie.getReleaseDate());
			System.out.println(i + ". " + line);
			i++;
		}
	}
	
	public static void printSortedByName(List<Movie> movieList) {
		Collections.sort(movieList, Comparator.comparing(Movie::getName));
		DataPrint.printAll(movieList);
	}
	
	public static void printCategories(HashSet<String> categoriesSet) {		
		System.out.print("Categories of movies available in database: \n");
		for (String catSet : categoriesSet) {
			System.out.println(catSet);
		}
	}
	
	public static void printSortedByRate(List<Movie> movieList) {
		Collections.sort(movieList, Comparator.comparingDouble(Movie::getRate).reversed());
		DataPrint.printAll(movieList);
	}
	
	public static void printSortedByReleaseDate(List<Movie> movieList) { 
		Collections.sort(movieList, Comparator.comparingInt(Movie::getReleaseDate).reversed());
		DataPrint.printAll(movieList);
	}
	
	public static void categoryFiltered(List<Movie> movieList, HashSet<String> categories, Scanner scanner) {
		boolean typedCategoryExists = false;
		String line, command;
		int i = 1;
		
		do {
			System.out.println("Type one of the following categories, to print movies belonging to it.\nAvailable categories:");
			for (String cat : categories) System.out.print(cat + ", ");
			System.out.println();
			command = scanner.nextLine().toLowerCase();
				if (categories.contains(command)) {
					for (Movie movie : movieList) {
						if (movie.getCategory().equals(command)) {
							line = String.format("Movie: '%s', Rate: %s, Release date: %s", movie.getName(),
								movie.getRate(), movie.getReleaseDate());
							System.out.println(i + ". " + line);
							i++;
						}
					}
					typedCategoryExists = true;
				}
				else System.out.println("Category '" + command + "' does not exist in database.\n Please try again:");
		} while (typedCategoryExists == false);
	}
}
