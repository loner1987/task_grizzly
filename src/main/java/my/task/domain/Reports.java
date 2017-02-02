package my.task.domain;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Loner on 24.01.2017.
 */

@Entity
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date startDate;
    private Date endDate;
    private String perfomer;
    private String activity;

    @Transient
    private SimpleDateFormat format = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);

    public Reports(Date startDate, Date endDate, String perfomer, String activity) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.perfomer = perfomer;
        this.activity = activity;
    }

    public Reports(String startDate, String endDate, String perfomer, String activity) throws ParseException{
        this.startDate = format.parse(startDate);
        this.endDate = format.parse(endDate);
        this.perfomer = perfomer;
        this.activity = activity;
    }

    public Reports() {
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPerfomer() {
        return perfomer;
    }

    public void setPerfomer(String perfomer) {
        this.perfomer = perfomer;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public String toString() {
        return "Reports{" +
                "activity='" + activity + '\'' +
                ", perfomer='" + perfomer + '\'' +
                ", endDate=" + endDate +
                ", startDate=" + startDate +
                '}';
    }
}
