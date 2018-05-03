object scala_ws {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  case class Student (var id : Int=1, var name : String="Athi", var age : Int = 50)
  {
  	def show() = println("Name = " + name + ", Age = " + age)
  	
  	def >(student : Student) : Boolean = age > student.age
  }
  
  var s1 =Student(1, "Rahul", 25)                 //> s1  : scala_ws.Student = Student(1,Rahul,25)
  s1.show()                                       //> Name = Rahul, Age = 25
  var s2 = Student(2,"Renu")                      //> s2  : scala_ws.Student = Student(2,Renu,50)
	s2.show()                                 //> Name = Renu, Age = 50
	
	s1>(s2)                                   //> res0: Boolean = false
	
	//List
	var numsList = List(6,5,1,2,3,4)          //> numsList  : List[Int] = List(6, 5, 1, 2, 3, 4)
	print(numsList)                           //> List(6, 5, 1, 2, 3, 4)
	for (n <- numsList) println(n)            //> 6
                                                  //| 5
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  //Lamba
  numsList.foreach{i:Int => println(i)}           //> 6
                                                  //| 5
                                                  //| 1
                                                  //| 2
                                                  //| 3
                                                  //| 4
  
  var reversedList = numsList.reverse             //> reversedList  : List[Int] = List(4, 3, 2, 1, 5, 6)
  print(reversedList)                             //> List(4, 3, 2, 1, 5, 6)
 
 	print(numsList)                           //> List(6, 5, 1, 2, 3, 4)
  var sortedList = numsList.sorted                //> sortedList  : List[Int] = List(1, 2, 3, 4, 5, 6)
  print(sortedList)                               //> List(1, 2, 3, 4, 5, 6)
  print(numsList)                                 //> List(6, 5, 1, 2, 3, 4)
  	
  var newList = numsList.drop(2)                  //> newList  : List[Int] = List(1, 2, 3, 4)
  print(newList)                                  //> List(1, 2, 3, 4)
  var newList1 = numsList.drop(2).take(2)         //> newList1  : List[Int] = List(1, 2)
  print(newList1)                                 //> List(1, 2)
  numsList.drop(2).take(2)                        //> res1: List[Int] = List(1, 2)
  
  numsList drop 3 take 3                          //> res2: List[Int] = List(2, 3, 4)
  
  var complexList = List (1,2,3,"Athi", true)     //> complexList  : List[Any] = List(1, 2, 3, Athi, true)
  print(complexList)                              //> List(1, 2, 3, Athi, true)
  complexList drop 3 take 3                       //> res3: List[Any] = List(Athi, true)
  
  val students = List(Student(), Student(1, "Rahul", 25), Student(1, "Renu", 26), Student(4, "Navin", 54))
                                                  //> students  : List[scala_ws.Student] = List(Student(1,Athi,50), Student(1,Rah
                                                  //| ul,25), Student(1,Renu,26), Student(4,Navin,54))
  print(students)                                 //> List(Student(1,Athi,50), Student(1,Rahul,25), Student(1,Renu,26), Student(4
                                                  //| ,Navin,54))
  students.foreach{i:Student => println(i)}       //> Student(1,Athi,50)
                                                  //| Student(1,Rahul,25)
                                                  //| Student(1,Renu,26)
                                                  //| Student(4,Navin,54)
  print (students.head)                           //> Student(1,Athi,50)
  print (students.tail)                           //> List(Student(1,Rahul,25), Student(1,Renu,26), Student(4,Navin,54))
  print (students.tail.tail)                      //> List(Student(1,Renu,26), Student(4,Navin,54))
  print (students.tail.head)                      //> Student(1,Rahul,25)
  print(students)                                 //> List(Student(1,Athi,50), Student(1,Rahul,25), Student(1,Renu,26), Student(4
                                                  //| ,Navin,54))
  
  val midagestudents = students.filter(s => s.age>=50)
                                                  //> midagestudents  : List[scala_ws.Student] = List(Student(1,Athi,50), Student
                                                  //| (4,Navin,54))
  print(midagestudents)                           //> List(Student(1,Athi,50), Student(4,Navin,54))
  
  val mid20s = students.partition(s => (s.age >= 20 && s.age <= 30))
                                                  //> mid20s  : (List[scala_ws.Student], List[scala_ws.Student]) = (List(Student(
                                                  //| 1,Rahul,25), Student(1,Renu,26)),List(Student(1,Athi,50), Student(4,Navin,5
                                                  //| 4)))
  print(mid20s)                                   //> (List(Student(1,Rahul,25), Student(1,Renu,26)),List(Student(1,Athi,50), Stu
                                                  //| dent(4,Navin,54)))
  
  //Tuples
  print(mid20s._1)                                //> List(Student(1,Rahul,25), Student(1,Renu,26))
  print(mid20s._2)                                //> List(Student(1,Athi,50), Student(4,Navin,54))
  
  val (part1, part2) = students.partition(s => (s.age >= 20 && s.age <= 30))
                                                  //> part1  : List[scala_ws.Student] = List(Student(1,Rahul,25), Student(1,Renu,
                                                  //| 26))
                                                  //| part2  : List[scala_ws.Student] = List(Student(1,Athi,50), Student(4,Navin,
                                                  //| 54))
  part1                                           //> res4: List[scala_ws.Student] = List(Student(1,Rahul,25), Student(1,Renu,26)
                                                  //| )
  
  part2                                           //> res5: List[scala_ws.Student] = List(Student(1,Athi,50), Student(4,Navin,54)
                                                  //| )
  
}