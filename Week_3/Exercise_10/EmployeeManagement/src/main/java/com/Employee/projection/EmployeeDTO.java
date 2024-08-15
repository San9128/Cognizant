package com.Employee.projection;

public class EmployeeDTO {

private final String name;

private final String email;

public EmployeeDTO(String name, String email) {

this.name = name;

this.email = email;

}

public String getName() {

return name;

}

public String getEmail() {

return email;

}

}