package server;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public List<Host> getHostList() {
        return hostList;
    }

    public void setHostList(List<Host> hostList) {
        this.hostList = hostList;
    }

    List<Host> hostList = new ArrayList<Host>();
}
