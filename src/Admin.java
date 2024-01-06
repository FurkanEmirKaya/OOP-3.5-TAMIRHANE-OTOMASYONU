import java.util.Objects;

public class Admin implements KontrolMetodlari{
    private String isim ;
    private String sifre ;
    /// Constructor ///////////////////////////////////////////////////////////////
    public Admin() {
        isim = "Admin";
        sifre = "1937";
    }




    /// Getter-Setter metotlar ///////////////////////////////////////////////////
    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifreler) {
        this.sifre = sifreler;
    }

    @Override
    public void girdiKontrol(String girdi) {

    }

    @Override
    public boolean booleanKontrol() {
        return false;
    }
}
