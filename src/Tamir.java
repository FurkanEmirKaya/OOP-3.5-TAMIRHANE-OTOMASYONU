import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public  class Tamir {
       Scanner scan = new Scanner(System.in);
       //Sipariş edip mi yoksa etmeden mi devam ettiğini kontrol eden değişken sadece 2 tane durum olduğu için bool deger kulllanıldı
       private boolean turID;
        //Hangi tur tamir işlemini sectiğini kontrol eden değişkenler 3 tane kontrol olduğu için int kullanıldı
        private int tamir=0;
        private int parcaSayisi;
        private int parcaFiyat;
        ArrayList<Integer> parcalar = new ArrayList<>();
              public void parcalarSayisiEkle(){
                  parcalar.add(100);
                  parcalar.add(46);
                  parcalar.add(89);
                  parcalar.add(12);
                  parcalar.add(18);
                  parcalar.add(81);
                  parcalar.add(45);
                  parcalar.add(67);
                  parcalar.add(76);
                  parcalar.add(34);
                  parcalar.add(23);
                  parcalar.add(50);
                  parcalar.add(54);
                  parcalar.add(71);
                  parcalar.add(4);
                  parcalar.add(5);
                  parcalar.add(7);
                  parcalar.add(29);
                  parcalar.add(38);
                  parcalar.add(90);
                  parcalar.add(42);
                  parcalar.add(38);
                  parcalar.add(61);
                  parcalar.add(2);
                  parcalar.add(69);
                  parcalar.add(77);
                  parcalar.add(10);
                  parcalar.add(100);
              }
      public void tamirEkrani() throws IOException {//Tamir ekranı
               parcalarSayisiEkle();
                  System.out.println("------------- Tamir ekranına -----------");
              System.out.println("Seçmek istediğiniz tamir işleminin turunu seçiniz");
              islemler();
               if(gettamir()==1){
                   mekanikTamir();
                   if(getturID()){
                       siparisler();
                       System.out.println("Borcunuz "+fiyat()+" TL dir");
                   }else {
                       System.out.println("Borcunuz "+fiyat()+" TL dir");
                   }
               } else if (gettamir()==2) {
                   elektrikAksam();
                       if (getturID()){
                           siparisler();
                           System.out.println("Borcunuz "+fiyat()+" TL dir");
                       }else {
                           System.out.println("Borcunuz "+fiyat()+" TL dir");
                       }
               } else if (gettamir()==3) {
                   kaportaTamir();
                   if (getturID()){
                       siparisler();
                       System.out.println("Borcunuz "+fiyat()+" TL dir");
                   }else {
                      System.out.println("Borcunuz "+fiyat()+" TL dir");
                   }
               }
      }
    public void islemler(){
        boolean control12=true;
        System.out.println("1-Mekanik tamiri\n2-Elektrik aksam\n3-Kaporta");
        int yanit = scan.nextInt();
        do {
            switch (yanit){
                case 1:
                    System.out.println("Mekanik tamiri seçtiniz.");
                    control12=false;
                    settamir(1);
                    break;
                case 2:
                    System.out.println("Elektrik aksam tamirini seçtiniz.");
                    control12=false;
                    settamir(2);
                    break;
                case 3:
                    System.out.println("Kaporta tamir işlemlerini seçtiniz.");
                    control12=false;
                    settamir(3);
                    break;
                default: System.out.println("Yanlış tuşlama yaptınız!!");
            }

        }while (control12);

    }

          public void mekanikTamir(){
              boolean control100=true;
              
          do {
              System.out.println("1-Parça sipariş et\n 2-Parça sipariş etmeden devam et");
              int answer = scan.nextInt();
              switch (answer){
                  case 1:
                      System.out.println("Parça sipariş et işlemini seçtiniz.");
                            control100=false;
                           setturID(true);
                      break;
                  case 2:
                      System.out.println("Sipariş etmeden devam ediliyor.");
                          control100=false;
                         setturID(false);
                      break;
                  default:System.out.println("Yanlış tuşlama yaptınız !!!");
                   }
          }while (control100);
               }
            public void elektrikAksam(){
                 
                   boolean control101=true;
                do {
                    System.out.println("1-Parça sipariş et\n2-Parça sipariş etmeden devam et");
                    int yanit = scan.nextInt();
                    switch (yanit){
                        case 1:
                            System.out.println("Parça sipariş et işlemini seçtiniz.");
                              control101=false;
                      setturID(true);
                            break;
                        case 2:
                            System.out.println("Sipariş etmeden devam ediliyor.");
                            control101=false;
                                setturID(false);
                            break;
                        default:System.out.println("Yanlış tuşlama yaptınız !!!");
                    }
                }while (control101);
            }
            public void kaportaTamir(){
                  
                    boolean control102 = true; 
              do {
                    System.out.println("1-Parça sipariş et\n 2-Parça sipariş etmeden devam et");
                    int answer = scan.nextInt();
                    switch (answer){
                        case 1:
                            System.out.println("Parça sipariş et işlemini seçtiniz.");
                            control102=false;
                               setturID(true);
                            break;
                        case 2:
                            System.out.println("Sipariş etmeden devam ediliyor.");
                            control102=false;
                                setturID(false);
                            break;
                        default:System.out.println("Yanlış tuşlama yaptınız !!!");
                    }
                }while (control102);
            }
    String depo ;
    public void siparisler() throws IOException {//TurID ye gore parca listeleme
        BufferedReader reader = new BufferedReader(new FileReader("Depo.txt"));
        if(gettamir()==1){
            int lineCounter=1;
               while(lineCounter<=10){
                   depo += reader.readLine()+"\n";
                   lineCounter++;
                  }
               System.out.println(depo);
                    parcaSecim();
                    setParcaFiyat(100*adet);
                  } else if (gettamir()==2) {
               int lineCounter =11;
                      while (10<lineCounter&&lineCounter<=19){
                          depo += reader.readLine()+"\n";
                          lineCounter++;
                      }
                      System.out.println(depo);
                      parcaSecim();
                      setParcaFiyat(100*adet);

                  } else if (gettamir()==3) {
            int lineCounter = 20;
                      while(19<lineCounter&&lineCounter<=27){
                          depo += reader.readLine()+"\n";
                          lineCounter++;
                      }
                      System.out.println(depo);
                      parcaSecim();
                      setParcaFiyat(100*adet);
                  }

    }
            int answer;
              int adet;
          public void parcaSecim() throws IOException {
             System.out.println("Seçmek istediğiniz parçanın adını giriniz : ");
              System.out.println();
                 answer = scan.nextInt();
                   System.out.println(answer+" parçasından "+parcalar.indexOf(answer-1)+" adet vardır!") ;
                   System.out.println("Kaç adet sipariş etmek istersiniz?");
                    adet  = scan.nextInt();
                      System.out.println("Siparişiniz başarı ile alınmıştır.");
                     }



               public int fiyat(){//secilen parcalara gore fiyat cıkarma String tecrube ustanun gerekli

                          return 1000+getParcaFiyat();
                            }
    public boolean getturID() {
        return turID;
    }

    public void setturID(boolean turID) {
        this.turID = turID;
    }
    public int gettamir() {
        return tamir;
    }

    public void settamir(int tamir) {
        this.tamir = tamir;
    }

    public int getParcaSayisi() {
        return parcaSayisi;
    }

    public void setParcaSayisi(int parcaSayisi) {
        this.parcaSayisi = parcaSayisi;
    }

    public int getParcaFiyat() {
        return parcaFiyat;
    }

    public void setParcaFiyat(int parcaFiyat) {
        this.parcaFiyat = parcaFiyat;
    }
}
