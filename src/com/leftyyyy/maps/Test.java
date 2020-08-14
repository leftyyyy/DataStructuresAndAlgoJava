package com.leftyyyy.maps;

import java.util.*;

public class Test {
    public static Map count(ArrayList<Employee> objs){
        Map<Employee, Integer> map = new HashMap<Employee, Integer>();
        for(Employee e: objs){
            if(map.containsKey(e)){
                map.put(e,map.get(e)+1);
            }else{
                map.put(e, 1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        /*
        Map<String, String> map = new Hashtable<>();
        map.put("name", "Rishi");
        map.put("age", "23");
        Set<String> keys = map.keySet();
        for (String key: keys){
            System.out.println(key +"-->"+map.get(key));
        }

         */
        Employee e = new Employee();
        e.setName("Rishi");
        e.setAge(23);
        Employee e1 = new Employee();
        e1.setName("Anand");
        e1.setAge(26);
        Employee e2 = new Employee();
        e2.setName("Rishi");
        e2.setAge(23);
        ArrayList<Employee> objs = new ArrayList<Employee>();
        objs.add(e);
        objs.add(e1);
        objs.add(e2);

        /*
        if(e.equals(e2)){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        if(e.getName().hashCode()==e2.getName().hashCode()){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        System.out.println("----------------------------");
        */
        Map res = count(objs);
        Set<Employee> keys = res.keySet();
        for(Employee key: keys){
            System.out.println(key.getName() +"-->"+res.get(key));
        }
    }
}
