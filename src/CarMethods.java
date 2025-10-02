import java.util.List;

public class CarMethods {
    public static void showDailyInvoiceNumbers(List<Car> cars, String date) {
        System.out.println("Numery faktur z dnia " + date);
        for (Car car : cars) {
            if (car.dateOfInvoiceIssue.equals(date)) {
                System.out.print(car.invoiceNumber + ",");
            } else continue;
        }
    }
}
