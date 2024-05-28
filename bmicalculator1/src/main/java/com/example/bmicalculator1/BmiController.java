package com.example.bmicalculator1;

import org.springframework.web.bind.annotation.*;

//Calling ReactJS

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bmi")
public class BmiController {

    @PostMapping("/calculate")
    public BmiResponse calculateBmi(@RequestBody BmiRequest request) {
        double heightInMeters = request.getHeight() / 100.0;
        double bmi = request.getWeight() / (heightInMeters * heightInMeters);
        String category = categorizeBmi(bmi);

        return new BmiResponse(bmi, category);
    }

    //Calculations part added here

    private String categorizeBmi(double bmi) {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 24.9) return "Normal weight";
        else if (bmi < 29.9) return "Overweight";
        else return "Obesity";
    }
}

//Handled all the input and output

class BmiRequest {
    private double height;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private double weight;
    private String gender;
}

class BmiResponse {
    private double bmi;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBmi() {
        return bmi;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }

    private String category;

    public BmiResponse(double bmi, String category) {
        this.bmi = bmi;
        this.category = category;
    }


}
