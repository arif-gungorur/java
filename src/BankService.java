package src;

import java.util.Scanner;

public class BankService {
    private static final char A = 0;
    static String kartNo="12" ;
    static String sifre="12";
    static double bakiye = 45  ;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String bankNo ="";
        String password ="";

        do {

            System.out.println("Lutfen kart numaranızı giriniz");
            bankNo = scan.nextLine();
            System.out.println("sifrenizi giriniz");
            password = scan.nextLine();
            if (!bankNo.equals(kartNo) || !password.equals(sifre)) {
                System.out.println("Bilgileriniz yanlıs tekrar deneyiniz");
            }
            System.out.println();



        } while (!bankNo.equals(kartNo) || !password.equals(sifre) );

        ekran();

    }

    private static void ekran() {
        char secim =' ';
        do {

            System.out.println("Lutfen yapmak istediğiniz islemi seciniz \n A-Bakiye Sorma \n B-Para Cekme \n C-Para Yatirma \n D-Para Gönderme \n E-Sifre Degistir \n F-Cıkıs");
            secim = scan.next().toUpperCase().charAt(0);

            switch (secim) {
                case 'A' :
                    bakiyeSorma();
                    break;
                case 'B' :
                    paraCekme();
                    break;
                case 'C' :
                    paraYatirma();
                    break;
                case 'D' :
                    paraGonderme();
                    break;
                case 'E' :
                    sifreDegistir();
                    break;
                case 'F' :
                    Cikis();
                    break;
                default:
                    System.out.println("lutfen gecerli bir islem seciniz");
                    break;
            }
        } while (secim!='F');



    }

    private static void Cikis() {
        System.out.println("Bizi tercih ettiğiniz için teşekkürler");

    }

    private static void sifreDegistir() {

        System.out.println("Mevcut sifrenizi giriniz");
        String teyitSifre= scan.next();
        if (teyitSifre.equals(sifre)) {
            System.out.println("Yeni sifrenizi giriniz");
            String yeniSifre= scan.next();
            sifre=yeniSifre ;
            System.out.println("İsleminiz Basarili");

        }
        else {
            System.out.println("sifrenizi yanlis girdiniz");
        }


    }



    private static void paraGonderme() {
        System.out.println("alıcinin ibanini giriniz");
        String aliciIban = scan.next();
        if (aliciIban.startsWith("TR") && aliciIban.length()==4) {
            System.out.println("Gonderilecek Tutari Giriniz");
            double gonderilecekTutar = scan.nextDouble();
            if (gonderilecekTutar<=bakiye) {
                bakiye-=gonderilecekTutar ;
                System.out.println("İsleminiz Basarili \nMevcut Bakiyeniz ="+ bakiye);
                System.out.println();
            }
            else {
                System.out.println("yetersiz bakiye");
            }

        }else {
            System.out.println("Iban no hatalı girdiniz, tekrar deneyiniz");
        }

    }

    private static void paraYatirma() {
        System.out.println("yatiracaginiz tutari giriniz");
        double yatirilacakTutar = scan.nextDouble();
        bakiye += yatirilacakTutar ;
        System.out.println("İsleminiz Basarili \nMevcut Bakiyeniz ="+ bakiye);
        System.out.println();

    }

    private static void paraCekme() {
        System.out.println("cekeceğiniz tutari giriniz");
        double cekilecekTutar = scan.nextDouble();
        if (cekilecekTutar<=bakiye) {
            bakiye-=cekilecekTutar ;
            System.out.println("İsleminiz Basarili \nMevcut Bakiyeniz ="+ bakiye);
            System.out.println();
        }

        else {
            System.out.println("bakiyeniz yetersizdir");


        }

    }

    private static void bakiyeSorma() {
        System.out.println("Mevcut bakiyeniz =" + bakiye);

    }



}




