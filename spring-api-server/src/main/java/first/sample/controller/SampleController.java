package first.sample.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import first.sample.service.SampleService;

@Controller
public class SampleController {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="sampleService")
	private SampleService sampleService;
	
	@RequestMapping(value="/sample/openSampleBoardList.do", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
    public List<Map<String,Object>> openSampleBoardList(Map<String,Object> commandMap) throws Exception{
    	//ModelAndView mv = new ModelAndView("/sample/index");
    	
    	List<Map<String,Object>> list = sampleService.selectBoardList(commandMap);
    	//mv.addObject("list", list);
    	return list;
    	
    	//return mv;
    }
}
