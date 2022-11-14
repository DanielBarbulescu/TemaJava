public class Student implements Human{
    private String Nume;
    private String Prenume;
    private String Facultate;
    private Integer Varsta;
    private Integer AnDeStudiu;

    public Student(String nume, String prenume, String facultate, Integer varsta, Integer anDeStudiu) {
        Nume = nume;
        Prenume = prenume;
        Facultate = facultate;
        Varsta = varsta;
        AnDeStudiu = anDeStudiu;
    }

    public String getNume() {
        return Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public String getFacultate() {
        return Facultate;
    }

    @Override
    public Integer getVarsta() {
        return Varsta;
    }

    public Integer getAnDeStudiu() {
        return AnDeStudiu;
    }

    @Override
    public void greeting() {
        System.out.println("Studentul " + this.getNume() + " saluta...");
    }

    @Override
    public void doWork() {
        System.out.println("Studentul " + this.getNume() + " munceste...");
    }

    @Override
    public String toString() {
        return "[Sd. "+ this.getNume() + " " + this.getPrenume() +
                ",Anul " + this.getAnDeStudiu() + ", Fac. " + this.getFacultate() +
                ", Varsta " + this.getVarsta() + "]";
    }

    @Override
    public int compareTo(Human o) {
        if(this.getVarsta() < o.getVarsta())
        {
            return -1;
        }
        else if(this.getVarsta() > o.getVarsta())
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }
}
