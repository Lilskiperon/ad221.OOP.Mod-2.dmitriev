package Modular_2;

public class Person {
    public String gender;
    public int age;
    public int height;
    public int weight;
    public String activity;
    public String goal;
    public double metabolism;
    public double dailyNorm;
    public double weightCalories;
    public Person(String gender,int age,int height,int weight,String activity,String goal,double metabolism,double dailyNorm,double weightCalories){
        this.gender = gender;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.activity = activity;
        this.goal = goal;
        this.metabolism = metabolism;
        this.dailyNorm = dailyNorm;
        this.weightCalories = weightCalories;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public String getActivity() {
        return activity;
    }

    public String getGoal() {
        return goal;
    }
    public double getMetabolism() {
        return metabolism;
    }
    public double getDailyNorm() {
        return dailyNorm;
    }
    public double getWeightCalories() {
        return weightCalories;
    }

    public void setMetabolism(double metabolism){
        this.metabolism=metabolism;
    }
    public void setDailyNorm(double dailyNorm){
        this.dailyNorm=dailyNorm;
    }
    public void setWeightCalories(double weightCalories){
        this.weightCalories=weightCalories;
    }
    public void calculateCalories(){

        if (getGender() == "Мужчина") {
            setMetabolism((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) + 5);
        } else {
            setMetabolism((10 * getWeight()) + (6.25 * getHeight()) - (5 * getAge()) - 161);
        }


        if (getActivity() == "Низкий") {
            setDailyNorm(getMetabolism() * 1.375);
        } else if (getActivity() == "Средний") {
            setDailyNorm(getMetabolism() * 1.55);
        } else if (getActivity() == "Высокий") {
            setDailyNorm(getMetabolism() * 1.725);
        }

        switch (getGoal()) {
            case "Похудеть на 2 кг за неделю":
                setWeightCalories(getDailyNorm() - 1000);
                break;

            case "Похудеть на 1.5 кг за неделю":
                setWeightCalories(getDailyNorm() - 750);
                break;

            case "Похудеть на 1 кг за неделю":
                setWeightCalories(getDailyNorm() - 500);
                break;

            case "Похудеть на 0.5 кг за неделю":
                setWeightCalories(getDailyNorm() - 250);
                break;

            case "Ничего":
                setWeightCalories(getDailyNorm());
                break;

            case "Набрать 0.5 кг за неделю":
                setWeightCalories(getDailyNorm() + 250);
                break;

            case "Набрать 1 кг за неделю":
                setWeightCalories(getDailyNorm() + 500);
                break;

            case "Набрать 1.5 кг за неделю":
                setWeightCalories(getDailyNorm() + 750);
                break;

            case "Набрать 2 кг за неделю":
                setWeightCalories(getDailyNorm() + 1000);

        }
    }
}

