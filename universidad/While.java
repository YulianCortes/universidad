public class While {
    public static void main(String[] args) {
        System.out.println("Clases for");
        int seg = 0;
        int min = 0;
        int hora = 0;
        while(true){
            while (hora < 24){
                while(min < 60){
                    while (seg < 60){
                        System.out.println(hora + ":" + min + ":" + seg);
                        seg++;
                    }
                    seg = 0;
                    min++;
                }  
                min = 0;
                hora++;     
            }
        }
            
    }
}