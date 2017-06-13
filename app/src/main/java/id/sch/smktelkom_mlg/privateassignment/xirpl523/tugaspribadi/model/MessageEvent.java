package id.sch.smktelkom_mlg.privateassignment.xirpl523.tugaspribadi.model;

public class MessageEvent {
    private boolean update = false;

    public MessageEvent(boolean update) {
        this.update = update;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }
}