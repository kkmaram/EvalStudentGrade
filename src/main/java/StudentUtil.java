import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;


public class StudentUtil {


    private static final String DT_FORMAT = "yyyy-MM-dd";

    /**
     * returns student's grade level based on dates given.
     * @param highSchoolGradDateStr
     * @param givenDateStr
     * @return
     * @throws ParseException
     */
    public int getGradeOnGivenDate(String highSchoolGradDateStr, String
            givenDateStr) throws ParseException {

        Date grdDt = DateUtils.parseDate(highSchoolGradDateStr,DT_FORMAT);

        Date givenDt = givenDateStr == null ? Calendar.getInstance().getTime() : DateUtils.parseDate(givenDateStr,DT_FORMAT);

        if(DateUtils.isSameDay(grdDt,givenDt)){

            return GradesEnum.SENIORS.getGradeLevel();

        }else if(givenDt.after(grdDt)){

            return 99;

        }else if(givenDt.before(grdDt)){

            LocalDateTime ldtGrdDt = LocalDateTime.ofInstant(grdDt.toInstant(), ZoneId.systemDefault());

            LocalDateTime ldtGivenDt = LocalDateTime.ofInstant(givenDt.toInstant(), ZoneId.systemDefault());

            long diffInYears = ChronoUnit.YEARS.between(ldtGivenDt,ldtGrdDt);

            int givenDtMonth = ldtGivenDt.getMonth().getValue();

            if(givenDtMonth > Month.JUNE.getValue() && givenDtMonth < Month.SEPTEMBER.getValue()){
                diffInYears++;
            }

            return getCurrentGrade(diffInYears).getGradeLevel();
        }
        return 0;
    }

    /**
     *
     * @param diffInYears
     * @return
     */
    private GradesEnum getCurrentGrade(long diffInYears) {
        for(GradesEnum grade : GradesEnum.values()){
            if(grade.getYrsToGraduateHS() == diffInYears ){
               return grade;
            }
        }
        return GradesEnum.PRE_SCHOOL;

    }
}
