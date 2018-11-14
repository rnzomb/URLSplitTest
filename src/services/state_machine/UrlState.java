package services.state_machine;

import models.Url;

import java.net.URL;       // simple way to split Urls using this Class and methods.

// each part of our URL will be enumerated below as a state.
// enumeration elements will call each other recursively, overriding parsing method.
// null turns to "None"

public enum UrlState implements UrlStateSplitterInterface {
    START {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            return SCHEME;
        }
    },
    SCHEME {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            urlMod.setScheme(urlLib.getProtocol());
            return HOST;
        }
    },
    HOST {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            urlMod.setHost(urlLib.getHost());
            return PORT;

        }
    },
    PORT {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            urlMod.setPort(urlLib.getPort() != -1 ? Integer.toString(urlLib.getPort()) : "None");
            return PATH;

        }
    },
    PATH {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            urlMod.setPath(urlLib.getPath().length() > 0 ? urlLib.getPath().substring(1) : "None");
            return PARAMETERS;

        }
    },
    PARAMETERS {
        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            urlMod.setParameters(urlLib.getQuery() != null ? urlLib.getQuery() : "None");
            return END;

        }
    },
    END {                                                           // will mean the end of "while" cycle

        @Override
        public UrlState nextState(URL urlLib, Url urlMod) {
            return this;
        }
    }
}
