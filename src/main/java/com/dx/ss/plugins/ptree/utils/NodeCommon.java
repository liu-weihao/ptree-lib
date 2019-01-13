package com.dx.ss.plugins.ptree.utils;

public class NodeCommon {

    /**
     * 添加子节点层
     */
    public static int addSubLevel(Integer fatherLevel) {

        return fatherLevel + 1;
    }

    /**
     * 新增子节点的左节点
     *
     * @param fatherLeftNode 父节点左节点
     */
    public static int addSubLeftNode(Integer fatherLeftNode) {

        return fatherLeftNode + 1;
    }

    /**
     * 新增子节点的右节点
     *
     * @param fatherLeftNode 父节点左节点
     */
    public static int addSubRightNode(Integer fatherLeftNode) {

        return fatherLeftNode + 2;
    }

    /**
     * 添加平级节点层
     */
    public static int addLevelLevel(Integer beforeLevel) {

        return beforeLevel;
    }

    /**
     * 新增平级节点的左节点
     *
     * @param levelRightNode 前平级节点的右节点
     */
    public static int addLevelLeftNode(Integer levelRightNode) {
        return levelRightNode + 1;
    }

    /**
     * 新增平级节点的右节点
     *
     * @param levelRightNode 前平级节点的右节点
     */
    public static int addLevelRightNode(Integer levelRightNode) {
        return levelRightNode + 2;
    }
}
