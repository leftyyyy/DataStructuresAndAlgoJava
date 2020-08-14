package com.leftyyyy.maps;

public class Employee {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object object){
        /*
        if(this==object){
            return true;
        }

        if(object==null || object.getClass()!=this.getClass()){
            return false;
        }

         */

        return (((Employee) object).getName()==this.getName() && ((Employee) object).getAge()==this.getAge());
    }

    @Override
    public int hashCode(){
        String s = Integer.toString(age);
        return name.hashCode()+s.hashCode();
    }
}
