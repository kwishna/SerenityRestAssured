package Rough;

import org.jetbrains.annotations.NotNull;

@FunctionalInterface
interface Cal{

    int operation(int i, int j);

    @Override
    String toString();                //Overridden from Object class

    @Override
    boolean equals(Object obj);      //Overridden from Object class

}

public class Rough2 {

    private static int doAddition(int i, int j, @NotNull Cal c){

        return c.operation(i, j);
    }

    public static void main(String[] args) {

        // Using Lambda Expression
        Rough2.doAddition(2, 4, (i, j) -> { return i + j; }); // Implementing Interface

        //Annonymous Class Impl.
        Cal c = new Cal(){

            @Override
            public int operation(int i, int j) {
                return i * j;
            }
        };

        int i = Rough2.doAddition(2, 4, c);

    }
}
