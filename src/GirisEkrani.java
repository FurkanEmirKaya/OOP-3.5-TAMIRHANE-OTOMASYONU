import java.util.Objects;
import java.util.Scanner;

public class GirisEkrani implements KontrolMetodlari{
    Scanner scan = new Scanner(System.in);
    Admin a = new Admin();
    boolean adminlik; // Admin olarak giriş yapılıp yapılmadığını kontrol eden değişken
    protected  void girisEkrani(){ // Program başlangıcı.

        System.out.println("Sisteme hoşgeldiniz!");

        do {

            System.out.println("1-Kullanıcı 2-Admin");
            System.out.println("Giriş şeklini seçiniz: ");
            String girdi = scan.nextLine();

            if (girdi.equals("1") || girdi.equalsIgnoreCase("Kullanıcı")) { // Kullanıcı girişi seçildi.
                //Kullanıcı kontrol ve metotları. İçi doldurulacak.
                adminlik = false;




            }

            if (girdi.equals("2") || girdi.equalsIgnoreCase("Admin")) { // Admin girişi seçildi.

                boolean kullaniciKontrol;

                do {

                    System.out.print("Admin adı:"); // Kullanıcıdan Admin adı ve şifrenin alınması
                    String isim = scan.nextLine();
                    System.out.print("Admin şifresi:");
                    String sifre = scan.nextLine();

                    if (Objects.equals(isim, a.getIsim()) && Objects.equals(sifre, a.getSifre())) { // Admin adı ve şifre kontrolü

                        System.out.println("Admin olarak sisteme giriş yaptınız!!");
                        adminlik = true;
                        kullaniciKontrol = false;
                    } else {

                        System.out.println("Kullanıcı adı veya şifre hatalı!\nTekrar giriş yapınız!");

                        kullaniciKontrol = true;
                    }
                } while (kullaniciKontrol); // Kullanıcının admin girişini doğru yapıp yapmamasına göre boolean değer döner.

            }

            if(adminlik){ // Eğer kullanıcı doğru giriş yaptıysa adminlik işlemlerine buradan devam ediyor.

                a.adminCalistir(); // Admin arayüzü çalıştırılıyor.

            }

        }while (false) ; // Bütün kodlar buraya yazılacak. Bütün kodu bitirme ya da tekrar başlatma için


    }



/// KontrolMetodlari Interfacesi ////////////////////////////////////////////////

    @Override
    public void girdiKontrol(String girdi) {


}

    @Override
    public boolean booleanKontrol() {
        return false;
    }
}
