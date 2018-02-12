import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class StudentUtilTest {

    private final String hsclGrdDt;
    private final String givenDate;
    private final int expectedResult;
    private StudentUtil studentUtil;


    @org.junit.Before
    public void setUp() {
        studentUtil = new StudentUtil();
    }

    public StudentUtilTest(String hsclGrdDt, String givenDate,int expectedResult) {
        this.hsclGrdDt = hsclGrdDt;
        this.givenDate = givenDate;
        this.expectedResult = expectedResult;
    }


    @org.junit.After
    public void tearDown() {
    }

    @Parameterized.Parameters
    public static Collection dateInputsAndExpectedGrades() {
        return Arrays.asList(new Object[][] {
                { "2019-06-30", "2019-06-30",12 },
                { "2019-06-30", null,11 },
                { "2019-06-30", "2002-02-10",-1 },
                { "2018-02-10", "2018-03-10",99 },
                { "2018-02-10", "2016-02-10",10 },
                { "2019-06-30", "2018-10-10",12 },
                { "2018-06-30", null,12 },
                { "2019-06-30", "2018-07-30",11 },
                { "2019-06-30", "2018-09-01",12 },
                { "2019-06-30", "2014-08-30",7 },
                { "2019-06-30", "2007-08-30",0 },
                { "2019-06-30", "2007-09-01",1 },
                { "2019-06-30", "2019-09-01",99 },
                { "2019-06-30", "2015-07-01",8 },
                { "2019-06-30", "2015-09-01",9 },
        });
    }


    @org.junit.Test
    public void getGradeOnGivenDate() throws ParseException {
        System.out.println(String.format("Parameterized dates :: hsclGrdDt='%s', givenDate='%s'",hsclGrdDt,givenDate));
        assertEquals(expectedResult,
                studentUtil.getGradeOnGivenDate(hsclGrdDt,givenDate));
    }
}