package mrmodest.demoproject;

import com.opencsv.bean.CsvBindByName;

import java.time.LocalDateTime;

public class WalletDto {
    @CsvBindByName(column = "account")
    private String account;

    @CsvBindByName(column = "category")
    private String category;

    @CsvBindByName(column = "currency")
    private Currency currency;

    @CsvBindByName(column = "amount")
    private double amount;

    @CsvBindByName(column = "type")
    private WalletRecordType type;

    @CsvBindByName(column = "note")
    private String note;

    @CsvBindByName(column = "date")
    private LocalDateTime date;

    @CsvBindByName(column = "transfer")
    private boolean transfer;

    public WalletDto() {
    }


    public WalletDto(
            String account,
            String category,
            Currency currency,
            double amount,
            WalletRecordType type,
            String note,
            LocalDateTime date,
            boolean transfer) {
        this.account = account;
        this.category = category;
        this.currency = currency;
        this.amount = amount;
        this.type = type;
        this.note = note;
        this.date = date;
        this.transfer = transfer;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public WalletRecordType getType() {
        return type;
    }

    public void setType(WalletRecordType type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public boolean isTransfer() {
        return transfer;
    }

    public void setTransfer(boolean transfer) {
        this.transfer = transfer;
    }
}
