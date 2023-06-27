package bahasapemrograman2;

public class cKamera {
    private String jenisKamera;
    private String jumlahKamera;
    private String merk;
    
    //constructor
    cKamera(){
        System.out.println("Contructor 1 Film");
    }
    cKamera(String jk, String jmk,String mrk){
        jenisKamera=jk; jumlahKamera=jmk; merk=mrk;
        System.out.println("Contructor 2 Film");   
    }
    //member function
    //method setter
    public void setJenisKamera(String jk){
        jenisKamera=jk;
    }
    public void setJumlahKamera(String jmk){
        jumlahKamera=jmk;
    }
    public void setMerk(String mrk){
        merk=mrk;
    }
    //method getter
    public String getJenisKamera(){
        return jenisKamera;
    }
    public String getJumlahKamera(){
        return jumlahKamera;
    }
    public String getMerk(){
        return merk;
    }
   
   
    
    //method query
    public String ToString(){
        return "Kamera:"+jenisKamera+""+jumlahKamera+""+merk;
    }
    
}
