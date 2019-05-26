package edu.nju.vivofinal.service;

import edu.nju.vivofinal.statistics.AverageScore;
import edu.nju.vivofinal.statistics.StudentScore;

public interface StatisticsService {

    StudentScore showStudentScores(String parentMail);

    AverageScore showAverageScores(String teacherMail);

}
