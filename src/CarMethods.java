import java.util.List;

public class CarMethods {

    public static String showDailyComments(List<Car> cars, String date) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            if (car.dateOfInvoiceIssue.equals(date) && !car.comment.isEmpty()) {
                sb.append(car.regNumber + ": " + car.comment).append("\n");
            }
        }
        return sb.toString();
    }

    public static String showCarOfInterest(List<Car> cars, String reg) {
        String carOfInterest = "";
        boolean found = false;
        for (Car car : cars) {
            if (car.regNumber.equals(reg.toUpperCase().trim()) || car.vin.equals(reg.toUpperCase().trim())) {
                found = true;
                carOfInterest = car.allAttributeNames();
                break;
            }
        }
        return found ? carOfInterest : "Nie znaleziono takiego pojazdu";
    }

    public static String showDailyInvoiceNumbers(List<Car> cars, String date) {
        StringBuilder sb = new StringBuilder("Numery faktur z dnia " + date + ":\n");
        for (Car car : cars) {
            if (car.dateOfInvoiceIssue.equals(date)) {
                sb.append(car.invoiceNumber).append(",");
            }
        }
        return sb.toString();
    }
}