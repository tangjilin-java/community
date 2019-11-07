package ab.tjl.tscommunity.service;

import ab.tjl.tscommunity.mapper.AdMapper;
import ab.tjl.tscommunity.model.Ad;
import ab.tjl.tscommunity.model.AdExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:TangJiLin
 * @Description:广告业务层
 * @Date: Created in 2019/11/7 19:17
 * @Modified By:
 */
@Service
public class AdService {
    @Autowired
    private AdMapper adMapper;


    public List<Ad> list(String pos){
        AdExample adExample = new AdExample();
        adExample.createCriteria()
                .andStatusEqualTo(1)
                .andPosEqualTo(pos)
                .andGmtStartLessThan(System.currentTimeMillis())
                .andGmtEndGreaterThan(System.currentTimeMillis());
        //adExample.setOrderByClause("priority desc");

        return adMapper.selectByExample(adExample);
    }
}
