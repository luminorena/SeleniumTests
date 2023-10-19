package selenium.practice.helpers;

import java.util.HashMap;
import java.util.Map;

public class GetElementsHelper {
    public Integer getElementsBlockItem(String input) {
        Map<Integer, String> map = new HashMap<>();
        map.put(0, "Text Box");
        map.put(1, "Check Box");
        map.put(2, "Radio Button");
        map.put(3, "Web Tables");
        map.put(4, "Buttons");
        map.put(5, "Links");
        map.put(6, "Broken Links - Images");
        map.put(7, "Upload and Download");
        map.put(8, "Dynamic Properties");

        return map.entrySet().stream().filter(x -> x.getValue()
                .equals(input))
                .map(Map.Entry::getKey).findFirst().orElse(null);

    }

    public static void main(String[] args) {
        GetElementsHelper getElementsHelper = new GetElementsHelper();
        System.out.println(getElementsHelper.getElementsBlockItem("Buttons"));

    }
}
