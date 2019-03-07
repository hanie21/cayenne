package org.apache.cayenne.testdo.cay_2521.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.cayenne.BaseDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.testdo.cay_2521.Issue;
import org.apache.cayenne.testdo.cay_2521.Team;

/**
 * Class _Location was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Location extends BaseDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "id";

    public static final Property<String> NAME = Property.create("name", String.class);
    public static final Property<List<Issue>> ISSUES = Property.create("issues", List.class);
    public static final Property<Team> TEAM = Property.create("team", Team.class);
    public static final Property<Team> HOME_TEAM = Property.create("homeTeam", Team.class);

    protected String name;

    protected Object issues;
    protected Object team;
    protected Object homeTeam;

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        return this.name;
    }

    public void addToIssues(Issue obj) {
        addToManyTarget("issues", obj, true);
    }

    public void removeFromIssues(Issue obj) {
        removeToManyTarget("issues", obj, true);
    }

    @SuppressWarnings("unchecked")
    public List<Issue> getIssues() {
        return (List<Issue>)readProperty("issues");
    }

    public void setTeam(Team team) {
        setToOneTarget("team", team, true);
    }

    public Team getTeam() {
        return (Team)readProperty("team");
    }

    public void setHomeTeam(Team homeTeam) {
        setToOneTarget("homeTeam", homeTeam, true);
    }

    public Team getHomeTeam() {
        return (Team)readProperty("homeTeam");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "name":
                return this.name;
            case "issues":
                return this.issues;
            case "team":
                return this.team;
            case "homeTeam":
                return this.homeTeam;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "name":
                this.name = (String)val;
                break;
            case "issues":
                this.issues = val;
                break;
            case "team":
                this.team = val;
                break;
            case "homeTeam":
                this.homeTeam = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.name);
        out.writeObject(this.issues);
        out.writeObject(this.team);
        out.writeObject(this.homeTeam);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.name = (String)in.readObject();
        this.issues = in.readObject();
        this.team = in.readObject();
        this.homeTeam = in.readObject();
    }

}
