package rest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/student")
public class StudentRest {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> getAllStudents() {
        StudentDaoService studentDaoService = new StudentDaoService();
        List<Student> students = studentDaoService.getStudents();
        return students;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Student returnStudent(@PathParam("id") int id) {
        StudentDaoService sdt = new StudentDaoService();
        Student student = sdt.getStudent(id);
        return student;
    }

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveStudent(Student student) {
        StudentDaoService studentDaoService = new StudentDaoService();
        studentDaoService.createStudent(student);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id")int id, Student student) {
        StudentDaoService studentDaoService = new StudentDaoService();
        student.setId(id);
        studentDaoService.updateStudent(student);
        return Response.ok().build();

    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id")int id){
        StudentDaoService studentDaoService = new StudentDaoService();
        studentDaoService.deleteStudent(id);

        return Response.status(Response.Status.NO_CONTENT).build();
    }
}


