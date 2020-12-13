学习笔记

##### 实用位操作
- 判断奇偶 
    - x & 1 == 1
    - x & 1 == 0
- 清0最低位的0
    - x = x & (x - 1)
- 得到最低位的1
    - x & -x

##### 布隆过滤器
- 存入数据，数据经过不同的hash算法算出多个值，把对应下标置为1
- 数据不在缓存中时是确定的，命中时可能会误判，所以通常用作第一级缓存进行快速判断

##### LRU Cache
- 顾名思义，最近最少使用缓存，每次淘汰时淘汰最后访问的一个缓存

---

##### 三种基础排序，时间复杂度 n ^ 2
```
选择排序
for (int i = 0; i < arr.length - 1; i++) {
    int index = i;
    for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < arr[index]) {
            index = j;
        }
    }
    int temp = arr[i];
    arr[i] = arr[index];
    arr[index] = temp;
}

冒泡排序
for (int i = 0; i <arr.length - 1; i++) {
    for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}

插入排序
for (int i = 1; i < arr.length - 1; i++) {
    int preIndex = i - 1;
    int current = arr[i];
    while(preIndex >= 0 && arr[preIndex] > current) {
        arr[preIndex + 1] = arr[preIndex];
        preIndex--;
    }
    arr[preIndex + 1] = current;
}
```

---

##### 三种 n * log n 的排序

- 快速排序，选择一个点pivot，然后把数组中小于pivot的数放到pivot左右，大于pivot的放到右边，然后再递归左右区间
- 归并排序，选择中点，把数组分成左右区间，递归左右区间直到子区间最多只有一个数，最后合并左右区间的结果
- 堆排序，维护一个堆，不停的堆化就能排好序

##### 三种线性时间复杂度的排序，一般只有整数数据才能使用这些排序

- 计数排序，创建一个数组，大小是待排序数组中最大的数，遍历待排序数组，记录每个数字出现的次数，最后遍历新数组就能排好序
- 桶排序，计数排序的升级版，有点像hash算法，可以节约空间
- 基数排序，从最低位开始排序，排到最高位