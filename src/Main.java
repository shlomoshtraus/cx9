
public class Main {

    public static void main(String[] args) {
        Sales a = new Sales();

        a.addCar("BF3548","Mazda",6,200000.0,5.5,10,"4*4",120,true);
        a.addCar("BA35T5","BMW",6,100847.0,5.5,10,"4*4",120,true);
        a.addCar("CKY76R","Volvo",6,203500.0,5.5,10,"2",120,true);
        a.addCar("KU75G9","Toyota",6,184760.0,5.5,10,"4*4",120,true);
        a.addCar("M65FT8","Nissan",6,458100.0,5.5,10,"2",120,true);
        a.addCar("Y345HU","Ferrari",6,288070.0,5.5,10,"2",120,true);

        System.out.println(a.getCars());


    }
}
