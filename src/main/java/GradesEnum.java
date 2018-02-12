public enum GradesEnum {

    PRE_SCHOOL(-1,13),KINDER_GARDEN(0,12),FIRST(1,11),SECOND(2,10),THIRD(3,9),FOURTH(4,8),FIFTH(5,7),SIXTH(6,6),
    SEVENTH(7,5),EIGHTH(8,4),FRESHMAN(9,3),SOPHOMORE(10,2),JUNIORS(11,1),SENIORS(12,0);



    private final int gradeLevel;
    private final int yrsToGraduateHS;

    GradesEnum(int gradeLevel,int yrsToGraduateHS){
        this.gradeLevel = gradeLevel;
        this.yrsToGraduateHS = yrsToGraduateHS;
    }

    public int getGradeLevel() {
        return gradeLevel;
    }

    public int getYrsToGraduateHS() {
        return yrsToGraduateHS;
    }


}
