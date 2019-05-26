package edu.nju.vivofinal.controller;

import edu.nju.vivofinal.model.Parent;
import edu.nju.vivofinal.service.ParentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parent")
public class ParentController {

    @Autowired
    private ParentInfoService parentInfoService;

    @PostMapping(value = "/update")
    @ResponseBody
    public void update(@RequestBody Parent parent){
        parentInfoService.updateParentInfo(parent);
    }

    @PostMapping(value = "/findByMail")
    @ResponseBody
    public Parent findParentInfoByMail(@RequestParam String parentMail) {
        return parentInfoService.findParentByMail(parentMail);
    }

    @PostMapping(value = "/applyToJoinClass")
    @ResponseBody
    public boolean applyToJoinClass(@RequestParam String parentMail, @RequestParam String teacherMail) {
        return parentInfoService.applyToJoinClass(parentMail, teacherMail);
    }

    @PostMapping(value = "/agreeApplication")
    @ResponseBody
    public boolean agreeApplication(@RequestParam long applicationId) {
        return parentInfoService.agreeApplication(applicationId);
    }

    @PostMapping(value = "/disagreeApplication")
    @ResponseBody
    public boolean disagreeApplication(@RequestParam long applicationId) {
        return parentInfoService.disagreeApplication(applicationId);
    }

}
