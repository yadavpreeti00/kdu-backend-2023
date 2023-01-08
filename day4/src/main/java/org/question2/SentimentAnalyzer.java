package org.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class SentimentAnalyzer {

    private static final Logger logger= LoggerFactory.getLogger(SentimentAnalyzer.class);

    /**
     * @param review : processed review sentence
     * @param featureSet : 2d array of features given
     * @param posOpinionWords : given
     * @param negOpinionWords : given
     * Arraylist features_set [] : contains features present in review , null if absent [in the order gievn in featureSet]
     * method getOpinionOnFeature invoked
     * @return : featureOpinions array
     */
    public static int[] detectProsAndCons(String review, String[][] featureSet, String[] posOpinionWords,
                                          String[] negOpinionWords) {

        int[] featureOpinions = new int[featureSet.length]; // output
        int flag=0;

        //extracting features in review in feature_set arraylist in order [null if not present]
        ArrayList<String> features_set=new ArrayList<>();

        for(String[] arr: featureSet)
        {
            flag=0;
            for(String s:arr)
            {
                if(review.contains(s))
                {
                    features_set.add(s);
                    flag=1;
                    break;
                }
            }
            //if string is not in review add null in feature_set
            if(flag==0)
            {
                features_set.add(null);
            }
        }

        for(String s:features_set)
        {
            logger.info(s);
        }

        int i=0;
        for(String feature:features_set)
        {
            if(feature==null)
            {
                featureOpinions[i]=0;
            }
            else
            {
                logger.info(feature);
                featureOpinions[i]=getOpinionOnFeature(review,feature,posOpinionWords,negOpinionWords);
            }
            i++;
        }
        return featureOpinions;
    }

    /**
     * @param review : processed review sentence
     * @param feature: feature passed to be tested from detectProsAndCons method
     * @param posOpinionWords : given
     * @param negOpinionWords : given
     * @return opinion for feature passed [0,1,-1]
     */
    // First invoke checkForWasPhrasePattern and
    // if it cannot find an opinion only then invoke checkForOpinionFirstPattern
    private static int getOpinionOnFeature(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        // your code
        int opinion=0;
        logger.info(feature);
        opinion=checkForWasPhrasePattern(review,feature,posOpinionWords,negOpinionWords);

        //if wasPhrasePattern not present invoke FirstPattern
        if(opinion==0)
        {
            opinion=checkForOpinionFirstPattern(review,feature,posOpinionWords,negOpinionWords);
        }
        return opinion;
    }

    /**
     * @param review : processed review sentence
     * @param feature: feature passed to be tested from getOpinionOnFeature method
     * @param posOpinionWords : given
     * @param negOpinionWords : given
     * @return: value of opinion [0,1,-1]
     * check for feature + was + opinion in review
     */
    // Tip: Look at String API doc. Methods like indexOf, length, substring(beginIndex), startsWith can come into play
    // Return 1 if positive opinion found, -1 for negative opinion, 0 for no opinion
    // You can first look for positive opinion. If not found, only then you can look for negative opinion
    private static int checkForWasPhrasePattern(String review, String feature, String[] posOpinionWords, String[] negOpinionWords) {

        int opinion = 0;
        String pattern ;

        //positive opinion
        for(int i=0;i< posOpinionWords.length;i++)
        {
            pattern=feature + " was "+posOpinionWords[i];
            logger.info(pattern);
            if(review.contains(pattern))
            {
                opinion=1;
                break;
            }
        }
        //if positive opinion not found -> negative opinion
        if(opinion==0)
        {
            for(int i=0;i< negOpinionWords.length;i++)
            {
                pattern=feature + " was "+negOpinionWords[i];
                logger.info(pattern);
                if(review.contains(pattern))
                {
                    opinion=-1;
                    break;
                }
            }
        }
        return opinion;
    }

    /**
     * @param review : processed review sentence
     * @param feature: feature passed to be tested from checkForWasPhrasePattern method
     * @param posOpinionWords : given
     * @param negOpinionWords : given
     * @return: value of opinion [0,1,-1]
     * check for opinion+ feature in review
     */
    private static int checkForOpinionFirstPattern(String review, String feature, String[] posOpinionWords,
                                                   String[] negOpinionWords) {
        // Extract sentences as feature might appear multiple times.
        // split() takes a regular expression and "." is a special character
        // for regular expression. So, escape it to make it work!!
        //String[] sentences = review.split("\\.");

        int opinion = 0;
        String pattern ;

        //positive opinion
        for(int i=0;i< posOpinionWords.length;i++)
        {
            pattern=posOpinionWords[i]+" "+feature;
            logger.info(pattern);
            if(review.contains(pattern))
            {
                opinion=1;
                break;
            }
        }
        //negative opinion
        if(opinion==0)
        {
            for(int i=0;i< negOpinionWords.length;i++)
            {
                pattern=negOpinionWords[i]+" "+feature;
                logger.info(pattern);
                if(review.contains(pattern))
                {
                    opinion=-1;
                    break;
                }
            }
        }
        return opinion;
    }


    /**
        method detectProsAndCons invoked
     */
    public static void main(String[] args) {

        String review = "Haven't been here in years! Fantastic service and the food was delicious! Definetly will be a frequent flyer! Francisco was very attentive";

        //String review = "Sorry OG, but you just lost some loyal customers. Horrible service, no smile or greeting just attitude. The breadsticks were stale and burnt, appetizer was cold and the food came out before the salad.";

        //String review="I chose two items from the new menu, the shrimp scampi and the shrimp and chicken carbonara, both with my favourite soup and some warm breadsticks. The soup was amazing, as always.\n" +
             //   "Not only was their food delicious, but I must say that the stars are more for the excellent service!";


        //removing punctuations and converting review to lowercase
        review=review.toLowerCase();
        review=review.replaceAll("[,.?!]"," ");

        String[][] featureSet = {
                { "ambiance", "ambience", "atmosphere", "decor" },
                { "dessert", "ice cream", "desert" },
                { "food" },
                { "soup" },
                { "service", "management", "waiter", "waitress", "bartender", "staff", "server" } };
        String[] posOpinionWords = { "good", "fantastic", "friendly", "great", "excellent", "amazing", "awesome",
                "delicious" };
        String[] negOpinionWords = { "slow", "bad", "horrible", "awful", "unprofessional", "poor" };

        int[] featureOpinions = detectProsAndCons(review, featureSet, posOpinionWords, negOpinionWords);
        System.out.println("Opinions on Features: " + Arrays.toString(featureOpinions));
    }
}