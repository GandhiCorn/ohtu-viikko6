package statistics.matcher;

import java.util.ArrayList;
import java.util.List;

public class QueryBuilder {
    Matcher m;
    
    public QueryBuilder() {
        this.m = new And();
    }
    
    public QueryBuilder playsIn(String team) {
        this.m = new And(this.m, new PlaysIn(team));
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.m = new And(this.m, new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.m = new And(this.m, new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder oneOf(Matcher... matchers) {
        this.m = new Or(matchers);
        return this;
    }
    
    public QueryBuilder notAnyOf(Matcher... matchers) {
        this.m = new Not(matchers);
        return this;
    }
    
    public Matcher build() {
        Matcher oldMatcher = this.m;
        this.m = new And();
        return oldMatcher;
    }
}