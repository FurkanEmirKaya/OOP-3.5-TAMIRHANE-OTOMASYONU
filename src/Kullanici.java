public class Kullanici extends Admin{

    private String  isim;
    private String sifre;

    public Kullanici() {
      this.sifre="1926";
    }
    public void kullaniciClistir(){

    }


    @Override
    public String getIsim() {
        return isim;
    }

    @Override
    public void setIsim(String isim) {
        this.isim = isim;
    }

    @Override
    public String getSifre() {
        return sifre;
    }

    @Override
    public void setSifre(String sifre) {
        this.sifre = sifre;
    }
}
