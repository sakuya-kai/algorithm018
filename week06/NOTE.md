学习笔记

动态规划 ≈ 递归+记忆化

dp数组就是用来存子问题结果，即记忆化，遍历就是递归

关键是找到状态转移方程

技巧

- 有的状态转移方程不需要用上所有的数组空间，可以用滚动数组的思想优化空间复杂度，比如```dp[i] = dp[i - 1] + dp[i - 2]```可以用两个变量来实现
- 有自低向上和自顶向下两种遍历方式，不同题目这两种方式的区别和难度可能很大，需要根据情况来判断