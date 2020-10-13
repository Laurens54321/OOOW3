package model.states;

public interface State {
    public String approve();
    public String reject();

    public boolean isAvailable();
    public boolean loan();
    public String verwijder();

    public String toString();

}
