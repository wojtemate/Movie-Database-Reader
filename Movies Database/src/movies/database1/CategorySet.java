package movies.database1;

import java.util.HashSet;
import java.util.List;

public class CategorySet {

	public static HashSet<String> createCategorySet(List<Movie> movieList){
		HashSet<String> categorySet = new HashSet<>(); 
		for (Movie movie : movieList) categorySet.add(movie.getCategory());
		return categorySet;
	}
	
}