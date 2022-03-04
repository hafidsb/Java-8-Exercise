import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamRefactor {
    public static void main(String[] args) {
        Invoice inv1 = new Invoice(1, "Transportation - Training", 50_000, "ORACLE Hafid");
        Invoice inv2 = new Invoice(2, "Food - Training", 25_000, "ORACLE Bernard");
        Invoice inv3 = new Invoice(3, "Health Bills - Training", 1_500_000, "WINDOWS Sarah");
        Invoice inv4 = new Invoice(4, "Food - Training", 150_000, "WINDOWS Alvian");
        Invoice inv5 = new Invoice(5, "Transportation - Training", 150_000, "ORACLE Alvian");
        Invoice inv6 = new Invoice(6, "Transportation - Training", 150_000, "ORACLE Sarah");
        Invoice inv7 = new Invoice(7, "Health Bills - Training", 150_000, "WINDOWS Hafid");
        Invoice inv8 = new Invoice(8, "Transportation - Training", 150_000, "WINDOWS Bernard");
        Invoice inv9 = new Invoice(9, "Food - Training", 150_000, "WINDOWS Raymon");
        Invoice inv10 = new Invoice(10, "Health Bills - Training", 150_000, "ORACLE Raymon");
        Invoice inv11 = new Invoice(11, "Health Bills - Training", 150_000, "ORACLE Tester");

        List<Invoice>  invoices = new ArrayList<>(Arrays.asList(inv1, inv2, inv3, inv4, inv5, inv6, inv7, inv8, inv9, inv10, inv11));
        List<Invoice>  oracleAndTrainingInvoices;
        List<Integer> ids = new ArrayList<>();
        List<Integer> firstFiveIds;

        oracleAndTrainingInvoices =
            invoices.stream()
                .filter(data -> data.getCustomer().contains("ORACLE"))
                .filter(data -> data.getTitle().contains("Training"))
                .collect(Collectors.toList());
        System.out.println(oracleAndTrainingInvoices);

        List<Invoice> sortedInvoices =
            oracleAndTrainingInvoices.stream()
                .sorted(Comparator.comparingDouble(Invoice::getAmount))
                .collect(Collectors.toList());
        System.out.println(sortedInvoices);

        ids =
            oracleAndTrainingInvoices.stream()
                    .map(Invoice::getId)
                    .collect(Collectors.toList());
        System.out.println(ids);

        firstFiveIds =
            ids.stream()
                    .limit(5)
                    .collect(Collectors.toList());
        System.out.println(firstFiveIds);

    }
}
