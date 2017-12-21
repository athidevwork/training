package org.athi;
 
public class MyDeadLock {
 
    String str1 = "Java";
    String str2 = "UNIX";
     
    Thread trd1 = new Thread("My Thread 1"){
        public void run(){
            while(true){
                synchronized(str1){
                    synchronized(str2){
                        System.out.println(Thread.currentThread().getName() + ": " + str1 + str2);
                        try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
                }
            }
        }
    };
     
    Thread trd2 = new Thread("My Thread 2"){
        public void run(){
            while(true){
                synchronized(str2){
                    synchronized(str1){
                        System.out.println(Thread.currentThread().getName() + ": " + str2 + str1);
                        try {
							Thread.sleep(10000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}                    
                    }
                }
            }
        }
    };
     
    public static void main(String a[]){
        MyDeadLock mdl = new MyDeadLock();
        mdl.trd1.start();
        mdl.trd2.start();
    }
}
