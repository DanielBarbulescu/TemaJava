public class Profesor implements Human{
    private String Nume;
    private String Prenume;
    private String Facultate;
    private Integer Varsta;
    private String Materie;

    public Profesor(String nume, String prenume, String facultate, Integer varsta, String materie) {
        Nume = nume;
        Prenume = prenume;
        Facultate = facultate;
        Varsta = varsta;
        Materie = materie;
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

    public String getMaterie() {
        return Materie;
    }

    @Override
    public Integer getVarsta() {
        return this.Varsta;
    }

    @Override
    public void greeting() {
        System.out.println("Profesorul " + this.getNume() + " saluta...");
    }

    @Override
    public void doWork() {
        System.out.println("Profesorul " + this.getNume() + " munceste...");
    }


    @Override
    public String toString() {
        return "[Prof. "+ this.getNume() + " " + this.getPrenume() +
                ", Fac. " + this.getFacultate() + ", Varsta " + this.getVarsta() + "]";
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
