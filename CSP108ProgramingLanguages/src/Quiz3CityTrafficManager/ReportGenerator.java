package Quiz3CityTrafficManager;

//3. Composition: ReportGenerator "has-a" TrafficAnalyzer to process data
class ReportGenerator {
 public void printReport(TrafficAnalyzer analyzer) {
     int[] pCounts = new int[7];
     int[] eCounts = new int[5];

     for (Vehicle v : analyzer.getVehicles()) {
         // Tabulate People
         int p = v.getPeople();
         if (p >= 1 && p <= 6) pCounts[p - 1]++;
         else if (p > 6) pCounts[6]++;

         // Tabulate Efficiency
         double e = v.getEfficiency();
         if (e < 20) eCounts[0]++;
         else if (e < 40) eCounts[1]++;
         else if (e < 60) eCounts[2]++;
         else if (e < 80) eCounts[3]++;
         else eCounts[4]++;
     }

     // Print Tables
     System.out.println("\n--- People Transported ---");
     for (int i = 1; i <= 6; i++) System.out.println(i + ": " + pCounts[i - 1]);
     System.out.println("> 6: " + pCounts[6]);

     System.out.println("\n--- Efficiency (%) ---");
     System.out.println("0-20: " + eCounts[0]);
     System.out.println("20-40: " + eCounts[1]);
     System.out.println("40-60: " + eCounts[2]);
     System.out.println("60-80: " + eCounts[3]);
     System.out.println("80-100: " + eCounts[4]);
 }
}