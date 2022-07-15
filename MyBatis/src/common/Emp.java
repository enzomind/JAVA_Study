package common;

public class Emp {
   int employee_id;
   String first_name;
   int salary;

   @Override
   public String toString() {
	   return "[" + employee_id + "," + first_name + "," + salary + "]";
   }

}
