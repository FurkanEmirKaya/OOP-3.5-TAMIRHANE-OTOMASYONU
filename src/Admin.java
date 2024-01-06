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
          while (subeSayaci<1){
            System.out.print("Eklemek istediğiniz şubeyi giriniz: ");
            String eklenecekSube = scan.nextLine();
            txtDosyasinaEkle("Subeler.txt", eklenecekSube);
            subeSayaci++;
               ustalarSecBolum();
               if(subeSayaci>1) {
                boolean control5 = true;
                do {
                    System.out.println("Şube eklemeye devam etmek ister misiniz?: ");
                    System.out.println("1-Evet\n2-Hayır");
                    String cevap = scan.nextLine();
                    if (cevap == "1" || cevap == "Evet") {
                        System.out.print("Eklemek istediğiniz şubeyi giriniz: ");
                        eklenecekSube = scan.nextLine();
                        txtDosyasinaEkle("Subeler.txt", eklenecekSube);
                        ustalarSecBolum();
                        control5 = true;
                    } else if (cevap == "2" || cevap == "Hayır") {
                        control5 = false;
                    }
                } while (control5);
            }
        }




        // Buradan sonra HashMap
       // dosyaOkuVeTxtEkranaYazdir("Subeler");
    }

                public final void ustalarSecBolum(){ //Ustalar boılumu secim ve kontrol işlemleri

                    int ustaSayaci = 0;
                    while (ustaSayaci < 2) {
                        System.out.println("Eklemek istediğiniz ustanın adını giriniz: ");
                        String eklenecekUsta = scan.nextLine();
                        txtDosyasinaEkle("Ustalar.txt", eklenecekUsta);
                        ustaSayaci++;
                        boolean control3 = true;
                        if (ustaSayaci >= 2) {
                            while (control3) {
                                System.out.println("Usta ekleme işlemine devam etmek ister misiniz?");
                                System.out.println("1-Evet 2-Hayır");
                                String cevap = scan.nextLine();
                                if (Objects.equals(cevap, "1") || Objects.equals(cevap, "Evet")) {
                                    System.out.println("Eklemek istediğiniz ustanın adını giriniz:");
                                    eklenecekUsta = scan.nextLine();
                                    txtDosyasinaEkle("Ustalar.txt", eklenecekUsta);
                                }  if (Objects.equals(cevap, "2") || Objects.equals(cevap, "Hayır")) {
                                    control3 = false;
                                }  else{
                                    System.out.println("Lütfen geçerli bir tuşlama yapınız.");
                                }
                            }
                        }

                    }
                }
    protected String ustaSecimYap(){
         boolean control1 = true;
         String uzmanlik = null;
       do{
        System.out.println("Ustanın uzmanlık alanını seçiniz: ");
        System.out.println("1-Mekanik\n2-Elektrikçi\n3-Kaportacı");
        String secim = scan.nextLine(); 
        switch (secim){
            case "1":
                System.out.println("Mekanik uzmanlık alanını seçtiniz.");
                uzmanlik ="Mekanik";
                control1 = false;
                break;
            case "Mekanik":
                System.out.println("Mekanik uzmanlık alanını seçtiniz.");
                uzmanlik ="Mekanik";
                control1 = false;
                break;
            case "2":
                System.out.println("Elektrikci uzmanlık alanını sectiniz");
                uzmanlik ="Elektrikci";
                control1 = false;
                break;
            case "Elektrikçi":
                System.out.println("Elektrikci uzmanlık alanını sectiniz");
                uzmanlik ="Elektrikci";
                control1 = false;
                break;
            case "3":
                System.out.println("Kaportacı uzmanlık alanı sectiniz");
                uzmanlik ="Kaportacı";
                control1 = false;
                break;
            case "Kaportacı":
                System.out.println("Kaportacı uzmanlık alanı sectiniz");
                uzmanlik ="Kaportacı";
                control1 = false;
                break;
            default:{
                     System.out.println("Yalnış tuşlama yaptınız lutfen tekrar deneyiniz.");
                               System.out.println("Sadece numara ya da uzmanlık alanının ismini girin!!");                    
                    }
            }
        }while (control1);
            boolean control2 = true;
            String tecrube = null;
            do {
             System.out.println("Ustanın tecrübesi nedir?: ");
             System.out.println("1-Junior(1-3 yıl)\n2-Senior(3-10 yıl)\n3-Master(10+ yıl)");
              String girdi = scan.nextLine();
             switch (girdi){
                 case "1":
                     System.out.println("Junior tecrübesini sectiniz");
                      tecrube="Junior";
                     control2= false;
                     break;
                 case "Junior":
                     System.out.println("Junior tecrübesini sectiniz");
                     tecrube="Junior";
                     control2= false;
                     break;
                 case "2":
                     System.out.println("Senior tecrübesini sectiniz");
                     tecrube="Senior";
                     control2= false;
                     break;
                 case"Senior":
                     System.out.println("Senior tecrübesini sectiniz");
                     tecrube="Senior";
                     control2= false;
                     break;
                 case"3":
                     System.out.println("Master tecrübesini sectiniz");
                     tecrube ="Master";
                     control2= false;
                     break;
                 case"Master":
                     System.out.println("Master tecrğbesini secriniz");
                     tecrube ="Mater";
                     control2= false;
                     break;
                 default:
                       {  System.out.println("Yanlış tuşlama yaptınız!!");
                          System.out.println("Lütfen sadece numara veya tecrübe adı giriniz!!!");
                                       }
             }

         }while (control2);

         return uzmanlik +"\t"+ tecrube;
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
    public void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri) {   ////// Bitti
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
                writer.write(eklenecekVeri + ustaSecimYap()); // Ustanın adı eklendi


                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


