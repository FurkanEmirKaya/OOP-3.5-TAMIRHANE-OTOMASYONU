import java.io.*;
import java.util.*;

public class Admin implements DosyaIslemleri {
    private String isim ;
    private String sifre ;
    private String eklenecekSehir;
    private String eklenecekSube;
    private String eklenecekUsta;
    Scanner scan = new Scanner(System.in);
    static SortedMap < String, String > SehirlerdenSubeleri = new TreeMap<>(); // Şehrin adı çağrıldığında o şehirdeki şubeler çağrılabilir. Hepsi ya da teker teker.
    static SortedMap < String, String > SubelerdenUstalari = new TreeMap<>(); // Şubenin adı çağrıldığında o şubedeki çalışan ustalar çağrılabilir. ArrayList.get("index");
    static ArrayList<String> subeler = new ArrayList<>(); // SortedMap üzerinden çağrıldığında şehirde ilgili indexte şube adı tutulur.
    static ArrayList<String> ustalar = new ArrayList<>(); // SortedMap üzerinden çağrıldığında şubede ilgili indexten usta adı tutulur.

    /// Constructor ///////////////////////////////////////////////////////////////
    public Admin() {

        isim = "Admin";
        sifre = "1937";

    }

    /// Metotlar /////////////////////////////////////////////////////////////////
    public final void adminCalistir(){ // Admini çalıştıran metot

        boolean enUstDongu = true; // Admin panelinin tekrar çalıştırılıp çalıştırılmamasını kontrol eden değişken

        while (enUstDongu) {

            System.out.println("1-Listeleme 2-Ekleme"); // Admin paneli çalıştırılıyor.
            String secim1 = scan.nextLine(); // Kullanıcının hangi admin paneli fonksiyonuna erişeceğini seçtiği değişken.

            if (Objects.equals(secim1, "1")) { // Listleme seçtiyse NOT: Burasının altı da bir metot haline getirilebilir.

                boolean donguKontrol = true; // Listemeden çıkış yapılıp yapılmayacağını kontrol eden değişken

                while (donguKontrol) {

                    sehirSubeVeUstalariListeleme(); // Şehir, şube ve ustaları listeleyen metot çağrıldı.
                    System.out.println("Listeleme fonksiyonunu kullanmaya devam etmek ister misiniz?"); //Kişi yanlış bir girdi yaptığında kod buraya geliyor.
                    System.out.println("1-Evet 2-Hayır"); // Devam edip edilmeyeceğini soruyor.
                    String secim2 = scan.nextLine(); // Seçim yapıyor.

                    if (Objects.equals(secim2, "1") || Objects.equals(secim2, "Evet")) { // Evet derse tekrardan listeleme ekranına devam ediliyor.

                        System.out.println("Listeme fonksiyonuna devam ediliyor.");

                    } else if (Objects.equals(secim2, "2") || Objects.equals(secim2, "Hayır")) { // Hayır derse döngüden çıkıyor. Adminlik arayüzünden çıkılıp çıkılmayacağı soruluyor.

                        donguKontrol = false;

                    } else if ((!(Objects.equals(secim2, "1") || Objects.equals(secim2, "Evet") && !(Objects.equals(secim2, "2") || Objects.equals(secim2, "Hayır"))))) {

                        System.out.println("Lütfen geçerli bir tuşlama yapınız."); // Yanlış girdi yapılırsa geçerli bir tuşlama yapılması gerektiğini söylüyor.

                    }

                }

            }
            if (Objects.equals(secim1, "2")) { // Eğer kullanıcı admin panelinde "2-Ekleme" seçerse buradan devam edilecek.

                addSehirSubeVeUstalar(); // Şehir, şube ve usta ekleme fonksiyonu çağrılıyor.

            }

            boolean adminliktenCikisDongusu = true; // NOT: Bu bir metota dönüştürülebilir.

            while(adminliktenCikisDongusu) {

                System.out.println("Adminlikten çıkmak ister misiniz?"); // Admin arayüzünden çıkılıp çıkılmayacağı soruluyor.
                System.out.println("1-Evet 2-Hayır");
                String secim3 = scan.nextLine();

                if (Objects.equals(secim3, "1") || Objects.equals(secim3, "Evet")) { // Kullanıcı evet derse adminlik panelinden çıkılıyor.

                    enUstDongu = false;
                    adminliktenCikisDongusu = false;

                } else if (Objects.equals(secim3, "2") || Objects.equals(secim3, "Hayır")) { // Kullanıcı hayır derse admin paneline tekrardan çalıştırılıyor.

                    System.out.println("Admin paneline geri dönülüyor.");
                    adminliktenCikisDongusu = false;

                } else if ((!(Objects.equals(secim3, "1") || Objects.equals(secim3, "Evet") && !(Objects.equals(secim3, "2") || Objects.equals(secim3, "Hayır"))))) {

                    System.out.println("Lütfen geçerli bir tuşlama yapınız."); // Kullanıcı hatalı bir tuşlama yapılırsa uyarı mesajı ekrana yazılıyor.

                }

            }

        }

    }

    public final void sehirSubeVeUstalariListeleme(){ // Kullanıcı listelemeyi seçince bu metot çağrılacak.

        System.out.println("Hangi dosyayı listelemek istersiniz?");
        System.out.println("1-Şehirler 2-Şubeler 3-Ustalar");
        String girdi = scan.nextLine(); // Kullanıcı hangi veriyi listemek istiyorsa onu giriyor.

        switch (girdi) { // Girdiye göre hangi dosyanın ekrana listeleneceğinin seçimi. Kişi yanlış bir

            case "1": // Kullanıcı ya 1 ya da Şehirler yazarak işlemi gerçekleştirebiliyor.

                System.out.println("~~~ Şehirler ~~~");
                dosyaOkuVeTxtEkranaYazdir("Sehirler.txt"); // DosyaIslemleri Interfacesinden çağrılan metot.
                break;

            case "Şehirler":

                System.out.println("~~~ Şehirler ~~~");
                dosyaOkuVeTxtEkranaYazdir("Sehirler.txt");

                break;

            case "2":

                System.out.println("~~~ Şubeler ~~~");
                dosyaOkuVeTxtEkranaYazdir("Subeler.txt");

                break;
            case "Şubeler":

                System.out.println("~~~ Şubeler ~~~");
                dosyaOkuVeTxtEkranaYazdir("Subeler.txt");
                break;

            case "3":

                System.out.println("~~~ Ustalar ~~~");
                dosyaOkuVeTxtEkranaYazdir("Ustalar.txt");
                break;

            case "Ustalar":

                System.out.println("~~~ Ustalar ~~~");
                dosyaOkuVeTxtEkranaYazdir("Ustalar.txt");
                break;

        }

    }

    public final void addSehirSubeVeUstalar(){ // Kullanıcı eklemeyi seçince bu metot çağrılacak.

        dosyaOkuVeTxtEkranaYazdir("Sehirler.txt");
        System.out.print("Eklemek istediğiniz şehri giriniz: "); // Şehir ekleme fonksiyonuna alınacak.
        setEklenecekSehir(scan.nextLine());
        txtDosyasinaEkle("Sehirler.txt", getEklenecekSehir()); // Kullanıcının girdiği şehir DosyaIslemleri Interfacesinden override edilen metotla dosyaya eklenir.

        int subeSayaci = 0; // En az bir kere şube eklendiğini kontrol etmemize yarayan değişken.

        while (subeSayaci < 1){

            System.out.print("Eklemek istediğiniz şubeyi giriniz: ");
            setEklenecekSube(scan.nextLine());
            txtDosyasinaEkle("Subeler.txt", getEklenecekSube());
            subeSayaci++; // En az bir kere şube girişi yapılmış oldu. Sayaç artırıldı.

            ustalarSecBolum(); // Girilen şubeye usta ekleyen metot.
            // BU ANDA
                boolean control5 = true; // Birden fazla şube eklemek istenme durumunu kontrol eden değişken.

                do {

                    System.out.println("Şube eklemeye devam etmek ister misiniz?: ");
                    System.out.println("1-Evet\n2-Hayır");
                    String cevap = scan.nextLine();

                    if (Objects.equals(cevap, "1") || Objects.equals(cevap, "Evet")) { // Kullanıcı Evet derse birden fazla şube eklemeye devam eder.
                        System.out.print("Eklemek istediğiniz şubeyi giriniz: ");
                        setEklenecekSube(scan.nextLine());
                        txtDosyasinaEkle("Subeler.txt", getEklenecekSube());
                        ustalarSecBolum(); // Eklenen şubeye ustaları ekler.

                    }

                    else if (Objects.equals(cevap, "2") || Objects.equals(cevap, "Hayır")) { // Kullanıcı Hayır derse şube eklemeye devam etmez.

                        control5 = false;

                    }
                    else if((!(Objects.equals(cevap, "1") || Objects.equals(cevap, "Evet") && !(Objects.equals(cevap, "2") || Objects.equals(cevap, "Hayır"))))){

                            System.out.println("Lütfen geçerli bir tuşlama yapınız."); // Kullanıcı yanlış bir değer girerse ekrana uyarı yazlırı ve şube eklemeye devam edilip edilmeyeceğini tekrar sorar..

                    }

                } while (control5);

        }
        // Buradan sonra SortedMap ile ilgili işlemler
        // dosyaOkuVeTxtEkranaYazdir("Subeler");


    }

    public final void ustalarSecBolum(){ // Ustalar bolümü seçim ve kontrol işlemleri


                        System.out.println("Eklemek istediğiniz ustanın adını giriniz: ");
                        setEklenecekUsta(scan.nextLine());
                        txtDosyasinaEkle("Ustalar.txt", getEklenecekUsta()); // DosyaIslemleri Interfacesinden override edilen metot çağrılır.
                        //Burada
                        sortedMapEkle(getEklenecekSehir(),getEklenecekSube(),getEklenecekUsta());

                        boolean control3 = true; // Usta ekleme işlemine devam edilip edilmeyeceğini kontrol eden değişken.

                            while (control3) {

                                System.out.println("Usta ekleme işlemine devam etmek ister misiniz?");
                                System.out.println("1-Evet 2-Hayır");
                                String cevap = scan.nextLine(); // Kullanıcıdan cevap alınır.


                                if (Objects.equals(cevap, "1") || Objects.equals(cevap, "Evet")) { // Kullanıcı evet derse tekra usta ekleme işlemine devam edilir.

                                    System.out.println("Eklemek istediğiniz ustanın adını giriniz:");
                                    setEklenecekUsta(scan.nextLine());
                                    txtDosyasinaEkle("Ustalar.txt", getEklenecekUsta());
                                    //Burada
                                    sortedMapEkle(getEklenecekSehir(),getEklenecekSube(),getEklenecekUsta());

                                }

                                else if (Objects.equals(cevap, "2") || Objects.equals(cevap, "Hayır")) { // Kullanıcı hayır derse usta ekleme işlemine devam edilmez.

                                    control3 = false;

                                }

                                else if((!(Objects.equals(cevap, "1") || Objects.equals(cevap, "Evet") && !(Objects.equals(cevap, "2") || Objects.equals(cevap, "Hayır"))))){

                                    System.out.println("Lütfen geçerli bir tuşlama yapınız."); // Kullanıcı yanlış bir tuşlama yaparsa hata mesajı alır ve tekrar usta ekleyip eklemeyeceği sorulur.

                                }
                            }
                            // BU ANDA

    }

    protected String ustaOzellikleriSecimYap(){ // Ustanın uzmanlık alanı ve tecrübesini seçtiren metot

        boolean control1 = true; // Uzmanlık alanı seçme döngü kontrolü
        String uzmanlik = null; // Ustanın uzmanlık alanı değişkeni

        do {

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
                    uzmanlik ="Elektrikçi";
                    control1 = false;
                    break;

                    case "Elektrikçi":

                        System.out.println("Elektrikci uzmanlık alanını sectiniz");
                        uzmanlik ="Elektrikçi";
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

            default:{ // Yanlış tuşlama yapıldığında default case çalışır ve döngü başa döner.

                System.out.println("YanLış tuşlama yaptınız lutfen tekrar deneyiniz.");
                               System.out.println("Sadece numara ya da uzmanlık alanının ismini girin!!");                    
                    }
            }
        } while (control1); // Uzmanlık alanı seçme döngü kontrolü

        boolean control2 = true; // Tecrübe seçme döngü kontrolü
        String tecrube = null; // Ustanın tecrübe değişkeni

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

                    case "Senior":

                        System.out.println("Senior tecrübesini sectiniz");
                        tecrube="Senior";
                        control2= false;
                        break;

                    case "3":

                        System.out.println("Master tecrübesini sectiniz");
                        tecrube ="Master";
                        control2= false;
                        break;

                    case "Master":

                        System.out.println("Master tecrübesini secriniz");
                        tecrube ="Master";
                        control2= false;
                        break;

                 default:{ // Yanlış tuşlama yapılınca default case çalışır.

                     System.out.println("Yanlış tuşlama yaptınız!!");
                     System.out.println("Lütfen sadece numara veya tecrübe adı giriniz!!!");

                 }

                }

         } while (control2); // Tecrübe seçme döngü kontrolü

         return uzmanlik +"\t"+ tecrube;

    }
    @Override
    public void sortedMapEkle(String mapeEklenecekSehir, String mapeEklenecekSube, String mapeEklenecekUsta){

        SehirlerdenSubeleri.put(mapeEklenecekSehir, mapeEklenecekSube);
        SubelerdenUstalari.put(mapeEklenecekSube, mapeEklenecekUsta);

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

    public String getEklenecekSehir() {
        return eklenecekSehir;
    }

    public void setEklenecekSehir(String eklenecekSehir) {
        this.eklenecekSehir = eklenecekSehir;
    }

    public String getEklenecekSube() {
        return eklenecekSube;
    }

    public void setEklenecekSube(String eklenecekSube) {
        this.eklenecekSube = eklenecekSube;
    }

    public String getEklenecekUsta() {
        return eklenecekUsta;
    }

    public void setEklenecekUsta(String eklenecekUsta) {
        this.eklenecekUsta = eklenecekUsta;
    }


    /// Interface Metotları ///////////////////////////////////////////////
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
    public void txtDosyasinaEkle(String dosyaAdi, String eklenecekVeri) {   ////// Bitti

        if(dosyaAdi.equals("Sehirler.txt")){ // Sehirler.txt dosyasına satır satır veri ekler.

            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.
                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri);
                writer.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

        else if(dosyaAdi.equals("Subeler.txt")){ // Subeler.txt dosyasına satır satır veri ekler.

            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.
                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri);
                writer.close();

            } catch (IOException e) {

                e.printStackTrace();

            }
        }

        else if(dosyaAdi.equals("Ustalar.txt")){ // Ustalar.txt dosyasına satır satır veri ekler.

            try {

                BufferedWriter writer = new BufferedWriter(new FileWriter(dosyaAdi, true));  // Kodu sonradan değiştirilebilir olarak açar.

                writer.newLine(); // Yeni satır ekler.
                writer.write(eklenecekVeri + "\t" + ustaOzellikleriSecimYap()); // Veri eklenirken Ustanın adı, uzmanlık alanı ve tecrübesi eklendi.

                writer.close();

            } catch (IOException e) {

                e.printStackTrace();

            }

        }

    }

}


