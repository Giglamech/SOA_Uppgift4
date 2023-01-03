import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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

    public CalendarEntry(JSONObject content) throws JSONException {
        JSONArray columns = (JSONArray) content.get("columns");

        this.id = content.get("id").toString();
        this.startDate = content.get("startdate").toString();
        this.endDate = content.get("enddate").toString();
        this.startTime = content.get("starttime").toString();
        this.endTime = content.get("endtime").toString();
        this.location = columns.get(2).toString();
        this.courseCode = columns.get(7).toString();
        this.activityType = columns.get(1).toString();
        this.teacher = columns.get(3).toString();
    }


    public void printObject() {
        System.out.println("ID = " + id);
        System.out.println("StartDate = " + startDate);
        System.out.println("EndDate = " + endDate);
        System.out.println("StartTime = " + startTime);
        System.out.println("EndTime = " + endTime);
        System.out.println("Location = " + location);
        System.out.println("CourseCode = " + courseCode);
        System.out.println("ActivityType = " + activityType);
        System.out.println("Teacher = " + teacher);
    }
}
