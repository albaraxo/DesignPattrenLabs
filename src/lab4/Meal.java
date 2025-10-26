package lab4;

public class Meal {
    String appetizers;
    String main_courses;
    String side_dishes;
    String desserts;

    public Meal() {

    }

    public String getAppetizers() {
        return appetizers;
    }

    public void setAppetizers(String appetizers) {
        this.appetizers = appetizers;
    }

    public String getMain_courses() {
        return main_courses;
    }

    public void setMain_courses(String main_courses) {
        this.main_courses = main_courses;
    }

    public String getSide_dishes() {
        return side_dishes;
    }

    public void setSide_dishes(String side_dishes) {
        this.side_dishes = side_dishes;
    }

    public String getDesserts() {
        return desserts;
    }

    public void setDesserts(String desserts) {
        this.desserts = desserts;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "appetizers='" + appetizers + '\'' +
                ", main_courses='" + main_courses + '\'' +
                ", side_dishes='" + side_dishes + '\'' +
                ", desserts='" + desserts + '\'' +
                '}';
    }
}

interface MealBuilder{
    public Meal build();
    public ConcreteMealBuilder buildAppetizers(String appetizers);
    public ConcreteMealBuilder buildMainCourse(String main_courses);
    public ConcreteMealBuilder buildSideDishes(String side_dishes);
    public ConcreteMealBuilder buildDessert(String desserts);


}

class ConcreteMealBuilder implements MealBuilder{

    Meal meal;
    public ConcreteMealBuilder() {
        this.meal = new Meal();
    }


    @Override
    public ConcreteMealBuilder buildAppetizers(String appetizers) {
        meal.setAppetizers(appetizers);
        return this;
    }

    @Override
    public ConcreteMealBuilder buildMainCourse(String main_courses) {
        meal.setMain_courses(main_courses);
        return this;
    }

    @Override
    public ConcreteMealBuilder buildSideDishes(String side_dishes) {
       meal.setSide_dishes(side_dishes);
       return this;
    }

    @Override
    public ConcreteMealBuilder buildDessert(String desserts) {
        meal.setDesserts(desserts);
        return this;
    }
    @Override
    public Meal build() {
        return this.meal;
    }
}
class MealBuilderDirector{
    public Meal ConcreteMeal(MealBuilder builder) {
      return builder
              .buildAppetizers("baking bread")
              .buildMainCourse("Stake Dian")
              .buildSideDishes("cisar Salad")
              .buildDessert("cease cake")
              .build();
    }
}

class BuilderMealDemo{
    public static void main(String[] args) {
        MealBuilder builder = new ConcreteMealBuilder();
        MealBuilderDirector director = new MealBuilderDirector();

        Meal defultMeal = director.ConcreteMeal(builder);
        System.out.println(defultMeal.toString());

        Meal buildCustomMeal = new ConcreteMealBuilder()
                .buildAppetizers("warg onab")
                .buildMainCourse("burger")
                .buildSideDishes("no side")
                .buildDessert("pie")
                .build();

        System.out.println(buildCustomMeal.toString());

    }
}
