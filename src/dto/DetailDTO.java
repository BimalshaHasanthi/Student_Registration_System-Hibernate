package dto;

import entity.Program;
import entity.Student;


import java.util.Date;

public class DetailDTO {
    private String detailId;
    private Date date;
    private Program program;
    private Student student;

    public DetailDTO() {
    }

    public DetailDTO(String detailId, Date date, Program program, Student student) {
        this.setDetailId(detailId);
        this.setDate(date);
        this.setProgram(program);
        this.setStudent(student);
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
