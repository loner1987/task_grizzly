package my.task.controller;

import my.task.domain.JPAReports;
import my.task.repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


/**
 * Created by Loner on 25.01.2017.
 */

@RestController
public class HelloController {

    @Autowired
    ReportRepository repo;

    @Autowired
    JPAReports reports;

    /**
     * This is a start controller for index.jsp
     * Main idea is send data for selector
     * @return index.jsp
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView mov = new ModelAndView();
        mov.setViewName("index");

        mov.addObject("report", repo.findAll());
        return mov;
    }


    /**
     *
     * @param start data from start date input. Type is Date.
     * @param end data from end date input. Type is Date.
     * @param perfomer data from Performer selector. Type is String.
     * @return test.jsp
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public ModelAndView tram(@RequestParam(value = "start_date", defaultValue = "01/01/1900")Date start,
                             @RequestParam(value = "end_date", defaultValue = "01/01/1900")Date end,
                             @RequestParam("perf")String perfomer) {
        ModelAndView mov = new ModelAndView();
        mov.addObject("List", reports.getPerformers(start, end, perfomer));
        return mov;
    }
}
