package com.dx.ss.plugins.ptree.dao;

import com.dx.ss.plugins.ptree.model.TreeNode;

import java.util.List;

/**
 * 功能：树形结构共用(<a href="http://my.oschina.net/bootstrap/blog/166805">预排序遍历树算法</a>)<br/>
 * <strong>不建议做批量删除功能</strong>
 *
 * @author liu.weihao
 * Copyright 2016 tsou.com, Inc. All rights reserved
 * @version V1.0
 */
public abstract class TreeDao<T extends TreeNode> {

    /**
     * 功能：获取分类列表
     *
     * @param parentId    如果为null，表示获取所有分类，否则获取指定分类的<strong>直接子类</strong>
     * @param includeSelf 查询子节点时，是否包含父节点本身。仅当{@code parentId!=null}时生效
     * @author liu.weihao
     */
    public abstract List<T> classifyList(Integer parentId, boolean includeSelf);

    /**
     * 功能：获取指定层级的分类
     *
     * @author weihao.liu
     */
    public abstract List<T> classifyListByLevel(Integer level);

    /**
     * 功能：根据子类id，获取父类以及父类的同级分类
     *
     * @author weihao.liu
     */
    public abstract List<T> getParentSiblings(Integer children);

    /**
     * 功能：获取分类树形结构数据
     *
     * @author liu.weihao
     */
    public abstract String classifyTree();

    /**
     * 功能：根据id获取分类详情
     *
     * @author liu.weihao
     */
    public abstract T getClassifyInfoById(Integer classifyId);

    /**
     * 功能：根据子类id，获取父类信息
     *
     * @author weihao.liu
     */
    public abstract T getParentClassify(Integer children);

    /**
     * 功能：新增分类
     *
     * @author liu.weihao
     */
    public abstract Integer addClassify(T classify);

    /**
     * 功能：修改分类，不传入分类id将会修改失败
     *
     * @author liu.weihao
     */
    public abstract boolean editClassify(T classify);

    /**
     * 功能：删除分类信息
     *
     * @author liu.weihao
     */
    public abstract boolean removeClassifyById(Integer classifyId);

    /**
     * 功能：插入节点，分配左节点，+2
     *
     * @author liu.weihao
     */
    public abstract int allocateLeftId(T classify);

    /**
     * 功能：插入节点，分配右节点，+2
     *
     * @author liu.weihao
     */
    public abstract int allocateRightId(T classify);

    /**
     * 功能：删除节点，回收左节点，都减去2
     *
     * @author liu.weihao
     */
    public abstract int recycleLeftId(Integer leftId);

    /**
     * 功能：删除节点，回收右节点，都减去2
     *
     * @author liu.weihao
     */
    public abstract int recycleRightId(Integer rightId);
}
