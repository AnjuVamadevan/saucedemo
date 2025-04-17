package com.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.opencsv.exceptions.CsvValidationException;
import com.utitlities.Utilities;

public class LoginData {

    @DataProvider(name = "validCredentials")
    public Object[][] validCredentials() throws CsvValidationException, IOException {
//        return new Object[][]{
//            {"standard_user", "secret_sauce", "inventory.html"},
//            {"problem_user", "secret_sauce", "inventory.html"}
//        };
        return Utilities.readDataFromCSV("src/test/resources/validCredentials.csv");

    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] invalidCredentials() throws CsvValidationException, IOException {
//        return new Object[][]{
//            {"locked_out_user", "secret_sauce", "locked out"},
//            {"invalid_user", "wrong_pass", "Username and password"},
//            {"", "", "Username is required"},
//            {"standard_user", "", "Password is required"}
//        };
        return Utilities.readDataFromCSV("src/test/resources/invalidCredentials.csv");

    }
}
