object scala_ws {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  println("Welcome to the Scala worksheet")
  
  case class Student (var id : Int=1, var name : String="Athi", var age : Int = 50)
  {
  	def show() = println("Name = " + name + ", Age = " + age)
  	
  	def >(student : Student) : Boolean = age > student.age
  };$skip(255); 
  
  var s1 =Student(1, "Rahul", 25);System.out.println("""s1  : scala_ws.Student = """ + $show(s1 ));$skip(12); 
  s1.show();$skip(29); 
  var s2 = Student(2,"Renu");System.out.println("""s2  : scala_ws.Student = """ + $show(s2 ));$skip(11); 
	s2.show();$skip(11); val res$0 = 
	
	s1>(s2);System.out.println("""res0: Boolean = """ + $show(res$0));$skip(44); 
	
	//List
	var numsList = List(6,5,1,2,3,4);System.out.println("""numsList  : List[Int] = """ + $show(numsList ));$skip(17); 
	print(numsList);$skip(32); 
	for (n <- numsList) println(n);$skip(50); 
  //Lamba
  numsList.foreach{i:Int => println(i)};$skip(41); 
  
  var reversedList = numsList.reverse;System.out.println("""reversedList  : List[Int] = """ + $show(reversedList ));$skip(22); 
  print(reversedList);$skip(20); 
 
 	print(numsList);$skip(35); 
  var sortedList = numsList.sorted;System.out.println("""sortedList  : List[Int] = """ + $show(sortedList ));$skip(20); 
  print(sortedList);$skip(18); 
  print(numsList);$skip(37); 
  	
  var newList = numsList.drop(2);System.out.println("""newList  : List[Int] = """ + $show(newList ));$skip(17); 
  print(newList);$skip(42); 
  var newList1 = numsList.drop(2).take(2);System.out.println("""newList1  : List[Int] = """ + $show(newList1 ));$skip(18); 
  print(newList1);$skip(27); val res$1 = 
  numsList.drop(2).take(2);System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(28); val res$2 = 
  
  numsList drop 3 take 3;System.out.println("""res2: List[Int] = """ + $show(res$2));$skip(49); 
  
  var complexList = List (1,2,3,"Athi", true);System.out.println("""complexList  : List[Any] = """ + $show(complexList ));$skip(21); 
  print(complexList);$skip(28); val res$3 = 
  complexList drop 3 take 3;System.out.println("""res3: List[Any] = """ + $show(res$3));$skip(110); 
  
  val students = List(Student(), Student(1, "Rahul", 25), Student(1, "Renu", 26), Student(4, "Navin", 54));System.out.println("""students  : List[scala_ws.Student] = """ + $show(students ));$skip(18); 
  print(students);$skip(44); 
  students.foreach{i:Student => println(i)};$skip(24); 
  print (students.head);$skip(24); 
  print (students.tail);$skip(29); 
  print (students.tail.tail);$skip(29); 
  print (students.tail.head);$skip(18); 
  print(students);$skip(58); 
  
  val midagestudents = students.filter(s => s.age>=50);System.out.println("""midagestudents  : List[scala_ws.Student] = """ + $show(midagestudents ));$skip(24); 
  print(midagestudents);$skip(72); 
  
  val mid20s = students.partition(s => (s.age >= 20 && s.age <= 30));System.out.println("""mid20s  : (List[scala_ws.Student], List[scala_ws.Student]) = """ + $show(mid20s ));$skip(16); 
  print(mid20s);$skip(33); 
  
  //Tuples
  print(mid20s._1);$skip(19); 
  print(mid20s._2);$skip(80); 
  
  val (part1, part2) = students.partition(s => (s.age >= 20 && s.age <= 30));System.out.println("""part1  : List[scala_ws.Student] = """ + $show(part1 ));System.out.println("""part2  : List[scala_ws.Student] = """ + $show(part2 ));$skip(8); val res$4 = 
  part1;System.out.println("""res4: List[scala_ws.Student] = """ + $show(res$4));$skip(11); val res$5 = 
  
  part2;System.out.println("""res5: List[scala_ws.Student] = """ + $show(res$5))}
  
}
