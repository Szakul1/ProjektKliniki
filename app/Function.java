package app;

public enum Function
{
    SELECT,
    CHOOSEONE,
    MODIFY,
    DELETE;

    private int id; 
    public void setId(int id)
    {
        this.id=id;
    }
    public int getId()
    {
        return id;
    }
}