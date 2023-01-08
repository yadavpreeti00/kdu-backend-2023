package org.question3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIResponseParser {

    private static final Logger logger= LoggerFactory.getLogger(APIResponseParser.class);

    /**
     * Parses the input text and returns a Book instance containing
     * the parsed data.
     * @param response text to be parsed
     * @return Book instance containing parsed data
     */
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        String startRule;

        startRule= "<title>";
        endRule= "</title";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);
        logger.info(book.getTitle());

        startRule = "<name>";
        endRule="</name>";
        String author = parse(response, startRule, endRule);
        logger.info(author);
        book.setAuthor(author);

        startRule = "<original_publication_year type=\"integer\">";
        endRule = "</original_publication_year>";
        String pubYear = parse(response, startRule, endRule);
        int publicationYear=Integer.parseInt(pubYear);
        System.out.println(publicationYear);
        logger.info(String.valueOf(publicationYear));


        startRule = "<average_rating>";
        endRule = "</average_rating>";
        String avgRating = parse(response, startRule, endRule);
        double averageRating = Double.parseDouble(avgRating);
        logger.info(String.valueOf(averageRating));
        book.setAverageRating(averageRating);

        startRule = "<ratings_count type=\"integer\">";
        endRule = "</ratings_count>";
        String rating = parse(response, startRule, endRule);
        rating=rating.replace(",","");
        int ratingsCount=Integer.parseInt(rating);
        logger.info(String.valueOf(ratingsCount));
        book.setRatingsCount(ratingsCount);

        startRule = "<image_url>";
        endRule = "</image_url>";
        String imageUrl = parse(response, startRule, endRule);
        logger.info(imageUrl);
        book.setImageUrl(imageUrl);

        return book;
    }

    private static String parse(String response, String startRule, String endRule) {

        int startIndex = response.indexOf(startRule);

        if (startIndex == -1) {
            return "";
        }

        int endIndex = response.indexOf(endRule, startIndex);

        if (endIndex == -1) {
            return "";
        }

        String ans="";
        ans= response.substring(startIndex+startRule.length(), endIndex);
        return ans;
    }


    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>" ;

        Book book=new Book();
        book=APIResponseParser.parse(response);

        System.out.println("Book Information\n1.Book Title : "+book.getTitle()+
                "\n2.Author Name : "+book.getAuthor()+"\n3.Publication Year : "+ book.getPublicationYear()
        +"\n4.Average Rating : "+book.getAverageRating()+"\n5.Ratings Count : "+book.getRatingsCount()
        +"\n6.Image Url : " + book.getImageUrl());

    }
}