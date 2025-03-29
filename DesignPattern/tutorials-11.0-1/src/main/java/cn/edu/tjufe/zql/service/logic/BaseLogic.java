package cn.edu.tjufe.zql.service.logic;

import cn.edu.tjufe.zql.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

public abstract class BaseLogic implements LogicFilter {
    @Override
    public abstract String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);

    @Override
    public Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList){
        for(TreeNodeLink treeNodeLink : treeNodeLineInfoList){
            if(desicionLogic(matterValue,treeNodeLink)) return treeNodeLink.getNodeIdTo();
        }
        return 0L;
    }

    public boolean desicionLogic(String matterValue,TreeNodeLink nodeLink){
        switch(nodeLink.getRuleLimitType()){
            case 1: return matterValue.equals(nodeLink.getRuleLimitValue());
            case 2: return Double.parseDouble(matterValue) > Double.parseDouble(nodeLink.getRuleLimitValue());
            case 3: return Double.parseDouble(matterValue) < Double.parseDouble(nodeLink.getRuleLimitValue());
            case 4: return Double.parseDouble(matterValue) >= Double.parseDouble(nodeLink.getRuleLimitValue());
            case 5: return Double.parseDouble(matterValue) <= Double.parseDouble(nodeLink.getRuleLimitValue());
            default: return false;
        }
    }
}
