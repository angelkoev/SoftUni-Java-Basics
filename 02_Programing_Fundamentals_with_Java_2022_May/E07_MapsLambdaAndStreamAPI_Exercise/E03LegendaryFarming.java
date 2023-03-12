package E07_MapsLambdaAndStreamAPI_Exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E03LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasWinner = false;
        String winner = "";

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        while (!hasWinner) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length - 1; i += 2) {
                int quantity = Integer.parseInt(data[i]);
                String resource = data[i + 1].toLowerCase();

                items.putIfAbsent(resource, 0);
                items.put(resource, items.get(resource) + quantity);

                if (resource.equals("shards") || resource.equals("fragments") || resource.equals("motes")) {
                    if (items.get(resource) >= 250) {
                        items.put(resource, items.get(resource) - 250);
                        winner = resource;
                        hasWinner = true;
                        break;
                    }
                }
            }
        }

//        switch (winner) {
//            case "shards":
//                System.out.println("Shadowmourne obtained!");
//                break;
//            case "fragments":
//                System.out.println("Valanyr obtained!");
//                break;
//            case "motes":
//                System.out.println("Dragonwrath obtained!");
//                break;
//        }

        Map <String, String> legendaryItems = new HashMap<>();
        legendaryItems.put("shards", "Shadowmourne obtained!");
        legendaryItems.put("fragments", "Valanyr obtained!");
        legendaryItems.put("motes", "Dragonwrath obtained!");

        System.out.println(legendaryItems.get(winner));

        // където имаме switch с принтиране е по-добре да ипозлваме HashMap !!!

        items.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));


    }
}
