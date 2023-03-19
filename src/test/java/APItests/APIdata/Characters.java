package APItests.APIdata;

import java.util.ArrayList;

public class Characters {
        private Info info;
        private ArrayList<Result> results;

    public Characters() {
    }

    public Info getInfo() {
        return info;
    }

    public ArrayList<Result> getResults() {
        return results;
    }

    public Characters(Info info, ArrayList<Result> results) {
        this.info = info;
        this.results = results;


    }
}


