package server;

import java.util.ArrayList;
import java.util.List;

public class Host {
    public List<Context> getContextList() {
        return contextList;
    }

    public void setContextList(List<Context> contextList) {
        this.contextList = contextList;
    }

    List<Context> contextList = new ArrayList<Context>();
}
