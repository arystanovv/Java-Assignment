package com.example.demo;

import java.util.*;

public class Assignment21_1 {
    public static void main(String[] args) {
        LinkedHashSet<String> attar1 = new LinkedHashSet<>();
        LinkedHashSet<String> attar2 = new LinkedHashSet<>();

            attar1.add("George");
            attar1.add("Jim");
            attar1.add("John");
            attar1.add("Blake");
            attar1.add("Kevin");
            attar1.add("Michael");

            attar2.add("George");
            attar2.add("Katie");
            attar2.add("Kevin");
            attar2.add("Michelle");
            attar2.add("Ryan");

            LinkedHashSet<String> lhs1 = new LinkedHashSet<>();
            lhs1.addAll(attar1);

            LinkedHashSet<String> lhs2 = new LinkedHashSet<>();
            lhs2.addAll(attar2);

            attar1.addAll(attar2);
            System.out.println("Obiedenenie is: " + attar1);

            LinkedHashSet<String> copyNames1 = new LinkedHashSet<String>(lhs1);

            attar1.removeAll(copyNames1);
            System.out.println("Raznica is: " + attar1);

            copyNames1.retainAll(attar2);
            System.out.println("Peresecenie is: " + copyNames1);
        }
}
