import java.util.ArrayList;
import java.util.List;

public class Liste {
    int tailleList;
    List<Integer> listOr = new ArrayList<Integer>();
    int NLIST;

    public Liste(int tailleList) {
        this.tailleList = tailleList;
    }

    public int getTailleList() {
        return tailleList;
    }

    public void setTailleList(int tailleList) {
        this.tailleList = tailleList;
    }

    public List<Integer> getlistOr() {
        return listOr;
    }

    public void setlistOr(List<Integer> liste1) {
        this.listOr = liste1;
    }

    public int getNLIST() {
        return NLIST;
    }

    public void setNLIST(int NLIST) {
        this.NLIST = NLIST;
    }

    @Override
    public String toString() {
        return "Liste{" +
                "tailleList=" + tailleList +
                ", listOr=" + listOr +
                ", NLIST=" + NLIST +
                '}';
    }

    // TODO : separer la liste en 2 elements egaux recu par l'usager
    // TODO: private ou pas
    private void separerEnSousListe() {

    }

    // TODO: sort la sous liste
    // TODO: private ou pas
    private void sortSousListe() {

    }
}
