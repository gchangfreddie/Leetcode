package algorithm;

import java.util.*;

public class Movie {
    private final int movieId;
    private final float rating;
    private List<Movie> similarMovies; // Similarity is bidirectional
 
    public Movie(int movieId, float rating) {
        this.movieId = movieId;
        this.rating = rating;
        similarMovies = new ArrayList<Movie>();
    }
 
    public int getId() {
        return movieId;
    }
 
    public float getRating() {
        return rating;
    }
 
    public void addSimilarMovie(Movie movie) {
        similarMovies.add(movie);
        movie.similarMovies.add(this);
    }
 
    public List<Movie> getSimilarMovies() {
        return similarMovies;
    }
 
    /*
     * Implement a function to return top rated movies in the network of movies 
     * reachable from the current movie
     * eg:             A(Rating 1.2)
     *               /   \
     *            B(2.4)  C(3.6)
     *              \     /
     *                D(4.8)
     * In the above example edges represent similarity and the number is rating.
     * getMovieRecommendations(A,2) should return C and D (sorting order doesn't matter so it can also return D and C)
     * getMovieRecommendations(A,4) should return A, B, C, D (it can also return these in any order eg: B,C,D,A)
     * getMovieRecommendations(A,1) should return D. Note distance from A to D doesn't matter, return the highest rated.
     *     
     *     @param movie
     *     @param numTopRatedSimilarMovies 
     *                      number of movies we want to return
     *     @return List of top rated similar movies
     */
    public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
    	List<Movie> movieListOfRecommendations = new ArrayList<Movie>(); 
    	if (movie==null || numTopRatedSimilarMovies<=0)  return movieListOfRecommendations; 
    
    	Queue<Movie> neighborMovies = new LinkedList<Movie>(); 
        HashSet<Integer> visitedMovies = new HashSet<Integer>(); // movie Id should be unique key
        /*
         * use a priority queue to keep numTopRatedSimilarMovies top movie. 
         * float numbers can not be compare directly. 
         */
        PriorityQueue<Movie> priorityQueueOfMovies =new PriorityQueue<Movie>(numTopRatedSimilarMovies, new Comparator<Movie>(){
        	public int compare(Movie  m1, Movie m2){
        		return Float.compare(m1.getRating(), m2.getRating()); 
        	}
		});
        neighborMovies.add(movie); 
        visitedMovies.add(movie.getId()); 
        priorityQueueOfMovies.add(movie); 
        while(!neighborMovies.isEmpty()){
        	Movie currentMovie = neighborMovies.poll(); 
    		List<Movie> list = currentMovie.getSimilarMovies(); 
    		for (Movie neighbor :list){
    			if (!visitedMovies.contains(neighbor.getId())) {
    				visitedMovies.add(neighbor.getId()); 
    				neighborMovies.add(neighbor); 
    				priorityQueueOfMovies.add(neighbor); 
    				if (priorityQueueOfMovies.size()>numTopRatedSimilarMovies) priorityQueueOfMovies.remove(); 
    			}
    		}
        }
        int size = priorityQueueOfMovies.size(); 
        for (int i=0; i<size; i++) {
        	movieListOfRecommendations.add(priorityQueueOfMovies.poll()); 
        }
        return movieListOfRecommendations;
    }
    // Run time is O(n) and spatial is O(n). 
    
    public static void main(String[] args){
    	Movie a = new Movie(1, 1.2f); 
    	Movie c = new Movie(3, 3.6f); 
    	Movie b = new Movie(2, 2.4f); 
    	Movie d = new Movie(4, 4.8f); 
    	Movie e = new Movie(5, 5.8f); 
    	a.similarMovies.add(c); a.similarMovies.add(b); 
    	c.similarMovies.add(d); b.similarMovies.add(d); b.similarMovies.add(e);
    	
    	List<Movie> list = getMovieRecommendations(a, 2); 
    	for (Movie m : list) {
    		System.out.println(m.movieId);
    	}
    	
    	System.out.println(5.82f==5.82f);
    }
}
