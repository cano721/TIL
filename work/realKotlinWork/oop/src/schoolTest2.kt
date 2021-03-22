import kr.multicampus.kotlin.insa.Staff
import kr.multicampus.kotlin.insa.Student
import kr.multicampus.kotlin.insa.Teacher

fun main(){
    var student: Student = Student("홍길동",20,200201)
    var teacher: Teacher = Teacher("이순신",30,"JAVA")
    var staff: Staff = Staff("유관순",40,"교무과")

    student.print()
    teacher.print()
    staff.print()
}