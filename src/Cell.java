public class Cell {
    private boolean status;
    private boolean isChanged;

    public Cell() {
        status = false;
        isChanged = false;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getChanged() {
        return this.isChanged;
    }

    public void setChange(boolean isChanged) {
        this.isChanged = isChanged;
    }
}
