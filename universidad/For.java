public class For{
    public static void main(String[] args) {
        System.out.println("Clases for");
        int seg,min,hor = 0;
        for(;;){
            for(hor = 0; hor < 24; hor++){
                for(min = 0; min < 60; min++){      
                    for(seg = 0; seg < 60; seg++){
                        System.out.println(hor + ":" + min + ":" + seg);
                    }
                }
            }    
        }
            
   }
}    