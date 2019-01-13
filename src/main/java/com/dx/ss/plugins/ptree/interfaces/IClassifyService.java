package com.dx.ss.plugins.ptree.interfaces;

import com.dx.ss.plugins.ptree.model.TreeNode;

import java.util.List;

/**
 * 功能：树形结构(<a href="http://my.oschina.net/bootstrap/blog/166805">预排序遍历树算法</a>)<br/>
 * 相关操作接口定义
 *
 * @param <T> 具体的分类
 * @author weihao.liu
 * @version V1.0
 */
public interface IClassifyService<T extends TreeNode> {

    /**
     * 功能：商品分类树形结构
     *
     * @author weihao.liu
     */
    String getClassifyTree();

    /**
     * 功能：获取分类列表
     *
     * @param parentId    如果为null，表示获取所有分类，否则获取指定分类的<strong>直接子类</strong>
     * @param includeSelf 是否包含父类本身
     * @author weihao.liu
     */
    List<T> classifyList(Integer parentId, boolean includeSelf);

    /**
     * 功能：获取某个层级的分类
     *
     * @param level 分类层级，从1开始
     * @author weihao.liu
     */
    List<T> classifyListByLevel(Integer level);

    /**
     * 功能：根据子类id，获取父类以及父类的同级分类
     *
     * @author weihao.liu
     */
    List<T> getParentSiblings(Integer children);

    /**
     * 功能：根据子类id，获取父类信息
     *
     * @param children 子类id
     * @author weihao.liu
     */
    T getParentClassify(Integer children);

    /**
     * 功能：根据id获取分类详情
     *
     * @author liu.weihao
     */
    T getClassifyInfoById(Integer classifyId);

    /**
     * 功能：生成一个新节点
     *
     * @param classify 要添加的节点
     * @param parentId 父节点id
     * @param preId    前置节点，最前端则不传入
     * @author liu.weihao
     */
    T mallocClassify(T classify, Integer parentId, Integer preId);

    /**
     * 功能：添加类别
     *
     * @author liu.weihao
     */
    boolean addClassify(T classify);

    /**
     * 功能：修改分类，不传入分类id将会修改失败
     *
     * @author liu.weihao
     */
    boolean editClassify(T classify);

    /**
     * 功能：删除分类信息
     *
     * @author liu.weihao
     */
    boolean removeClassifyById(Integer classifyId);

}
