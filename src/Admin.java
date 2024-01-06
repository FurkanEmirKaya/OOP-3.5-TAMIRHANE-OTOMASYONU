import java.util.Objects;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Admin implements KontrolMetodlari, DosyaIslemleri{
    private String isim ;
    private String sifre ;
    /// Constructor ///////////////////////////////////////////////////////////////
    public Admin() {
        isim = "Admin";
        sifre = "1937";
    }

    /// Metotlar /////////////////////////////////////////////////////////////////

    public final void addSehirSubeVeUstalar(){
        dosyaOkuVeTxtEkranaYazdir("Sehirler.txt");
        System.out.println("Eklemek istediğiniz şehri giriniz"); //Şehir ekleme fonksiyonuna alınacak.
        // Buradan sonra HashMap
        dosyaOkuVeTxtEkranaYazdir("Subeler");
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

    /// Interface Metotları ///////////////////////////////////////////////
    @Override
    public void girdiKontrol(String girdi) {

    }

    @Override
    public boolean booleanKontrol() {
        return false;
    }

    @Override
    public void dosyaOkuVeTxtEkranaYazdir(String dosyaAdi) {
        if (dosyaAdi.equals("Sehirler.txt")){ // Sehirler.txt dosyasını okuyup ekrana yazdırır.
            try {
                BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) { // Debug için
                e.printStackTrace();
            }
        }
        else if(dosyaAdi.equals("Subeler.txt")){ // Subeler.txt dosyasını okuyup ekrana yazdırır.
            try {
                BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) { // Debug için
                e.printStackTrace();
            }
        }
        else if(dosyaAdi.equals("Ustalar.txt")){ // Ustalar.txt dosyasın okuyup ekrana yazdırır.
            try {
                BufferedReader reader = new BufferedReader(new FileReader(dosyaAdi));
                String line = reader.readLine();
                while (line != null) {
                    System.out.println(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) { // Debug için
                e.printStackTrace();
            }
        }

    }

    @Override
    public void dosyaOkuVeArrayListeEkle() {

    }

    @Override
    public void arrayListEkranaYazdir() {

    }

    @Override
    public void txtDosyasinaEkle() {

    }
}
