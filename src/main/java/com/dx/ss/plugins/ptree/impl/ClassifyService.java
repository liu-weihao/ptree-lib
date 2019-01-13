package com.dx.ss.plugins.ptree.impl;

import com.dx.ss.plugins.ptree.dao.TreeDao;
import com.dx.ss.plugins.ptree.interfaces.IClassifyService;
import com.dx.ss.plugins.ptree.model.TreeNode;
import com.dx.ss.plugins.ptree.utils.NodeCommon;

import java.util.List;

/**
 * 功能：分类通用操作业务类
 *
 * @author liu.weihao
 * @version V1.0
 */
public abstract class ClassifyService<Node extends TreeNode, T extends TreeDao<Node>> implements IClassifyService<Node> {

    private T classifyDao;

    /**
     * 功能：分类树形结构
     *
     * @author liu.weihao
     */
    @Override
    public String getClassifyTree() {
        return classifyDao.classifyTree();
    }

    /**
     * 功能：获取分类列表
     *
     * @param parentId    如果为null，表示获取所有分类，否则获取指定分类的<strong>直接子类</strong>
     * @param includeSelf 是否包含父类本身
     * @author liu.weihao
     */
    @Override
    public List<Node> classifyList(Integer parentId, boolean includeSelf) {
        return classifyDao.classifyList(parentId, includeSelf);
    }

    /**
     * 功能：根据id获取分类详情
     *
     * @author liu.weihao
     */
    @Override
    public Node getClassifyInfoById(Integer classifyId) {
        if (classifyId != null && classifyId > 0) return (Node) classifyDao.getClassifyInfoById(classifyId);
        return null;
    }

    /**
     * 功能：根据子类id，获取父类信息
     *
     * @param children 子类id
     * @author weihao.liu
     */
    @Override
    public Node getParentClassify(Integer children) {
        return classifyDao.getParentClassify(children);
    }

    @Override
    public List<Node> classifyListByLevel(Integer level) {
        return classifyDao.classifyListByLevel(level);
    }

    @Override
    public List<Node> getParentSiblings(Integer children) {
        return classifyDao.getParentSiblings(children);
    }

    /**
     * 功能：生成一个新节点
     *
     * @param classify 要添加的节点
     * @param parentId 父节点id
     * @param preId    前置节点，最前端则不传入
     * @author liu.weihao
     */
    @Override
    public Node mallocClassify(Node classify, Integer parentId, Integer preId) {
        //添加分类，计算新加入的分类的左右节点和层级
        int nlevel = 0, leftId = 0, rightId = 0;
        Node referClassify = null;
        if (parentId != null && parentId > 0 && preId == 0) {  //最前端
            referClassify = (Node) classifyDao.getClassifyInfoById(parentId);
            nlevel = NodeCommon.addSubLevel(referClassify.getNlevel());
            leftId = NodeCommon.addSubLeftNode(referClassify.getLeftId());
            rightId = NodeCommon.addSubRightNode(referClassify.getLeftId());
        } else if (preId != null && preId > 0) {    //已选择前置节点
            referClassify = (Node) classifyDao.getClassifyInfoById(preId);
            nlevel = referClassify.getNlevel();
            leftId = NodeCommon.addSubLeftNode(referClassify.getRightId());
            rightId = NodeCommon.addSubRightNode(referClassify.getRightId());
        }
        classify.setNlevel(nlevel);
        classify.setLeftId(leftId);
        classify.setRightId(rightId);
        return classify;
    }

    /**
     * 功能：添加类别
     *
     * @author liu.weihao
     */
    @Override
    public boolean addClassify(Node classify) {
        classifyDao.allocateLeftId(classify);
        classifyDao.allocateRightId(classify);
        return classifyDao.addClassify(classify) != null;
    }

    /**
     * 功能：修改分类，不传入分类id将会修改失败
     *
     * @author liu.weihao
     */
    @Override
    public boolean editClassify(Node classify) {

        return classifyDao.editClassify(classify);
    }

    /**
     * 功能：删除分类信息
     *
     * @author liu.weihao
     */
    @Override
    public boolean removeClassifyById(Integer classifyId) {
        Node classifyInfo = getClassifyInfoById(classifyId);
        Integer leftId = classifyInfo.getLeftId(), rightId = classifyInfo.getRightId();
        if (classifyDao.removeClassifyById(classifyId)) {
            classifyDao.recycleLeftId(leftId);
            classifyDao.recycleRightId(rightId);
            return true;
        }
        return false;
    }

}
