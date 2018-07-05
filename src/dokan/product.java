package dokan;


public class product {
    public int Pid; 
    public String Pname ;
    public String Pprice ;
    public String Pdetails ;
   
    
    
    public product(int Pid,String Pname,String Pprice,String Pdetails){
        this.Pid=Pid;
        this.Pname = Pname;
        this.Pprice = Pprice;
        this.Pdetails = Pdetails;
       
        
    }


    public void setPid(int Pid) {
        this.Pid = Pid;
    }

    public int getPid() {
        return Pid;
    }

    public void setPname(String Pname) {
        this.Pname = Pname;
    }

    public void setPprice(String Pprice) {
        this.Pprice = Pprice;
    }

    public void setPdetails(String Pdetails) {
        this.Pdetails = Pdetails;
    }

    public String getPname() {
        return Pname;
    }

    public String getPprice() {
        return Pprice;
    }

    public String getPdetails() {
        return Pdetails;
    }

 
    
    
    
    
}
