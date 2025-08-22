public class estructurascontrol {
    public void estructuras() throws InterruptedException {
        //IF ELSE ELSE IF
        Boolean acreditaste = null;

        if(Boolean.TRUE.equals(acreditaste)){
            System.out.println("Acreditaste");
        }else if(Boolean.FALSE.equals(acreditaste)){
            System.out.println("NO Acreditaste");
        }else{
            System.out.println("Pendiente a revision");
        }

        //FOR
        int i;
        for (i=1; i<11; i++){
            System.out.printf("Conteo: %d%n",i);
            Thread.sleep(1000);
        }

        //DO WHILE Y WHILE
        int j=1;
        do{

            System.out.printf("Conteo: %d%n",j);
            Thread.sleep(1000);
            j++;

        }while(j<1);


        while(j<1){

            System.out.printf("Conteo: %d%n",j);
            Thread.sleep(1000);
            j++;
        }


    }
}
