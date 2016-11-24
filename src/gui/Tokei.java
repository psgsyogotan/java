package gui;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class Tokei extends Frame implements Runnable{
        static int hours;          
        static int minute;         
        static int seconds;           

      
        static Tokei f = new Tokei();
        static Thread th = new Thread(f);
        Calendar now = Calendar.getInstance(); 
        
        
    public static void main(String args[]){

        //フレーム作成
        f.setSize(300, 300);
        f.setVisible(true);
        f.addWindowListener(new Ada());

        th.start();   //スレッドスタート
    }
    public void run(){
        while(true){
              hours = now.getInstance().get(now.HOUR_OF_DAY); //時を代入
              minute = now.getInstance().get(now.MINUTE);      //分を代入
              seconds= now.getInstance().get(now.SECOND);       //秒を代入
              repaint();

              try{
                  th.sleep(1000);  //スリープ１秒
              }catch(InterruptedException e){
              }               
        }
    }
    public void paint(Graphics g)
    {
        
        g.drawString(hours+":"+minute+":"+seconds,130,140);
    }
    

}
class Ada extends WindowAdapter
{
    public void windowClosing(WindowEvent e){   //×を押されたときの処理
       System.exit(0);
    }
}