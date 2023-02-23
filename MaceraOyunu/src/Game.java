import java.util.Scanner;

public class Game {
    private Scanner input = new Scanner(System.in);
    public void start(){
        System.out.println("Macera Oyununa Hoş Geldiniz");
        System.out.println("Lütfen bir isim giriniz: ");
        //String playerName = input.nextLine();
        Player player = new Player("YGG");
        System.out.println("Sayın " + player.getName() + ", bu karanlık ve sisli adaya Hoş Geldiniz! Burada yaşananların hepsi gerçektir.");
        System.out.println("Lütfen bir karakter seçiniz.");
        System.out.println("-------------------------------------------------------------");
        player.selectChar();
        //HAYATTA KALDIĞIMIZ SÜRECE ÖLENE KADAR KULLANICIYA BİR MEKAN SORMAK ZORUNDAYIZ

        Location location = null;
        while(true) {
            player.printInfo();
            System.out.println();
            System.out.println("####### Bölgeler #######");
            System.out.println();
            System.out.println("1 - Güvenli Ev --> Nurası sizin için güvenli bölge. Düşman yok!");
            System.out.println("2 - Eşya Dükkanı --> Silah veya zırh satın alabilirsiniz.");
            System.out.println("3 - Mağara --> Ödül <Yemek>, dikkatli ol karşına Zombi çıkabilir!");
            System.out.println("4 - Orman --> Ödül <Odun>, dikkatli ol karşına Vampir çıkabilir!");
            System.out.println("5 - Nehir --> Ödül <Su>, dikkatli ol karşına Ayı çıkabilir!");
            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player); //Location'ı refereans alıyor ama ToolHouse şeklinde davranıyor.
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge seçiniz!");;
            }
            if(location == null){
                System.out.println("Oyun Bitti.");
                break;
            }
            if (!location.onLocation()) { //onLocation methodu sayesinde çağırdık.
                System.out.println("GAME OVER!");
                break;
            }
        }
    }
}
