package ab.tjl.tscommunity.service;

import ab.tjl.tscommunity.dto.QuestionDTO;
import ab.tjl.tscommunity.mapper.QuestionMapper;
import ab.tjl.tscommunity.mapper.UserMapper;
import ab.tjl.tscommunity.model.Question;
import ab.tjl.tscommunity.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:tangjilin
 * @Description:问题业务层
 * @Date:Created in 16:23 2019/8/25
 * @Modified By:
 */
@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;

    public List<QuestionDTO> list() {
        List<Question> questions = questionMapper.list();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question:questions) {
          User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}
