package bahasapemrograman2;
//satu penyewa bisa menyewa banyak kamera
public class cTransaksi{
    private String jumlahSewa;
    private String maksSewa;
    private String total;
    
    private cMember mbr;
    cTransaksi(){
        jumlahSewa="1";
        maksSewa="3";
        total="";
        mbr=null;
        System.out.println("Object Transaksi Dibuat");
    }
    
    cTransaksi(String js, String makssewa, String ttal){
        jumlahSewa = js;
        maksSewa=makssewa;
        total=ttal;
        mbr=null;
        System.out.println("Object Transaksi Dibuat");
    }
    public void setMember(cMember m){
        mbr=m;
    }
    public cMember getMember(){
        return mbr;
    }
    public void deleteMember(){
        mbr=null;
    }
    public void setJumlahSewa(String js){
        jumlahSewa=js;
    }
    public void setMaksSewa(String makssewa){
        maksSewa = makssewa;
    }
    public void setTotal(String ttal){
        total = ttal;
    }
    public String getJumlahsewa(){
        return jumlahSewa;
    }
    public String getMaksSewa(){
        return maksSewa;
    }
    public String getTotal(){
        return total;
    }
    public String ToString(){
        return jumlahSewa+""+maksSewa+""+total;
    }
}
    
        
        
          
      