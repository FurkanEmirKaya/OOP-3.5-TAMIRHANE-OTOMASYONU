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
                  parcalar.add(0,100);
                  parcalar.add(1,46);
                  parcalar.add(2,89);
                  parcalar.add(3,12);
                  parcalar.add(4,18);
                  parcalar.add(5,81);
                  parcalar.add(6,45);
                  parcalar.add(7,67);
                  parcalar.add(8,76);
                  parcalar.add(9,34);
                  parcalar.add(10,23);
                  parcalar.add(11,50);
                  parcalar.add(12,54);
                  parcalar.add(13,71);
                  parcalar.add(14,4);
                  parcalar.add(15,5);
                  parcalar.add(16,7);
                  parcalar.add(17,29);
                  parcalar.add(18,38);
                  parcalar.add(19,90);
                  parcalar.add(20,42);
                  parcalar.add(21,38);
                  parcalar.add(22,61);
                  parcalar.add(23,2);
                  parcalar.add(24,69);
                  parcalar.add(25,77);
                  parcalar.add(26,10);
                  parcalar.add(27,100);
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
              System.out.println("1-Parça sipariş et\n2-Parça sipariş etmeden devam et");
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
                    System.out.println("1-Parça sipariş et\n2-Parça sipariş etmeden devam et");
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

    public void siparisler() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("Depo.txt"));
        if(gettamir()==1||gettamir()==2||gettamir()==3){
            int lineCounter=1;
            StringBuffer sb = new StringBuffer();
               while(lineCounter<=27){
                   sb.append(reader.readLine());
                   sb.append("\n");
                   lineCounter++;
               }

               do {
                   System.out.println(sb);
                   parcaSecim();
                   setParcaFiyat(100 * adet);
               }while (control200);
        }
    }

           boolean control200;
            int answer;
              int adet;
          public void parcaSecim() throws IOException {
             System.out.println("Seçmek istediğiniz parçanın numarasını giriniz : ");
              System.out.println();
                 answer = scan.nextInt();
                   System.out.println(answer+" parçasından "+parcalar.get(answer-1)+" adet vardır!") ;
                   System.out.println("Kaç adet sipariş etmek istersiniz?");
                    adet  = scan.nextInt();
                        if(adet>parcalar.get(answer)){
                            System.out.println("İstediğiniz parçadan depoda bulunmamaktadır!! ");
                            System.out.println("Lutfen farklı bir parça seçin :");
                            control200=true;
                        }else {
                            System.out.println("Siparişiniz başarı ile alınmıştır.");
                            control200=false;
                        }

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
