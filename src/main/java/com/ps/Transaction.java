package com.ps;

public class Transaction {

    private String date;
    private String time;
    private String description;
    private String vendor;
    private String amount;

    public Transaction(String date, String time, String description, String vendor, String amount) {
        this.date = String.valueOf(date);
        this.time = String.valueOf(time);
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "\nTransaction{" +
                "date=" + date +
                ", time=" + time +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                '}';
    }
}
