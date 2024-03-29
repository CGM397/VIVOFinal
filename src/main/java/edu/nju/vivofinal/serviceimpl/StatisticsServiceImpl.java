package edu.nju.vivofinal.serviceimpl;

import edu.nju.vivofinal.dao.ParentInfoDao;
import edu.nju.vivofinal.dao.TeacherInfoDao;
import edu.nju.vivofinal.model.ExamScore;
import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.model.ScoreItem;
import edu.nju.vivofinal.model.Teacher;
import edu.nju.vivofinal.service.StatisticsService;
import edu.nju.vivofinal.service.TeacherInfoService;
import edu.nju.vivofinal.statistics.AverageScore;
import edu.nju.vivofinal.statistics.StudentScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ParentInfoDao parentInfoDao;
    @Autowired
    private TeacherInfoDao teacherInfoDao;
    @Autowired
    private TeacherInfoService teacherInfoService;

    @Override
    public StudentScore showStudentScores(String parentMail) {
        StudentScore res = new StudentScore();
        List<Date> examDate = new ArrayList<>();
        List<Double> scores = new ArrayList<>();
        Parent parent = parentInfoDao.findParentByMail(parentMail);
        String studentId = parent.getStudentId();
        Teacher teacher = teacherInfoService.findTeacherByParentMail(parentMail);
        if(teacher != null) {
            List<ExamScore> examScores = new ArrayList<>(teacher.getExamScores());
            sort(examScores);
            for(ExamScore oneExamScore : examScores) {
                Date oneDate = oneExamScore.getExamTime();
                List<ScoreItem> items = oneExamScore.getItems();
                for(ScoreItem oneItem : items) {
                    if(oneItem.getStudentId().equals(studentId)) {
                        examDate.add(oneDate);
                        scores.add(oneItem.getExamScore());
                        break;
                    }
                }
            }
        }
        res.setExamDate(examDate);
        res.setScores(scores);
        return res;
    }

    private void sort(List<ExamScore> store) {
        for(int i = 0; i < store.size() - 1; i++) {
            for(int j = 0; j < store.size() - i - 1; j++) {
                ExamScore one = store.get(j);
                ExamScore two = store.get(j + 1);
                Date oneDate = one.getExamTime();
                Date twoDate = two.getExamTime();
                if(oneDate.after(twoDate)) {
                    ExamScore tmpOne = store.get(j);
                    ExamScore tmpTwo = store.get(j + 1);
                    store.set(j, tmpTwo);
                    store.set(j + 1, tmpOne);
                }
            }
        }
    }

    @Override
    public AverageScore showAverageScores(String teacherMail) {
        AverageScore res = new AverageScore();
        List<Date> examDate = new ArrayList<>();
        List<Double> averageScores = new ArrayList<>();
        Teacher teacher = teacherInfoDao.findTeacherByMail(teacherMail);
        List<ExamScore> examScoreList = new ArrayList<>(teacher.getExamScores());
        sort(examScoreList);
        for(ExamScore one : examScoreList) {
            Date oneDate = one.getExamTime();
            double totalScore = 0.0;
            int num = 0;
            double oneAverageScore = 0;
            for(ScoreItem oneItem : one.getItems()) {
                totalScore += oneItem.getExamScore();
                num++;
            }
            if(num > 0)
                oneAverageScore = totalScore / num;
            examDate.add(oneDate);
            averageScores.add(oneAverageScore);
        }
        res.setExamDate(examDate);
        res.setAverageScores(averageScores);
        return res;
    }


}
