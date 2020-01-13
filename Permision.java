package app;
public enum Permision
{
    ADMIN,
    DIRECTOR,
    VET,
    TECHNICIAN,
    CLIENT;
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