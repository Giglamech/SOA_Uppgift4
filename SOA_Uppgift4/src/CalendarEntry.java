import java.sql.Time;
import java.util.Date;
import java.util.Dictionary;

public class CalendarEntry {
    //Initiated with data from TimeEdit
    String id;
    String startDate;
    String endDate;
    String startTime;
    String endTime;

    String location;
    String courseCode;
    String activityType;
    String teacher;


    //Initiated by user
    String zoomLink;
    String activityContent;
    String title;
    String description;

    public CalendarEntry(String id, String startDate, String endDate, String startTime, String endTime, String location, String courseCode, String activityType, String teacher) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
        this.courseCode = courseCode;
        this.activityType = activityType;
        this.teacher = teacher;
    }

    public CalendarEntry(Dictionary<String, String> dict) {
        this.id = dict.get("id");
        this.startDate = dict.get("startdate");
        this.endDate = dict.get("enddate");
        this.startTime = dict.get("starttime");
        this.endTime = dict.get("endtime");
        this.location = dict.get("Plats, Lokal");
        this.courseCode = dict.get("Kurskod, Kursnamn");
        this.activityType = dict.get("Aktivitet");
        this.teacher = dict.get("Lärare, Student");
    }
}
