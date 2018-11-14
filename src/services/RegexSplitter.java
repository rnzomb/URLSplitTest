package services;

import models.Url;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSplitter implements UrlSplitter {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*)/?)?([^?#]*)(\\?([^#]*)?)?");

    /*   this pattern example contains 7 selection groups to parse/split Urls.
         we need a few of them in accordance with the task.

         * scheme             = $2
         * authority/address  = $4    -   if address contains colon, it contains host and port
         * path               = $5
         * query/parameters   = $7
    */
    @Override
    public Url splitUrl(String Url) {

        Url regexSplitUrl = null;

        try {
            Matcher matcher = SPLIT_PATTERN.matcher(Url);
            matcher.find();
            String scheme = matcher.group(2);
            String address = matcher.group(4);                                               // host/port
            String host = address.contains(":") ? address.split(":")[0] : address;     // check if the address contains a colon,
            String port = address.contains(":") ? address.split(":")[1] : "None";      // then define a port, otherwise "None".
            String path = matcher.group(5);
            String params = matcher.group(7);

            regexSplitUrl = new Url(scheme, host, port, path, params);

        } catch (Exception exc) {
            System.out.println("Error parsing URL, using regular expressions : " + exc);
        }

        return regexSplitUrl;
    }
}
