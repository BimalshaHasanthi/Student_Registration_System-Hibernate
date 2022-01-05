package entity;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Detail implements SuperEntity{
    @Id
    private String detailId;
    @CreationTimestamp
    private Date date;

    @ManyToOne(cascade = CascadeType.ALL)
    private Program program;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

    public Detail() {
    }

    public Detail(String detailId, Date date, Program program, Student student) {
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

    @Override
    public String toString() {
        return "Detail{" +
                "detailId='" + detailId + '\'' +
                ", date=" + date +
                ", program=" + program +
                ", student=" + student +
                '}';
    }
}
