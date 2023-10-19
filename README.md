# program to find sum of diagonal of an array
* Problem input
```
11 2  4
4  5  6
10 8 -38
```
* Logic
```
for (int i = 0; i < n; i++)
{
	d1 += arr[i][i];
	d2 += arr[i][n-i-1];
}
```

