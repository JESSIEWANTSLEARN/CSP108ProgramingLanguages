package Quiz3CityTrafficManager;

//4. Main Execution
public class Main {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     TrafficAnalyzer analyzer = new TrafficAnalyzer();
     ReportGenerator report = new ReportGenerator();

     System.out.print("Enter number of vehicles to observe: ");
     int n = sc.nextInt();

     for (int i = 0; i < n; i++) {
         System.out.print("Vehicle " + (i + 1) + " (People Capacity): ");
         analyzer.addVehicle(sc.nextInt(), sc.nextInt());
     }

     report.printReport(analyzer);
     sc.close();
 }

is this best 