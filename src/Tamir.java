import java.util.Scanner;

public abstract class Tamir {
       Scanner scan = new Scanner(System.in);
       //Sipariş edip mi yoksa etmeden mi devam ettiğini kontrol eden değişken sadece 2 tane durum olduğu için bool deger kulllanıldı
       private boolean turID;
        //Hangi tur tamir işlemini sectiğini kontrol eden değişkenler 3 tane kontrol olduğu için int kullanıldı
        private int tamir=0;
      public void tamirEkrani() {//Tamir ekranı
               System.out.println("Tamir ekranına Hoş geldiniz");
              System.out.println("Seçmek istediğiniz tamir işleminin turunu seçiniz");
              islemler();
               if(gettamir()==1){
                   mekanikTamir();
                   if(getturID()){
                       siparisler();
                       fiyat();
                   }else {
                      fiyat();
                   }
               } else if (gettamir()==2) {
                   elektrikAksam();
                       if (getturID()){
                           siparisler();
                           fiyat();
                       }else {
                           fiyat();
                       }
               } else if (gettamir()==3) {
                   kaportaTamir();
                   if (getturID()){
                       siparisler();
                       fiyat();
                   }else {
                       fiyat();
                   }
               }
      }
    public void islemler(){
        boolean control12=true;
        System.out.println("1-Mekanik tamiri\n2-Elektrik aksam\n3-Kaporta");
        String yanit = scan.next();
        do {
            switch (yanit){
                case "1":
                    System.out.println("Mekanik tamiri seçtiniz.");
                    control12=false;
                    settamir(1);
                    break;
                case "2":
                    System.out.println("Elektrik aksam tamirini seçtiniz.");
                    control12=false;
                    settamir(2);
                    break;
                case "3":
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
              String answer = scan.nextLine();
              switch (answer){
                  case "1":
                      System.out.println("Parça sipariş et işlemini seçtiniz.");
                            control100=false;
                           setturID(true);
                      break;
                  case "2":
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
                    System.out.println("1-Parça sipariş et\n 2-Parça sipariş etmeden devam et");
                    String answer = scan.nextLine();
                    switch (answer){
                        case "1":
                            System.out.println("Parça sipariş et işlemini seçtiniz.");
                              control101=false;
                      setturID(true);
                            break;
                        case "2":
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
                    String answer = scan.nextLine();
                    switch (answer){
                        case "1":
                            System.out.println("Parça sipariş et işlemini seçtiniz.");
                            control102=false;
                               setturID(true);
                            break;
                        case "2":
                            System.out.println("Sipariş etmeden devam ediliyor.");
                            control102=false;
                                setturID(false);
                            break;
                        default:System.out.println("Yanlış tuşlama yaptınız !!!");
                    }
                }while (control102);
            }
            
    public void siparisler(){//TurID ye gore parca listeleme
             
             }
               public void fiyat(){//secilen parcalara gore fiyat cıkarma String tecrube ustanun gerekli

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

}
