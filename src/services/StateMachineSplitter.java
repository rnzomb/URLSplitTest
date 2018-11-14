package services;

import models.Url;
import services.state_machine.UrlState;

import java.net.URL;

public class StateMachineSplitter implements UrlSplitter {

    @Override
    public Url splitUrl(String urlString) {
        Url urlSplitSM = new Url();
        try {
            UrlState urlState = UrlState.START;                            //set beginning state
            URL url = new URL(urlString);

            while(!urlState.equals(UrlState.END)){                         // pass through all enumerated states and get values
                urlState = urlState.nextState(url, urlSplitSM);

            }

        } catch (Exception exc) {
            System.out.println("Error parsing URL, using state machine : " + exc);
        }
        return urlSplitSM;
    }
}
