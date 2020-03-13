import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MedianFind {

    static class Hotel {
        int id;
        int rating;
        int positiveReview;

        public int getPositiveReview() {
            return positiveReview;
        }

        public void setPositiveReview(int positiveReview) {
            this.positiveReview = positiveReview;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public Hotel(int id, int rating, int positiveReview) {
            this.id = id;
            this.rating = rating;
            this.positiveReview = positiveReview;
        }
    }
    public static void main(String args[]) {
        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(new Hotel(1, 5, 6));
        hotels.add(new Hotel(2, 4, 3));
        hotels.add(new Hotel(3, 3, 3));
        hotels.add(new Hotel(4, 2, 5));
        hotels.add(new Hotel(5, 5, 5));

        Collections.sort(hotels, Comparator.comparing(Hotel::getRating).reversed().thenComparing(Hotel::getPositiveReview));
        hotels.forEach(x -> System.out.println(x.id + " " + x.rating + " " + x.positiveReview));
    }
}
