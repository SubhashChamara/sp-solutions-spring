package biz.spsolutions.workallocationpanel;

import biz.spsolutions.workallocationpanel.app.entity.WorkTaskOriginal;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(WorkTaskOriginal.class)
@MapperScan("biz.spsolutions.workallocationpanel.app.dao.mapper")
@SpringBootApplication
public class WorkAllocationPanelApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkAllocationPanelApplication.class, args);
	}

}
