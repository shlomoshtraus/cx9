import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Sales a = new Sales();

        a.cars.add(new Car("BF3548","Mazda",6,200000.0,5.5,10,"4*4",120,true));
        a.cars.add(new Car("BA35T5","BMW",6,200000.0,5.5,10,"4*4",120,true));
        a.cars.add(new Car("CKY76R","Volvo",6,200000.0,5.5,10,"",120,true));
        a.cars.add(new Car("KU75G9","Toyota",6,200000.0,5.5,10,"4*4",120,true));
        a.cars.add(new Car("M65FT8","Nissan",6,200000.0,5.5,10,"",120,true));
        a.cars.add(new Car("Y345HU","Ferrari",6,200000.0,5.5,10,"",120,true));

        System.out.println(a.cars);


    }
}
