import java.util.HashMap;
import java.util.Map;

public class LoanManager {
    private Map<String, String> loanRecords;  // Maps ISBN to user ID

    public LoanManager() {
        loanRecords = new HashMap<>();
    }

    public boolean checkOutBook(String isbn, String userID) {
        if (!loanRecords.containsKey(isbn)) {
            loanRecords.put(isbn, userID);
            return true;
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        if (loanRecords.containsKey(isbn)) {
            loanRecords.remove(isbn);
            return true;
        }
        return false;
    }

    public String getLoaner(String isbn) {
        return loanRecords.get(isbn);
    }
}
