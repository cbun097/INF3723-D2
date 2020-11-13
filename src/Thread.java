public class Thread extends java.lang.Thread {

    String nom;
    int temps;

    public Thread(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    @Override
    public String toString() {
        return "Thread{" +
                "nom='" + nom + '\'' +
                ", temps=" + temps +
                '}';
    }

    @Override
    public void run() {
        super.run();
        System.out.println(currentThread() + " is running");
        System.out.println(getNom() + " is running");
    }
}
