public class Student {

    private String uid;
    private String name;
    private int fineAmount;
    private int currentBorrowCount;

    public Student(String uid, String name, int fineAmount, int currentBorrowCount) {
        this.uid = uid;
        this.name = name;
        this.fineAmount = fineAmount;
        this.currentBorrowCount = currentBorrowCount;
    }

    public String getUid()                { return uid; }
    public String getName()               { return name; }
    public int    getFineAmount()         { return fineAmount; }
    public int    getCurrentBorrowCount() { return currentBorrowCount; }

    public void setFineAmount(int fineAmount)        { this.fineAmount = fineAmount; }
    public void setCurrentBorrowCount(int count)     { this.currentBorrowCount = count; }

    public void checkFinePolicy() throws IllegalStateException {
        if (fineAmount > 0) {
            throw new IllegalStateException(
                "Student [" + uid + "] has a pending fine of Rs." + fineAmount +
                ". Checkout is blocked until the fine is cleared."
            );
        }
    }

    public void checkBorrowLimitPolicy() throws IllegalStateException {
        if (currentBorrowCount >= 2) {
            throw new IllegalStateException(
                "Student [" + uid + "] has reached the borrow limit (" +
                currentBorrowCount + "/2). Return an item before borrowing again."
            );
        }
    }

    @Override
    public String toString() {
        return "Student{uid='" + uid + "', name='" + name +
               "', fine=" + fineAmount + ", borrowed=" + currentBorrowCount + "}";
    }
}
