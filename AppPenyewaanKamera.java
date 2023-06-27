package bahasapemrograman2;
import java.util.Scanner;
public class AppPenyewaanKamera {
    public static void main(String[]args){ 
        Scanner sc= new Scanner(System.in);
        cMember mbr[] = new cMember[3];
        mbr[0]= new cMember();
        mbr[0].setNama("Ardilla Firosya");
        mbr[0].setAlamat("Ds.Pademawu Barat");
        mbr[0].setNoTelp("0816777898");
                
        cKamera kmr[] = new cKamera[4];
        //buat object daftar
        kmr[0]= new cKamera("Analog","1","Sony");
        kmr[1]= new cKamera("DSLR","1","Canon");
        kmr[2]= new cKamera("Point and Shoot","1","Panasonyc");
        kmr[3]= new cKamera("Mirrorless","1","FujiFilm");
       
        
        //satu object Transakasi untuk 1 cust dan banyak kamera
        cTransaksi tr[]=new cTransaksi[3];
        
        //variable pendukung
        int jmbr,jkmr,jtr = 0; //untuk menyimpan indeks array object di main
        int pilih, pilih2;
        //array of object di main
        int maksmember= 3, makskmr=4, makstr=3;
        //inisialisasi jumlah object tiap array
        jmbr=1;jkmr=2;
        
        do{

                System.out.println("--Selamat Datang di Penyewaan Kamera--");
                System.out.println("1.Member");
                System.out.println("2.Kamera");
                System.out.println("3.Transaksi");
                System.out.println("4.Selesai");
                System.out.println("Pilih = ");
                pilih = sc.nextInt();
                switch(pilih){
                    case 1:
                        System.out.println("Sub Menu Member");
                        System.out.println("1. Tambah Member");
                        System.out.println("2. Hapus Member");
                        System.out.println("3. Update Member");
                        System.out.println("4. Cetak Data");
                        System.out.println("Pilih= ");
                        pilih2=sc.nextInt();
                        System.out.println("");
                        switch(pilih2){
                            case 1:
                            System.out.println("==Tambah Customer==");
                            //jumlah cust masih di bawah kapasitas maksimal
                            if(jmbr<maksmember){ 
                            System.out.print("Masukkan Nama = ");
                            sc = new Scanner(System.in);
                            String nama = sc.nextLine();
                            System.out.print("Masukkan Alamat = ");
                            String alamat =sc.nextLine();
                            String notelp="";
                            //cek apakah NoTelp sdh dipakai
                            boolean sudahada;
                            do{
                            System.out.print("Masukkan NoTelepon = ");
                            notelp = sc.next();
                            System.out.println("");
                            sudahada=false;
                            for (int i = 0; i < jmbr; i++) {
                            if(mbr[i].getNoTelp().equalsIgnoreCase(notelp)){
                            sudahada=true;
                           break;
                            }      
                         }
                         if(sudahada){
                            System.out.println("NoTelepon Sudah Ada!");
                            }
                            }while(sudahada==true);
                            //simpan di array object cust di MAIN
                            mbr[jmbr] = new cMember(nama, alamat, notelp);
                            jmbr++;
                            System.out.println("Penambahan Sukses");
                            }
                            else{
                            System.out.println("Kapasitas Penuh!");
                            }
                            break;   
                        case 2:
                            System.out.println("==Hapus Member==");
                            //jumlah object cust harus minimal 1
                            if(jmbr>0){
                            System.out.print("Masukkan NoTelp = ");
                            String notelp  = sc.next();
                            //cari di array object member di MAIN
                            boolean ketemu=false;
                            for (int i = 0; i < jmbr; i++) {
                              if(mbr[i].getNoTelp().equalsIgnoreCase(notelp)){
                              ketemu=true;
                              System.out.println("Data ditemukan");
                              System.out.println("Dihapus? 1. Ya, 2. Tidak");
                              System.out.print("Pilih = ");
                              pilih2 = sc.nextInt();
                              if(pilih2==1){
                              //hapus elemen array object di MAIN
                                mbr[i] = null;
                                //geser maju utk mengisi elemen yg dihapus
                                for (int j = i; j < jmbr; j++) {
                                if(j==jmbr-1)
                                    mbr[j]=null;
                                 else
                                    mbr[j]=mbr[j+1];
                                 }
                                 jmbr--;
                                 System.out.println("Penghapusan Sukses");
                                 }
                                 else System.out.println("Batal Hapus!");   
                            break;
                              }
                            }
                            if(!ketemu){
                               System.out.println("No Telepon Tidak Ada!");
                                }
                              }
                              else System.out.println("Data Cust Kosong!");
                              break;
                        case 3:
                            System.out.println("==Update Data==");
                            //jumlah object cust harus minimal 1
                            if(jmbr>0){
                                System.out.print("Masukkan NoTelepon = ");
                                String notelp = sc.next();
                                //cari NPM di array object di MAIN
                                boolean ketemu=false;
                                for (int i = 0; i < jmbr; i++) {
                                if(mbr[i].getNoTelp().equalsIgnoreCase(notelp)){
                                    ketemu=true;
                                    System.out.println("Data ditemukan!");
                                    //skenarionya update data Member
                                    System.out.print("Masukkan Nama baru = ");
                                    String nama = sc.nextLine();
                                    System.out.print("Masukkan Alamat baru = ");
                                    String alamat = sc.nextLine();
                                    System.out.println("Simpan? 1. Ya, 2. Tidak");
                                    System.out.print("Pilih = ");
                                    pilih2 = sc.nextInt();
                                    if(pilih2==1){
                                    ///update elemen array object di MAIN
                                    mbr[i].setNama(nama);
                                    mbr[i].setAlamat(alamat);
                                    System.out.println("Update Sukses...");
                                }
                                else System.out.println("Batal update!");
                                  } 
                                }
                                if(!ketemu){
                                    System.out.println("No Telp Tidak Ada!");
                                }
                            }
                            else System.out.println("Data member kosong!");
                            break;
                        case 4:
                           System.out.println("==Cetak Data==");
                            //object mhs harus ada dulu
                            if(jmbr>0){
                                System.out.println("No.\tNoTelp\tNama\tAlamat");
                                for (int i = 0; i < jmbr; i++) {
                                  System.out.print((i+1)+". ");
                                  System.out.print(mbr[i].getNoTelp()+"\t");
                                  System.out.print(mbr[i].getNama()+"\t");
                                  System.out.println(mbr[i].getAlamat());
                               }
                            }
                            else System.out.println("Data cust kosong!");
                            break; 
                        case 5:
                            System.out.println("==Query Data==");
                            //object mhs harus ada dulu
                            if(jmbr>0){
                            for (int i = 0; i < jmbr; i++) {
                                System.out.println(mbr[i].ToString());
                                }
                            }
                            else System.out.println("Data Member kosong!");
                            break;
                       }
                       break;
                case 2:
                    System.out.println("Sub Menu Kamera");
                    System.out.println("1. Tambah Data Kamera");
                    System.out.println("2. Hapus Data Kamera");
                    System.out.println("3. Update Data");
                    System.out.println("4. Cetak Data");
                    System.out.println("5. Query");
                    System.out.print("Pilih = ");
                    pilih2 = sc.nextInt();
                    switch(pilih2){
                        case 1:
                        System.out.println("==Tambah Data Kamera==");
                            //jumlah cust masih di bawah kapasitas maksimal
                            if(jkmr<makskmr){ 
                            System.out.print("Masukkan Jenis Kamera = ");
                            sc = new Scanner(System.in);
                            String jenisKamera="";
                            //cek apakah jenis kamera sdh dipakai
                            boolean sudahada;
                            do{
                            System.out.print("Masukkan Jenis Kamera = ");
                            jenisKamera = sc.next();
                            System.out.println("");
                            sudahada=false;
                            for (int i = 0; i < jkmr; i++) {
                            if(kmr[i].getJenisKamera().equalsIgnoreCase(jenisKamera)){
                            sudahada=true;
                            }
                            break;
                            }    
                         if(sudahada){
                            System.out.println("Jenis Kamera Sudah Ada!");
                            }
                            }while(sudahada==true);
                            System.out.println("Jumlah Kamera = ");
                            String jumlahKamera = sc.next();
                            System.out.println("Merk Kamera = ");
                            String merk = sc.next();
                            kmr[jkmr] = new cKamera(jenisKamera, jumlahKamera, merk);
                            jkmr++;
                            System.out.println("Penambahan Sukses");
                            }
                            else{
                            System.out.println("Kapasitas Penuh!");
                            }
                            break;   
                        case 2:
                        System.out.println("== Hapus Kamera ==");
                            if(jkmr>0){
                            System.out.print("Masukkan Jenis Kamera = ");
                            String jenisKamera = sc.next();
                            boolean ketemu=false;
                            for (int i = 0; i < jkmr; i++) {
                              if(kmr[i].getJenisKamera().equalsIgnoreCase(jenisKamera)){
                              ketemu=true;
                              System.out.println("Data ditemukan");
                              System.out.println("Dihapus? 1. Ya, 2. Tidak");
                              System.out.print("Pilih = ");
                              pilih2 = sc.nextInt();
                              if(pilih2==1){
                              //hapus elemen array object di MAIN
                                kmr[i] = null;
                                //geser maju utk mengisi elemen yg dihapus
                                for (int j = i; j < jkmr; j++) {
                                if(j==jkmr-1)
                                    kmr[j]=null;
                                 else
                                    kmr[j]=kmr[j+1];
                                 }
                                 jkmr--;
                                 System.out.println("Penghapusan Sukses");
                                 }
                                 else System.out.println("Batal Hapus!");   
                            break;
                              }
                            }
                            if(!ketemu){
                               System.out.println("Jenis Kamera Tidak Ada!");
                                }
                              }
                              else System.out.println("Data Kamera Kosong!");
                              break;
                           case 3:
                               System.out.println("==Update Data==");
                            //jumlah object cust harus minimal 1
                            if(jkmr>0){
                                System.out.print("Masukkan Jenis Kamera = ");
                                String jenisKamera = sc.next();
                                boolean ketemu=false;
                                for (int i = 0; i < jkmr; i++) {
                                if(kmr[i].getJenisKamera().equalsIgnoreCase(jenisKamera)){
                                    ketemu=true;
                                    System.out.println("Data ditemukan!");
                                    //skenarionya update data Kamera
                                    System.out.print("Masukkan Jenis Kamera baru = ");
                                    jenisKamera = sc.next();
                                    System.out.print("Masukkan jumlah Kamera baru = ");
                                    String jumlahKamera = sc.next();
                                    System.out.print("Masukkan Merk baru = ");
                                    String merk = sc.next();
                                    System.out.println("Simpan? 1. Ya, 2. Tidak");
                                    System.out.print("Pilih = ");
                                    pilih2 = sc.nextInt();
                                    if(pilih2==1){
                                    ///update elemen array object di MAIN
                                    kmr[i].setJenisKamera(jenisKamera);
                                    kmr[i].setJumlahKamera(jumlahKamera);
                                    kmr[i].setMerk(merk);
                                    System.out.println("Update Sukses...");
                                }
                                else System.out.println("Batal update!");
                                  } 
                                }
                                if(!ketemu){
                                    System.out.println("Jenis Kamera Tidak Ada!");
                                }
                            }
                            else System.out.println("Data Kamera kosong!");
                            break;
                           case 4:
                               System.out.println("== Cetak Data ==");
                            if(jkmr>0){
                                System.out.println("No.\tJenis Kamera\tJumlah kamera\tMerk");
                                for (int i = 0; i < jkmr; i++) {
                                  System.out.print((i+1)+". ");
                                  System.out.print(kmr[i].getJenisKamera()+"\t");
                                  System.out.print(kmr[i].getJumlahKamera()+"\t");
                                  System.out.print(kmr[i].getMerk()+"\t");
                               }
                            }
                            else System.out.println("Data Kamera kosong!");
                            break; 
                           case 5:
                               System.out.println("== Query Data ==");
                            if(jkmr>0){
                            for (int i = 0; i < jkmr; i++) {
                                System.out.println(kmr[i].ToString());
                                }
                            }
                            else System.out.println("Data Treatment kosong!");
                            break;
                       }
                       break;
                        case 3:
                            System.out.println("Sub Menu Transaksi");
                            System.out.println("1. Buat Transaksi");
                            System.out.println("2. Cetak Transaksi");
                            System.out.println("3. Query");
                            System.out.print("Pilih = ");
                            pilih2 = sc.nextInt();
                            switch(pilih2){
                               case 1:
                                    System.out.println("==Buat Transaksi Baru==");
                                    if(jtr<makstr){ 
                                    System.out.print("Masukkan Nama = ");
                                    String nama = sc.next();
                                    System.out.print("Masukkan Alamat = ");
                                    String alamat = sc.next();
                                    System.out.print("Masukkan No telepon = ");
                                    String notelp =sc.next();
                                    System.out.print("Masukkan Jenis Kamera = ");
                                    String jenisKamera=sc.next();
                                    System.out.print("Masukkan Jumlah Kamera = ");
                                    String jumlahKamera = sc.next();
                                    System.out.print("Masukkan Merk = ");
                                    String merk =sc.next();
                                    break;
                                    }
                               case 2:
                                    System.out.println("==Cetak Nota==");
                                if(jtr>0){
                                System.out.println("No.\tNama \tALamat\tNoTelp");
                                for (int i = 0; i < jtr; i++) {
                                  System.out.print((i+1)+". ");
                                  System.out.print(mbr[i].getNama()+"\t");
                                  System.out.print(mbr[i].getAlamat()+"\t");
                                  System.out.print(kmr[i].getJenisKamera()+"\t");
                                  System.out.print(kmr[i].getJumlahKamera()+"\t");
                                  System.out.print(kmr[i].getMerk()+"\t");
                               }
                            }
                            else System.out.println("Data Nota kosong!");
                            break; 
                               case 3:
                                 System.out.println("== Query Data ==");
                                if(jkmr>0){
                                for (int i = 0; i < jkmr; i++) {
                                System.out.println(tr[i].ToString());
                                }
                            }
                            else System.out.println("Data Nota kosong!");
                            break;
                       }
                            break;
                        case 4:
                          System.out.println("Terima kasih!");
                           break;
            }
        } while(pilih!=4);
    }
}


    
    
                        
                        
                        
                        
                        
                        
                            
        
    

    
    

    
                                            
                                            
                                        
                                        
                                        
                                    
                                    
                                    
                                    
                
            
    
    



