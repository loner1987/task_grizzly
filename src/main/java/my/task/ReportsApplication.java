package my.task;

import my.task.domain.Reports;
import my.task.repository.ReportRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

@ComponentScan
@EnableAutoConfiguration
public class ReportsApplication {

	@Bean
	InitializingBean saveData(ReportRepository repo){
		return () -> {
			repo.save(new Reports(new Date(), new Date(), "test1", "test1"));
			repo.save(new Reports("13 Jan 2017", "13 Jan 2017", "test2", "test2"));
			repo.save(new Reports("31 Dec 2016", "31 Dec 2016", "test3", "test3"));
			repo.save(new Reports("31 Dec 2016", "31 Dec 2016", "test4", "test3"));
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ReportsApplication.class, args);
	}
}
