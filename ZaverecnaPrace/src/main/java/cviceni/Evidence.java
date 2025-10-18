package cviceni;

import java.util.ArrayList;

public class Evidence {

    private ArrayList<Pojistenec> seznam = new ArrayList<>();

    public void pridej(Pojistenec p){
        seznam.add(p);
    }

    /**
     *
     * @return kopie seznamu na vyhledavání
     */
    public ArrayList<Pojistenec> getAll() {
        return new ArrayList<>(seznam);
    }

    /**
     * Vyhledavání schody jmena a přijmeni
     * @param hledaneJmeno
     * @param hledanePrijmeni
     * @return
     */
    public ArrayList<Pojistenec> vyhledej(String hledaneJmeno, String hledanePrijmeni) {
        ArrayList<Pojistenec> vysledek = new ArrayList<>();

        for (Pojistenec p : seznam) {
            boolean schodaJmeno = hledaneJmeno.isEmpty() || p.getJmeno().equalsIgnoreCase(hledaneJmeno);
            boolean schodaPrijmeni = hledanePrijmeni.isEmpty() || p.getPrijmeni().equalsIgnoreCase(hledanePrijmeni);

            if (schodaJmeno && schodaPrijmeni) {
                vysledek.add(p);
            }
        }

        return vysledek;
    }


}
