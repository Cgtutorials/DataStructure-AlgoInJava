package ConstructorReferences;

public class ConstructerMain {

    public static void main(String[] args) {
        System.out.println(" Learning COnstructer");
        Provider provider = Student:: new;

        provider.getStudent().display();

    }
}
