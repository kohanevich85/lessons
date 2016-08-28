package lessons.lucene.example_1;

import java.util.List;

public class Park {
    //need this because the JSON actually contains a capitol letter
    //@JsonProperty("Name")
    private String Name = "";

    private List pos = null;

    public String getname() {
        return Name;
    }

    public void setname(String name) {
        this.Name = name;
    }

    public List getPos() {
        return pos;
    }

    public void setPos(List pos) {
        this.pos = pos;
    }

    @Override
    public String toString() {
        return "Park{" + "name=" + Name + ", pos=" + pos + '}';
    }
}
