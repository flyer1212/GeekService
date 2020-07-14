package hello;



public class AppService {


    ThreadLocal<Integer> num = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    public String add(){
        num.set(num.get() +1);
        return num.get() +"";
    }
}
