package com.company;

class LuggageLimitExceededException extends Exception {
    LuggageLimitExceededException(double weight, String message) {
        super(message);
    }
}

class Luggage {
    double weight;

    Luggage(double weight) {
        this.weight = weight;
    }

    public void weightChecker() throws LuggageLimitExceededException {
        if (weight > 15) {
            if (weight == 15.1) {
                throw new LuggageLimitExceededException(weight, "excused on request");
            }
            throw new LuggageLimitExceededException(weight, "luaggage limit is exceeded");
        }
    }

    public void calculateFine() {
        if (weight > 15) {
            System.out.println((weight - 15) * 500);
        }
    }

}

public class LuggageChecker {
    public static void main(String[] args) {
        Luggage bhavya = new Luggage(15.1);
        Luggage shruthi = new Luggage(18);
        try {
            bhavya.weightChecker();
        } catch (LuggageLimitExceededException e) {
            System.out.println(e);
        }
        try {
            shruthi.weightChecker();
        } catch (LuggageLimitExceededException e) {
            System.out.println(e);
        } finally {
            shruthi.calculateFine();
        }
    }
}
