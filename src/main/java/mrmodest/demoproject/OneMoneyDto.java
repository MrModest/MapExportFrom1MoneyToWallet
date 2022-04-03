package mrmodest.demoproject;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDate;

public class OneMoneyDto {
    @CsvDate("dd/MM/yyyy")
    @CsvBindByName(column = "DATE", required = true)
    private LocalDate date;

    @CsvBindByName(column = "TYPE")
    private OneMoneyRecordType type;

    @CsvBindByName(column = "FROM ACCOUNT")
    private String fromAccount;

    @CsvBindByName(column = "TO ACCOUNT / TO CATEGORY")
    private String toAccountOrCategory;

    @CsvBindByName(column = "AMOUNT")
    private double amount1;

    @CsvBindByName(column = "CURRENCY")
    private Currency currency1;

    @CsvBindByName(column = "AMOUNT 2")
    private double amount2;

    @CsvBindByName(column = "CURRENCY 2")
    private Currency currency2;

    @CsvBindByName(column = "NOTES")
    private String note;

    @CsvBindByName(column = "TAGS")
    private String tags;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public OneMoneyRecordType getType() {
        return type;
    }

    public void setType(OneMoneyRecordType type) {
        this.type = type;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccountOrCategory() {
        return toAccountOrCategory;
    }

    public void setToAccountOrCategory(String toAccountOrCategory) {
        this.toAccountOrCategory = toAccountOrCategory;
    }

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(double amount1) {
        this.amount1 = amount1;
    }

    public Currency getCurrency1() {
        return currency1;
    }

    public void setCurrency1(Currency currency1) {
        this.currency1 = currency1;
    }

    public double getAmount2() {
        return amount2;
    }

    public void setAmount2(double amount2) {
        this.amount2 = amount2;
    }

    public Currency getCurrency2() {
        return currency2;
    }

    public void setCurrency2(Currency currency2) {
        this.currency2 = currency2;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
