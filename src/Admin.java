import java.io.*;
import java.util.Objects;
import java.util.Scanner;

public class Admin implements KontrolMetodlari, DosyaIslemleri{
    private String isim ;
    private String sifre ;
    Scanner scan = new Scanner(System.in);
    /// Constructor ///////////////////////////////////////////////////////////////
    public Admin() {
        isim = "Admin";
        sifre = "1937";
    }

    /// Metotlar /////////////////////////////////////////////////////////////////
    public final void adminCalistir(){ // Admini çalıştıran metot

        System.out.println("1-Listeleme 2-Ekleme");
        String secim1 = scan.nextLine();
        if(Objects.equals(secim1, "1")){
            // Buraya listeleme metotu gelecek
        }
        if(Objects.equals(secim1,"2")){
            addSehirSubeVeUstalar();
        }

    }
    public final void addSehirSubeVeUstalar(){

        dosyaOkuVeTxtEkranaYazdir("Sehirler.txt");
        System.out.print("Eklemek istediğiniz şehri giriniz: "); //Şehir ekleme fonksiyonuna alınacak.
        String eklenecekSehir = scan.nextLine();
        txtDosyasinaEkle("Sehirler.txt", eklenecekSehir);

        int subeSayaci = 0;
        do{ // Şube ve usta eklemek için döngü
            System.out.print("Eklemek istediğiniz şubeyi giriniz: ");
            String eklenecekSube = scan.nextLine();
            txtDosyasinaEkle("Subeler.txt", eklenecekSube);

            System.out.println("Eklemek istediğiniz ustanın adını giriniz: ");
            String eklenecekUsta = scan.nextLine();
            txtDosyasinaEkle("Ustalar.txt", eklenecekUsta);



            System.out.println("Şube eklemeye devam etmek ister misiniz?: ");
        } while ();




        // Buradan sonra HashMap
        dosyaOkuVeTxtEkranaYazdir("Subeler");
    }

    protected String ustaSecimYap(){
        System.out.println("Ustanın uzmanlık alanını seçiniz: ");
        switch (){
            case 0;
        }
        System.out.println("Ustanın tecrübesi ne kadardır?: ");


        return
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
    public void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri) {
        if(dosyaAdi.equals("Sehirler.txt")){ // Sehirler.txt dosyasına veri ekler.
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.
                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(dosyaAdi.equals("Subeler.txt")){ // Subeler.txt dosyasına veri ekler.
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.
                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(dosyaAdi.equals("Ustalar.txt")){ // Ustalar.txt dosyasına veri ekler.
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.


                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri); // Ustanın adı eklendi



                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


