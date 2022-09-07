package org.cpueng.se2122;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    // This is the Main class, which is the main Java program that will run your Java application.
    // Every Java application will have one main class, regardless of frameworks being used.
    // In most frameworks such as Spring or J2EE, the main class doesn't do a lot, but is still required
    // in order to initialize the application.

    // The main class is basically coded in a Functional Programming way, where program logic are partitioned 
    // into functions.  Programming everything in the Main class is not OO programming at all.

    // In Java or OO in general, the variables are called "attributes".
    // But in the Main class, the name "attributes" do not make sense, so we still usually call them in this
    // class as "variables".

    // these are global variables
    static int globalIntegerNumber;

    // these are global variables w/ initial values
    int globalIntegerNumber2 = 10;
    String helloString = "Hello World!";

    // these are global constants
    final String CONSTANT_STRING = "I can't be changed silly!";

    public static void main(String[] args) {
        // This is the main 

        // These are the literal variables
        int integerNumber;
        long longNumber;
        double doubleNumber;
        char characters;
        byte[] byteArray;

        // These are object variables
        Map<String, String> sampleMap;
        ArrayList<String> list = new ArrayList<>(); // this is how you create a Java object.
        String helloWorldStr = "Hello World!";

        // Outputting in the console
        System.out.println(helloWorldStr);
    }

    // In Java or OO in general, functions are called "Methods" or "Behaviours".
    // But "Methods" or "Behaviours" do not make sense in the Main class.  So we will call them here as 
    // "Functions".  These words are being interchanged by most software professionals, but it's important
    // that we make these distinctions to make communications a lot easier and more precise.

    void functionWithPackageLevelPrivacy() {
        // This is a function with package level privacy.
        // Accessible by other classeses within the same package.
    }

    public void iAmPublicFunction() {
        // This is a public function with no return.
    }

    protected void iAmProtectedFunction() {
        // This is a protected function with no return.
        // Accessible by other classeses within the same package
        // and accessible by subclasses.
    }

    private void doSomething() {
        // this is a private function with no return.
        // Not accessible at all by any external class.
    }

    private boolean returnMyBoolean() {
        // this is a private function that returns a literal.
        return true;
    }
}
