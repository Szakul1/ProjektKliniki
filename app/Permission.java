package app;
public enum Permission
{
    ADMIN,
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