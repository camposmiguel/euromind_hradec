package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class DbGenerator {
    public static void main(String[] args) throws Exception {
        Schema schema = new Schema(1000, "com.miguelcr.studentdatabase.entities");
        schema.setDefaultJavaPackageDao("com.miguelcr.studentdatabase.dao");


        addStudent(schema);

        new DaoGenerator().generateAll(schema, "../02_StudentDatabase/app/src/main/java");
    }

    private static void addStudent(Schema schema) {
        Entity student = schema.addEntity("Student");
        student.addIdProperty().autoincrement();
        student.addStringProperty("name").notNull();
        student.addIntProperty("age");
        student.addStringProperty("sex");
    }
}
