package mrmodest.demoproject;

import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static final String dirPath = "/Users/me/Downloads/csv/";
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws IOException {
        var file = new FileReader(dirPath + "1Money_2022_03_01_without_comma.csv");
        var records = new CsvToBeanBuilder<OneMoneyDto>(file)
                .withType(OneMoneyDto.class)
                .build()
                .parse();

        var walletRecords = map(records);

        var walletByAccount = walletRecords.stream()
                .collect(Collectors.groupingBy(WalletDto::getAccount));

        for (var account : walletByAccount.entrySet()) {
            System.out.println("========= " + account.getKey() + " =========");
            createExcelFile(account.getValue(), "Wallet_" + account.getKey() + "_2022_03_01.xlsx");
            System.out.println("===========================");
        }
    }

    public static long sum(int a, int b) {
        return a + b;
    }

    private static void createExcelFile(List<WalletDto> records, String fileName) throws IOException {
        var workbook = new XSSFWorkbook();
        var sheet = workbook.createSheet("Records");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        var header = sheet.createRow(0);
        createCell(header, 0, "account");
        createCell(header, 1, "category");
        createCell(header, 2, "currency");
        createCell(header, 3, "amount");
        createCell(header, 4, "type");
        createCell(header, 5, "note");
        createCell(header, 6, "date");
        createCell(header, 7, "transfer");

        System.out.println("Header succeed!");

        for (var i = 0; i < records.size(); i++) {
            var record = records.get(i);
            var row = sheet.createRow(i + 1);

            createCell(row, 0, record.getAccount());
            createCell(row, 1, record.getCategory());
            createCell(row, 2, record.getCurrency().name());
            createCell(row, 3, df.format(record.getAmount()));
            createCell(row, 4, record.getType().name());
            createCell(row, 5, record.getNote());
            createCell(row, 6, record.getDate().format(dateTimeFormatter));
            createCell(row, 7, String.valueOf(record.isTransfer()).toUpperCase());

            System.out.println("Row " + i + " succeed!");
        }

        var outputStream = new FileOutputStream(dirPath + fileName);
        workbook.write(outputStream);
        workbook.close();
    }

    private static List<WalletDto> map(List<OneMoneyDto> records) {
        var walletRecords = new ArrayList<WalletDto>();

        for (var record: records) {
            if (record.getType() == OneMoneyRecordType.Transfer) {
                var expenses = new WalletDto(
                        record.getFromAccount(),
                        "Transfer, withdraw",
                        record.getCurrency1(),
                        record.getAmount1() * -1,
                        WalletRecordType.Expenses,
                        record.getNote(),
                        record.getDate().atStartOfDay(),
                        true
                );

                var income = new WalletDto(
                        record.getToAccountOrCategory(),
                        "Transfer, withdraw",
                        record.getCurrency2(),
                        record.getAmount2(),
                        WalletRecordType.Income,
                        record.getNote(),
                        record.getDate().atStartOfDay(),
                        true
                );

                walletRecords.add(expenses);
                walletRecords.add(income);
            } else {
                walletRecords.add(new WalletDto(
                        record.getFromAccount(),
                        FromOneMoneyToWalletCategoryMapper.map(record.getToAccountOrCategory()),
                        record.getCurrency1(),
                        record.getAmount1() * getSign(record),
                        map(record.getType()),
                        record.getNote(),
                        record.getDate().atStartOfDay(),
                        false
                ));
            }
        }

        return walletRecords;
    }

    private static int getSign(OneMoneyDto record) {
        if (record.getType().equals(OneMoneyRecordType.Expense)) {
            return -1;
        }

        return 1;
    }

    private static WalletRecordType map(OneMoneyRecordType type) {
        return switch (type) {
            case Income -> WalletRecordType.Income;
            case Expense -> WalletRecordType.Expenses;
            case Transfer -> throw new IndexOutOfBoundsException("Transfer must not be mapped!");
        };
    }

    private static void createCell(XSSFRow row, int colIndex, String value) {
        row.createCell(colIndex).setCellValue(value);
    }
}
