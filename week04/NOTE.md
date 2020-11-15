学习笔记

---

DFS代码模板
```
// 递归写法
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if(root==null){
        return allResults;
    }
    travel(root,0,allResults);
    return allResults;
}


private void travel(TreeNode root,int level,List<List<Integer>> results){
    if(results.size()==level){
        results.add(new ArrayList<>());
    }
    results.get(level).add(root.val);
    if(root.left!=null){
        travel(root.left,level+1,results);
    }
    if(root.right!=null){
        travel(root.right,level+1,results);
    }
}

// 非递归写法，手动模拟栈
private void dfs(Node root) {
    Set<Node> visited = new HashSet<>();
    if(root == null) return;
    
    Stack<Node> stackNode = new Stack<>();
    stackNode.push(root);
    
    while (!stackNode.empty()) {
        Node node = stackNode.pop();
        if (visited.contains(node) continue;
        visited.add(node);
        
        if (node.left != null) stackNode.push(node.left);
        if (node.right != null) stackNode.push(node.right);
    }
    return;
}
```

BFS代码模板
```
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> allResults = new ArrayList<>();
    if (root == null) {
        return allResults;
    }
    Queue<TreeNode> nodes = new LinkedList<>();
    nodes.add(root);
    while (!nodes.isEmpty()) {
        int size = nodes.size();
        List<Integer> results = new ArrayList<>();
        // 每次取上一轮加进去的点来遍历
        for (int i = 0; i < size; i++) {
            TreeNode node = nodes.poll();
            results.add(node.val);
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }
        allResults.add(results);
    }
    return allResults;
}
```

二分查找代码模板
```
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

二分查找关键：
- 单调（不一定是严格单调
- 边界
- 下标（二分查找的各种变体对下标判断条件可能不同