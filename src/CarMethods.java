import java.util.List;

public class CarMethods {

//    public static void showDailyInvoiceNumbers(List<Car> cars, String date) {
//        System.out.println("Numery faktur z dnia " + date + ":");
//        int counter = 0;
//        for (Car car : cars) {
//            if (car.dateOfInvoiceIssue.equals(date)) {
//                System.out.print(car.invoiceNumber + ",");
//                counter++;
//                if (counter % 10 == 0) {
//                    System.out.println();
//                }
//            } else continue;
//        }
//    }

    public static void showDailyComments(List<Car> cars, String date) {
        for (Car car : cars) {
            if (car.dateOfInvoiceIssue.equals(date) && !car.comment.isEmpty()) {
                System.out.println(car.regNumber + ": " + car.comment);
            }
        }
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
        int counter = 0;
        for (Car car : cars) {
            if (car.dateOfInvoiceIssue.equals(date)) {
                sb.append(car.invoiceNumber).append(",");
                counter++;
                if (counter % 10 == 0) sb.append("\n");
            }
        }
        return sb.toString();
    }

}


