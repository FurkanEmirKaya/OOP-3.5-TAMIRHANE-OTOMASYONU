import java.util.Objects;

public class Admin implements KontrolMetodlari{
    private String isim = "Admin";
    private String sifre = "1937";
    /// Constructor ///////////////////////////////////////////////////////////////
    public Admin(String isim, String sifre) {
        while (kontrol()) {
            if (Objects.equals(this.isim, isim) && Objects.equals(this.sifre, sifre)) {

            } else {
                System.out.println("Kullanıcı adı veya şifre hatalı!\nTekrar giriş yapınız!");
            }
        }
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
