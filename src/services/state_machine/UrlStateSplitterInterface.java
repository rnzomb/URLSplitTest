package services.state_machine;

import models.Url;

import java.net.URL;

public interface UrlStateSplitterInterface {
    UrlState nextState(URL urlLib, Url urlMod);            // method that will be overridden in accordance to states

}
