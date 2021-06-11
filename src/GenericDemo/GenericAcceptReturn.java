package GenericDemo;

public class GenericAcceptReturn {
    public static <E> void display(E[] vals){
        for(E e:vals){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Integer[] intvals = {1,2,3,4};
        Double[] doublesvals = {4.2,5.1,9.9};
        String[] stringvals = {"a","b","c"};

        display(intvals);
        display(doublesvals);
        display(stringvals);
    }
}
