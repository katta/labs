package org.katta.labs.metrics.toxicity.todelete;

public class SomeClass {

    private void tooManyIfBlocks() {
        if(true) {
            System.out.println("this is first block");
            if(false) {
                System.out.println("this wont get executed");
                if(false) {
                    System.out.println("this is false");
                    if(true) {
                        System.out.println("last block");
                    }
                }

            }
        }
    }
}
