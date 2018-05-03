object Demo {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(38); 
  println("Hello World");$skip(25); 
  
  var num1 : Int = 9;System.out.println("""num1  : Int = """ + $show(num1 ));$skip(21); 
  val num2 : Int = 9;System.out.println("""num2  : Int = """ + $show(num2 ));$skip(23); 
  println(num1 + num2);$skip(58); 
  //val num12 : Float = 2.1;
  var name : String = "Athi";System.out.println("""name  : String = """ + $show(name ));$skip(35); 
  
  name = "Athi" + " " + "Muthu";$skip(19); 
  
  println(name)}
}
