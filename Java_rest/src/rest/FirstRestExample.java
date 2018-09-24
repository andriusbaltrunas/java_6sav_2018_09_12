package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/example")
public class FirstRestExample {

    @GET
    @Path("/sayHi")
    public String sayHi() {
        return "Labas";
    }

    @GET
    @Path("/sayHi/{name}")
    public String sayHiToNme(@PathParam("name") String userName) {
        return "Labas, kaip gyveni " + userName;
    }

    @GET
    @Path("/student")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudent() {
        return new Student(1, "Andrius", "Baltrunas", "a@kcs.com", "+3708477474");
    }

    @GET
    @Path("/students")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getStudents() {
        return buildDummyData();
    }


    private List<Student> buildDummyData() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Andrius", "Baltrunas", "a@kcs.com", "+3708477474"));
        students.add(new Student(2, "Jonas", "Jonaitis", "j@kcs.com", "+37084325235"));
        students.add(new Student(3, "Petras", "Petraitis", "p@kcs.com", "+370235235235"));

        return students;
    }

    @GET
    @Path("/student/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student getStudentById(@PathParam("id") int id) {
        List<Student> students = buildDummyData();
        return students.stream().filter(s -> s.getId() == id).findFirst().get();
    }

    @POST
    @Path("/saveStudent")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student saveStudent(Student student) {
        student.setId(4);
        student.setName(student.getName() + "_changed");
        student.setLastName(student.getLastName() + "_changed");
        student.setEmail(student.getEmail() + "_changed");
        student.setPhone(student.getPhone() + "_changed");
        return student;
    }

}
