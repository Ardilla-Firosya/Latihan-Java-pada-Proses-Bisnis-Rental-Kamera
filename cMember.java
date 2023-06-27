package bahasapemrograman2;
public class cMember {
    private String nama;
    private String alamat;
    private String notelp;
    
    //constructor
    cMember(){
        System.out.println("Conturctor 1 Member");
    }
    cMember(String nm, String almt, String ntlp){
        nama=nm; alamat=almt; notelp=ntlp;
        System.out.println("Contructor 2 Member");
    }
    //member function
    //method setter
    public void setNama(String nm){
        nama = nm;
    }
   
    public void setAlamat(String almt){
        alamat = almt;
    }
    public void setNoTelp(String  ntlp){
        notelp = ntlp;
    }
    
    //method getter
    public String getNama(){
        return nama;
    }
    
    public String getAlamat(){
        return alamat;
    }
    public String getNoTelp(){
        return notelp;
    }
    //method query
    public String ToString(){
        return "Member:"+nama+""+alamat+""+notelp;
    }
}

