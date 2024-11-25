
interface BankInterface {
    double getBalance();       
    double getInterestRate();  


class BankA implements BankInterface {
    private double balance;

    public BankA(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0; 
    }
}

// Implementing BankB class
class BankB implements BankInterface {
    private double balance;

    public BankB(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4; // Interest rate for BankB
    }
}

// Implementing BankC class
class BankC implements BankInterface {
    private double balance;

    public BankC(double balance) {
        this.balance = balance;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9; // Interest rate for BankC
    }
}


public class BankDetails {
    public static void main(String[] args) {
        
        BankA bankA = new BankA(10000);
        BankB bankB = new BankB(150000);
        BankC bankC = new BankC(200000);

        //details of BankA
        System.out.println("BankA Details:");
        System.out.println("Balance: Rs" + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%\n");

        // details of BankB
        System.out.println("BankB Details:");
        System.out.println("Balance: Rs" + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%\n");

        // details of BankC
        System.out.println("BankC Details:");
        System.out.println("Balance: Rs" + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");
    }
}
