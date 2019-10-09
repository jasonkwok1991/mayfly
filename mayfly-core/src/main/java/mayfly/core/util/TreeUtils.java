package mayfly.core.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * 树形结构工具类
 * @author meilin.huang
 * @version 1.0
 * @date 2019-08-24 1:57 下午
 */
public class TreeUtils {

    /**
     * 根据所有树节点列表，生成含有所有树形结构的列表
     * @param nodes  树形节点列表
     * @param <T>    节点类型
     * @return       树形结构列表
     */
    public static <T extends TreeNode> List<T> generateTrees(List<T> nodes) {
        List<T> roots = new ArrayList<>();
        for (Iterator<T> ite = nodes.iterator(); ite.hasNext();) {
            T node = ite.next();
            if (node.isRoot()) {
                roots.add(node);
                // 从所有节点列表中删除该节点
                ite.remove();
            }
        }

        roots.forEach(r -> {
            setChildren(r, nodes);
        });
        return roots;
    }

    /**
     * 获取指定树节点下的所有叶子节点
     * @param parent  父节点
     * @param <T>     实际节点类型
     * @return        叶子节点
     */
    public static <T extends TreeNode> List<T> getLeafs(T parent) {
        List<T> leafs = new ArrayList<>();
        fillLeaf(parent, leafs);
        return leafs;
    }

    /**
     * 从所有节点列表中查找并设置parent的所有子节点
     * @param parent  父节点
     * @param nodes   所有树节点列表
     */
    public static <T extends TreeNode> void setChildren(T parent, List<T> nodes) {
        List<T> children = new ArrayList<>();
        Number parentId = parent.id();
        for (Iterator<T> ite = nodes.iterator(); ite.hasNext();) {
            T node = ite.next();
            if (Objects.equals(node.parentId(), parentId)) {
                children.add(node);
                ite.remove();
            }
        }
        // 如果孩子为空，则直接返回,否则继续递归设置孩子的孩子
        if (children.isEmpty()) {
            return;
        }
        parent.setChildren(children);
        children.forEach(m -> {
            // 递归设置子节点
            setChildren(m, nodes);
        });
    }

    /**
     * 将parent的所有叶子节点填充至leafs列表中
     * @param parent  父节点
     * @param leafs   叶子节点列表
     * @param <T>     实际节点类型
     */
    public static <T extends TreeNode> void fillLeaf(T parent, List<T> leafs) {
        @SuppressWarnings("unchecked")
        List<T> children = parent.getChildren();
        // 如果节点没有子节点则说明为叶子节点
        if (CollectionUtils.isEmpty(children)) {
            leafs.add(parent);
            return;
        }
        // 递归调用子节点，查找叶子节点
        for (T child : children) {
            fillLeaf(child, leafs);
        }
    }


    /**
     * 树节点父类，所有需要使用{@linkplain TreeUtils}工具类形成树形结构等操作的节点都需要实现该接口
     * @param <T>  节点id类型
     */
    public interface TreeNode<T extends Number> {
        /**
         * 获取节点id
         * @return  树节点id
         */
        T id();

        /**
         * 获取该节点的父节点id
         * @return  父节点id
         */
        T parentId();

        /**
         * 是否是根节点
         * @return  true：根节点
         */
        boolean isRoot();

        /**
         * 设置节点的子节点列表
         * @param children 子节点
         */
        void setChildren(List<? extends TreeNode> children);

        /**
         * 获取所有子节点
         * @return  子节点列表
         */
        List<? extends TreeNode> getChildren();
    }
}