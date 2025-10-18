package cviceni;

public class Pojistenec {
    private String jmeno;
    private String prijmeni;
    private int vek;
    private String telefon;

    /**
     * Konstruktor zadava se
     *
     * @param jmeno
     * @param prijmeni
     * @param telefon
     * @param vek
     */
    public Pojistenec(String jmeno, String prijmeni, String telefon, int vek) {
        /**
         * kontrola jestli neni pole prazdné
         */

        if (jmeno == null || jmeno.trim().isEmpty()) {
            throw new IllegalArgumentException("Jméno nesmí být prázdné.");
        }
        if (prijmeni == null || prijmeni.trim().isEmpty()) {
            throw new IllegalArgumentException("Příjmení nesmí být prázdné.");
        }
        if (telefon == null || telefon.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefon nesmí být prázdný.");
        }
        if (vek < 0 || vek > 150) {
            throw new IllegalArgumentException("Neplatný věk.");
        }

        this.jmeno = jmeno.trim();
        this.prijmeni = prijmeni.trim();
        this.vek = vek;
        this.telefon = telefon.trim();
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getTelefon() {
        return telefon;
    }

    public int getVek() {
        return vek;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return tostring Jmeno Přijmeni Věk Telefon
     */
    @Override
    public String toString() {
        return String.format("%s %s, %d let, tel: %s", jmeno, prijmeni, vek, telefon);
    }
}