package com.learn.设计模式.结构型模式.组合模式;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author xuejianjun<xuejianjun@corp.netease.com>
 * @since 2018/10/31 5:07 PM
 */
public class TreeNode {

    private String name;
    private TreeNode parent;
    private Vector<TreeNode> children = new Vector<>();

    public TreeNode(String name){
        this.name = name;
    }

    public void add(TreeNode node){
        children.add(node);
    }

    public void remove(TreeNode node){
        children.remove(node);
    }

    public Enumeration<TreeNode> getChildren(){
        return children.elements();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public void setChildren(Vector<TreeNode> children) {
        this.children = children;
    }
}
