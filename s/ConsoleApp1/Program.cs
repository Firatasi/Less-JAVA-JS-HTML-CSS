using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace ConsoleApp1
{
    class Program
    {

        struct Ogrenci
        {
            public int okulNo;
            public string ad;
            public string soyAd;
            public string dersAd;
            public byte vize;
            public byte final;
            public double ortalama;
        }

        public static string yol = @"C:\Users\FIRAT\source\repos\ConsoleApp1\ConsoleApp1\bin\Debug" + @"\okul.txt";

        static void Main(string[] args)
        {
           
            while (true)
            {
                Console.Clear();
                Console.BackgroundColor = ConsoleColor.DarkYellow;
                Console.ForegroundColor = ConsoleColor.White;
                Console.Clear();

                Console.SetCursorPosition(10, 2); //konsoldaki yazının konumunu belirler.
                Console.Write("1- Kayıt");

                Console.SetCursorPosition(10, 3); //konsoldaki yazının konumunu belirler.
                Console.Write("2- Liste");

                Console.SetCursorPosition(10, 4); //konsoldaki yazının konumunu belirler.
                Console.Write("3- Arama");

                Console.SetCursorPosition(10, 5); //konsoldaki yazının konumunu belirler.
                Console.Write("4- Çıkış");

                Console.SetCursorPosition(10, 6); //konsoldaki yazının konumunu belirler.
                Console.Write("5- Silme");

                int sec;
                Console.SetCursorPosition(5, 7);

                Console.Write("Seçiminizi giriniz: ");
                sec = Convert.ToInt16(Console.ReadLine());
               

                switch (sec)
                {
                    case 1:
                        kayitYap();
                        break;

                    case 2:
                        liste();
                        break;

                    case 3:
                        arama();
                        break;

                    case 4:
                        System.Environment.Exit(1);
                        break;

                    case 5:
                        silme();
                        break;

                    default:
                        break;


                }
                
            }



        }

        public static void kayitYap()
        {
            Ogrenci kayit;
            Console.Clear();
            StreamWriter dosya1 = File.AppendText(yol);

            Console.SetCursorPosition(10, 2);
            Console.Write("Okul numarası: ");
            kayit.okulNo = int.Parse(Console.ReadLine());

            Console.SetCursorPosition(10, 3);
            Console.Write("Adınızı giriniz: ");
            kayit.ad = Console.ReadLine();

            Console.SetCursorPosition(10, 4);
            Console.Write("Soyadınızı giriniz: ");
            kayit.soyAd = Console.ReadLine();

            Console.SetCursorPosition(10, 5);
            Console.Write("Ders adını giriniz: ");
            kayit.dersAd = Console.ReadLine();

            Console.SetCursorPosition(10, 6);
            Console.Write("Vize notunuzu giriniz: ");
            kayit.vize = byte.Parse(Console.ReadLine());

            Console.SetCursorPosition(10, 7);
            Console.Write("Final notunuzu giriniz: ");
            kayit.final = byte.Parse(Console.ReadLine());

            kayit.ortalama = (kayit.vize * 0.4) + (kayit.final * 0.6);
            

            dosya1.Write(kayit.okulNo + "-");
            dosya1.Write(kayit.ad + "-");
            dosya1.Write(kayit.soyAd + "-");
            dosya1.Write(kayit.dersAd + "-");
            dosya1.Write(kayit.vize + "-");
            dosya1.Write(kayit.final + "-");
            dosya1.Write(kayit.ortalama);
            dosya1.WriteLine();

            dosya1.Close();
        }

        public static void liste()
        {
            Console.Clear();


            Console.SetCursorPosition(5, 1);
            Console.Write("OKUL NO");

            Console.SetCursorPosition(15, 1);
            Console.Write("AD");

            Console.SetCursorPosition(25, 1);
            Console.Write("SOYAD");

            Console.SetCursorPosition(40, 1);
            Console.Write("DERS ADI");

            Console.SetCursorPosition(55, 1);
            Console.Write("ORTALAMA");

            Console.SetCursorPosition(5, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(15, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(25, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(40, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(55, 2);
            Console.Write("----------------");

            int satir = 3;
            int sss;

            StreamReader dosya2 = File.OpenText(yol);
            string oku = dosya2.ReadLine();// dosya2 yi okur 

            while(oku != null)
            {
                sss = satir++;
                string[] p = oku.Split('-'); // - ye göre ayırır 
                Console.SetCursorPosition(5, sss); Console.Write(p[0]);

                Console.SetCursorPosition(15, sss); Console.Write(p[1]);

                Console.SetCursorPosition(25, sss); Console.Write(p[2]);

                Console.SetCursorPosition(40, sss); Console.Write(p[3]);

                Console.SetCursorPosition(55, sss); Console.Write(p[4]);

                oku = dosya2.ReadLine();

            }

            dosya2.Close();
            Console.ReadKey();

        }

        public static void arama()
        {
            Console.Clear();

            Console.SetCursorPosition(10, 2); Console.Write("Aradığınız Okul Numarasını Giriniz: ");
            string findName = Console.ReadLine();

            Console.Clear();


            Console.SetCursorPosition(5, 1);
            Console.Write("OKUL NO");

            Console.SetCursorPosition(15, 1);
            Console.Write("AD");

            Console.SetCursorPosition(25, 1);
            Console.Write("SOYAD");

            Console.SetCursorPosition(40, 1);
            Console.Write("DERS ADI");

            Console.SetCursorPosition(55, 1);
            Console.Write("ORTALAMA");

            Console.SetCursorPosition(5, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(15, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(25, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(40, 2);
            Console.Write("----------------");

            Console.SetCursorPosition(55, 2);
            Console.Write("----------------");

            int satir = 3;
            int sss;

            StreamReader dosya2 = File.OpenText(yol);
            string oku = dosya2.ReadLine();// dosya2 yi okur 

            while (oku != null)
            {
                sss = satir++;
                string[] p = oku.Split('-'); // - ye göre ayırır 
                if(findName == p[0])
                {
                    Console.SetCursorPosition(5, sss); Console.Write(p[0]);

                    Console.SetCursorPosition(15, sss); Console.Write(p[1]);

                    Console.SetCursorPosition(25, sss); Console.Write(p[2]);

                    Console.SetCursorPosition(40, sss); Console.Write(p[3]);

                    Console.SetCursorPosition(55, sss); Console.Write(p[4]);
                }

                oku = dosya2.ReadLine();

            }

            dosya2.Close();
            Console.ReadKey();
   
        }


    }
}
