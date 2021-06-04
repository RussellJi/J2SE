package IO_HSP.simulation;

public class BufferedRead extends Read{
    Read rd = null;
    BufferedRead(Read rd){
        this.rd = rd;
    }
    public void read10times(){
        System.out.println(this.rd.getClass().getName());
        if (rd.getClass().getName() == "IO_HSP.simulation.FileRead"){
            for(int i=0; i<10;i++){
                rd.fileRead();
            }
        }else{
            for(int i=0;i<10;i++){
                rd.stringRead();
            }
        }
    }
}
