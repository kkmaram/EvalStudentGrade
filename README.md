# EvalStudentGrade
Evaluates Student's garde based on given dates.
First paramter takes high school graduation date in "yyyy-MM-DD" format.
Second paramter takes date on which the grade is evaluated.

Assumptions:
1. date inputs are provided in valid format( else system throws exception)
2. Academic year starts on Sep-01.
3. Given date can be null, in which case, today's date is taken for grade evaluation.

Examples:
Graduation Date: 2019-06-30
Given Date : 2018-07-25
Expected Grade: 11

Graduation Date: 2019-06-30
Given Date : 2018-09-01
Expected Grade: 12
