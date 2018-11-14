import services.RegexSplitter;
import services.StateMachineSplitter;
import services.UrlSplitter;

// Main class
public class ApplicationMain {

    public static void main(String[] args) {
        String url = "";

        try {
            url = args[0];                // reads url string from command line argument
            System.out.println(url);

            UrlSplitter regexSplitter = new RegexSplitter();
            System.out.println(regexSplitter.splitUrl(url).toString());        // output URL parts

            // cycle of 10000 iterations, calculating of the required time
            System.out.println("Regex: " + calculateTimeRegexSplit(10000, url) + "msec");
            System.out.println("State: " + calculateTimeStateSplit(10000, url) + "msec");

        } catch (Exception exc) {
            System.out.println("Empty or incorrect URL, or typed without protocol, " + exc);
        }

    }


    public static long calculateTimeRegexSplit(int iterations, String url) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            // we could move following line before cycle, not to make an instance each time,
            // but i decided to calculate whole entire time
            UrlSplitter regexSplitter = new RegexSplitter();
            regexSplitter.splitUrl(url);
        }

        return System.currentTimeMillis() - start;             // return elapsed time using Regex
    }


    public static long calculateTimeStateSplit(int iterations, String url) {

        long start = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            UrlSplitter stateMachineSplitter = new StateMachineSplitter();
            stateMachineSplitter.splitUrl(url);
        }

        return System.currentTimeMillis() - start;             // return elapsed time using State machine
    }

}


