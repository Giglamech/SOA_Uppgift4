import java.sql.Time;
import java.util.Date;

public class CanvasCalendarEntry {
    Date date;
    Time startTime;
    Time endTime;

    String courseCode;
    String lectionType;
    String location;
    String zoomLink;
    String teacher;
    String lectionContent;

    public CanvasCalendarEntry(String[] sendRequest) {
    }
}
