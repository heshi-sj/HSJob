package server;

import java.util.ArrayList;
import java.util.List;

public class Context {
    public List<Wrapper> getWrapperList() {
        return wrapperList;
    }

    public void setWrapperList(List<Wrapper> wrapperList) {
        this.wrapperList = wrapperList;
    }

    List<Wrapper> wrapperList = new ArrayList<Wrapper>();

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    String appname;
}
