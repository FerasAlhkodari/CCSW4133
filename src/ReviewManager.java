import java.util.HashMap;
import java.util.Map;

public class ReviewManager {
    private Map<String, String> reviews; // Maps ISBN to review text

    public ReviewManager() {
        this.reviews = new HashMap<>();
    }

    // Add or update a review for a specific book
    public void addReview(String isbn, String review) {
        reviews.put(isbn, review);
    }

    // Retrieve a review by ISBN, returning null if no review exists
    public String getReview(String isbn) {
        return reviews.get(isbn);
    }

    // Return a copy of all reviews, providing safe access to the data
    public Map<String, String> getAllReviews() {
        return new HashMap<>(reviews);
    }
}