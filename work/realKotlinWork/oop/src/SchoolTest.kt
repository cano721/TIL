import kr.multicampus.kotlin.insa.Staff
import kr.multicampus.kotlin.insa.Student
import kr.multicampus.kotlin.insa.Teacher
import kr.multicampus.kotlin.insa.Person

fun main(){
    var student:Student = Student("홍길동",20,200201)
    var teacher:Teacher = Teacher("이순신",30,"JAVA")
    var staff:Staff = Staff("유관순",40,"교무과")

    var obj4:Person = Student("홍길동",20,200201)
    var obj5:Person = Teacher("이순신",30,"JAVA")
    var obj6:Person = Staff("유관순",40,"교무과")
    student.print()
    teacher.print()
    staff.print()

    obj4.print()
    obj5.print()
    obj6.print()
}