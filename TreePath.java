import java.util.LinkedList;
 
public class TreePath {
 
	/**
	 * 打印二叉树从根节点到叶子节点的所有路径
	 * @param args
	 */
	public static void getPath(TreeNode root){
		if(root==null) return;
		LinkedList<TreeNode> list = new LinkedList<>();
		getpathcore(root,list);
	}
	private static void getpathcore(TreeNode root, LinkedList<TreeNode> list) {
		if(root==null) return;
		list.add(root);
		if(root.left==null&&root.right==null){
			for(TreeNode temp:list){
				System.out.print(temp.value+" ");
			}
			System.out.println();
			list.removeLast();
			return;
		}
		getpathcore(root.left,list);
		getpathcore(root.right,list);
		list.removeLast();//返回时一定要清除
		
	}
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		getPath(root);
 
	}
 
}
--------------------- 
作者：dongqifan 
来源：CSDN 
原文：https://blog.csdn.net/dongqifan/article/details/35666035 
版权声明：本文为博主原创文章，转载请附上博文链接！
