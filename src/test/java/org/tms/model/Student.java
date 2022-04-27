package org.tms.model;

public class Student {

    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String country;
    private String city;


    public Student(StudentBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.country = builder.country;
        this.city = builder.city;
    }

    public static class StudentBuilder{
        private  String firstName;
        private  String lastName;
        private  int age;
        private String phone;
        private String country;
        private String city;

        public StudentBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public StudentBuilder phone(String phone){
            this.phone = phone;
            return this;
        }

        public StudentBuilder age(int age){
            this.age = age;
            return this;
        }

        public StudentBuilder country(String country){
            this.country = country;
            return this;
        }

        public StudentBuilder city(String city){
            this.city = city;
            return this;
        }
        public Student build(){
            return new Student(this);
        }
    }
}

